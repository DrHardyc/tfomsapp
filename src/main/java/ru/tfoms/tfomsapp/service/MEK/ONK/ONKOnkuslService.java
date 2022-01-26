package ru.tfoms.tfomsapp.service.MEK.ONK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKLekpr;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKOnkusl;

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
        return essOnkOnkusl;
    }
}