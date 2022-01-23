package ru.tfoms.tfomsapp.service.MP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Zap;

@Service
public class MPZapService {
    private final MPPacientService mpPacientService = new MPPacientService();
    private final MPZslService mpZslService = new MPZslService();

    public Zap loadMpZap(Element element) {
        Zap essZap = new Zap();

        Elements childs = element.getChildElements();

        for (Element child : childs){
            switch (child.getLocalName()){
                case "N_ZAP" -> essZap.setNzap(child.getValue());
                case "PR_NOV" -> essZap.setPrnov(child.getValue());
                case "PACIENT" -> essZap.setPacient(mpPacientService.mpPacient(child));
                case "Z_SL" -> essZap.setMPZsl(mpZslService.loadMPZsl(child));

            }
        }
        return essZap;

    }
}
