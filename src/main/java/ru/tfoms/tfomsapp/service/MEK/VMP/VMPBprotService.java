package ru.tfoms.tfomsapp.service.MEK.VMP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPBprot;

@Service
public class VMPBprotService {
    public VMPBprot loadVmpBprot(Element element){
        VMPBprot essVmpBprot = new VMPBprot();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "PROT" -> essVmpBprot.setProt(child.getValue());
                case "D_PROT" -> essVmpBprot.setDprot(child.getValue());
            }
        }
        return CHeckForNull(essVmpBprot);
    }

    private VMPBprot CHeckForNull(VMPBprot essVmpBprot) {
        if (essVmpBprot.getProt() == null){
            essVmpBprot.setProt("");
        }
        if (essVmpBprot.getDprot() == null){
            essVmpBprot.setDprot("");
        }


        return essVmpBprot;
    }
}
