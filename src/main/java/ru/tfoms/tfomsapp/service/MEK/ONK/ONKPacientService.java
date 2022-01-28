package ru.tfoms.tfomsapp.service.MEK.ONK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKPacient;

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
        return essOnkPacient;
    }
}
