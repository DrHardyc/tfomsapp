package ru.tfoms.tfomsapp.service.file;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.Ksgkpg;
import ru.tfoms.tfomsapp.domain.file.Slkoef;

import java.util.ArrayList;
import java.util.List;

@Service
public class KsgkpgService {
    public final SlkoefService slkoefService = new SlkoefService();
    public Ksgkpg loadKsgkpg(Element element){
        Ksgkpg essKsgkpg = new Ksgkpg();
        Elements childs = element.getChildElements();
        List<String> crits = new ArrayList<>();
        List<Slkoef> slkoefs = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "N_KSG" -> essKsgkpg.setNksg(child.getValue());
                case "VER_KSG" -> essKsgkpg.setVerksg(child.getValue());
                case "KSG_PG" -> essKsgkpg.setKsgpg(child.getValue());
                case "N_KPG" -> essKsgkpg.setNkpg(child.getValue());
                case "KOEF_Z" -> essKsgkpg.setKoefz(child.getValue());
                case "KOEF_UP" -> essKsgkpg.setKoefup(child.getValue());
                case "BZTSZ" -> essKsgkpg.setBztsz(child.getValue());
                case "KOEF_D" -> essKsgkpg.setKoefd(child.getValue());
                case "KOEF_U" -> essKsgkpg.setKoefu(child.getValue());
                case "CRIT" -> crits.add(child.getValue());
                case "SL_K" -> essKsgkpg.setSlk(child.getValue());
                case "IT_SL" -> essKsgkpg.setItsl(child.getValue());
                case "SL_KOEF" -> slkoefs.add(slkoefService.loadSlcoef(child));
            }
        }
        essKsgkpg.setCrit(crits);
        essKsgkpg.setSlkoef(slkoefs);
        return CheckForNull(essKsgkpg);
    }

    private Ksgkpg CheckForNull(Ksgkpg essKsgkpg) {
        if (essKsgkpg.getNksg() == null){
            essKsgkpg.setNksg("");
        }
        if (essKsgkpg.getNkpg() == null){
            essKsgkpg.setNkpg("");
        }
        if (essKsgkpg.getVerksg() == null){
            essKsgkpg.setVerksg("");
        }
        if (essKsgkpg.getKsgpg() == null){
            essKsgkpg.setKsgpg("");
        }
        if (essKsgkpg.getKoefz() == null){
            essKsgkpg.setKoefz("");
        }
        if (essKsgkpg.getKoefup() == null){
            essKsgkpg.setKoefup("");
        }
        if (essKsgkpg.getBztsz() == null){
            essKsgkpg.setBztsz("");
        }
        if (essKsgkpg.getKoefd() == null){
            essKsgkpg.setKoefd("");
        }
        if (essKsgkpg.getKoefu() == null){
            essKsgkpg.setKoefu("");
        }
        if (essKsgkpg.getSlk() == null){
            essKsgkpg.setSlk("");
        }
        if (essKsgkpg.getItsl() == null){
            essKsgkpg.setItsl("");
        }

        return essKsgkpg;
    }
}
