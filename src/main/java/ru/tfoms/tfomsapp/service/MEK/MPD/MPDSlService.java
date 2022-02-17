package ru.tfoms.tfomsapp.service.MEK.MPD;

import nu.xom.Element;
import nu.xom.Elements;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDDs2n;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDNaz;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDSl;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDUsl;
import ru.tfoms.tfomsapp.service.MEK.SankService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MPDSlService {
    public final MPDDs2nService mpdDs2nService = new MPDDs2nService();
    public final MPDNazService mpdNazService = new MPDNazService();
    public final MPDUslService mpdUslService = new MPDUslService();
    public MPDSl loadMpdSl(Element element){
        MPDSl essMpdSl = new MPDSl();
        Elements childs = element.getChildElements();
        List<MPDDs2n> mpdDs2ns = new ArrayList<>();
        List<MPDNaz> mpdNazs = new ArrayList<>();
        List<MPDUsl> mpdUsls = new ArrayList<>();
        for (Element child : childs){
            switch (child.getLocalName()){
                case "SL_ID" -> essMpdSl.setSlid(child.getValue());
                case "LPU_1" -> essMpdSl.setLpu1(child.getValue());
                case "NHISTORY" -> essMpdSl.setNhistory(child.getValue());
                case "DATE_1" -> essMpdSl.setDate1(child.getValue());
                case "DATE_2" -> essMpdSl.setDate2(child.getValue());
                case "DS1" -> essMpdSl.setDs1(child.getValue());
                case "DS1_PR" -> essMpdSl.setDs1pr(child.getValue());
                case "DS_ONK" -> essMpdSl.setDsonk(child.getValue());
                case "PR_D_N" -> essMpdSl.setPrdn(child.getValue());
                case "DS2_N" -> mpdDs2ns.add(mpdDs2nService.loadMpdDs2n(child));
                case "NAZ" -> mpdNazs.add(mpdNazService.loadMpdNaz(child));
                case "ED_COL" -> essMpdSl.setEdcol(child.getValue());
                case "TARIF" -> essMpdSl.setTarif(child.getValue());
                case "SUM_M" -> essMpdSl.setSumm(child.getValue());
                case "USL" -> mpdUsls.add(mpdUslService.loadMpdUsl(child));
                case "COMENTSL" -> essMpdSl.setComentsl(child.getValue());
            }
        }
        essMpdSl.setDs2n(mpdDs2ns);
        essMpdSl.setNaz(mpdNazs);
        essMpdSl.setUsl(mpdUsls);
        return ChekForNull(essMpdSl);
    }

    private MPDSl ChekForNull(MPDSl essMpdSl) {
        if (essMpdSl.getSlid() == null){
            essMpdSl.setSlid("");
        }
        if (essMpdSl.getLpu1() == null){
            essMpdSl.setLpu1("");
        }
        if (essMpdSl.getNhistory() == null){
            essMpdSl.setNhistory("");
        }
        if (essMpdSl.getDate1() == null){
            essMpdSl.setDate1("");
        }
        if (essMpdSl.getDate2() == null){
            essMpdSl.setDate2("");
        }
        if (essMpdSl.getDs1() == null){
            essMpdSl.setDs1("");
        }
        if (essMpdSl.getDs1pr() == null){
            essMpdSl.setDs1pr("");
        }
        if (essMpdSl.getDsonk() == null){
            essMpdSl.setDsonk("");
        }
        if (essMpdSl.getPrdn() == null){
            essMpdSl.setPrdn("");
        }
        if (essMpdSl.getEdcol() == null){
            essMpdSl.setEdcol("");
        }
        if (essMpdSl.getTarif() == null){
            essMpdSl.setTarif("");
        }
        if (essMpdSl.getSumm() == null){
            essMpdSl.setSumm("");
        }
        if (essMpdSl.getComentsl() == null){
            essMpdSl.setComentsl("");
        }
        return essMpdSl;
    }
}
