package ru.tfoms.tfomsapp.service.file.vmp;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.vmp.VMPZap;

@Service
public class VMPZapService {
    private final VMPPacientService vmpPacientService = new VMPPacientService();
    private final VMPZslService vmpZslService = new VMPZslService();

    public VMPZap loadVMPZap(Element element){
        VMPZap essVMPZap = new VMPZap();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "N_ZAP" -> essVMPZap.setNzap(child.getValue());
                case "PR_NOV" -> essVMPZap.setPrnov(child.getValue());
                case "PACIENT" -> essVMPZap.setPacient(vmpPacientService.loadVmpPacient(child));
                case "Z_SL" -> essVMPZap.setZsl(vmpZslService.loadVmpZsl(child));
            }
        }
        return CheckForNull(essVMPZap);
    }

    private VMPZap CheckForNull(VMPZap essVMPZap) {
        if (essVMPZap.getNzap() == null){
            essVMPZap.setNzap("");
        }
        if (essVMPZap.getPrnov() == null){
            essVMPZap.setPrnov("");
        }

        return essVMPZap;
    }
}
