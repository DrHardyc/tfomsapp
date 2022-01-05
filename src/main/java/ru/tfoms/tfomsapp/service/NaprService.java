package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Napr;

@Service
public class NaprService {

    private final Napr essNapr = new Napr();
    private final ServiceUtil su = new ServiceUtil();

    public Napr LoadNapr(Element napr){
        Elements childs = napr.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "NAPR_DATE" -> essNapr.setNaprdate(su.getChildValueByName(child, "NAPR_DATE"));
                case "NAPR_MP" -> essNapr.setNaprmo(su.getChildValueByName(child, "NAPR_MO"));
                case "NAPR_V" -> essNapr.setNaprv(su.getChildValueByName(child, "NAPR_V"));
                case "MET_ISSL" -> essNapr.setMetissl(su.getChildValueByName(child, "MET_ISSL"));
            }
        }
        return essNapr;
    }
}
