package ru.tfoms.tfomsapp.service.MEK.MPD;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDPacient;

@Service
public class MPDPacientService {
    public MPDPacient loadMpdPacient(Element element){
        MPDPacient essMpdPacient = new MPDPacient();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ID_PAC" -> essMpdPacient.setIdpac(child.getValue());
                case "VPOLIS" -> essMpdPacient.setVpolis(child.getValue());
                case "SPOLIS" -> essMpdPacient.setSpolis(child.getValue());
                case "NPOLIS" -> essMpdPacient.setNpolis(child.getValue());
                case "ENP" -> essMpdPacient.setEnp(child.getValue());
                case "ST_OKATO" -> essMpdPacient.setStokato(child.getValue());
                case "SMO" -> essMpdPacient.setSmo(child.getValue());
                case "SMO_NAM" -> essMpdPacient.setSmonam(child.getValue());
                case "NOVOR" -> essMpdPacient.setNovor(child.getValue());
            }
        }
        return essMpdPacient;
    }
}
