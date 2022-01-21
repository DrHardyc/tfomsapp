package ru.tfoms.tfomsapp.service.MedPom;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPSchet;

@Service
public class MPSchetService {

    public MPSchet loadMpSchet(Element element){
        MPSchet essSchet = new MPSchet();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "CODE" -> essSchet.setCode(child.getValue());
                case "CODE_MO" -> essSchet.setCodemo(child.getValue());
                case "YEAR" -> essSchet.setYear(child.getValue());
                case "MONTH" -> essSchet.setMonth(child.getValue());
                case "NSCHET" -> essSchet.setNschet(child.getValue());
                case "DSCHET" -> essSchet.setDschet(child.getValue());
                case "PLAT" -> essSchet.setPlat(child.getValue());
                case "SUMMAV" -> essSchet.setSummav(child.getValue());
                case "COMENTS" -> essSchet.setComents(child.getValue());
                case "SUMMAP" -> essSchet.setSummap(child.getValue());
                case "SANK_MEK" -> essSchet.setSankmek(child.getValue());
                case "SANK_MEE" -> essSchet.setSankmee(child.getValue());
                case "SANK_EKMP" -> essSchet.setSankekmp(child.getValue());
            }
        }
        return essSchet;
    }
}
