package ru.tfoms.tfomsapp.service.file.onk;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.Cons;
import ru.tfoms.tfomsapp.domain.file.Napr;
import ru.tfoms.tfomsapp.domain.file.onk.ONKSl;
import ru.tfoms.tfomsapp.domain.file.onk.ONKUsl;
import ru.tfoms.tfomsapp.service.file.ConsService;
import ru.tfoms.tfomsapp.service.file.KsgkpgService;
import ru.tfoms.tfomsapp.service.file.NaprService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ONKSlService {
    private final NaprService naprService = new NaprService();
    private final ConsService consService = new ConsService();
    private final ONKOnkslService onkOnkslService = new ONKOnkslService();
    private final KsgkpgService ksgkpgService = new KsgkpgService();
    private final ONKUslService onkUslService = new ONKUslService();
    public ONKSl loadOnkSl(Element element){
        ONKSl essOnkSl = new ONKSl();
        Elements childs = element.getChildElements();
        List<String> ds2s = new ArrayList<>();
        List<String> ds3s = new ArrayList<>();
        List<String> codemes1s = new ArrayList<>();
        List<Napr> naprs = new ArrayList<>();
        List<Cons> cons = new ArrayList<>();
        List<ONKUsl> onkUsls = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "SL_ID" -> essOnkSl.setSlid(child.getValue());
                case "LPU_1" -> essOnkSl.setLpu1(child.getValue());
                case "PODR" -> essOnkSl.setPodr(child.getValue());
                case "PROFIL" -> essOnkSl.setProfil(child.getValue());
                case "PROFIL_K" -> essOnkSl.setProfilk(child.getValue());
                case "DET" -> essOnkSl.setDet(child.getValue());
                case "P_CEL" -> essOnkSl.setPcel(child.getValue());
                case "NHISTORY" -> essOnkSl.setNhistory(child.getValue());
                case "P_PER" -> essOnkSl.setPper(child.getValue());
                case "DATE_1" -> essOnkSl.setDate1(child.getValue());
                case "DATE_2" -> essOnkSl.setDate2(child.getValue());
                case "KD" -> essOnkSl.setKd(child.getValue());
                case "DS0" -> essOnkSl.setDs0(child.getValue());
                case "DS1" -> essOnkSl.setDs1(child.getValue());
                case "DS2" -> ds2s.add(child.getValue());
                case "DS3" -> ds3s.add(child.getValue());
                case "C_ZAB" -> essOnkSl.setCzab(child.getValue());
                case "DS_ONK" -> essOnkSl.setDsonk(child.getValue());
                case "DN" -> essOnkSl.setDn(child.getValue());
                case "CODE_MES1" -> codemes1s.add(child.getValue());
                case "CODE_MES2" -> essOnkSl.setCodemes2(child.getValue());
                case "NAPR" -> naprs.add(naprService.loadNapr(child));
                case "CONS" -> cons.add(consService.loadCons(child));
                case "ONK_SL" -> onkOnkslService.loadOnkOnksl(child);
                case "KSG_KPG" -> essOnkSl.setKsgkpg(ksgkpgService.loadKsgkpg(child));
                case "REAB" -> essOnkSl.setReab(child.getValue());
                case "PRVS" -> essOnkSl.setPrvs(child.getValue());
                case "VERS_SPEC" -> essOnkSl.setVersspec(child.getValue());
                case "IDDOKT" -> essOnkSl.setIddokt(child.getValue());
                case "ED_COL" -> essOnkSl.setEdcol(child.getValue());
                case "TARIF" -> essOnkSl.setTarif(child.getValue());
                case "SUM_M" -> essOnkSl.setSumm(child.getValue());
                case "USL" -> onkUsls.add(onkUslService.loadOnkUsl(child));
                case "COMENTSL" -> essOnkSl.setComentsl(child.getValue());
            }
        }
        essOnkSl.setDs2(ds2s);
        essOnkSl.setDs3(ds3s);
        essOnkSl.setCodemes1(codemes1s);
        essOnkSl.setNapr(naprs);
        essOnkSl.setCons(cons);
        essOnkSl.setUsl(onkUsls);
        return CheckForNull(essOnkSl);
    }

    private ONKSl CheckForNull(ONKSl essOnkSl) {
        if (essOnkSl.getSlid() == null){
            essOnkSl.setSlid("");
        }
        if (essOnkSl.getLpu1() == null){
            essOnkSl.setLpu1("");
        }
        if (essOnkSl.getPodr() == null){
            essOnkSl.setPodr("");
        }
        if (essOnkSl.getProfil() == null){
            essOnkSl.setProfil("");
        }
        if (essOnkSl.getProfilk() == null){
            essOnkSl.setProfilk("");
        }
        if (essOnkSl.getDet() == null){
            essOnkSl.setDet("");
        }
        if (essOnkSl.getPcel() == null){
            essOnkSl.setPcel("");
        }
        if (essOnkSl.getNhistory() == null){
            essOnkSl.setNhistory("");
        }
        if (essOnkSl.getPper() == null){
            essOnkSl.setPper("");
        }
        if (essOnkSl.getDate1() == null){
            essOnkSl.setDate1("");
        }
        if (essOnkSl.getDate2() == null){
            essOnkSl.setDate2("");
        }
        if (essOnkSl.getKd() == null){
            essOnkSl.setKd("");
        }
        if (essOnkSl.getDs0() == null){
            essOnkSl.setDs0("");
        }
        if (essOnkSl.getDs1() == null){
            essOnkSl.setDs1("");
        }
        if (essOnkSl.getCzab() == null){
            essOnkSl.setCzab("");
        }
        if (essOnkSl.getDsonk() == null){
            essOnkSl.setDsonk("");
        }
        if (essOnkSl.getDn() == null){
            essOnkSl.setDn("");
        }
        if (essOnkSl.getCodemes2() == null){
            essOnkSl.setCodemes2("");
        }
        if (essOnkSl.getReab() == null){
            essOnkSl.setReab("");
        }
        if (essOnkSl.getPrvs() == null){
            essOnkSl.setPrvs("");
        }
        if (essOnkSl.getVersspec() == null){
            essOnkSl.setVersspec("");
        }
        if (essOnkSl.getIddokt() == null){
            essOnkSl.setIddokt("");
        }
        if (essOnkSl.getEdcol() == null){
            essOnkSl.setEdcol("");
        }
        if (essOnkSl.getTarif() == null){
            essOnkSl.setTarif("");
        }
        if (essOnkSl.getSumm() == null){
            essOnkSl.setSumm("");
        }
        if (essOnkSl.getComentsl() == null){
            essOnkSl.setComentsl("");
        }


        return essOnkSl;
    }
}
