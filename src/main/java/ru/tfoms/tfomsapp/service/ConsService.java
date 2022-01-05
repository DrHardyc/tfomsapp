package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Cons;

@Service
public class ConsService {
    private final Cons essCons = new Cons();
    private final ServiceUtil su = new ServiceUtil();

    public Cons LoadCons(Element cons){
        Elements childs = cons.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "PR_CONS" -> essCons.setPrcons(su.getChildValueByName(child, "PR_CONS"));
                case "DT_CONS" -> essCons.setDtcons(su.getChildValueByName(child, "DT_CONS"));
            }
        }
        return essCons;
    }
}
