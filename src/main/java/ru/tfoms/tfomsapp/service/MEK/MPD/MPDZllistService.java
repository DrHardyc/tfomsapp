package ru.tfoms.tfomsapp.service.MEK.MPD;

import nu.xom.*;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDZap;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDZllist;
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
public class MPDZllistService {
    private final ServiceUtil su = new ServiceUtil();
    private final ZglvService zglvService = new ZglvService();
    private final SchetService schetService = new SchetService();
    private final MPDZapService mpdZapService = new MPDZapService();

    public MPDZllist loadVMPZllist(InputStream inputStream){
        MPDZllist essMPDZllist = new MPDZllist();
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
        List<MPDZap> mpdZaps = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ZGLV" -> essMPDZllist.setZglv(zglvService.loadZglv(child));
                case "SCHET" -> essMPDZllist.setSchet(schetService.loadSchet(child));
                case "ZAP" -> mpdZaps.add(mpdZapService.loadMPDZap(child));
            }
        }
        essMPDZllist.setZap(mpdZaps);
        return essMPDZllist;
    }
}
