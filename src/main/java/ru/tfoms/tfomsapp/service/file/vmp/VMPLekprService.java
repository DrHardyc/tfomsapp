package ru.tfoms.tfomsapp.service.file.vmp;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.vmp.VMPLekpr;

@Service
public class VMPLekprService {
    public VMPLekpr loadVmpLekpr(Element element){
        VMPLekpr essVmpLekpr = new VMPLekpr();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "REGNUM" -> essVmpLekpr.setRegnum(child.getValue());
                case "CODE_SH" -> essVmpLekpr.setCodesh(child.getValue());
                case "DATE_INJ" -> essVmpLekpr.setDateinj(child.getValue());
            }
        }
        return CheckForNull(essVmpLekpr);
    }

    private VMPLekpr CheckForNull(VMPLekpr essVmpLekpr) {
        if (essVmpLekpr.getRegnum() == null){
            essVmpLekpr.setRegnum("");
        }
        if (essVmpLekpr.getCodesh() == null){
            essVmpLekpr.setCodesh("");
        }
        if (essVmpLekpr.getDateinj() == null){
            essVmpLekpr.setDateinj("");
        }


        return essVmpLekpr;
    }
}
