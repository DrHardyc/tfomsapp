package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import nu.xom.Elements;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Onksl;

@Service
public class OnkslService {

    private final ServiceUtil su = new ServiceUtil();
    private final BdiagService bdiagService = new BdiagService();
    private final BprotService bprotService = new BprotService();
    private final OnkuslService onkuslService = new OnkuslService();

    public Onksl LoadOnksl(Element onksl){
        Elements childs = onksl.getChildElements();
        final Onksl essOnksl = new Onksl();

        for (Element child : childs){
            switch (child.getLocalName()){
                case "DS1_T" -> essOnksl.setDs1t(su.getChildValueByName(child, "DS1_T"));
                case "STAD" -> essOnksl.setStad(su.getChildValueByName(child, "STAD"));
                case "ONK_T" -> essOnksl.setOnkt(su.getChildValueByName(child, "ONK_T"));
                case "ONK_N" -> essOnksl.setOnkn(su.getChildValueByName(child, "ONK_N"));
                case "ONK_M" -> essOnksl.setOnkm(su.getChildValueByName(child, "ONK_M"));
                case "MTSTZ" -> essOnksl.setMtstz(su.getChildValueByName(child, "MTSTZ"));
                case "SOD" -> essOnksl.setSod(su.getChildValueByName(child, "SOD"));
                case "K_FR" -> essOnksl.setKfr(su.getChildValueByName(child, "K_FR"));
                case "WEI" -> essOnksl.setWei(su.getChildValueByName(child, "WEI"));
                case "HEI" -> essOnksl.setHei(su.getChildValueByName(child, "HEI"));
                case "BSA" -> essOnksl.setBsa(su.getChildValueByName(child, "BSA"));
                case "B_DIAG" -> essOnksl.setBdiag(bdiagService.LoadBdiag(onksl));
                case "B_PROT" -> essOnksl.setBprot(bprotService.LoadBprot(onksl));
                case "ONK_USL" -> essOnksl.setOnkusl(onkuslService.LoadOnkusl(onksl));
            }
        }
        return essOnksl;

    }
}
