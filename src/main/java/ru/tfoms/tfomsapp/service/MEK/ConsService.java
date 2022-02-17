package ru.tfoms.tfomsapp.service.MEK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Cons;

@Service
public class ConsService {
    public Cons loadCons(Element element){
        Cons essCons = new Cons();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()) {
                case "PR_CONS" -> essCons.setPrcons(child.getValue());
                case "DT_CONS" -> essCons.setDtcons(child.getValue());
            }
        }
        return CHeckForNull(essCons);
    }

    private Cons CHeckForNull(Cons essCons) {
        if (essCons.getPrcons() == null){
            essCons.setPrcons("");
        }
        if (essCons.getDtcons() == null){
            essCons.setDtcons("");
        }
        return essCons;
    }
}
