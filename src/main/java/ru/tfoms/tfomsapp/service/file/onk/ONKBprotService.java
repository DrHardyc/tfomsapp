package ru.tfoms.tfomsapp.service.file.onk;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.onk.ONKBprot;

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

        return CheckForNull(essOnkBprot);
    }

    private ONKBprot CheckForNull(ONKBprot essOnkBprot) {
        if (essOnkBprot.getProt() == null){
            essOnkBprot.setProt("");
        }
        if (essOnkBprot.getDprot() == null){
            essOnkBprot.setDprot("");
        }

        return essOnkBprot;
    }
}
