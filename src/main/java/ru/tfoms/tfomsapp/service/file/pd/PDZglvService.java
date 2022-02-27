package ru.tfoms.tfomsapp.service.file.pd;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.file.pd.PDZglv;

@Service
public class PDZglvService {
    public PDZglv loadPdZglv(Element element){
        PDZglv essPdZglv = new PDZglv();
        Elements childs = element.getChildElements();

        for (Element child : childs){
            switch (child.getLocalName()){
                case "VERSION" -> essPdZglv.setVersion(child.getValue());
                case "DATE" -> essPdZglv.setDate(child.getValue());
                case "FILENAME" -> essPdZglv.setFilename(child.getValue());
                case "FILENAME1" -> essPdZglv.setFilename1(child.getValue());
            }
        }
        return CheckForNull(essPdZglv);
    }

    private PDZglv CheckForNull(PDZglv essPdZglv) {
        if (essPdZglv.getVersion() == null){
            essPdZglv.setVersion("");
        }
        if (essPdZglv.getDate() == null){
            essPdZglv.setDate("");
        }
        if (essPdZglv.getFilename() == null){
            essPdZglv.setFilename("");
        }
        if (essPdZglv.getFilename1() == null){
            essPdZglv.setFilename1("");
        }

        return essPdZglv;
    }
}
