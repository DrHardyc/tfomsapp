package ru.tfoms.tfomsapp.service.MEK.ONK;

import nu.xom.*;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKZap;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKZllist;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPZap;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPZllist;
import ru.tfoms.tfomsapp.service.MEK.SchetService;
import ru.tfoms.tfomsapp.service.MEK.VMP.VMPZapService;
import ru.tfoms.tfomsapp.service.MEK.ZglvService;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ONKZllistService {
    private final ServiceUtil su = new ServiceUtil();
    private final ZglvService zglvService = new ZglvService();
    private final SchetService schetService = new SchetService();
    private final ONKZapService onkZapService = new ONKZapService();

    public ONKZllist loadONKZllist(InputStream inputStream){
        ONKZllist essONKZllist = new ONKZllist();
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
        List<ONKZap> onkZaps = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ZGLV" -> essONKZllist.setZglv(zglvService.loadZglv(child));
                case "SCHET" -> essONKZllist.setSchet(schetService.loadSchet(child));
                case "ZAP" -> onkZaps.add(onkZapService.loadMPDZap(child));
            }
        }
        essONKZllist.setZaps(onkZaps);
        return essONKZllist;
    }
}
