package ru.tfoms.tfomsapp.service.MEK.MP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Ksgkpg;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPLekpr;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPSl;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPUsl;
import ru.tfoms.tfomsapp.service.MEK.KsgkpgService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MPSlService {
    private final KsgkpgService ksgkpgService = new KsgkpgService();
    private final MPLekprService mpLekprService = new MPLekprService();
    private final MPUslService mpUslService = new MPUslService();
    public MPSl loadMPSl(Element element){
        MPSl essMpsl = new MPSl();
        Elements childs = element.getChildElements();
        List<String> mpDs2 = new ArrayList<>();
        List<String> mpDs3 = new ArrayList<>();
        List<String> mpCodemes1 = new ArrayList<>();
        List<MPLekpr> mpLekprs = new ArrayList<>();
        List<MPUsl> mpUsls = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "SL_ID" -> essMpsl.setSlid(child.getValue());
                case "LPU_1" -> essMpsl.setLpu1(child.getValue());
                case "PODR" -> essMpsl.setPodr(child.getValue());
                case "PROFIL" -> essMpsl.setProfil(child.getValue());
                case "PROFIL_K" -> essMpsl.setProfilk(child.getValue());
                case "DET" -> essMpsl.setDet(child.getValue());
                case "P_CEL" -> essMpsl.setPcel(child.getValue());
                case "NHISTORY" -> essMpsl.setNhistory(child.getValue());
                case "P_PER" -> essMpsl.setPper(child.getValue());
                case "DATE_1" -> essMpsl.setDate1(child.getValue());
                case "DATE_2" -> essMpsl.setDate2(child.getValue());
                case "KD" -> essMpsl.setKd(child.getValue());
                case "WEI" -> essMpsl.setWei(child.getValue());
                case "DS0" -> essMpsl.setDs0(child.getValue());
                case "DS1" -> essMpsl.setDs1(child.getValue());
                case "DS2" -> mpDs2.add(child.getValue());
                case "DS3" -> mpDs3.add(child.getValue());
                case "C_ZAB" -> essMpsl.setCzab(child.getValue());
                case "DN" -> essMpsl.setDn(child.getValue());
                case "CODE_MES1" -> mpCodemes1.add(child.getValue());
                case "CODE_MES2" -> essMpsl.setCodemes2(child.getValue());
                case "KSG_KPG" -> essMpsl.setKsgkpg(ksgkpgService.loadKsgkpg(child));
                case "REAB" -> essMpsl.setReab(child.getValue());
                case "PRVS" -> essMpsl.setPrvs(child.getValue());
                case "VERS_SPEC" -> essMpsl.setVersspec(child.getValue());
                case "IDDOKT" -> essMpsl.setIddoct(child.getValue());
                case "ED_COL" -> essMpsl.setEdcol(child.getValue());
                case "TARIF" -> essMpsl.setTarif(child.getValue());
                case "SUM_M" -> essMpsl.setSumm(child.getValue());
                case "LEK_PR" -> mpLekprs.add(mpLekprService.loadMPLekpr(child));
                case "USL" -> mpUsls.add(mpUslService.loadMpUsl(child));
                case "COMENTSL" -> essMpsl.setComentsl(child.getValue());
            }
        }
        essMpsl.setDs2(mpDs2);
        essMpsl.setDs3(mpDs3);
        essMpsl.setCodemes1(mpCodemes1);
        essMpsl.setLekpr(mpLekprs);
        essMpsl.setUsl(mpUsls);
        return essMpsl;
    }
}