package ru.tfoms.tfomsapp.service.file.mp;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.mp.MPLekpr;

@Service
public class MPLekprService {
    private final MPLekdoseService mpLekdoseService = new MPLekdoseService();

    public MPLekpr loadMPLekpr(Element element){
        MPLekpr essMpLekpr = new MPLekpr();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "DATE_INJ" -> essMpLekpr.setDateinj(child.getValue());
                case "CODE_SH" -> essMpLekpr.setCodesh(child.getValue());
                case "REGNUM" -> essMpLekpr.setRegnum(child.getValue());
                case "COD_MARK" -> essMpLekpr.setCodmark(child.getValue());
                case "LEK_DOSE" -> essMpLekpr.setLekdose(mpLekdoseService.loadMpLekdose(child));
            }
        }
        return CheckForNull(essMpLekpr);
    }

    private MPLekpr CheckForNull(MPLekpr essMpLekpr) {
        if (essMpLekpr.getDateinj() == null){
            essMpLekpr.setDateinj("");
        }
        if (essMpLekpr.getCodesh() == null){
            essMpLekpr.setCodesh("");
        }
        if (essMpLekpr.getRegnum() == null){
            essMpLekpr.setRegnum("");
        }
        if (essMpLekpr.getCodmark() == null){
            essMpLekpr.setCodmark("");
        }
        return essMpLekpr;
    }
}
