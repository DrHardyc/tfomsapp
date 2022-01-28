package ru.tfoms.tfomsapp.service.MEK.VMP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Sank;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPSl;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPZsl;
import ru.tfoms.tfomsapp.service.MEK.SankService;

import java.util.ArrayList;
import java.util.List;

@Service
public class VMPZslService {
    private final VMPSlService vmpSlService = new VMPSlService();
    private final SankService sankService = new SankService();

    public VMPZsl loadVmpZsl(Element element){
        VMPZsl essVmpZsl = new VMPZsl();
        Elements childs = element.getChildElements();
        List<String> vnovms = new ArrayList<>();
        List<String> ossluchs = new ArrayList<>();
        List<VMPSl> sls = new ArrayList<>();
        List<Sank> sanks = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDCASE" -> essVmpZsl.setIdcase(child.getValue());
                case "USL_OK" -> essVmpZsl.setUslok(child.getValue());
                case "VIDPOM" -> essVmpZsl.setVidpom(child.getValue());
                case "FOR_POM" -> essVmpZsl.setForpom(child.getValue());
                case "NPR_MO" -> essVmpZsl.setNprmo(child.getValue());
                case "NPR_DATE" -> essVmpZsl.setNprdate(child.getValue());
                case "LPU" -> essVmpZsl.setLpu(child.getValue());
                case "DATE_Z_1" -> essVmpZsl.setDatez1(child.getValue());
                case "DATE_Z_2" -> essVmpZsl.setDatez2(child.getValue());
                case "KD_Z" -> essVmpZsl.setKdz(child.getValue());
                case "VNOV_M" -> vnovms.add(child.getValue());
                case "RSLT" -> essVmpZsl.setRslt(child.getValue());
                case "ISHOD" -> essVmpZsl.setIshod(child.getValue());
                case "OS_SLUCH" -> ossluchs.add(child.getValue());
                case "SL" -> sls.add(vmpSlService.loadVmpSl(child));
                case "IDSP" -> essVmpZsl.setIdsp(child.getValue());
                case "SUMV" -> essVmpZsl.setSumv(child.getValue());
                case "OPLATA" -> essVmpZsl.setOplata(child.getValue());
                case "SUMP" -> essVmpZsl.setSump(child.getValue());
                case "SANK" -> sanks.add(sankService.loadSank(child));
                case "SANK_IT" -> essVmpZsl.setSankit(child.getValue());
            }
        }
        essVmpZsl.setVnovm(vnovms);
        essVmpZsl.setOssluch(ossluchs);
        essVmpZsl.setSl(sls);
        essVmpZsl.setSanks(sanks);
        return essVmpZsl;
    }
}
