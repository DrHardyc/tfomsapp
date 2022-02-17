package ru.tfoms.tfomsapp.service.MEK.VMP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Cons;
import ru.tfoms.tfomsapp.domain.MEK.Napr;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPSl;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPUsl;
import ru.tfoms.tfomsapp.service.MEK.ConsService;
import ru.tfoms.tfomsapp.service.MEK.NaprService;

import java.util.ArrayList;
import java.util.List;

@Service
public class VMPSlService {
    private final NaprService naprService = new NaprService();
    private final ConsService consService = new ConsService();
    private final VMPOnkslService vmpOnkslService = new VMPOnkslService();
    private final VMPUslService vmpUslServcie = new VMPUslService();
    public VMPSl loadVmpSl(Element element){
        VMPSl essVmpSl = new VMPSl();
        Elements childs = element.getChildElements();
        List<String> ds2s = new ArrayList<>();
        List<String> ds3s = new ArrayList<>();
        List<String> codemes1 = new ArrayList<>();
        List<Napr> naprs = new ArrayList<>();
        List<Cons> conss = new ArrayList<>();
        List<VMPUsl> usls = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "SL_ID" -> essVmpSl.setSlid(child.getValue());
                case "VID_HMP" -> essVmpSl.setVidhmp(child.getValue());
                case "METOD_HMP" -> essVmpSl.setMetodhmp(child.getValue());
                case "LPU_1" -> essVmpSl.setLpu1(child.getValue());
                case "PODR" -> essVmpSl.setPodr(child.getValue());
                case "PROFIL" -> essVmpSl.setProfil(child.getValue());
                case "PROFIL_K" -> essVmpSl.setProfilk(child.getValue());
                case "DET" -> essVmpSl.setDet(child.getValue());
                case "TAL_D" -> essVmpSl.setTald(child.getValue());
                case "TAL_NUM" -> essVmpSl.setTalnum(child.getValue());
                case "TAL_P" -> essVmpSl.setTalp(child.getValue());
                case "NHISTORY" -> essVmpSl.setNhistory(child.getValue());
                case "DATE_1" -> essVmpSl.setDate1(child.getValue());
                case "DATE_2" -> essVmpSl.setDate2(child.getValue());
                case "DS0" -> essVmpSl.setDs0(child.getValue());
                case "DS1" -> essVmpSl.setDs1(child.getValue());
                case "DS2" -> ds2s.add(child.getValue());
                case "DS3" -> ds3s.add(child.getValue());
                case "C_ZAB" -> essVmpSl.setCzab(child.getValue());
                case "DS_ONK" -> essVmpSl.setDsonk(child.getValue());
                case "CODE_MES1" -> codemes1.add(child.getValue());
                case "CODE_MES2" -> essVmpSl.setCodemes2(child.getValue());
                case "NAPR" -> naprs.add(naprService.loadNapr(child));
                case "CONS" -> conss.add(consService.loadCons(child));
                case "ONK_SL" -> essVmpSl.setOnksl(vmpOnkslService.loadVmpOnksl(child));
                case "PRVS" -> essVmpSl.setPrvs(child.getValue());
                case "VERS_SPEC" -> essVmpSl.setVersspec(child.getValue());
                case "IDDOKT" -> essVmpSl.setIddokt(child.getValue());
                case "ED_COL" -> essVmpSl.setEdcol(child.getValue());
                case "TARIF" -> essVmpSl.setTarif(child.getValue());
                case "SUM_M" -> essVmpSl.setSumm(child.getValue());
                case "USL" -> usls.add(vmpUslServcie.loadVmpUsl(child));
                case "COMENTSL" -> essVmpSl.setComentsl(child.getValue());

            }
        }
        essVmpSl.setDs2(ds2s);
        essVmpSl.setDs3(ds3s);
        essVmpSl.setCodemes1(codemes1);
        essVmpSl.setNapr(naprs);
        essVmpSl.setCons(conss);
        essVmpSl.setUsl(usls);
        return CheckForNull(essVmpSl);
    }

    private VMPSl CheckForNull(VMPSl essVmpSl) {
        if (essVmpSl.getSlid() == null){
            essVmpSl.setSlid("");
        }
        if (essVmpSl.getVidhmp() == null){
            essVmpSl.setVidhmp("");
        }
        if (essVmpSl.getMetodhmp() == null){
            essVmpSl.setMetodhmp("");
        }
        if (essVmpSl.getLpu1() == null){
            essVmpSl.setLpu1("");
        }
        if (essVmpSl.getPodr() == null){
            essVmpSl.setPodr("");
        }
        if (essVmpSl.getProfil() == null){
            essVmpSl.setProfil("");
        }
        if (essVmpSl.getProfilk() == null){
            essVmpSl.setProfilk("");
        }
        if (essVmpSl.getDet() == null){
            essVmpSl.setDet("");
        }
        if (essVmpSl.getTald() == null){
            essVmpSl.setTald("");
        }
        if (essVmpSl.getTalnum() == null){
            essVmpSl.setTald("");
        }
        if (essVmpSl.getTalp() == null){
            essVmpSl.setTalp("");
        }
        if (essVmpSl.getNhistory() == null){
            essVmpSl.setNhistory("");
        }
        if (essVmpSl.getDate1() == null){
            essVmpSl.setDate1("");
        }
        if (essVmpSl.getDate2() == null){
            essVmpSl.setDate2("");
        }
        if (essVmpSl.getDs0() == null){
            essVmpSl.setDs0("");
        }
        if (essVmpSl.getDs1() == null){
            essVmpSl.setDs1("");
        }
        if (essVmpSl.getCzab() == null){
            essVmpSl.setCzab("");
        }
        if (essVmpSl.getDsonk() == null){
            essVmpSl.setDsonk("");
        }
        if (essVmpSl.getCodemes2() == null){
            essVmpSl.setCodemes2("");
        }
        if (essVmpSl.getPrvs() == null){
            essVmpSl.setPrvs("");
        }
        if (essVmpSl.getVersspec() == null){
            essVmpSl.setVersspec("");
        }
        if (essVmpSl.getIddokt() == null){
            essVmpSl.setIddokt("");
        }
        if (essVmpSl.getEdcol() == null){
            essVmpSl.setEdcol("");
        }
        if (essVmpSl.getTarif() == null){
            essVmpSl.setTarif("");
        }
        if (essVmpSl.getSumm() == null){
            essVmpSl.setSumm("");
        }
        if (essVmpSl.getComentsl() == null){
            essVmpSl.setComentsl("");
        }

        return essVmpSl;
    }
}
