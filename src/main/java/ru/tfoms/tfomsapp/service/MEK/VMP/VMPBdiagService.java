package ru.tfoms.tfomsapp.service.MEK.VMP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPBdiag;

@Service
public class VMPBdiagService {
    public VMPBdiag loadVmpBdiag(Element element){
        VMPBdiag essVmpBdiag = new VMPBdiag();
        Elements childs = element.getChildElements();

        for (Element child : childs){
            switch (child.getLocalName()){
                case "DIAG_DATE" -> essVmpBdiag.setDiagdate(child.getValue());
                case "DIAG_TIP" -> essVmpBdiag.setDiagtip(child.getValue());
                case "DIAG_CODE" -> essVmpBdiag.setDiagcode(child.getValue());
                case "DIAG_RSLT" -> essVmpBdiag.setDiagrlst(child.getValue());
                case "REC_RSLT" -> essVmpBdiag.setRecrslt(child.getValue());
            }
        }
        return CheckForNull(essVmpBdiag);
    }

    private VMPBdiag CheckForNull(VMPBdiag essVmpBdiag) {
        if (essVmpBdiag.getDiagcode() == null){
            essVmpBdiag.setDiagdate("");
        }
        if (essVmpBdiag.getDiagtip() == null){
            essVmpBdiag.setDiagtip("");
        }
        if (essVmpBdiag.getDiagcode() == null){
            essVmpBdiag.setDiagcode("");
        }
        if (essVmpBdiag.getDiagrlst() == null){
            essVmpBdiag.setDiagrlst("");
        }
        if (essVmpBdiag.getRecrslt() == null){
            essVmpBdiag.setRecrslt("");
        }

        return essVmpBdiag;
    }
}
