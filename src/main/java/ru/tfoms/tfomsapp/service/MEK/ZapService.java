package ru.tfoms.tfomsapp.service.MEK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPPacient;
import ru.tfoms.tfomsapp.domain.MEK.Zap;
import ru.tfoms.tfomsapp.service.MEK.MP.MPPacientService;
import ru.tfoms.tfomsapp.service.MEK.MP.MPZslService;
import ru.tfoms.tfomsapp.service.MEK.MPD.MPDPacientService;
import ru.tfoms.tfomsapp.service.MEK.MPD.MPDZslService;
import ru.tfoms.tfomsapp.service.MEK.ONK.ONKPacientService;
import ru.tfoms.tfomsapp.service.MEK.ONK.ONKZslService;
import ru.tfoms.tfomsapp.service.MEK.VMP.VMPPacientService;
import ru.tfoms.tfomsapp.service.MEK.VMP.VMPZslService;

@Service
public class ZapService {

    private final MPPacientService mpPacientService = new MPPacientService();
    private final MPZslService mpZslService = new MPZslService();
    private final VMPPacientService vmpPacientService = new VMPPacientService();
    private final VMPZslService vmpZslService = new VMPZslService();
    private final MPDPacientService mpdPacientService = new MPDPacientService();
    private final MPDZslService mpdZslService = new MPDZslService();
    private final ONKPacientService onkPacientService = new ONKPacientService();
    private final ONKZslService onkZslService = new ONKZslService();

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
                        case "VMP" -> essZap.setPacient(vmpPacientService.loadVmpPacient(child));
                        case "MPD" -> essZap.setPacient(mpdPacientService.loadMpdPacient(child));
                        case "ONK" -> essZap.setPacient(onkPacientService.loadOnkPacient(child));
                    }
                }
                case "Z_SL" -> {
                    switch (fileStructureName) {
                        case "MP" -> essZap.setZsl(mpZslService.loadMPZsl(child));
                        case "VMP" -> essZap.setZsl(vmpZslService.loadVmpZsl(child));
                        case "MPD" -> essZap.setZsl(mpdZslService.loadMpdZsl(child));
                        case "ONK" -> essZap.setZsl(onkZslService.loadOnkZsl(child));
                    }
                }

            }
        }
        return essZap;
    }
}
