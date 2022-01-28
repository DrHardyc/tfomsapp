package ru.tfoms.tfomsapp.service.MEK.DS;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSZglv;

@Service
public class DSZglvService {
    public DSZglv loadDsZglv(Element element){
        DSZglv essDsZglv = new DSZglv();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "VERSION" -> essDsZglv.setVersion(child.getValue());
                case "DATE" -> essDsZglv.setDate(child.getValue());
                case "FILENAME" -> essDsZglv.setFilename(child.getValue());
                case "SD_Z" -> essDsZglv.setSdz(child.getValue());
                case "TEST" -> essDsZglv.setTest(child.getValue());
                case "VER_PO" -> essDsZglv.setVerpo(child.getValue());
            }
        }
        return essDsZglv;
    }
}
