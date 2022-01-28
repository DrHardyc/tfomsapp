package ru.tfoms.tfomsapp.service.MEK.DS;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSSl;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSUsl;

import java.util.ArrayList;
import java.util.List;

@Service
public class DSSlService {
    private final DSUslService uslService = new DSUslService();
    public DSSl loadDsSl(Element element){
        DSSl essDsSl = new DSSl();
        Elements childs = element.getChildElements();
        List<DSUsl> dsUsl = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "SL_ID" -> essDsSl.setSlid(child.getValue());
                case "USL" -> dsUsl.add(uslService.loadDsUsl(child));
                case "CEL_OBSL" -> essDsSl.setCelobsl(child.getValue());
                case "POL_VIS" -> essDsSl.setPolvis(child.getValue());
                case "HOM_VIS" -> essDsSl.setHomvis(child.getValue());
                case "SPEC_END" -> essDsSl.setSpecend(child.getValue());
                case "CEL1" -> essDsSl.setCel1(child.getValue());
                case "TYPE_MN" -> essDsSl.setTypemn(child.getValue());
                case "OBR" -> essDsSl.setObr(child.getValue());
                case "TIMEV" -> essDsSl.setTimev(child.getValue());
                case "TIMEP" -> essDsSl.setTimep(child.getValue());
                case "TL" -> essDsSl.setTl(child.getValue());
                case "VIDTR" -> essDsSl.setVidtr(child.getValue());
                case "KSLP_P" -> essDsSl.setKslpp(child.getValue());
                case "BARTEL" -> essDsSl.setBartel(child.getValue());
                case "PERS_POST" -> essDsSl.setPerspost(child.getValue());
                case "DATE_R1" -> essDsSl.setDater1(child.getValue());
                case "DATE_R2" -> essDsSl.setDater2(child.getValue());
                case "SOST" -> essDsSl.setSost(child.getValue());
            }
        }
        essDsSl.setUsl(dsUsl);
        return essDsSl;
    }
}
