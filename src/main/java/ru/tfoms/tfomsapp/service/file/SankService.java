package ru.tfoms.tfomsapp.service.file;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.Sank;

import java.util.ArrayList;
import java.util.List;

@Service
public class SankService {
    public Sank loadSank(Element element){
        Sank essSank = new Sank();
        Elements childs = element.getChildElements();
        List<String> slid = new ArrayList<>();
        List<String> codeexp = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "S_CODE" -> essSank.setScode(child.getValue());
                case "S_SUM" -> essSank.setSsum(child.getValue());
                case "S_TIP" -> essSank.setStip(child.getValue());
                case "SL_ID" -> slid.add(child.getValue());
                case "S_OSN" -> essSank.setSosn(child.getValue());
                case "DATE_ACT" -> essSank.setDateact(child.getValue());
                case "NUM_ACT" -> essSank.setNumact(child.getValue());
                case "CODE_EXP" -> codeexp.add(child.getValue());
                case "S_COM" -> essSank.setScom(child.getValue());
                case "S_IST" -> essSank.setSist(child.getValue());
            }
        }
        essSank.setSlid(slid);
        essSank.setCodeexp(codeexp);
        return CheckForNull(essSank);
    }

    private Sank CheckForNull(Sank essSank) {
        if (essSank.getScode() == null){
            essSank.setScode("");
        }
        if (essSank.getSsum() == null){
            essSank.setSsum("");
        }
        if (essSank.getStip() == null){
            essSank.setStip("");
        }
        if (essSank.getSosn() == null){
            essSank.setSosn("");
        }
        if (essSank.getDateact() == null){
            essSank.setDateact("");
        }
        if (essSank.getNumact() == null){
            essSank.setNumact("");
        }
        if (essSank.getScom() == null){
            essSank.setScom("");
        }
        if (essSank.getSist() == null){
            essSank.setSist("");
        }

        return essSank;
    }
}
