package ru.tfoms.tfomsapp.service.file.onk;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.onk.ONKLekpr;

@Service
public class ONKLekprService {
    public ONKLekpr loadOnkLekpr(Element element){
        ONKLekpr essOnkLekpr = new ONKLekpr();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "REGNUM" -> essOnkLekpr.setRegnum(child.getValue());
                case "CODE_SH" -> essOnkLekpr.setCodesh(child.getValue());
                case "DATE_INJ" -> essOnkLekpr.setDateinj(child.getValue());
            }
        }
        return CheckForNull(essOnkLekpr);
    }

    private ONKLekpr CheckForNull(ONKLekpr essOnkLekpr) {
        if (essOnkLekpr.getRegnum() == null){
            essOnkLekpr.setRegnum("");
        }
        if (essOnkLekpr.getCodesh() == null){
            essOnkLekpr.setCodesh("");
        }
        if (essOnkLekpr.getDateinj() == null){
            essOnkLekpr.setDateinj("");
        }

        return essOnkLekpr;
    }
}
