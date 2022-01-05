package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Usl;

@Service
public class UslService {

    private final Usl essUsl = new Usl();
    private final ServiceUtil su = new ServiceUtil();

    public Usl LoadUsl(Element usl){
        Elements childs = usl.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDSERV" -> essUsl.setIdserv(su.getChildValueByName(child, "IDSERV"));
                case "LPU" -> essUsl.setLpu(su.getChildValueByName(child, "LPU"));
                case "KOD_TP" -> essUsl.setKodtp(su.getChildValueByName(child, "KOD_TP"));
                case "PODR" -> essUsl.setPodr(su.getChildValueByName(child, "PODR"));
                case "PROFI" -> essUsl.setProfil(su.getChildValueByName(child, "PROFIL"));
                case "VID-VME" -> essUsl.setVidvme(su.getChildValueByName(child, "VID_VME"));
                case "DET" -> essUsl.setDet(su.getChildValueByName(child, "DET"));
                case "DATE_IN" -> essUsl.setDatein(su.getChildValueByName(child, "DATE_IN"));
                case "DATE_OUT" -> essUsl.setIdserv(su.getChildValueByName(child, "DATE_OUT"));
                case "DS" -> essUsl.setDs(su.getChildValueByName(child, "DS"));
                case "CODE_USL" -> essUsl.setCodeusl(su.getChildValueByName(child, "CODE_USL"));
                case "KOL_USL" -> essUsl.setKolusl(su.getChildValueByName(child, "KOL_USL"));
                case "SUMV_USL" -> essUsl.setSumvusl(su.getChildValueByName(child, "SUMV_USL"));
                case "PRVS" -> essUsl.setPrvs(su.getChildValueByName(child, "PRVS"));
                case "CODE_MD" -> essUsl.setCodemd(su.getChildValueByName(child, "CODE_MD"));
                case "F_ZUB" -> essUsl.setFzub(su.getChildValueByName(child, "F_ZUB"));
                case "VIS_ZUB" -> essUsl.setViszub(su.getChildValueByName(child, "VIS_ZUB"));
                case "COMENTU" -> essUsl.setComentu(su.getChildValueByName(child, "COMENTU"));
                case "NPL" -> essUsl.setNpl(su.getChildValueByName(child, "NPL"));
                case "P_OTK" -> essUsl.setPotk(su.getChildValueByName(child, "P_OTK"));
                case "PR_ANAST" -> essUsl.setPranast(su.getChildValueByName(child, "PR_ANAST"));

            }
        }
        return essUsl;
    }
}
