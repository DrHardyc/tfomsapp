package ru.tfoms.tfomsapp.service.file.ds;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.ds.DSUsl;

@Service
public class DSUslService {
    public DSUsl loadDsUsl(Element element){
        DSUsl essDsUsl = new DSUsl();
        Elements childs = element.getChildElements();

        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDSERV" -> essDsUsl.setIdserv(child.getValue());
                case "F_ZUB" -> essDsUsl.setFzub(child.getValue());
                case "VIS_ZUB" -> essDsUsl.setViszub(child.getValue());
                case "PR_ANAST" -> essDsUsl.setPranast(child.getValue());
            }
        }
        return CheckForNull(essDsUsl);
    }

    private DSUsl CheckForNull(DSUsl essDsUsl) {
        if (essDsUsl.getIdserv() == null){
            essDsUsl.setIdserv("");
        }
        if (essDsUsl.getFzub() == null){
            essDsUsl.setFzub("");
        }
        if (essDsUsl.getViszub() == null){
            essDsUsl.setViszub("");
        }
        if (essDsUsl.getPranast() == null){
            essDsUsl.setPranast("");
        }


        return essDsUsl;
    }
}
