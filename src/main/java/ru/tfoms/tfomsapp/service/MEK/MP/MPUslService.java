package ru.tfoms.tfomsapp.service.MEK.MP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPMeddev;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPUsl;
import ru.tfoms.tfomsapp.domain.MEK.Mrusln;
import ru.tfoms.tfomsapp.service.MEK.MruslnService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MPUslService {
    private final MPMeddevService mpMeddevService = new MPMeddevService();
    private final MruslnService mruslnService = new MruslnService();

    public MPUsl loadMpUsl(Element element){
        MPUsl essMpUsl = new MPUsl();
        List<MPMeddev> mpMeddevList = new ArrayList<>();
        List<Mrusln> mrUslns = new ArrayList<>();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDSERV" -> essMpUsl.setIdserv(child.getValue());
                case "LPU" -> essMpUsl.setLpu(child.getValue());
                case "LPU_1" -> essMpUsl.setLpu1(child.getValue());
                case "PODR" -> essMpUsl.setPodr(child.getValue());
                case "PROFIL" -> essMpUsl.setProfil(child.getValue());
                case "VID_VME" -> essMpUsl.setVidvme(child.getValue());
                case "DET" -> essMpUsl.setDet(child.getValue());
                case "DATE_IN" -> essMpUsl.setDatein(child.getValue());
                case "DATE_OUT" -> essMpUsl.setDateout(child.getValue());
                case "DS" -> essMpUsl.setDs(child.getValue());
                case "CODE_USL" -> essMpUsl.setCodeusl(child.getValue());
                case "KOL_USL" -> essMpUsl.setKolusl(child.getValue());
                case "TARIF" -> essMpUsl.setTarif(child.getValue());
                case "SUMV_USL" -> essMpUsl.setSumvusl(child.getValue());
                case "MED_DEV" -> mpMeddevList.add(mpMeddevService.loadMpMeddev(child));
                case "MR_USL_N" -> mrUslns.add(mruslnService.loadMrusln(child));
                case "NPL" -> essMpUsl.setNpl(child.getValue());
                case "COMENTU" -> essMpUsl.setComentu(child.getValue());
            }
        }
        essMpUsl.setMeddev(mpMeddevList);
        essMpUsl.setMruslns(mrUslns);
        return essMpUsl;
    }
}
