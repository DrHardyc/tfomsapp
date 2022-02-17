package ru.tfoms.tfomsapp.service.MEK.MPD;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDZap;

@Service
public class MPDZapService {
    private final MPDPacientService mpdPacientService = new MPDPacientService();
    private final MPDZslService mpdZslService = new MPDZslService();

    public MPDZap loadMPDZap(Element element){
        MPDZap essMPDZap = new MPDZap();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "N_ZAP" -> essMPDZap.setNzap(child.getValue());
                case "PR_NOV" -> essMPDZap.setPrnov(child.getValue());
                case "PACIENT" -> essMPDZap.setPacient(mpdPacientService.loadMpdPacient(child));
                case "Z_SL" -> essMPDZap.setZsl(mpdZslService.loadMpdZsl(child));
            }
        }
        return CheckForNull(essMPDZap);
    }

    private MPDZap CheckForNull(MPDZap essMPDZap) {
        if (essMPDZap.getNzap() == null){
            essMPDZap.setNzap("");
        }
        if (essMPDZap.getPrnov() == null){
            essMPDZap.setPrnov("");
        }
        return essMPDZap;
    }
}
