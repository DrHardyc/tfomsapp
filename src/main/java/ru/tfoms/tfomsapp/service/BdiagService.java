package ru.tfoms.tfomsapp.service;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Bdiag;

@Service
public class BdiagService {
    private final Bdiag essBdiag = new Bdiag();
    private final ServiceUtil su = new ServiceUtil();

    public Bdiag LoadBdiag(Element bdiag){

        Elements childBdiags = bdiag.getChildElements();
        for (Element child : childBdiags){
            switch (child.getLocalName()){
                case "DIAG_DATE" -> essBdiag.setDiagdate(su.getChildValueByName(child, "DIAG_DATE"));
                case "DIAG_TIP" -> essBdiag.setDiagtip(su.getChildValueByName(child, "DIAG_TIP"));
                case "DIAG_CODE" -> essBdiag.setDiagcode(su.getChildValueByName(child, "DIAG_CODE"));
                case "DIAG_RSLT" -> essBdiag.setDiagrslt(su.getChildValueByName(child, "DIAG_RSLT"));
                case "REC_RSLT" -> essBdiag.setRecrslt(su.getChildValueByName(child, "REC_RSLT"));
            }
        }
        return essBdiag;
    }



}
