package ru.tfoms.tfomsapp.service.MEK.DS;


import nu.xom.*;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSZap;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSZllist;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPers;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPerslist;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class DSZllistService {
    private final ServiceUtil su = new ServiceUtil();
    private final DSZglvService dsZglvService = new DSZglvService();
    private final DSZapService dsZapService = new DSZapService();
    public DSZllist loadDSZllist(InputStream inputStream){
        DSZllist essDSZllist = new DSZllist();
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
        List<DSZap> dszaps = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ZGLV" -> essDSZllist.setZglv(dsZglvService.loadDsZglv(child));
                case "ZAP" -> dszaps.add(dsZapService.loadDsZap(child));
            }
        }
        essDSZllist.setZaps(dszaps);
        return essDSZllist;
    }
}
