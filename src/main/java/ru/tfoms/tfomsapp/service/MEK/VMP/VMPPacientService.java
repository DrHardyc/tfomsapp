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
        return CheckForNull(essVmpPacient);
    }

    private VMPPacient CheckForNull(VMPPacient essVmpPacient) {
        if (essVmpPacient.getIdpac() == null){
            essVmpPacient.setIdpac("");
        }
        if (essVmpPacient.getVpolis() == null){
            essVmpPacient.setVpolis("");
        }
        if (essVmpPacient.getSpolis() == null){
            essVmpPacient.setSpolis("");
        }
        if (essVmpPacient.getNpolis() == null){
            essVmpPacient.setNpolis("");
        }
        if (essVmpPacient.getStokato() == null){
            essVmpPacient.setStokato("");
        }
        if (essVmpPacient.getSmo() == null){
            essVmpPacient.setSmo("");
        }
        if (essVmpPacient.getSmoogrn() == null){
            essVmpPacient.setSmoogrn("");
        }
        if (essVmpPacient.getSmook() == null){
            essVmpPacient.setSmook("");
        }
        if (essVmpPacient.getSmonam() == null){
            essVmpPacient.setSmonam("");
        }
        if(essVmpPacient.getMse() == null){
            essVmpPacient.setMse("");
        }
        if (essVmpPacient.getNovor() == null){
            essVmpPacient.setNovor("");
        }
        if (essVmpPacient.getVnovd() == null){
            essVmpPacient.setVnovd("");
        }


        return essVmpPacient;
    }

}
