package ru.tfoms.tfomsapp.service.MP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPMrusln;

@Service
public class MPMruslnService {

    public MPMrusln loadMPMrusln(Element element){
        MPMrusln essMrusln = new MPMrusln();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "MR_N" -> essMrusln.setMrn(child.getValue());
                case "PRVS" -> essMrusln.setPrvs(child.getValue());
                case "CADE_MD" -> essMrusln.setCodemd(child.getValue());
            }
        }
        return essMrusln;
    }
}
