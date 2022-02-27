package ru.tfoms.tfomsapp.service.file.mpd;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.mpd.MPDDs2n;

@Service
public class MPDDs2nService {
    public MPDDs2n loadMpdDs2n(Element element){
        MPDDs2n essMpdDs2n = new MPDDs2n();
        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "DS2" -> essMpdDs2n.setDs2(child.getValue());
                case "DS2_PR" -> essMpdDs2n.setDs2pr(child.getValue());
                case "PR_DS2_N" -> essMpdDs2n.setPrds2n(child.getValue());
            }
        }
        return CheckForNull(essMpdDs2n);
    }

    private MPDDs2n CheckForNull(MPDDs2n essMpdDs2n) {
        if (essMpdDs2n.getDs2() == null){
            essMpdDs2n.setDs2("");
        }
        if (essMpdDs2n.getDs2pr() == null){
            essMpdDs2n.setDs2pr("");
        }
        if (essMpdDs2n.getPrds2n() == null){
            essMpdDs2n.setPrds2n("");
        }

        return essMpdDs2n;
    }
}
