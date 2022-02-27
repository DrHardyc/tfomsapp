package ru.tfoms.tfomsapp.service.file.mpd;

import nu.xom.*;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.mpd.MPDZap;
import ru.tfoms.tfomsapp.domain.file.mpd.MPDZllist;
import ru.tfoms.tfomsapp.service.file.SchetService;
import ru.tfoms.tfomsapp.service.file.ZglvService;
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
