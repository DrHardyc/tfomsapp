package ru.tfoms.tfomsapp.service.MP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPMeddev;

@Service
public class MPMeddevService {

    public MPMeddev loadMPMeddev(Element element){
        MPMeddev essMeddev =  new MPMeddev();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "DATE_MED" -> essMeddev.setDatemed(child.getValue());
                case "CODE_MEDDEV" -> essMeddev.setCodemeddev(child.getValue());
                case "NUMBER_SER" -> essMeddev.setNumberser(child.getValue());
            }
        }
        return essMeddev;
    }
}
