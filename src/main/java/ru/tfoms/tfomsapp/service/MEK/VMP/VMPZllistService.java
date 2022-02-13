package ru.tfoms.tfomsapp.service.MEK.VMP;

import nu.xom.*;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPZap;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPZllist;
import ru.tfoms.tfomsapp.service.MEK.SchetService;
import ru.tfoms.tfomsapp.service.MEK.ZglvService;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class VMPZllistService {
    private final ServiceUtil su = new ServiceUtil();
    private final ZglvService zglvService = new ZglvService();
    private final SchetService schetService = new SchetService();
    private final VMPZapService vmpZapService = new VMPZapService();

    public VMPZllist loadVMPZllist(InputStream inputStream){
        VMPZllist essVMPZllist = new VMPZllist();
        Document doc = null;
        Builder parser = new Builder(false);
        try {
            doc = parser.build(inputStream);
        } catch (ParsingException | IOException e) {
            e.printStackTrace();
        }
        if (doc == null){
            su.showMessagesEx("Документ не загружен." + doc.getClass().getName());
            return null;
        }
        Element zl = doc.getRootElement();
        Elements childs = zl.getChildElements();
        List<VMPZap> vmpZaps = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ZGLV" -> essVMPZllist.setZglv(zglvService.loadZglv(child));
                case "SCHET" -> essVMPZllist.setSchet(schetService.loadSchet(child));
                case "ZAP" -> vmpZaps.add(vmpZapService.loadVMPZap(child));
            }
        }
        essVMPZllist.setZaps(vmpZaps);
        return essVMPZllist;
    }
}
