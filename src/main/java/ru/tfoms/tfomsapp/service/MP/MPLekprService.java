package ru.tfoms.tfomsapp.service.MP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPLekpr;

@Service
public class MPLekprService {
    private final MPLekdoseService mpLekdoseService = new MPLekdoseService();

    public MPLekpr loadMPLekpr(Element element){
        MPLekpr essLekpr = new MPLekpr();

        Elements childs = element.getChildElements();

        for (Element child : childs){
            switch (child.getLocalName()){
                case "DATA_INJ" -> essLekpr.setDateinj(child.getValue());
                case "CODE_SH" -> essLekpr.setCodesh(child.getValue());
                case "REGNUM" -> essLekpr.setRegnum(child.getValue());
                case "COD_MARK" -> essLekpr.setCodmark(child.getValue());
                case "LEK_DOSE" -> essLekpr.setMPLekdose(mpLekdoseService.loasMPLekdose(child));
            }
        }



        return essLekpr;
    }
}
