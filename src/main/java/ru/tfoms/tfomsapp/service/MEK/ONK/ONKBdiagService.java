package ru.tfoms.tfomsapp.service.MEK.ONK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKBdiag;

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
        return essOnkBdiag;
    }
}
