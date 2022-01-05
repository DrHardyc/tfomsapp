package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.ZapPcient;

@Service
public class ZappacientService {

    private final ZapPcient essZappcient = new ZapPcient();
    private final ServiceUtil su = new ServiceUtil();

    public ZapPcient LoadZappacient(Element zappacient){
        Elements childs = zappacient.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ID_PAC" -> essZappcient.setIdpac(su.getChildValueByName(child, "ID_PAC"));
                case "VPOLIS" -> essZappcient.setVpolis(su.getChildValueByName(child, "VPOLIS"));
                case "SPOLIS" -> essZappcient.setSpolis(su.getChildValueByName(child, "SPOLIS"));
                case "NPOLIS" -> essZappcient.setEnp(su.getChildValueByName(child, "NPOLIS"));
                case "SMO" -> essZappcient.setSmo(su.getChildValueByName(child, "SMO"));
                case "SMO_OGRN" -> essZappcient.setSmoogrn(su.getChildValueByName(child, "SMO_OGRN"));
                case "SMO_OK" -> essZappcient.setSmook(su.getChildValueByName(child, "SMO_OK"));
                case "SMO_NAM" -> essZappcient.setSmonam(su.getChildValueByName(child, "SMO_NAM"));
                case "NOVOR" -> essZappcient.setNovor(su.getChildValueByName(child, "NOVOR"));
                case "VNOV_D" -> essZappcient.setVnovd(su.getChildValueByName(child, "VNOV_D"));
                case "MSE" -> essZappcient.setMse(su.getChildValueByName(child, "MSE"));
                case "INV" -> essZappcient.setInv(su.getChildValueByName(child, "INV"));
            }
        }
        return essZappcient;
    }
}
