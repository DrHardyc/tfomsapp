package ru.tfoms.tfomsapp.service.MEK.PD;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDZglv;

@Service
public class PDZglvService {
    public PDZglv loadPdZglv(Element element){
        PDZglv essPdZglv = new PDZglv();
        Elements childs = element.getChildElements();

        for (Element child : childs){
            switch (child.getLocalName()){
                case "VERSION" -> essPdZglv.setVersion(child.getValue());
                case "DATE" -> essPdZglv.setDate(child.getValue());
                case "FILENAME" -> essPdZglv.setFilename(child.getValue());
                case "FILENAME1" -> essPdZglv.setFilename1(child.getValue());
            }
        }
        return essPdZglv;
    }
}
