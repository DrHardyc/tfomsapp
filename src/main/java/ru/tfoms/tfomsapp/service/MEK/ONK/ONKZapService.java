package ru.tfoms.tfomsapp.service.MEK.ONK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKZap;

@Service
public class ONKZapService {
    private final ONKPacientService onkPacientService = new ONKPacientService();
    private final ONKZslService onkZslService = new ONKZslService();

    public ONKZap loadMPDZap(Element element){
        ONKZap essONKZap = new ONKZap();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "N_ZAP" -> essONKZap.setNzap(child.getValue());
                case "PR_NOV" -> essONKZap.setPrnov(child.getValue());
                case "PACIENT" -> essONKZap.setPacient(onkPacientService.loadOnkPacient(child));
                case "Z_SL" -> essONKZap.setZsl(onkZslService.loadOnkZsl(child));
            }
        }
        return essONKZap;
    }
}
