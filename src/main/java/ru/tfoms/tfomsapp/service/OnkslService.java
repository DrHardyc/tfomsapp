package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import nu.xom.Elements;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Onksl;

@Service
public class OnkslService {

    private final Onksl essOnksl = new Onksl();
    private final ServiceUtil su = new ServiceUtil();
    private final BdiagService bdiagService = new BdiagService();
    private final BprotService bprotService = new BprotService();
    private final OnkuslService onkuslService = new OnkuslService();

    public Onksl LoadOnksl(Element onksl){
        Elements childs = onksl.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "DS1_T" -> essOnksl.setDs1t(su.getChildValueByName(onksl, "DS1_T"));
                case "STAD" -> essOnksl.setStad(su.getChildValueByName(onksl, "STAD"));
                case "ONK_T" -> essOnksl.setOnkt(su.getChildValueByName(onksl, "ONK_T"));
                case "ONK_N" -> essOnksl.setOnkn(su.getChildValueByName(onksl, "ONK_N"));
                case "ONK_M" -> essOnksl.setOnkm(su.getChildValueByName(onksl, "ONK_M"));
                case "MTSTZ" -> essOnksl.setMtstz(su.getChildValueByName(onksl, "MTSTZ"));
                case "SOD" -> essOnksl.setSod(su.getChildValueByName(onksl, "SOD"));
                case "K_FR" -> essOnksl.setKfr(su.getChildValueByName(onksl, "K_FR"));
                case "WEI" -> essOnksl.setWei(su.getChildValueByName(onksl, "WEI"));
                case "HEI" -> essOnksl.setHei(su.getChildValueByName(onksl, "HEI"));
                case "BSA" -> essOnksl.setBsa(su.getChildValueByName(onksl, "BSA"));
                case "B_DIAG" -> essOnksl.setBdiag(bdiagService.LoadBdiag(onksl));
                case "B_PROT" -> essOnksl.setBprot(bprotService.LoadBprot(onksl));
                case "ONK_USL" -> essOnksl.setOnkusl(onkuslService.LoadOnkusl(onksl));
            }
        }
        return essOnksl;

    }
}
