package ru.tfoms.tfomsapp.service.file.onk;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.onk.ONKBdiag;

@Service
public class ONKBdiagService {
    public ONKBdiag loadOnkBdiag(Element element){
        ONKBdiag essOnkBdiag = new ONKBdiag();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "DIAG_DATE" -> essOnkBdiag.setDiagdate(child.getValue());
                case "DIAG_TIP" -> essOnkBdiag.setDiagtip(child.getValue());
                case "DIAG_CODE" -> essOnkBdiag.setDiagcode(child.getValue());
                case "DIAG_RSLT" -> essOnkBdiag.setDiagrlst(child.getValue());
                case "REC_RSLT" -> essOnkBdiag.setRecrlst(child.getValue());
            }
        }
        return CheckForNull(essOnkBdiag);
    }

    private ONKBdiag CheckForNull(ONKBdiag essOnkBdiag) {
        if (essOnkBdiag.getDiagdate() == null){
            essOnkBdiag.setDiagdate("");
        }
        if (essOnkBdiag.getDiagtip() == null){
            essOnkBdiag.setDiagtip("");
        }
        if (essOnkBdiag.getDiagcode() == null){
            essOnkBdiag.setDiagcode("");
        }
        if (essOnkBdiag.getDiagrlst() == null){
            essOnkBdiag.setDiagrlst("");
        }
        if (essOnkBdiag.getRecrlst() == null){
            essOnkBdiag.setRecrlst("");
        }

        return essOnkBdiag;
    }
}
