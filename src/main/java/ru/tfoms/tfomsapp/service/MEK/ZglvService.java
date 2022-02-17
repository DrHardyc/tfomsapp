package ru.tfoms.tfomsapp.service.MEK;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Zglv;

import javax.annotation.CheckForNull;

@Service
public class ZglvService {
    public Zglv loadZglv(Element element){
        Zglv zglv = new Zglv();

        Elements childs = element.getChildElements();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "VERSION" -> zglv.setVersion(child.getValue());
                case "DATE" -> zglv.setDate(child.getValue());
                case "FILENAME" -> zglv.setFilename(child.getValue());
                case "SD_Z" -> zglv.setSdz(child.getValue());
            }
        }
        return CheckForNull(zglv);
    }

    private Zglv CheckForNull(Zglv zglv){

        if (zglv.getFilename() == null){
            zglv.setFilename("");
        }
        if (zglv.getDate() == null){
            zglv.setDate("");
        }
        if (zglv.getSdz() == null){
            zglv.setSdz("");
        }
        if (zglv.getVersion() == null){
            zglv.setVersion("");
        }
        return zglv;
    }
}
