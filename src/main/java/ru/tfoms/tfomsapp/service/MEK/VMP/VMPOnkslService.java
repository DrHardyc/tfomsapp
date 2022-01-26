package ru.tfoms.tfomsapp.service.MEK.VMP;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPBdiag;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPBprot;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPOnksl;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPOnkusl;

import java.util.ArrayList;
import java.util.List;

@Service
public class VMPOnkslService {
    private final VMPBdiagService vmpBdiagService = new VMPBdiagService();
    private final VMPBprotService vmpBprotService = new VMPBprotService();
    private final VMPOnkuslService vmpOnkuslService = new VMPOnkuslService();
    public VMPOnksl loadVmpOnksl(Element element){
        VMPOnksl essVmpOnksl = new VMPOnksl();
        Elements childs = element.getChildElements();
        List<VMPBdiag> vmpBdiags = new ArrayList<>();
        List<VMPBprot> vmpBprots = new ArrayList<>();
        List<VMPOnkusl> vmpOnkusls = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "DS1_T" -> essVmpOnksl.setDs1t(child.getValue());
                case "STAD" -> essVmpOnksl.setStad(child.getValue());
                case "ONK_T" -> essVmpOnksl.setOnkt(child.getValue());
                case "ONK_N" -> essVmpOnksl.setOnkn(child.getValue());
                case "ONK_M" -> essVmpOnksl.setOnkm(child.getValue());
                case "MTSTZ" -> essVmpOnksl.setMtstz(child.getValue());
                case "SOD" -> essVmpOnksl.setSod(child.getValue());
                case "K_FR" -> essVmpOnksl.setKfr(child.getValue());
                case "WEI" -> essVmpOnksl.setWei(child.getValue());
                case "HEI" -> essVmpOnksl.setHei(child.getValue());
                case "BSA" -> essVmpOnksl.setBsa(child.getValue());
                case "B_DIAG" -> vmpBdiags.add(vmpBdiagService.loadVmpBdiag(child));
                case "B_PROT" -> vmpBprots.add(vmpBprotService.loadVmpBprot(child));
                case "ONK_USL" -> vmpOnkusls.add(vmpOnkuslService.loadVmpOnkusl(child));
            }
        }
        essVmpOnksl.setBdiags(vmpBdiags);
        essVmpOnksl.setBprots(vmpBprots);
        essVmpOnksl.setOnkusls(vmpOnkusls);
        return essVmpOnksl;
    }
}
