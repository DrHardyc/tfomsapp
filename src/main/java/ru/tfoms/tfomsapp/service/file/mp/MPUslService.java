package ru.tfoms.tfomsapp.service.file.mp;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.mp.MPMeddev;
import ru.tfoms.tfomsapp.domain.file.mp.MPUsl;
import ru.tfoms.tfomsapp.domain.file.Mrusln;
import ru.tfoms.tfomsapp.service.file.MruslnService;

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
        return CheckForNull(essMpUsl);
    }

    private MPUsl CheckForNull(MPUsl essMpUsl) {
        if (essMpUsl.getIdserv() == null){
            essMpUsl.setIdserv("");
        }
        if (essMpUsl.getLpu() == null){
            essMpUsl.setLpu("");
        }
        if (essMpUsl.getLpu1() == null){
            essMpUsl.setLpu1("");
        }
        if (essMpUsl.getPodr() == null){
            essMpUsl.setPodr("");
        }
        if (essMpUsl.getProfil() == null){
            essMpUsl.setProfil("");
        }
        if (essMpUsl.getVidvme() == null){
            essMpUsl.setVidvme("");
        }
        if (essMpUsl.getDet() == null){
            essMpUsl.setDet("");
        }
        if (essMpUsl.getDatein() == null){
            essMpUsl.setDatein("");
        }
        if (essMpUsl.getDateout() == null){
            essMpUsl.setDateout("");
        }
        if (essMpUsl.getDs() == null){
            essMpUsl.setDs("");
        }
        if (essMpUsl.getCodeusl() == null){
            essMpUsl.setCodeusl("");
        }
        if (essMpUsl.getKolusl() == null){
            essMpUsl.setKolusl("");
        }
        if (essMpUsl.getTarif() == null){
            essMpUsl.setTarif("");
        }
        if (essMpUsl.getSumvusl() == null){
            essMpUsl.setSumvusl("");
        }
        if (essMpUsl.getNpl() == null){
            essMpUsl.setNpl("");
        }
        if (essMpUsl.getNpl() == null){
            essMpUsl.setNpl("");
        }
        if (essMpUsl.getComentu() == null){
            essMpUsl.setComentu("");
        }

        return essMpUsl;
    }
}
