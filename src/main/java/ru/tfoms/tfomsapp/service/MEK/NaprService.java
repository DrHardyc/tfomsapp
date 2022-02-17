package ru.tfoms.tfomsapp.service.MEK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Napr;

@Service
public class NaprService {
    public Napr loadNapr(Element element){
        Napr essNapr = new Napr();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "NAPR_DATE" -> essNapr.setNaprdate(child.getValue());
                case "NAPR_MO" -> essNapr.setNaprmo(child.getValue());
                case "NAPR_V" -> essNapr.setNaprv(child.getValue());
                case "MET_ISSL" -> essNapr.setMetissl(child.getValue());
                case "NAPR_USL" -> essNapr.setNaprusl(child.getValue());
            }
        }
        return CheckForNull(essNapr);
    }

    private Napr CheckForNull(Napr essNapr) {
        if (essNapr.getNaprdate() == null){
            essNapr.setNaprdate("");
        }
        if (essNapr.getNaprmo() == null){
            essNapr.setNaprmo("");
        }
        if (essNapr.getNaprv() == null){
            essNapr.setNaprv("");
        }
        if (essNapr.getMetissl() == null){
            essNapr.setMetissl("");
        }
        if (essNapr.getNaprusl() == null){
            essNapr.setNaprusl("");
        }

        return essNapr;
    }
}
