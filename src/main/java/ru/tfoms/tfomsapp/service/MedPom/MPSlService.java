package ru.tfoms.tfomsapp.service.MedPom;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPLekpr;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPSl;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPUsl;

import java.util.ArrayList;
import java.util.List;

@Service
public class MPSlService {

    private final MPKsgkpgService mpKsgkpgService = new MPKsgkpgService();
    private final MPLekprService mpLekprService = new MPLekprService();
    private final MPUslService mpUslService = new MPUslService();

    public MPSl loadMPSl(Element element){
        MPSl essSl = new MPSl();

        List<String> ds2s = new ArrayList<>();
        List<String> ds3s = new ArrayList<>();
        List<String> codemes1s = new ArrayList<>();
        List<MPLekpr> mpLekprs = new ArrayList<>();
        List<MPUsl> mpUsls = new ArrayList<>();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "SL_ID" -> essSl.setSlid(child.getValue());
                case "LPU_1" -> essSl.setLpu1(child.getValue());
                case "PODR" -> essSl.setPodr(child.getValue());
                case "PROFIL" -> essSl.setProfil(child.getValue());
                case "PORFIL_K" -> essSl.setProfilk(child.getValue());
                case "DET" -> essSl.setDet(child.getValue());
                case "P_CEL" -> essSl.setPcel(child.getValue());
                case "NHISTORY" -> essSl.setNhistory(child.getValue());
                case "P_PER" -> essSl.setPper(child.getValue());
                case "DATE_1" -> essSl.setDate1(child.getValue());
                case "DATE_2" -> essSl.setDate2(child.getValue());
                case "KD" -> essSl.setKd(child.getValue());
                case "WEI" -> essSl.setWai(child.getValue());
                case "DSO" -> essSl.setDso(child.getValue());
                case "DS1" -> essSl.setDs1(child.getValue());
                case "DS2" -> ds2s.add(child.getValue());
                case "DS3" -> ds3s.add(child.getValue());
                case "C_ZAB" -> essSl.setCzab(child.getValue());
                case "DN" -> essSl.setDn(child.getValue());
                case "CODE_MES1" -> codemes1s.add(child.getValue());
                case "CODE_MES2" -> essSl.setCode_mes2(child.getValue());
                case "KSG_KPG" -> essSl.setKsgkpg(mpKsgkpgService.loadMPKsgkpg(child));
                case "REAB" -> essSl.setReab(child.getValue());
                case "PRVS" -> essSl.setPrvs(child.getValue());
                case "VERS_SPEC" -> essSl.setVersspec(child.getValue());
                case "IDDOCT" -> essSl.setIddokt(child.getValue());
                case "ED_COL" -> essSl.setEdcol(child.getValue());
                case "TARIF" -> essSl.setTarif(child.getValue());
                case "SUM_M" -> essSl.setSumm(child.getValue());
                case "LEK_PR" -> mpLekprs.add(mpLekprService.loadMPLekpr(child));
                case "USL" -> mpUsls.add(mpUslService.loadMpUsl(element));
                case "COMENTSL" -> essSl.setComentsl(child.getValue());
            }
        }
        essSl.setDs2(ds2s);
        essSl.setDs3(ds3s);
        essSl.setCode_mes1(codemes1s);
        essSl.setLekpr(mpLekprs);
        essSl.setUsl(mpUsls);
        return essSl;
    }
}
