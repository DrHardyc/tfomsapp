package ru.tfoms.tfomsapp.service.MEK.PD;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.PD.Pers;

import java.util.ArrayList;
import java.util.List;

@Service
public class PDPersService {
    public Pers loadPers(Element element){
        Pers essPers = new Pers();
        Elements childs = element.getChildElements();
        List<String> dostps = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "ID_PAC" -> essPers.setIdpac(child.getValue());
                case "FAM" -> essPers.setFam(child.getValue());
                case "IM" -> essPers.setIm(child.getValue());
                case "OT" -> essPers.setOt(child.getValue());
                case "W" -> essPers.setW(child.getValue());
                case "DR" -> essPers.setDr(child.getValue());
                case "DOST" -> essPers.setDost(child.getValue());
                case "TEL" -> essPers.setTel(child.getValue());
                case "FAM_P" -> essPers.setFamp(child.getValue());
                case "IM_P" -> essPers.setImp(child.getValue());
                case "OT_P"-> essPers.setOtp(child.getValue());
                case "W_P" -> essPers.setWp(child.getValue());
                case "DR_P" -> essPers.setDrp(child.getValue());
                case "DOST_P" -> dostps.add(child.getValue());
                case "MR" -> essPers.setMr(child.getValue());
                case "DOCTYPE" -> essPers.setDoctype(child.getValue());
                case "DOCSER" -> essPers.setDocser(child.getValue());
                case "DOCNUM" -> essPers.setDocnum(child.getValue());
                case "DOCDATE" -> essPers.setDocdate(child.getValue());
                case "DOCORG" -> essPers.setDocorg(child.getValue());
                case "SNILS" -> essPers.setSnils(child.getValue());
                case "OKATOG" -> essPers.setOkatog(child.getValue());
                case "OKATOP" -> essPers.setOkatop(child.getValue());
                case "COMENTP" -> essPers.setComentp(child.getValue());
            }
        }
        essPers.setDostp(dostps);
        return essPers;
    }
}
