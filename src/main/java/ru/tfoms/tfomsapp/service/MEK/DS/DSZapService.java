package ru.tfoms.tfomsapp.service.MEK.DS;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSZap;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSZsl;

import java.util.ArrayList;
import java.util.List;

@Service
public class DSZapService {
    private final DSZslService dsZslService = new DSZslService();
    public DSZap loadDsZap(Element element){
        DSZap essDsZap = new DSZap();
        Elements childs = element.getChildElements();
        List<DSZsl> dsZsls = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "N_ZAP" -> essDsZap.setNzap(child.getValue());
                case "FILENAME1" -> essDsZap.setFilename1(child.getValue());
                case "Z_SL" -> dsZsls.add(dsZslService.loadDsZsl(child));
            }
        }
        essDsZap.setZsl(dsZsls);
        return CheckForNull(essDsZap);
    }

    private DSZap CheckForNull(DSZap essDsZap) {
        if (essDsZap.getNzap() == null){
            essDsZap.setNzap("");
        }
        if (essDsZap.getFilename1() == null){
            essDsZap.setFilename1("");
        }

        return essDsZap;
    }
}
