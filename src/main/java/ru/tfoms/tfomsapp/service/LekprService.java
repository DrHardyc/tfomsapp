package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Lekpr;



@Service
public class LekprService {

    private final Lekpr essLekpr = new Lekpr();
    private final ServiceUtil su = new ServiceUtil();

    public Lekpr LoadLekpr(Element lekpr){
        Elements childLekpr = lekpr.getChildElements();
        for (Element child : childLekpr){
            switch (child.getLocalName()){
                case "REGNUM" -> essLekpr.setRegnum(su.getChildValueByName(child, "REG_NUM"));
                case "CODE_SH" -> essLekpr.setCodesh(su.getChildValueByName(child, "CODE_SH"));
                case "DATE_INJ" -> essLekpr.setDateinj(su.getChildValueByName(child, "DATE_INJ"));
            }
        }
        return essLekpr;
    }
}
