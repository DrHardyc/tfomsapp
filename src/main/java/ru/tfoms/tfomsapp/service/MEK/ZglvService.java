package ru.tfoms.tfomsapp.service.MEK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Zglv;

@Service
public class ZglvService {
    public Zglv loadZglv(Element element){
        Zglv zglv = new Zglv();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "VERSION" -> zglv.setVersion(child.getValue());
                case "DATA" -> zglv.setData(child.getValue());
                case "FILENAME" -> zglv.setFilename(child.getValue());
                case "SD_Z" -> zglv.setSdz(child.getValue());
            }
        }
        return zglv;
    }
}
