package ru.tfoms.tfomsapp.service.MEK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Slkoef;

@Service
public class SlkoefService {
    public Slkoef loadSlcoef(Element element){
        Slkoef essSlcoef = new Slkoef();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDSL" -> essSlcoef.setIdsl(child.getValue());
                case "Z_SL" -> essSlcoef.setZsl(child.getValue());
            }
        }
        return CheckForNull(essSlcoef);
    }

    private Slkoef CheckForNull(Slkoef slkoef){
        if (slkoef.getZsl() == null){
            slkoef.setZsl("");
        }
        if (slkoef.getIdsl() == null){
            slkoef.setIdsl("");
        }

        return slkoef;
    }
}
