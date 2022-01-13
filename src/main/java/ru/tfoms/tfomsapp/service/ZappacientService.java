package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.ZapPacient;

@Service
public class ZappacientService {

    private final ServiceUtil su = new ServiceUtil();

    public ZapPacient LoadZappacient(Element zappacient){
        Elements childs = zappacient.getChildElements();
        ZapPacient essZappacient = new ZapPacient();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ID_PAC" -> essZappacient.setIdpac(su.getChildValueByName(child, "ID_PAC"));
                case "VPOLIS" -> essZappacient.setVpolis(su.getChildValueByName(child, "VPOLIS"));
                case "SPOLIS" -> essZappacient.setSpolis(su.getChildValueByName(child, "SPOLIS"));
                case "NPOLIS" -> essZappacient.setEnp(su.getChildValueByName(child, "NPOLIS"));
                case "SMO" -> essZappacient.setSmo(su.getChildValueByName(child, "SMO"));
                case "SMO_OGRN" -> essZappacient.setSmoogrn(su.getChildValueByName(child, "SMO_OGRN"));
                case "SMO_OK" -> essZappacient.setSmook(su.getChildValueByName(child, "SMO_OK"));
                case "SMO_NAM" -> essZappacient.setSmonam(su.getChildValueByName(child, "SMO_NAM"));
                case "NOVOR" -> essZappacient.setNovor(su.getChildValueByName(child, "NOVOR"));
                case "VNOV_D" -> essZappacient.setVnovd(su.getChildValueByName(child, "VNOV_D"));
                case "MSE" -> essZappacient.setMse(su.getChildValueByName(child, "MSE"));
                case "INV" -> essZappacient.setInv(su.getChildValueByName(child, "INV"));
            }
        }
        return essZappacient;
    }
}
