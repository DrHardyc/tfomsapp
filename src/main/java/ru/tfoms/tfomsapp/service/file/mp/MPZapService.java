package ru.tfoms.tfomsapp.service.file.mp;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.mp.MPZap;

@Service
public class MPZapService {
    private final MPPacientService mpPacientService = new MPPacientService();
    private final MPZslService mpZslService = new MPZslService();

    public MPZap loadMPZap(Element element){
        MPZap essMPZap = new MPZap();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "N_ZAP" -> essMPZap.setNzap(child.getValue());
                case "PR_NOV" -> essMPZap.setPrnov(child.getValue());
                case "PACIENT" -> essMPZap.setPacient(mpPacientService.loadMPPacient(child));
                case "Z_SL" -> essMPZap.setZsl(mpZslService.loadMPZsl(child));
            }
        }
        return CheckForNull(essMPZap);
    }

    private MPZap CheckForNull(MPZap essMPZap) {
        if (essMPZap.getNzap() == null){
            essMPZap.setNzap("");
        }
        if (essMPZap.getPrnov() == null){
            essMPZap.setPrnov("");
        }

        return essMPZap;
    }
}
