package ru.tfoms.tfomsapp.service.MEK.MPD;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDZsl;
import ru.tfoms.tfomsapp.domain.MEK.Sank;
import ru.tfoms.tfomsapp.service.MEK.SankService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MPDZslService {
    private final MPDSlService mpdSlService = new MPDSlService();
    private final SankService sankService = new SankService();
    public MPDZsl loadMpdZsl(Element element){
        MPDZsl essMpdZsl = new MPDZsl();
        Elements childs = element.getChildElements();
        List<String> ossluchs = new ArrayList<>();
        List<Sank> sanks = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDCASE" -> essMpdZsl.setIdcase(child.getValue());
                case "VIDPOM" -> essMpdZsl.setVidpom(child.getValue());
                case "LPU" -> essMpdZsl.setLpu(child.getValue());
                case "VBR" -> essMpdZsl.setVbr(child.getValue());
                case "DATE_Z_1" -> essMpdZsl.setDatez1(child.getValue());
                case "DATE_Z_2" -> essMpdZsl.setDatez2(child.getValue());
                case "P_OTK" -> essMpdZsl.setPotk(child.getValue());
                case "RSLT_D" -> essMpdZsl.setRsltd(child.getValue());
                case "OS_SLUCH" -> ossluchs.add(child.getValue());
                case "SL" -> essMpdZsl.setSl(mpdSlService.loadMpdSl(child));
                case "IDSP" -> essMpdZsl.setIdsp(child.getValue());
                case "SUMV" -> essMpdZsl.setSumv(child.getValue());
                case "OPLATA" -> essMpdZsl.setOplata(child.getValue());
                case "SUMP" -> essMpdZsl.setSump(child.getValue());
                case "SANK" -> sanks.add(sankService.loadSank(child));
                case "SANK_IT" -> essMpdZsl.setSankit(child.getValue());
            }
        }
        essMpdZsl.setOssluch(ossluchs);
        essMpdZsl.setSank(sanks);
        return CheckForNull(essMpdZsl);
    }

    private MPDZsl CheckForNull(MPDZsl essMpdZsl) {
        if (essMpdZsl.getIdcase() == null){
            essMpdZsl.setIdsp("");
        }
        if (essMpdZsl.getVidpom() == null){
            essMpdZsl.setVidpom("");
        }
        if (essMpdZsl.getLpu() == null){
            essMpdZsl.setLpu("");
        }
        if (essMpdZsl.getVbr() == null){
            essMpdZsl.setVbr("");
        }
        if (essMpdZsl.getDatez1() == null){
            essMpdZsl.setDatez1("");
        }
        if (essMpdZsl.getDatez2() == null){
            essMpdZsl.setDatez2("");
        }
        if (essMpdZsl.getPotk() == null){
            essMpdZsl.setPotk("");
        }
        if (essMpdZsl.getRsltd() == null){
            essMpdZsl.setRsltd("");
        }
        if (essMpdZsl.getIdsp() == null){
            essMpdZsl.setIdsp("");
        }
        if (essMpdZsl.getSumv() == null){
            essMpdZsl.setSumv("");
        }
        if (essMpdZsl.getSump() == null){
            essMpdZsl.setSump("");
        }
        if (essMpdZsl.getOplata() == null){
            essMpdZsl.setOplata("");
        }
        if (essMpdZsl.getSankit() == null){
            essMpdZsl.setSankit("");
        }

        return essMpdZsl;
    }
}
