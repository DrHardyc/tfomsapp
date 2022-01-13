package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Sluch;

@Service
public class SluchService {

    private final ServiceUtil su = new ServiceUtil();
    private final OnkslService onkslService = new OnkslService();
    private final UslService uslService = new UslService();
    private final NaprService naprService = new NaprService();
    private final ConsService consService = new ConsService();

    public Sluch LoadSluch(Element sluch){
        Elements childs = sluch.getChildElements();
        Sluch essSluch = new Sluch();

        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDCASE" -> essSluch.setIdcase(su.getChildValueByName(child,"IDCASE"));
                case "USL_OK" -> essSluch.setUslok(su.getChildValueByName(child,"USL_OK"));
                case "VIDPOM" -> essSluch.setVidpom(su.getChildValueByName(child,"VIDPOM"));
                case "FOR_POM" -> essSluch.setForpom(su.getChildValueByName(child,"FOR_POM"));
                case "NPR_MO" -> essSluch.setNprmo(su.getChildValueByName(child,"NPR_MO"));
                case "NPR_DATE" -> essSluch.setNprdate(su.getChildValueByName(child,"NPR_DATE"));
                case "NPR_NOM" -> essSluch.setNprnom(su.getChildValueByName(child,"NPR_NOM"));
                case "EXTR" -> essSluch.setExtr(su.getChildValueByName(child,"EXTR"));
                case "LPU" -> essSluch.setLpu(su.getChildValueByName(child,"LPU"));
                case "KOD_TP" -> essSluch.setKodtp(su.getChildValueByName(child,"KOD_TP"));
                case "PROFILE" -> essSluch.setProfile(su.getChildValueByName(child,"PROFILE"));
                case "PROFILE_K" -> essSluch.setProfilek(su.getChildValueByName(child,"PROFILE_K"));
                case "DET" -> essSluch.setDet(su.getChildValueByName(child,"DET"));
                case "P_CEL" -> essSluch.setPcel(su.getChildValueByName(child,"P_CEL"));
                case "NHISTORY" -> essSluch.setNhistory(su.getChildValueByName(child,"NHISTORY"));
                case "DATE_1" -> essSluch.setDate1(su.getChildValueByName(child,"DATE_1"));
                case "DATE_2" -> essSluch.setDate2(su.getChildValueByName(child,"DATE_2"));
                case "DS0" -> essSluch.setDs0(su.getChildValueByName(child,"DS0"));
                case "DS1" -> essSluch.setDs1(su.getChildValueByName(child,"DS1"));
                case "DS2" -> essSluch.setDs2(su.getChildValueByName(child,"DS2"));
                case "DS3" -> essSluch.setDs3(su.getChildValueByName(child,"DS3"));
                case "C_ZAB" -> essSluch.setCzab(su.getChildValueByName(child,"C_ZAB"));
                case "DN" -> essSluch.setDn(su.getChildValueByName(child,"DN"));
                case "VNOV_M" -> essSluch.setVnovm(su.getChildValueByName(child,"VNOV_M"));
                case "CODE_MES1" -> essSluch.setCodemes1(su.getChildValueByName(child,"CODE_MES1"));
                case "CODE_MES2" -> essSluch.setCodemes2(su.getChildValueByName(child,"CODE_MES2"));
                case "CEL_OBSL" -> essSluch.setCelobsl(su.getChildValueByName(child,"CEL_OBSL"));
                case "POL_VIS" -> essSluch.setPolvis(su.getChildValueByName(child,"POL_VIS"));
                case "HOM_VIS" -> essSluch.setHomvis(su.getChildValueByName(child,"HOM_VIS"));
                case "RSLT" -> essSluch.setRslt(su.getChildValueByName(child,"RSLT"));
                case "ISHOD" -> essSluch.setIshod(su.getChildValueByName(child,"ISHOD"));
                case "PRVS" -> essSluch.setPrvs(su.getChildValueByName(child,"PRVS"));
                case "VERS_SPEC" -> essSluch.setVersspec(su.getChildValueByName(child,"VERS_SPEC"));
                case "IDDOCT" -> essSluch.setIddokt(su.getChildValueByName(child,"IDDOCT"));
                case "SPEC_END" -> essSluch.setSpecend(su.getChildValueByName(child,"SPEC_END"));
                case "POVTOR" -> essSluch.setPovtor(su.getChildValueByName(child,"POVTOR"));
                case "ZAKONCH" -> essSluch.setZakonch(su.getChildValueByName(child,"ZAKONCH"));
                case "OS_SLUCH" -> essSluch.setOssluch(su.getChildValueByName(child,"OS_SLUCH"));
                case "CEL1" -> essSluch.setCel1(su.getChildValueByName(child,"CEL1"));
                case "TYPE_MN" -> essSluch.setTypemn(su.getChildValueByName(child,"TYPE_MN"));
                case "DISP" -> essSluch.setDisp(su.getChildValueByName(child,"DISP"));
                case "OBR" -> essSluch.setObr(su.getChildValueByName(child,"OBR"));
                case "TIMEV" -> essSluch.setTimev(su.getChildValueByName(child,"TIMEV"));
                case "TIMEP" -> essSluch.setTimep(su.getChildValueByName(child,"TIMEP"));
                case "TL" -> essSluch.setTl(su.getChildValueByName(child,"TL"));
                case "VIDTR" -> essSluch.setVidtr(su.getChildValueByName(child,"VIDTR"));
                case "IDSP" -> essSluch.setIdsp(su.getChildValueByName(child,"IDSP"));
                case "KOD_KSG" -> essSluch.setKodksg(su.getChildValueByName(child,"KODKSG"));
                case "REAB" -> essSluch.setReab(su.getChildValueByName(child,"REAB"));
                case "V_BP" -> essSluch.setVbp(su.getChildValueByName(child,"VB_P"));
                case "VIS_HMP" -> essSluch.setVidhmp(su.getChildValueByName(child,"VID_HMP"));
                case "METOD_HMP" -> essSluch.setMetodhmp(su.getChildValueByName(child,"METOD_HMP"));
                case "TAL_D" -> essSluch.setTald(su.getChildValueByName(child,"TAL_D"));
                case "TAL_P" -> essSluch.setTalp(su.getChildValueByName(child,"TAL_P"));
                case "TAL_NUM" -> essSluch.setTalnum(su.getChildValueByName(child,"TAL_NUM"));
                case "ED_COL" -> essSluch.setEdcol(su.getChildValueByName(child,"ED_COL"));
                case "TSRIF" -> essSluch.setTarif(su.getChildValueByName(child,"TSRIF"));
                case "SUMV" -> essSluch.setSumv(su.getChildValueByName(child,"SUMV"));
                case "OPLATA" -> essSluch.setOplata(su.getChildValueByName(child,"OPLATA"));
                case "SUMP" -> essSluch.setSump(su.getChildValueByName(child,"SUMP"));
                case "SANK_IT" -> essSluch.setSankit(su.getChildValueByName(child,"SANK_IT"));
                case "P_PER" -> essSluch.setPper(su.getChildValueByName(child,"P_PER"));
                case "VBR" -> essSluch.setVbr(su.getChildValueByName(child,"VBR"));
                case "P_OTK" -> essSluch.setPotk(su.getChildValueByName(child,"P_OTK"));
                case "DS1_PR" -> essSluch.setDs1pr(su.getChildValueByName(child,"DS1_PR"));
                case "PR_D_N" -> essSluch.setPrdn(su.getChildValueByName(child,"PR_D_N"));
                case "COMENTSL" -> essSluch.setComentsl(su.getChildValueByName(child,"COMENTSL"));
                case "KSLP_P" -> essSluch.setKslpp(su.getChildValueByName(child,"KSLP_P"));
                case "BARTEL" -> essSluch.setBartel(su.getChildValueByName(child,"BARTEL"));
                case "PERS_POST" -> essSluch.setPerspost(su.getChildValueByName(child,"PERS_POST"));
                case "DATE_R1" -> essSluch.setDater1(su.getChildValueByName(child,"DATE_R1"));
                case "DATE_R2" -> essSluch.setDater2(su.getChildValueByName(child,"DATE_R2"));
                case "SOST" -> essSluch.setSost(su.getChildValueByName(child,"SOST"));
                case "DS_ONK" -> essSluch.setDsonk(su.getChildValueByName(child,"DS_ONK"));
                case "ONK_SL" -> essSluch.setOnksl(onkslService.LoadOnksl(sluch));
                case "USL" -> essSluch.setUsl(uslService.LoadUsl(sluch));
                case "NAPR" -> essSluch.setNapr(naprService.LoadNapr(sluch));
                case "CONS" -> essSluch.setCons(consService.LoadCons(sluch));
            }
        }
        return essSluch;
    }
}
