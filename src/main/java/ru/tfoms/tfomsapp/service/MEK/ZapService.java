package ru.tfoms.tfomsapp.service.MEK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Zap;
import ru.tfoms.tfomsapp.service.MEK.MP.MPPacientService;
import ru.tfoms.tfomsapp.service.MEK.MP.MPZslService;

@Service
public class ZapService {

    private final MPPacientService mpPacientService = new MPPacientService();
    private final MPZslService mpZslService = new MPZslService();

    public Zap loadZap(Element element, String fileStructureName){
        Zap essZap = new Zap();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "N_ZAP" -> essZap.setNzap(child.getValue());
                case "PR_NOV" -> essZap.setPrnov(child.getValue());
                case "PACIENT" -> {
                    switch (fileStructureName){
                        case "MP" -> essZap.setPacient(mpPacientService.loadMPPacient(child));
//                        case "VMP" -> ;
//                        case "MPD" -> ;
//                        case "ONK" -> ;
                    }
                }
                case "Z_SL" -> {
                    switch (fileStructureName) {
                        case "MP" -> essZap.setZsl(mpZslService.loadMPZsl(child));
//                        case "VMP" -> ;
//                        case "MPD" -> ;
//                        case "ONK" -> ;
                    }
                }

            }
        }
        return essZap;
    }
}
