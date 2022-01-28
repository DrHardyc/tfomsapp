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
        return essPDPers;
    }
}
