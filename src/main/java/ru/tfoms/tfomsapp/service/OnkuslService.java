package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Onkusl;


@Service
public class OnkuslService {

    private final ServiceUtil su = new ServiceUtil();
    private final LekprService lekprService = new LekprService();

    public Onkusl LoadOnkusl(Element onkusl){
        Elements childOnkusls = onkusl.getChildElements();
        Onkusl essOnkusl = new Onkusl();
        for (Element child : childOnkusls){
            switch (child.getLocalName()){
                case "USL_TIP" -> essOnkusl.setUsltip(su.getChildValueByName(child, "USL_TIP"));
                case "HIR_TIP" -> essOnkusl.setHirtip(su.getChildValueByName(child, "HIR_TIP"));
                case "LEK_TIP_L" -> essOnkusl.setLektipl(su.getChildValueByName(child, "LEK_TIP_L"));
                case "LEK_TIP_V" -> essOnkusl.setLektipv(su.getChildValueByName(child, "LEK_TIP_V"));
                case "LEK_PR" -> essOnkusl.setLekpr(lekprService.LoadLekpr(child));
            }
        }
        return essOnkusl;
    }
}
