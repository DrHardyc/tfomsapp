package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Sluch;

@Service
public class SluchService {

    private final Sluch essSluch = new Sluch();
    private final ServiceUtil su = new ServiceUtil();
    private final OnkslService onkslService = new OnkslService();
    private final UslService uslService = new UslService();
    private final NaprService naprService = new NaprService();
    private final ConsService consService = new ConsService();

    public Sluch LoadSluch(Element sluch){
        Elements childs = sluch.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDCASE" -> essSluch.setIdcase(su.getChildValueByName(sluch,"IDCASE"));
                case "USL_OK" -> essSluch.setUslok(su.getChildValueByName(sluch,"USL_OK"));
                case "VIDPOM" -> essSluch.setVidpom(su.getChildValueByName(sluch,"VIDPOM"));
                case "FOR_POM" ->essSluch.setForpom(su.getChildValueByName(sluch,"FOR_POM"));
                case "NPR_MO" ->essSluch.setNprmo(su.getChildValueByName(sluch,"NPR_MO"));
                case "NPR_DATE" ->essSluch.setNprdate(su.getChildValueByName(sluch,"NPR_DATE"));
                case "NPR_NOM" ->essSluch.setNprnom(su.getChildValueByName(sluch,"NPR_NOM"));
                case "EXTR" ->essSluch.setExtr(su.getChildValueByName(sluch,"EXTR"));
                case "LPU" -> essSluch.setLpu(su.getChildValueByName(sluch,"LPU"));
                case "KOD_TP" -> essSluch.setKodtp(su.getChildValueByName(sluch,"KOD_TP"));
                case "PROFILE" -> essSluch.setProfile(su.getChildValueByName(sluch,"PROFILE"));
                case "PROFILE_K" -> essSluch.setProfilek(su.getChildValueByName(sluch,"PROFILE_K"));
                case "DET" -> essSluch.setDet(su.getChildValueByName(sluch,"DET"));
                case "P_CEL" -> essSluch.setPcel(su.getChildValueByName(sluch,"P_CEL"));
                case "NHISTORY" -> essSluch.setNhistory(su.getChildValueByName(sluch,"NHISTORY"));
                case "DATE_1" -> essSluch.setDate1(su.getChildValueByName(sluch,"DATE_1"));
                case "DATE_2" -> essSluch.setDate2(su.getChildValueByName(sluch,"DATE_2"));
                case "DS0" -> essSluch.setDs0(su.getChildValueByName(sluch,"DS0"));
                case "DS1" -> essSluch.setDs1(su.getChildValueByName(sluch,"DS1"));
                case "DS2" -> essSluch.setDs2(su.getChildValueByName(sluch,"DS2"));
                case "DS3" -> essSluch.setDs3(su.getChildValueByName(sluch,"DS3"));
                case "C_ZAB" -> essSluch.setCzab(su.getChildValueByName(sluch,"C_ZAB"));
                case "DN" -> essSluch.setDn(su.getChildValueByName(sluch,"DN"));
                case "VNOV_M" -> essSluch.setVnovm(su.getChildValueByName(sluch,"VNOV_M"));
                case "CODE_MES1" -> essSluch.setCodemes1(su.getChildValueByName(sluch,"CODE_MES1"));
                case "CODE_MES2" -> essSluch.setCodemes2(su.getChildValueByName(sluch,"CODE_MES2"));
                case "CEL_OBSL" -> essSluch.setCelobsl(su.getChildValueByName(sluch,"CEL_OBSL"));
                case "POL_VIS" -> essSluch.setPolvis(su.getChildValueByName(sluch,"POL_VIS"));
                case "HOM_VIS" -> essSluch.setHomvis(su.getChildValueByName(sluch,"HOM_VIS"));
                case "RSLT" -> essSluch.setRslt(su.getChildValueByName(sluch,"RSLT"));
                case "ISHOD" -> essSluch.setIshod(su.getChildValueByName(sluch,"ISHOD"));
                case "PRVS" -> essSluch.setPrvs(su.getChildValueByName(sluch,"PRVS"));
                case "VERS_SPEC" -> essSluch.setVersspec(su.getChildValueByName(sluch,"VERS_SPEC"));
                case "IDDOCT" -> essSluch.setIddokt(su.getChildValueByName(sluch,"IDDOCT"));
                case "SPEC_END" -> essSluch.setSpecend(su.getChildValueByName(sluch,"SPEC_END"));
                case "POVTOR" -> essSluch.setPovtor(su.getChildValueByName(sluch,"POVTOR"));
                case "ZAKONCH" -> essSluch.setZakonch(su.getChildValueByName(sluch,"ZAKONCH"));
                case "OS_SLUCH" -> essSluch.setOssluch(su.getChildValueByName(sluch,"OS_SLUCH"));
                case "CEL1" -> essSluch.setCel1(su.getChildValueByName(sluch,"CEL1"));
                case "TYPE_MN" -> essSluch.setTypemn(su.getChildValueByName(sluch,"TYPE_MN"));
                case "DISP" -> essSluch.setDisp(su.getChildValueByName(sluch,"DISP"));
                case "OBR" -> essSluch.setObr(su.getChildValueByName(sluch,"OBR"));
                case "TIMEV" -> essSluch.setTimev(su.getChildValueByName(sluch,"TIMEV"));
                case "TIMEP" -> essSluch.setTimep(su.getChildValueByName(sluch,"TIMEP"));
                case "TL" -> essSluch.setTl(su.getChildValueByName(sluch,"TL"));
                case "VIDTR" -> essSluch.setVidtr(su.getChildValueByName(sluch,"VIDTR"));
                case "IDSP" -> essSluch.setIdsp(su.getChildValueByName(sluch,"IDSP"));
                case "KOD_KSG" -> essSluch.setKodksg(su.getChildValueByName(sluch,"KODKSG"));
                case "REAB" -> essSluch.setReab(su.getChildValueByName(sluch,"REAB"));
                case "V_BP" -> essSluch.setVbp(su.getChildValueByName(sluch,"VB_P"));
                case "VIS_HMP" -> essSluch.setVidhmp(su.getChildValueByName(sluch,"VID_HMP"));
                case "METOD_HMP" -> essSluch.setMetodhmp(su.getChildValueByName(sluch,"METOD_HMP"));
                case "TAL_D" -> essSluch.setTald(su.getChildValueByName(sluch,"TAL_D"));
                case "TAL_P" -> essSluch.setTalp(su.getChildValueByName(sluch,"TAL_P"));
                case "TAL_NUM" -> essSluch.setTalnum(su.getChildValueByName(sluch,"TAL_NUM"));
                case "ED_COL" -> essSluch.setEdcol(su.getChildValueByName(sluch,"ED_COL"));
                case "TSRIF" -> essSluch.setTarif(su.getChildValueByName(sluch,"TSRIF"));
                case "SUMV" -> essSluch.setSumv(su.getChildValueByName(sluch,"SUMV"));
                case "OPLATA" -> essSluch.setOplata(su.getChildValueByName(sluch,"OPLATA"));
                case "SUMP" -> essSluch.setSump(su.getChildValueByName(sluch,"SUMP"));
                case "SANK_IT" -> essSluch.setSankit(su.getChildValueByName(sluch,"SANK_IT"));
                case "P_PER" -> essSluch.setPper(su.getChildValueByName(sluch,"P_PER"));
                case "VBR" -> essSluch.setVbr(su.getChildValueByName(sluch,"VBR"));
                case "P_OTK" -> essSluch.setPotk(su.getChildValueByName(sluch,"P_OTK"));
                case "DS1_PR" -> essSluch.setDs1pr(su.getChildValueByName(sluch,"DS1_PR"));
                case "PR_D_N" -> essSluch.setPrdn(su.getChildValueByName(sluch,"PR_D_N"));
                case "COMENTSL" -> essSluch.setComentsl(su.getChildValueByName(sluch,"COMENTSL"));
                case "KSLP_P" -> essSluch.setKslpp(su.getChildValueByName(sluch,"KSLP_P"));
                case "BARTEL" -> essSluch.setBartel(su.getChildValueByName(sluch,"BARTEL"));
                case "PERS_POST" -> essSluch.setPerspost(su.getChildValueByName(sluch,"PERS_POST"));
                case "DATE_R1" -> essSluch.setDater1(su.getChildValueByName(sluch,"DATE_R1"));
                case "DATE_R2" -> essSluch.setDater2(su.getChildValueByName(sluch,"DATE_R2"));
                case "SOST" -> essSluch.setSost(su.getChildValueByName(sluch,"SOST"));
                case "DS_ONK" -> essSluch.setDsonk(su.getChildValueByName(sluch,"DS_ONK"));
                case "ONK_SL" -> essSluch.setOnksl(onkslService.LoadOnksl(sluch));
                case "USL" -> essSluch.setUsl(uslService.LoadUsl(sluch));
                case "NAPR" -> essSluch.setNapr(naprService.LoadNapr(sluch));
                case "CONS" -> essSluch.setCons(consService.LoadCons(sluch));
            }
        }
        return essSluch;
    }
}
