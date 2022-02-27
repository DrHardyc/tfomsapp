package ru.tfoms.tfomsapp.service.file.onk;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.onk.ONKSl;
import ru.tfoms.tfomsapp.domain.file.onk.ONKZsl;
import ru.tfoms.tfomsapp.domain.file.Sank;
import ru.tfoms.tfomsapp.service.file.SankService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ONKZslService {
    private final ONKSlService onkSlService = new ONKSlService();
    private final SankService sankService = new SankService();
    public ONKZsl loadOnkZsl(Element element){
        ONKZsl essOnkZsl = new ONKZsl();
        Elements childs = element.getChildElements();
        List<String> ossluchs = new ArrayList<>();
        List<ONKSl> onkSls = new ArrayList<>();
        List<Sank> sanks = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDCASE" -> essOnkZsl.setIdcase(child.getValue());
                case "USL_OK" -> essOnkZsl.setUslok(child.getValue());
                case "VIDPOM" -> essOnkZsl.setVidpom(child.getValue());
                case "FOR_POM" -> essOnkZsl.setForpom(child.getValue());
                case "NPR_MO" -> essOnkZsl.setNprmo(child.getValue());
                case "NPR_DATE" -> essOnkZsl.setNprdate(child.getValue());
                case "LPU" -> essOnkZsl.setLpu(child.getValue());
                case "DATE_Z_1" -> essOnkZsl.setDatez1(child.getValue());
                case "DATE_Z_2" -> essOnkZsl.setDatez2(child.getValue());
                case "KD_Z" -> essOnkZsl.setKdz(child.getValue());
                case "VNOV_M" -> essOnkZsl.setVnovm(child.getValue());
                case "RSLT" -> essOnkZsl.setRslt(child.getValue());
                case "ISHOD" -> essOnkZsl.setIshod(child.getValue());
                case "OS_SLUCH" -> ossluchs.add(child.getValue());
                case "VB_P" -> essOnkZsl.setVbp(child.getValue());
                case "SL" -> onkSls.add(onkSlService.loadOnkSl(child));
                case "IDSP" -> essOnkZsl.setIdsp(child.getValue());
                case "SUMV" -> essOnkZsl.setSumv(child.getValue());
                case "OPLATA" -> essOnkZsl.setOplata(child.getValue());
                case "SUMP" -> essOnkZsl.setSump(child.getValue());
                case "SANK" -> sanks.add(sankService.loadSank(child));
                case "SANK_IT" -> essOnkZsl.setSankit(child.getValue());

            }
        }
        essOnkZsl.setOssluch(ossluchs);
        essOnkZsl.setSls(onkSls);
        essOnkZsl.setSanks(sanks);
        return CheckForNull(essOnkZsl);
    }

    private ONKZsl CheckForNull(ONKZsl essOnkZsl) {
        if (essOnkZsl.getIdcase() == null){
            essOnkZsl.setIdcase("");
        }
        if (essOnkZsl.getUslok() == null){
            essOnkZsl.setUslok("");
        }
        if (essOnkZsl.getVidpom() == null){
            essOnkZsl.setVidpom("");
        }
        if (essOnkZsl.getForpom() == null){
            essOnkZsl.setForpom("");
        }
        if (essOnkZsl.getNprmo() == null){
            essOnkZsl.setNprmo("");
        }
        if (essOnkZsl.getNprdate() == null){
            essOnkZsl.setNprdate("");
        }
        if (essOnkZsl.getLpu() == null){
            essOnkZsl.setLpu("");
        }
        if (essOnkZsl.getDatez1() == null){
            essOnkZsl.setDatez1("");
        }
        if (essOnkZsl.getDatez2() == null){
            essOnkZsl.setDatez2("");
        }
        if (essOnkZsl.getKdz() == null){
            essOnkZsl.setKdz("");
        }
        if (essOnkZsl.getVnovm() == null){
            essOnkZsl.setVnovm("");
        }
        if (essOnkZsl.getRslt() == null){
            essOnkZsl.setRslt("");
        }
        if (essOnkZsl.getIshod() == null){
            essOnkZsl.setIshod("");
        }
        if (essOnkZsl.getVbp() == null){
            essOnkZsl.setVbp("");
        }
        if (essOnkZsl.getIdsp() == null){
            essOnkZsl.setIdsp("");
        }
        if (essOnkZsl.getSumv() == null){
            essOnkZsl.setSump("");
        }
        if (essOnkZsl.getOplata() == null){
            essOnkZsl.setOplata("");
        }
        if (essOnkZsl.getSump() == null){
            essOnkZsl.setSump("");
        }
        if (essOnkZsl.getSankit() == null){
            essOnkZsl.setSankit("");
        }

        return essOnkZsl;
    }
}
