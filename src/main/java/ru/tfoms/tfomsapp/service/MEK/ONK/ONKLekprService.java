package ru.tfoms.tfomsapp.service.MEK.ONK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKLekpr;

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
        return essOnkLekpr;
    }
}
