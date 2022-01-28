package ru.tfoms.tfomsapp.service.MEK;

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
public class ZllistService {
    private final ServiceUtil su = new ServiceUtil();
    private final ZglvService zglvService = new ZglvService();
    private final SchetService schetService = new SchetService();
    private final ZapService zapService = new ZapService();

    public Zllist loadZllist(InputStream inputStream, String fileStructureName){
        Zllist essZllist = new Zllist();
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
        List<Zap> zaps = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ZGLV" -> essZllist.setZglv(zglvService.loadZglv(child));
                case "SCHET" -> essZllist.setSchet(schetService.loadSchet(child));
                case "ZAP" -> zaps.add(zapService.loadZap(child, fileStructureName));
            }
        }
        essZllist.setZaps(zaps);
        return essZllist;
    }

}
