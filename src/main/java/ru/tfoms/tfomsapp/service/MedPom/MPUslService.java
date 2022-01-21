package ru.tfoms.tfomsapp.service.MedPom;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPMeddev;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPMrusln;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPUsl;

import java.util.ArrayList;
import java.util.List;

@Service
public class MPUslService {
    private final MPMeddevService mpMeddevService = new MPMeddevService();
    private final MPMruslnService mpMruslnService = new MPMruslnService();

    public MPUsl loadMpUsl(Element element){
        MPUsl essUsl = new MPUsl();
        List<MPMeddev> mpMeddevs = new ArrayList<>();
        List<MPMrusln> mpMruslns = new ArrayList<>();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDSERV" -> essUsl.setIdserv(child.getValue());
                case "LPU" -> essUsl.setLpu(child.getValue());
                case "LPU_1" -> essUsl.setLpu1(child.getValue());
                case "PODR" -> essUsl.setPodr(child.getValue());
                case "PROFIL" -> essUsl.setProfil(child.getValue());
                case "VID_VME" -> essUsl.setVidvme(child.getValue());
                case "DET" -> essUsl.setDet(child.getValue());
                case "DATE_IN" -> essUsl.setDatein(child.getValue());
                case "DATE_OUT" -> essUsl.setDateout(child.getValue());
                case "DS" -> essUsl.setDs(child.getValue());
                case "CODE_USL" -> essUsl.setCodeusl(child.getValue());
                case "KOL_USL" -> essUsl.setKolusl(child.getValue());
                case "TARIF" -> essUsl.setTarif(child.getValue());
                case "SUMV_USL" -> essUsl.setSumvusl(child.getValue());
                case "MED_DEV" -> mpMeddevs.add(mpMeddevService.loadMPMeddev(child));
                case "MR_USL_N" -> mpMruslns.add(mpMruslnService.loadMPMrusln(child));
                case "NPL" -> essUsl.setNpl(child.getValue());
                case "COMENTU" -> essUsl.setComentu(child.getValue());
            }
        }
        essUsl.setMeddev(mpMeddevs);
        essUsl.setMrusLn(mpMruslns);
        return essUsl;
    }
}
