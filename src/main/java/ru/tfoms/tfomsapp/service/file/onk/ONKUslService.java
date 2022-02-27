package ru.tfoms.tfomsapp.service.file.onk;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.onk.ONKUsl;

@Service
public class ONKUslService {
    public ONKUsl loadOnkUsl(Element element){
        ONKUsl essOnkUsl = new ONKUsl();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDSERV" -> essOnkUsl.setIdserv(child.getValue());
                case "LPU" -> essOnkUsl.setLpu(child.getValue());
                case "LPU_1" -> essOnkUsl.setLpu1(child.getValue());
                case "PODR" -> essOnkUsl.setPodr(child.getValue());
                case "PROFIL" -> essOnkUsl.setProfil(child.getValue());
                case "VID_VME" -> essOnkUsl.setVidvme(child.getValue());
                case "DET" -> essOnkUsl.setDet(child.getValue());
                case "DATE_IN" -> essOnkUsl.setDatein(child.getValue());
                case "DATE_OUT" -> essOnkUsl.setDateout(child.getValue());
                case "DS" -> essOnkUsl.setDs(child.getValue());
                case "CODE_USL" -> essOnkUsl.setCodeusl(child.getValue());
                case "KOL_USL" -> essOnkUsl.setKolusl(child.getValue());
                case "TARIF" -> essOnkUsl.setTarif(child.getValue());
                case "SUMV_USL" -> essOnkUsl.setSumvusl(child.getValue());
                case "PRVS" -> essOnkUsl.setPrvs(child.getValue());
                case "CODE_MD" -> essOnkUsl.setCodemd(child.getValue());
                case "NPL" -> essOnkUsl.setNpl(child.getValue());
                case "COMENTU" -> essOnkUsl.setComentu(child.getValue());
            }
        }
        return CheckForNull(essOnkUsl);
    }

    private ONKUsl CheckForNull(ONKUsl essOnkUsl) {
        if (essOnkUsl.getIdserv() == null){
            essOnkUsl.setIdserv("");
        }
        if (essOnkUsl.getLpu() == null){
            essOnkUsl.setLpu("");
        }
        if (essOnkUsl.getLpu1() == null){
            essOnkUsl.setLpu1("");
        }
        if (essOnkUsl.getPodr() == null){
            essOnkUsl.setPodr("");
        }
        if (essOnkUsl.getProfil() == null){
            essOnkUsl.setProfil("");
        }
        if (essOnkUsl.getVidvme() == null){
            essOnkUsl.setVidvme("");
        }
        if (essOnkUsl.getDet() == null){
            essOnkUsl.setDet("");
        }
        if (essOnkUsl.getDatein() == null){
            essOnkUsl.setDatein("");
        }
        if (essOnkUsl.getDateout() == null){
            essOnkUsl.setDateout("");
        }
        if (essOnkUsl.getDs() == null){
            essOnkUsl.setDs("");
        }
        if (essOnkUsl.getCodeusl() == null){
            essOnkUsl.setCodeusl("");
        }
        if (essOnkUsl.getKolusl() == null){
            essOnkUsl.setKolusl("");
        }
        if (essOnkUsl.getTarif() == null){
            essOnkUsl.setTarif("");
        }
        if (essOnkUsl.getSumvusl() == null){
            essOnkUsl.setSumvusl("");
        }
        if (essOnkUsl.getPrvs() == null){
            essOnkUsl.setPrvs("");
        }
        if (essOnkUsl.getCodemd() == null){
            essOnkUsl.setCodemd("");
        }
        if (essOnkUsl.getNpl() == null){
            essOnkUsl.setNpl("");
        }
        if (essOnkUsl.getComentu() == null){
            essOnkUsl.setComentu("");
        }


        return essOnkUsl;
    }
}
