package ru.tfoms.tfomsapp.service.MEK.VMP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPPacient;

@Service
public class VMPPacientService {
    public VMPPacient loadVmpPacient(Element element){
        VMPPacient essVmpPacient = new VMPPacient();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ID_PAC" -> essVmpPacient.setIdpac(child.getValue());
                case "VPOLIS" -> essVmpPacient.setVpolis(child.getValue());
                case "SPOLIS" -> essVmpPacient.setSpolis(child.getValue());
                case "NPOLIS" -> essVmpPacient.setNpolis(child.getValue());
                case "ST_OKATO" -> essVmpPacient.setStokato(child.getValue());
                case "SMO" -> essVmpPacient.setSmo(child.getValue());
                case "SMO_OGRN" -> essVmpPacient.setSmoogrn(child.getValue());
                case "SMO_OK" -> essVmpPacient.setSmook(child.getValue());
                case "SMO_NAM" -> essVmpPacient.setSmonam(child.getValue());
                case "MSE" -> essVmpPacient.setMse(child.getValue());
                case "NOVOR" -> essVmpPacient.setNovor(child.getValue());
                case "VNOV_D" -> essVmpPacient.setVnovd(child.getValue());
            }
        }
        return essVmpPacient;
    }

}
