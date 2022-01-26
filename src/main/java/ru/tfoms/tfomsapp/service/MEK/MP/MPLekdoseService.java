package ru.tfoms.tfomsapp.service.MEK.MP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPLekdose;

@Service
public class MPLekdoseService {
    public MPLekdose loadMpLekdose(Element element){
        MPLekdose essMpLekdose = new MPLekdose();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ED_IZM" -> essMpLekdose.setEdizm(child.getValue());
                case "DOSE_INJ" -> essMpLekdose.setDoseinj(child.getValue());
                case "METHOD_INJ" -> essMpLekdose.setMethodinj(child.getValue());
                case "COL_INJ" -> essMpLekdose.setColinj(child.getValue());
            }
        }
        return essMpLekdose;
    }
}
