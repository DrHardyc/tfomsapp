package ru.tfoms.tfomsapp.service.file.onk;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.onk.ONKLekpr;
import ru.tfoms.tfomsapp.domain.file.onk.ONKOnkusl;

import java.util.ArrayList;
import java.util.List;

@Service
public class ONKOnkuslService {
    private final ONKLekprService onkLekprService = new ONKLekprService();
    public ONKOnkusl loadOnkOnkusl(Element element){
        ONKOnkusl essOnkOnkusl = new ONKOnkusl();
        Elements childs = element.getChildElements();
        List<ONKLekpr> onkLekprs = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "USL_TIP" -> essOnkOnkusl.setUsltip(child.getValue());
                case "HIR_TIP" -> essOnkOnkusl.setHirtip(child.getValue());
                case "LEK_TIP_L" -> essOnkOnkusl.setLektipl(child.getValue());
                case "LEK_TIP_V" -> essOnkOnkusl.setLektipv(child.getValue());
                case "LEK_PR" -> onkLekprs.add(onkLekprService.loadOnkLekpr(child));
                case "PPTR" -> essOnkOnkusl.setPptr(child.getValue());
                case "LUCH_TIP" -> essOnkOnkusl.setLuchtip(child.getValue());
            }
        }
        essOnkOnkusl.setLekprs(onkLekprs);
        return CheckForNull(essOnkOnkusl);
    }

    private ONKOnkusl CheckForNull(ONKOnkusl essOnkOnkusl) {
        if (essOnkOnkusl.getUsltip() == null){
            essOnkOnkusl.setUsltip("");
        }
        if (essOnkOnkusl.getHirtip() == null){
            essOnkOnkusl.setHirtip("");
        }
        if (essOnkOnkusl.getLektipl() == null){
            essOnkOnkusl.setLektipl("");
        }
        if (essOnkOnkusl.getLektipv() == null){
            essOnkOnkusl.setLektipv("");
        }
        if (essOnkOnkusl.getPptr() == null){
            essOnkOnkusl.setPptr("");
        }
        if (essOnkOnkusl.getLuchtip() == null){
            essOnkOnkusl.setLuchtip("");
        }


        return essOnkOnkusl;
    }
}
