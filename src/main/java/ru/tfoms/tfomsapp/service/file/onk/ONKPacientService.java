package ru.tfoms.tfomsapp.service.file.onk;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.onk.ONKPacient;

@Service
public class ONKPacientService {
    public ONKPacient loadOnkPacient(Element element){
        ONKPacient essOnkPacient = new ONKPacient();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ID_PAC" -> essOnkPacient.setIdpac(child.getValue());
                case "VPOLIS" -> essOnkPacient.setVpolis(child.getValue());
                case "SPOLIS" -> essOnkPacient.setSpolis(child.getValue());
                case "NPOLIS" -> essOnkPacient.setNpolis(child.getValue());
                case "ST_OKATO" -> essOnkPacient.setStokato(child.getValue());
                case "SMO" -> essOnkPacient.setSmo(child.getValue());
                case "SMO_OGRN" -> essOnkPacient.setSmoogrn(child.getValue());
                case "SMO_OK" -> essOnkPacient.setSmook(child.getValue());
                case "SMO_NAM" -> essOnkPacient.setSmonam(child.getValue());
                case "INV" -> essOnkPacient.setInv(child.getValue());
                case "MSE" -> essOnkPacient.setMse(child.getValue());
                case "NOVOR" -> essOnkPacient.setNovor(child.getValue());
                case "VNOV_D" -> essOnkPacient.setVnovd(child.getValue());
            }
        }
        return CheckForNull(essOnkPacient);
    }

    private ONKPacient CheckForNull(ONKPacient essOnkPacient) {
        if (essOnkPacient.getIdpac() == null){
            essOnkPacient.setIdpac("");
        }
        if (essOnkPacient.getVpolis() == null){
            essOnkPacient.setVpolis("");
        }
        if (essOnkPacient.getSpolis() == null){
            essOnkPacient.setSpolis("");
        }
        if (essOnkPacient.getNpolis() == null){
            essOnkPacient.setNpolis("");
        }
        if (essOnkPacient.getStokato() == null){
            essOnkPacient.setStokato("");
        }
        if (essOnkPacient.getSmo() == null){
            essOnkPacient.setSmo("");
        }
        if (essOnkPacient.getSmoogrn() == null){
            essOnkPacient.setSmoogrn("");
        }
        if (essOnkPacient.getSmook() == null){
            essOnkPacient.setSmook("");
        }
        if (essOnkPacient.getSmonam() == null){
            essOnkPacient.setSmonam("");
        }
        if (essOnkPacient.getInv() == null){
            essOnkPacient.setInv("");
        }
        if (essOnkPacient.getMse() == null){
            essOnkPacient.setMse("");
        }
        if (essOnkPacient.getNovor() == null){
            essOnkPacient.setNovor("");
        }
        if (essOnkPacient.getVnovd() == null){
            essOnkPacient.setVnovd("");
        }

        return essOnkPacient;
    }
}
