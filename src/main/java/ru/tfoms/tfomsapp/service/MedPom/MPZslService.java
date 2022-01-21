package ru.tfoms.tfomsapp.service.MedPom;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPSank;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPSl;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPZsl;

import java.util.ArrayList;
import java.util.List;

@Service
public class MPZslService {
    private final MPSlService mpSlService = new MPSlService();
    private final MPSankService mpSankService = new MPSankService();

    public MPZsl loadMPZsl(Element element){
        MPZsl essZsl = new MPZsl();
        List<String> vnovms = new ArrayList<>();
        List<String> essluchs = new ArrayList<>();
        List<MPSl> essSls = new ArrayList<>();
        List<MPSank> essSanks = new ArrayList<>();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDCASE" -> essZsl.setIdcase(child.getValue());
                case "USL_OK" -> essZsl.setUslok(child.getValue());
                case "VIDPOM" -> essZsl.setVidpom(child.getValue());
                case "FOR_POM" -> essZsl.setForpom(child.getValue());
                case "NPR_MO" -> essZsl.setNprmo(child.getValue());
                case "NPR_DATE" -> essZsl.setNprdate(child.getValue());
                case "LPU" -> essZsl.setLpu(child.getValue());
                case "DATE_Z_1" -> essZsl.setDatez1(child.getValue());
                case "DATE_Z_2" -> essZsl.setDatez2(child.getValue());
                case "KD_Z" -> essZsl.setKdz(child.getValue());
                case "VNOV_M" -> vnovms.add(child.getValue());
                case "RSLT" -> essZsl.setRslt(child.getValue());
                case "ISHOD" -> essZsl.setIshod(child.getValue());
                case "OS_SLUCH" -> essluchs.add(child.getValue());
                case "VB_P" -> essZsl.setVbp(child.getValue());
                case "SL" -> essSls.add(mpSlService.loadMPSl(child));
                case "IDSP" -> essZsl.setIdsp(child.getValue());
                case "SUMV" -> essZsl.setSumv(child.getValue());
                case "OPLATA" -> essZsl.setOplata(child.getValue());
                case "SUMP" -> essZsl.setSump(child.getValue());
                case "SANK" -> essSanks.add(mpSankService.loadMpSank(child));
                case "SANK_IT" -> essZsl.setSankit(child.getValue());
            }
        }
        essZsl.setVnovm(vnovms);
        essZsl.setOssluch(essluchs);
        essZsl.setSl(essSls);
        essZsl.setSank(essSanks);
        return essZsl;
    }
}
