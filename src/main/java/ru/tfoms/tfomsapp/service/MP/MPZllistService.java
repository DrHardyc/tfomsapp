package ru.tfoms.tfomsapp.service.MP;

import nu.xom.*;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Zap;
import ru.tfoms.tfomsapp.domain.MEK.Zllist;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class MPZllistService {
    private final ServiceUtil su = new ServiceUtil();
    private final MPZglvService mpZglvService = new MPZglvService();
    private final MPSchetService mpSchetService = new MPSchetService();
    private final MPZapService mpZapService = new MPZapService();

    public Zllist loadMpZllist(InputStream inputStream){

        Zllist mpZllist = new Zllist();
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
        Element zllist = doc.getRootElement();
        Elements childs = zllist.getChildElements();
        List<Zap> zaps = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ZGLV" -> mpZllist.setZglv(mpZglvService.loadMpZglv(child));
                case "SCHET" -> mpZllist.setSchet(mpSchetService.loadMpSchet(child));
                case "ZAP" -> zaps.add(mpZapService.loadMpZap(child));

            }
        }
        mpZllist.setZap(zaps);
        return mpZllist;
    }
}
