package ru.tfoms.tfomsapp.service.MEK.VMP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPUsl;

@Service
public class VMPUslService {
    public VMPUsl loadVmpUsl(Element element){
        VMPUsl essVmpUsl = new VMPUsl();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDSERV" -> essVmpUsl.setIdserv(child.getValue());
                case "LPU" -> essVmpUsl.setLpu(child.getValue());
                case "PODR" -> essVmpUsl.setPodr(child.getValue());
                case "PROFIL" -> essVmpUsl.setProfil(child.getValue());
                case "VIDVME" -> essVmpUsl.setVidvme(child.getValue());
                case "DET" -> essVmpUsl.setDet(child.getValue());
                case "DATE_IN" -> essVmpUsl.setDatein(child.getValue());
                case "DATE_OUT" -> essVmpUsl.setDateout(child.getValue());
                case "DS" -> essVmpUsl.setDs(child.getValue());
                case "CODE_USL" -> essVmpUsl.setCodeusl(child.getValue());
                case "KOL_USL" -> essVmpUsl.setKolusl(child.getValue());
                case "TARIF" -> essVmpUsl.setTarif(child.getValue());
                case "SUMV_USL" -> essVmpUsl.setSumvusl(child.getValue());
                case "PRVS" -> essVmpUsl.setPrvs(child.getValue());
                case "CODE_MD" -> essVmpUsl.setCodemd(child.getValue());
                case "COMENTU" -> essVmpUsl.setComentu(child.getValue());
            }
        }

        return essVmpUsl;
    }
}
