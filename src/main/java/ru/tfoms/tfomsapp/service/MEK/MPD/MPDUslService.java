package ru.tfoms.tfomsapp.service.MEK.MPD;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDUsl;
import ru.tfoms.tfomsapp.service.MEK.MruslnService;

@Service
public class MPDUslService {
    private final MruslnService mruslnService = new MruslnService();
    public MPDUsl loadMpdUsl(Element element){
        MPDUsl essMpdUsl = new MPDUsl();
        Elements childs = element.getChildElements();

        for (Element child : childs){
            switch (child.getLocalName()){
                case "IDSERV" -> essMpdUsl.setIdserv(child.getValue());
                case "LPU" -> essMpdUsl.setLpu(child.getValue());
                case "LPU_1" -> essMpdUsl.setLpu1(child.getValue());
                case "DATE_IN" -> essMpdUsl.setDatein(child.getValue());
                case "DATE_OUT" -> essMpdUsl.setDateout(child.getValue());
                case "P_OTK" -> essMpdUsl.setPotk(child.getValue());
                case "CODE_USL" -> essMpdUsl.setCodeusl(child.getValue());
                case "TARIF" -> essMpdUsl.setTarif(child.getValue());
                case "SUMV_USL"-> essMpdUsl.setSumvusl(child.getValue());
                case "MR_USL_N" -> essMpdUsl.setMrusln(mruslnService.loadMrusln(child));
                case "COMENTU" -> essMpdUsl.setComentu(child.getValue());
            }
        }

        return essMpdUsl;
    }
}
