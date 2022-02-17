package ru.tfoms.tfomsapp.service.MEK.DS;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSSl;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSZsl;

import java.util.ArrayList;
import java.util.List;

@Service
public class DSZslService {
    private final DSSlService dsSlService = new DSSlService();

    public DSZsl loadDsZsl(Element element){
        DSZsl essDsZsl = new DSZsl();
        Elements childs = element.getChildElements();
        List<DSSl> dsSls = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDCASE" -> essDsZsl.setIdcase(child.getValue());
                case "SL" -> dsSls.add(dsSlService.loadDsSl(child));
                case "NPR_NOM" -> essDsZsl.setNprnom(child.getValue());
                case "EXTR" -> essDsZsl.setExtr(child.getValue());
            }
        }
        essDsZsl.setSl(dsSls);
        return CheckForNull(essDsZsl);
    }

    private DSZsl CheckForNull(DSZsl essDsZsl) {
        if (essDsZsl.getIdcase() == null){
            essDsZsl.setIdcase("");
        }
        if (essDsZsl.getNprnom() == null){
            essDsZsl.setNprnom("");
        }
        if (essDsZsl.getExtr() == null){
            essDsZsl.setExtr("");
        }

        return essDsZsl;
    }
}
