package ru.tfoms.tfomsapp.service.MEK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Schet;

@Service
public class SchetService {
    public Schet loadSchet(Element element){

        Schet schet = new Schet();

        Elements chids = element.getChildElements();
        for (Element child : chids){
            switch (child.getLocalName()){
                case "CODE" -> schet.setCode(child.getValue());
                case "CODE_MO" -> schet.setCodemo(child.getValue());
                case "YEAR" -> schet.setYear(child.getValue());
                case "MONTH" -> schet.setMonth(child.getValue());
                case "NSCHET" -> schet.setNschet(child.getValue());
                case "DSCHET" -> schet.setDschet(child.getValue());
                case "PLAT" -> schet.setPlat(child.getValue());
                case "SUMMAV" -> schet.setSummav(child.getValue());
                case "COMENTS" -> schet.setComents(child.getValue());
                case "SUMMAP" -> schet.setSummap(child.getValue());
                case "SANK_MEK" -> schet.setSankmek(child.getValue());
                case "SANK_MEE" -> schet.setSankmee(child.getValue());
                case "SANK_EKMP" -> schet.setSankekmp(child.getValue());
            }
        }
        return schet;
    }
}
