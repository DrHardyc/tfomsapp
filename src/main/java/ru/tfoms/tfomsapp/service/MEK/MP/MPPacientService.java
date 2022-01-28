package ru.tfoms.tfomsapp.service.MEK.MP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPPacient;

@Service
public class MPPacientService {
    public MPPacient loadMPPacient(Element element){
        MPPacient essMPPacient = new MPPacient();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ID_PAC" -> essMPPacient.setIdpac(child.getValue());
                case "VPOLIS" -> essMPPacient.setVpolis(child.getValue());
                case "SPOLIS" -> essMPPacient.setSpolis(child.getValue());
                case "NPOLIS" -> essMPPacient.setNpolis(child.getValue());
                case "ENP" -> essMPPacient.setEnp(child.getValue());
                case "ST_OKATO" -> essMPPacient.setStokato(child.getValue());
                case "SMO" -> essMPPacient.setSmo(child.getValue());
                case "SMO_NAM" -> essMPPacient.setSmonam(child.getValue());
                case "INV" -> essMPPacient.setInv(child.getValue());
                case "MSE" -> essMPPacient.setMse(child.getValue());
                case "NOVOR" -> essMPPacient.setNovor(child.getValue());
                case "VNOV_D" -> essMPPacient.setVnovd(child.getValue());
            }
        }
        return essMPPacient;
    }
}
