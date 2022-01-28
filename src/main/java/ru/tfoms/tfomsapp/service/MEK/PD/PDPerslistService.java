package ru.tfoms.tfomsapp.service.MEK.PD;

import nu.xom.*;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPerslist;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPers;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class PDPerslistService {
    private final ServiceUtil su = new ServiceUtil();
    private final PDZglvService pdZglvService = new PDZglvService();
    private final PDPersService pdPersService = new PDPersService();

    public PDPerslist loadPDPerslist(InputStream inputStream){
        PDPerslist essPdPerslist = new PDPerslist();
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
        Element pl = doc.getRootElement();
        Elements childs = pl.getChildElements();
        List<PDPers> pers = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ZGLV" -> essPdPerslist.setZglv(pdZglvService.loadPdZglv(child));
                case "PERS" -> pers.add(pdPersService.loadPers(child));
            }
        }
        essPdPerslist.setPers(pers);
        return essPdPerslist;
    }

}
