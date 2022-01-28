package ru.tfoms.tfomsapp.service.MEK.DS;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSUsl;

@Service
public class DSUslService {
    public DSUsl loadDsUsl(Element element){
        DSUsl essDsUsl = new DSUsl();
        Elements childs = element.getChildElements();

        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDSERV" -> essDsUsl.setIdserv(child.getValue());
                case "F_ZUB" -> essDsUsl.setFzub(child.getValue());
                case "VIS_ZUB" -> essDsUsl.setViszub(child.getValue());
                case "PR_ANAST" -> essDsUsl.setPranast(child.getValue());
            }
        }
        return essDsUsl;
    }
}
