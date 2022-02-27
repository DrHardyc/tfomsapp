package ru.tfoms.tfomsapp.service.file;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.Schet;

@Service
public class SchetService {
    public Schet loadSchet(Element element){

        Schet essSchet = new Schet();

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
                case "DISP" -> essSchet.setDisp(child.getValue());
            }
        }
        return CheckForNull(essSchet);
    }

    private Schet CheckForNull(Schet schet){
        if(schet.getCode() == null){
            schet.setCode("");
        }
        if(schet.getCodemo() == null){
            schet.setCodemo("");
        }
        if(schet.getYear() == null){
            schet.setYear("");
        }
        if(schet.getMonth() == null){
            schet.setMonth("");
        }
        if(schet.getNschet() == null){
            schet.setNschet("");
        }
        if(schet.getDschet() == null){
            schet.setDschet("");
        }
        if(schet.getPlat() == null){
            schet.setPlat("");
        }
        if(schet.getSummav() == null){
            schet.setSummav("");
        }
        if(schet.getComents() == null){
            schet.setComents("");
        }
        if (schet.getSankmek() == null){
            schet.setSankmek("");
        }
        if (schet.getSankekmp() == null){
            schet.setSankekmp("");
        }
        if (schet.getSankmee() == null){
            schet.setSankmee("");
        }
        if (schet.getSummap() == null){
            schet.setSummap("0");
        }
        if (schet.getDisp() == null){
            schet.setDisp("");
        }
        return schet;
    }
}
