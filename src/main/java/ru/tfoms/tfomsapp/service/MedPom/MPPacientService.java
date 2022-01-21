package ru.tfoms.tfomsapp.service.MedPom;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPPacient;

@Service
public class MPPacientService {
    public MPPacient mpPacient(Element element){
        MPPacient essPacient = new MPPacient();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ID_PAC" -> essPacient.setIdpac(child.getValue());
                case "VPOLIS" -> essPacient.setVpolis(child.getValue());
                case "SPOLIS" -> essPacient.setSpolis(child.getValue());
                case "NPOLOS" -> essPacient.setNpolis(child.getValue());
                case "ENP" -> essPacient.setEnp(child.getValue());
                case "ST_OKATO" -> essPacient.setStokato(child.getValue());
                case "SMO" -> essPacient.setSmo(child.getValue());
                case "SMO_NAM" -> essPacient.setSmonam(child.getValue());
                case "INV" -> essPacient.setInv(child.getValue());
                case "MSE" -> essPacient.setMse(child.getValue());
                case "NOVOR" -> essPacient.setNovor(child.getValue());
                case "VNOV_D" -> essPacient.setVnovd(child.getValue());
            }
        }
        return essPacient;
    }
}
