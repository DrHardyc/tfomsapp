package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Bprot;


@Service
public class BprotService {

    private final ServiceUtil su = new ServiceUtil();

    public Bprot LoadBprot(Element bprot){
        Elements childBprot = bprot.getChildElements();
        Bprot essBprot = new Bprot();
        for (Element child : childBprot){
            switch (child.getLocalName()){
                case "PROT" -> essBprot.setProt(su.getChildValueByName(child, "PROT"));
                case "D_PROT" -> essBprot.setDprot(su.getChildValueByName(child, "D_PROT"));
            }
        }
        return essBprot;
    }
}
