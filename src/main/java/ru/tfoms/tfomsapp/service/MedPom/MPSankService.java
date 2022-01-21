package ru.tfoms.tfomsapp.service.MedPom;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPSank;

import java.util.ArrayList;
import java.util.List;

@Service
public class MPSankService {

    public MPSank loadMpSank(Element element){
        MPSank essSank = new MPSank();

        List<String> slids = new ArrayList<>();
        List<String> codeexps = new ArrayList<>();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "S_CODE" -> essSank.setScode(child.getValue());
                case "S_SUM" -> essSank.setSsum(child.getValue());
                case "S_TIP" -> essSank.setStip(child.getValue());
                case "SL_ID" -> slids.add(child.getValue());
                case "S_OSN" -> essSank.setSosn(child.getValue());
                case "DATE_ACT" -> essSank.setDateact(child.getValue());
                case "NUM_ACT" -> essSank.setNumact(child.getValue());
                case "CODE_EXP" -> codeexps.add(child.getValue());
                case "S_COM" -> essSank.setScom(child.getValue());
                case "S_IST" -> essSank.setSist(child.getValue());
            }
        }
        essSank.setSlid(slids);
        essSank.setCodeexp(codeexps);
        return essSank;
    }
}
