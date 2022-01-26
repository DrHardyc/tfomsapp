package ru.tfoms.tfomsapp.service.MEK.ONK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKBprot;

@Service
public class ONKBprotService {
    public ONKBprot loadOnkBprot(Element element){
        ONKBprot essOnkBprot = new ONKBprot();
        Elements childs = element.getChildElements();

        for (Element child : childs){
            switch (child.getLocalName()){
                case "PROT" -> essOnkBprot.setProt(child.getValue());
                case "D_PROT" -> essOnkBprot.setDprot(child.getValue());
            }
        }
        return essOnkBprot;
    }
}
