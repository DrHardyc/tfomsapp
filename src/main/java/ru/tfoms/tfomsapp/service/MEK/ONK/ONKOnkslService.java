package ru.tfoms.tfomsapp.service.MEK.ONK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKBdiag;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKBprot;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKOnksl;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKOnkusl;

import java.util.ArrayList;
import java.util.List;

@Service
public class ONKOnkslService {
    private final ONKBdiagService onkBdiagService = new ONKBdiagService();
    private final ONKBprotService onkBprotService = new ONKBprotService();
    private final ONKOnkuslService onkOnkuslService = new ONKOnkuslService();
    public ONKOnksl loadOnkOnksl(Element element){
        ONKOnksl essOnkOnksl = new ONKOnksl();
        Elements childs = element.getChildElements();
        List<ONKBdiag> onkBdiags = new ArrayList<>();
        List<ONKBprot> onkBprots = new ArrayList<>();
        List<ONKOnkusl> onkOnkusls = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "DS1_T" -> essOnkOnksl.setDs1t(child.getValue());
                case "STAD" -> essOnkOnksl.setStad(child.getValue());
                case "ONK_T" -> essOnkOnksl.setOnkt(child.getValue());
                case "ONK_N" -> essOnkOnksl.setOnkn(child.getValue());
                case "ONK_M" -> essOnkOnksl.setOnkm(child.getValue());
                case "MTSTZ" -> essOnkOnksl.setMtstz(child.getValue());
                case "SOD" -> essOnkOnksl.setSod(child.getValue());
                case "K_FR" -> essOnkOnksl.setKfr(child.getValue());
                case "WEI" -> essOnkOnksl.setWei(child.getValue());
                case "HEI" -> essOnkOnksl.setHei(child.getValue());
                case "BSA" -> essOnkOnksl.setBsa(child.getValue());
                case "B_DIAG" -> onkBdiags.add(onkBdiagService.loadOnkBdiag(child));
                case "B_PROT" -> onkBprots.add(onkBprotService.loadOnkBprot(child));
                case "ONK_USL" -> onkOnkusls.add(onkOnkuslService.loadOnkOnkusl(child));
            }
        }
        essOnkOnksl.setBdiags(onkBdiags);
        essOnkOnksl.setBprots(onkBprots);
        essOnkOnksl.setOnkusls(onkOnkusls);
        return CheckForNull(essOnkOnksl);
    }

    private ONKOnksl CheckForNull(ONKOnksl essOnkOnksl) {
        if (essOnkOnksl.getDs1t() == null){
            essOnkOnksl.setDs1t("");
        }
        if (essOnkOnksl.getStad() == null){
            essOnkOnksl.setStad("");
        }
        if (essOnkOnksl.getOnkm() == null){
            essOnkOnksl.setOnkm("");
        }
        if (essOnkOnksl.getOnkn() == null){
            essOnkOnksl.setOnkn("");
        }
        if (essOnkOnksl.getOnkt() == null){
            essOnkOnksl.setOnkt("");
        }
        if (essOnkOnksl.getMtstz() == null){
            essOnkOnksl.setMtstz("");
        }
        if (essOnkOnksl.getSod() == null){
            essOnkOnksl.setSod("");
        }
        if (essOnkOnksl.getKfr() == null){
            essOnkOnksl.setKfr("");
        }
        if (essOnkOnksl.getWei() == null){
            essOnkOnksl.setWei("");
        }
        if (essOnkOnksl.getHei() == null){
            essOnkOnksl.setHei("");
        }
        if (essOnkOnksl.getBsa() == null){
            essOnkOnksl.setBsa("");
        }

        return essOnkOnksl;
    }
}
