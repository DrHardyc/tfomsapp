package ru.tfoms.tfomsapp.service.MP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPLekdose;

@Service
public class MPLekdoseService {

    public MPLekdose loasMPLekdose(Element element){
        MPLekdose essLekdose = new MPLekdose();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ED_IZM" -> essLekdose.setEdizm(child.getValue());
                case "DOSE_INJ" -> essLekdose.setDoseinj(child.getValue());
                case "METHOD_INJ" -> essLekdose.setMethodinj(child.getValue());
                case "COL_INJ" -> essLekdose.setColinj(child.getValue());
            }
        }
        return essLekdose;
    }
}
