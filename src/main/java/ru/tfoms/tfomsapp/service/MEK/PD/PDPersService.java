package ru.tfoms.tfomsapp.service.MEK.PD;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPers;

import java.util.ArrayList;
import java.util.List;

@Service
public class PDPersService {
    public PDPers loadPers(Element element){
        PDPers essPDPers = new PDPers();
        Elements childs = element.getChildElements();
        List<String> dosts = new ArrayList<>();
        List<String> dostps = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ID_PAC" -> essPDPers.setIdpac(child.getValue());
                case "FAM" -> essPDPers.setFam(child.getValue());
                case "IM" -> essPDPers.setIm(child.getValue());
                case "OT" -> essPDPers.setOt(child.getValue());
                case "W" -> essPDPers.setW(child.getValue());
                case "DR" -> essPDPers.setDr(child.getValue());
                case "DOST" -> dosts.add(child.getValue());
                case "TEL" -> essPDPers.setTel(child.getValue());
                case "FAM_P" -> essPDPers.setFamp(child.getValue());
                case "IM_P" -> essPDPers.setImp(child.getValue());
                case "OT_P"-> essPDPers.setOtp(child.getValue());
                case "W_P" -> essPDPers.setWp(child.getValue());
                case "DR_P" -> essPDPers.setDrp(child.getValue());
                case "DOST_P" -> dostps.add(child.getValue());
                case "MR" -> essPDPers.setMr(child.getValue());
                case "DOCTYPE" -> essPDPers.setDoctype(child.getValue());
                case "DOCSER" -> essPDPers.setDocser(child.getValue());
                case "DOCNUM" -> essPDPers.setDocnum(child.getValue());
                case "DOCDATE" -> essPDPers.setDocdate(child.getValue());
                case "DOCORG" -> essPDPers.setDocorg(child.getValue());
                case "SNILS" -> essPDPers.setSnils(child.getValue());
                case "OKATOG" -> essPDPers.setOkatog(child.getValue());
                case "OKATOP" -> essPDPers.setOkatop(child.getValue());
                case "COMENTP" -> essPDPers.setComentp(child.getValue());
            }
        }
        essPDPers.setDost(dosts);
        essPDPers.setDostp(dostps);
        return CheckForNull(essPDPers);
    }

    private PDPers CheckForNull(PDPers essPDPers) {
        if (essPDPers.getIdpac() == null){
            essPDPers.setIdpac("");
        }
        if (essPDPers.getFam() == null){
            essPDPers.setFam("");
        }
        if (essPDPers.getIm() == null){
            essPDPers.setIm("");
        }
        if (essPDPers.getOt() == null){
            essPDPers.setOt("");
        }
        if (essPDPers.getW() == null){
            essPDPers.setW("");
        }
        if (essPDPers.getDr() == null){
            essPDPers.setDr("");
        }
        if (essPDPers.getTel() == null){
            essPDPers.setTel("");
        }
        if (essPDPers.getFamp() == null){
            essPDPers.setFamp("");
        }
        if (essPDPers.getImp() == null){
            essPDPers.setImp("");
        }
        if (essPDPers.getOtp() == null){
            essPDPers.setOtp("");
        }
        if (essPDPers.getWp() == null){
            essPDPers.setWp("");
        }
        if (essPDPers.getDrp() == null){
            essPDPers.setDrp("");
        }
        if (essPDPers.getMr() == null){
            essPDPers.setMr("");
        }
        if (essPDPers.getDoctype() == null){
            essPDPers.setDoctype("");
        }
        if (essPDPers.getDocser() == null){
            essPDPers.setDocser("");
        }
        if (essPDPers.getDocnum() == null){
            essPDPers.setDocnum("");
        }
        if (essPDPers.getDocdate() == null){
            essPDPers.setDocdate("");
        }
        if (essPDPers.getDocorg() == null){
            essPDPers.setDocdate("");
        }
        if (essPDPers.getSnils() == null){
            essPDPers.setSnils("");
        }
        if (essPDPers.getOkatog() == null){
            essPDPers.setOkatog("");
        }
        if (essPDPers.getOkatop() == null){
            essPDPers.setOkatop("");
        }
        if (essPDPers.getComentp() == null){
            essPDPers.setComentp("");
        }

        return essPDPers;
    }
}
