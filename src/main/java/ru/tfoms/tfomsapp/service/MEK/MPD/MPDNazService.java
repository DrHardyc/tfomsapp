package ru.tfoms.tfomsapp.service.MEK.MPD;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDNaz;

@Service
public class MPDNazService {
    public MPDNaz loadMpdNaz(Element element){
        MPDNaz essMpdNaz = new MPDNaz();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "NAZ_N" -> essMpdNaz.setNazn(child.getValue());
                case "NAZ_R" -> essMpdNaz.setNazr(child.getValue());
                case "NAZ_IDDOKT" -> essMpdNaz.setNaziddokt(child.getValue());
                case "NAZ_V" -> essMpdNaz.setNazv(child.getValue());
                case "NAZ_USL" -> essMpdNaz.setNazusl(child.getValue());
                case "NAPR_DATE" -> essMpdNaz.setNaprdate(child.getValue());
                case "NAPR_MO" -> essMpdNaz.setNaprmo(child.getValue());
                case "NAZ_PMP" -> essMpdNaz.setNazpmp(child.getValue());
                case "NAZ_PK" -> essMpdNaz.setNazpk(child.getValue());
            }
        }
        return essMpdNaz;
    }
}
