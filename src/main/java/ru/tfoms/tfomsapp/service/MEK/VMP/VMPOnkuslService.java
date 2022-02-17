package ru.tfoms.tfomsapp.service.MEK.VMP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPLekpr;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPOnkusl;

import java.util.ArrayList;
import java.util.List;

@Service
public class VMPOnkuslService {
    private final VMPLekprService vmpLekprService = new VMPLekprService();
    public VMPOnkusl loadVmpOnkusl(Element element){
        VMPOnkusl essVmpOnkusl = new VMPOnkusl();
        Elements childs = element.getChildElements();
        List<VMPLekpr> vmpLekprs = new ArrayList<>();

        for (Element child : childs){
            switch (child.getLocalName()){
                case "USL_TIP" -> essVmpOnkusl.setUsltip(child.getValue());
                case "HIR_TIP" -> essVmpOnkusl.setHirtip(child.getValue());
                case "LEK_TIP_L" -> essVmpOnkusl.setLektipl(child.getValue());
                case "LEK_TIP_V" -> essVmpOnkusl.setLektipv(child.getValue());
                case "LEK_PR" -> vmpLekprs.add(vmpLekprService.loadVmpLekpr(child));
                case "PPTR" -> essVmpOnkusl.setPptr(child.getValue());
                case "LUCH_TIP" -> essVmpOnkusl.setLuchtip(child.getValue());
            }
        }
        essVmpOnkusl.setLekpr(vmpLekprs);
        return CheckForNull(essVmpOnkusl);
    }

    private VMPOnkusl CheckForNull(VMPOnkusl essVmpOnkusl) {
        if (essVmpOnkusl.getUsltip() == null){
            essVmpOnkusl.setUsltip("");
        }
        if (essVmpOnkusl.getHirtip() == null){
            essVmpOnkusl.setHirtip("");
        }
        if (essVmpOnkusl.getLektipl() == null){
            essVmpOnkusl.setLektipl("");
        }
        if (essVmpOnkusl.getLektipv() == null){
            essVmpOnkusl.setLektipv("");
        }
        if (essVmpOnkusl.getPptr() == null){
            essVmpOnkusl.setPptr("");
        }
        if (essVmpOnkusl.getLuchtip() == null){
            essVmpOnkusl.setLuchtip("");
        }

        return essVmpOnkusl;
    }
}
