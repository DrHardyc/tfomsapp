package ru.tfoms.tfomsapp.service.MedPom;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPSlkoef;

@Service
public class MPSlkoefService {

    public MPSlkoef loadMPSlkoef(Element element){

        MPSlkoef essSlkoef = new MPSlkoef();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDSL" -> essSlkoef.setIdsl(child.getValue());
                case "Z_SL" -> essSlkoef.setZsl(child.getValue());
            }
        }
        return essSlkoef;
    }
}
