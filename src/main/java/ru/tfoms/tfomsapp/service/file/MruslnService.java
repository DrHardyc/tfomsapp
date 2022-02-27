package ru.tfoms.tfomsapp.service.file;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.Mrusln;

@Service
public class MruslnService {
    public Mrusln loadMrusln(Element element){
        Mrusln essMrusln = new Mrusln();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "MR_N" -> essMrusln.setMrn(child.getValue());
                case "PRVS" -> essMrusln.setPrvs(child.getValue());
                case "CODE_MD" -> essMrusln.setCodemd(child.getValue());
            }
        }
        return CheckForNull(essMrusln);
    }

    private Mrusln CheckForNull(Mrusln essMrusln) {
        if (essMrusln.getMrn() == null){
            essMrusln.setMrn("");
        }
        if (essMrusln.getPrvs() == null){
            essMrusln.setPrvs("");
        }
        if (essMrusln.getCodemd() == null){
            essMrusln.setCodemd("");
        }

        return essMrusln;
    }
}
