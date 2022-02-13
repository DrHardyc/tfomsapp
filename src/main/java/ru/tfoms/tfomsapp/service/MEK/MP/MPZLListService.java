package ru.tfoms.tfomsapp.service.MEK.MP;

import nu.xom.*;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPZap;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPZllist;
import ru.tfoms.tfomsapp.service.MEK.SchetService;
import ru.tfoms.tfomsapp.service.MEK.ZglvService;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class MPZLListService {
    private final ServiceUtil su = new ServiceUtil();
    private final ZglvService zglvService = new ZglvService();
    private final SchetService schetService = new SchetService();
    private final MPZapService mpZapService = new MPZapService();

    public MPZllist loadMPZllist(InputStream inputStream){
        MPZllist essMPZllist = new MPZllist();
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
        List<MPZap> mpZaps = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ZGLV" -> essMPZllist.setZglv(zglvService.loadZglv(child));
                case "SCHET" -> essMPZllist.setSchet(schetService.loadSchet(child));
                case "ZAP" -> mpZaps.add(mpZapService.loadMPZap(child));
            }
        }
        essMPZllist.setZap(mpZaps);
        return essMPZllist;
    }


}
