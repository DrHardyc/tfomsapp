package ru.tfoms.tfomsapp.service.MedPom;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPZglv;



@Service
public class MPZglvService {

    public MPZglv loadMpZglv(Element element){
        MPZglv essZglv = new MPZglv();
        Elements childs = element.getChildElements();
        for (Element attribute : childs){
            switch (attribute.getLocalName()){
                case "VERSION" -> essZglv.setVersion(attribute.getValue());
                case "DATA" -> essZglv.setData(attribute.getValue());
                case "FILENAME" -> essZglv.setFilename(attribute.getValue());
                case "SD_Z" -> essZglv.setSdz(attribute.getValue());
            }
        }
        return essZglv;
    }
}
