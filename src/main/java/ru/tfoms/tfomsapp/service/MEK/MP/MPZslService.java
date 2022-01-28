package ru.tfoms.tfomsapp.service.MEK.MP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPSl;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPZsl;
import ru.tfoms.tfomsapp.domain.MEK.Sank;
import ru.tfoms.tfomsapp.service.MEK.SankService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MPZslService {
    private final MPSlService mpSlService = new MPSlService();
    private final SankService sankService = new SankService();

    public MPZsl loadMPZsl(Element element){
        MPZsl essMPZsl = new MPZsl();
        List<String> vnovm = new ArrayList<>();
        List<MPSl> mpSls = new ArrayList<>();
        List<String> ossluch = new ArrayList<>();
        List<Sank> sanks = new ArrayList<>();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDCASE" -> essMPZsl.setIdcase(child.getValue());
                case "USL_OK" -> essMPZsl.setUslok(child.getValue());
                case "VIDPOM" -> essMPZsl.setVidpom(child.getValue());
                case "FOR_POM" -> essMPZsl.setForpom(child.getValue());
                case "NPR_MO" -> essMPZsl.setNprmo(child.getValue());
                case "NPR_DATE" -> essMPZsl.setNprdate(child.getValue());
                case "LPU" -> essMPZsl.setLpu(child.getValue());
                case "DATE_Z_1" -> essMPZsl.setDatez1(child.getValue());
                case "DATE_Z_2" -> essMPZsl.setDatez2(child.getValue());
                case "KD_Z" -> essMPZsl.setKdz(child.getValue());
                case "VNOV_M" -> vnovm.add(child.getValue());
                case "RSLT" -> essMPZsl.setRslt(child.getValue());
                case "ISHOD" -> essMPZsl.setIshod(child.getValue());
                case "OS_SLUCH" -> ossluch.add(child.getValue());
                case "VB_P" -> essMPZsl.setVbp(child.getValue());
                case "SL" -> mpSls.add(mpSlService.loadMPSl(child));
                case "IDSP" -> essMPZsl.setIdsp(child.getValue());
                case "SUMV" -> essMPZsl.setSumv(child.getValue());
                case "OPLATA" -> essMPZsl.setOplata(child.getValue());
                case "SUMP" -> essMPZsl.setSump(child.getValue());
                case "SANK" -> sanks.add(sankService.loadSank(child));
                case "SANK_IT" -> essMPZsl.setSankit(child.getValue());
            }
        }
        essMPZsl.setVnovm(vnovm);
        essMPZsl.setOssluch(ossluch);
        essMPZsl.setSl(mpSls);
        essMPZsl.setSank(sanks);
        return essMPZsl;
    }
}
