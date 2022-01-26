package ru.tfoms.tfomsapp.service.MEK.MP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPMeddev;

@Service
public class MPMeddevService {
    public MPMeddev loadMpMeddev(Element element){
        MPMeddev essMpMeddev = new MPMeddev();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "DATE_MED" -> essMpMeddev.setDatemed(child.getValue());
                case "CODE_MEDDEV" -> essMpMeddev.setCodemeddev(child.getValue());
                case "NUMBER_SER" -> essMpMeddev.setNumberser(child.getValue());
            }
        }
        return essMpMeddev;
    }
}
