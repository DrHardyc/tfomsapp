package ru.tfoms.tfomsapp.service.Examination.MEK;

import nu.xom.Document;
import nu.xom.Element;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.Exam.ExamParam;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDNaz;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDSl;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDUsl;
import ru.tfoms.tfomsapp.domain.MEK.MPD.MPDZap;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPers;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPerslist;
import ru.tfoms.tfomsapp.domain.MEK.Sank;
import ru.tfoms.tfomsapp.domain.MEK.Schet;
import ru.tfoms.tfomsapp.domain.MEK.Zglv;
import ru.tfoms.tfomsapp.service.HandBook.*;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class MPDExam {
    private final F002Service f002Service = new F002Service();
    private final F003Service f003Service = new F003Service();
    private final F004Service f004Service = new F004Service();
    private final F006Service f006Service = new F006Service();
    private final F014Service f014Service = new F014Service();
    private final V001Service v001Service = new V001Service();
    private final V008Service v008Service = new V008Service();
    private final V010Service v010Service = new V010Service();
    private final V017Service v017Service = new V017Service();
    private final V020Service v020Service = new V020Service();
    private final V029Service v029Service = new V029Service();
    private final ServiceUtil su = new ServiceUtil();

    public ResultTestExam exam(PDPerslist persList, Zglv zglv, Schet schet, ExamParam examParam) throws IOException {
        ResultTestExam resultTestExam = ResultTestExam.Success;

        Element flk_p = new Element("FLK_P");
        Element fname = new Element("FNAME");
        fname.appendChild("V" + zglv.getFilename());
        flk_p.appendChild(fname);
        Element fname_i = new Element("FNAME_I");
        fname_i.appendChild(zglv.getFilename());
        flk_p.appendChild(fname_i);

        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_0300_00900)){
            if (f003Service.Check(schet.getCodemo())){
                Element pr = getPrElement("X_0300/00900", schet,
                        null, null, null, schet.getCodemo(),
                        "Ошибка соответствия записи c справочником F003");
                flk_p.appendChild(pr);
                su.showMessagesEx("Ошибка соответствия записи в справочнике X_0300/00900");
                resultTestExam = ResultTestExam.Failed;
            }
        }
        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_0300_01400)){
            if (f002Service.Check(schet.getPlat()) && !schet.getPlat().isEmpty()){
                Element pr = getPrElement("X_0300/01400", schet,
                        null, null, null, schet.getPlat(),
                        "Ошибка соответствия записи c справочником F002");
                flk_p.appendChild(pr);
                su.showMessagesEx("Ошибка соответствия записи в справочнике X_0300/01400");
                resultTestExam = ResultTestExam.Failed;
            }
        }
        if (persList != null){
            for (PDPers pers : persList.getPers()){
                if (pers.getMpdZap() != null){
                    for (MPDZap zap : pers.getMpdZap()){
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_0500_03100)) {
                            if (f002Service.Check(zap.getPacient().getSmo())) {
                                Element pr = getPrElement("X_0500/03100", schet,
                                        zap, null, null, zap.getPacient().getSmo(),
                                        "Ошибка соответствия записи c справочником F002");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соответствия записи в справочнике X_0500/03100");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }
                        if (zap.getZsl() != null){
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_0600_03700)) {
                                if (v008Service.Check(zap.getZsl().getVidpom())) {
                                    Element pr = getPrElement("X_0600/03700", schet,
                                            zap, null, null, zap.getZsl().getVidpom(),
                                            "Ошибка соответствия записи c справочником F008");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соответствия записи в справочнике X_0600/03700");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_0600_03800)) {
                                if (f003Service.Check(zap.getZsl().getLpu())) {
                                    Element pr = getPrElement("X_0600/03800", schet,
                                            zap, null, null, zap.getZsl().getLpu(),
                                            "Ошибка соответствия записи c справочником F003");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соответствия записи в справочнике X_0600/03800");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_0600_04301)) {
                                if (zap.getZsl().getPotk().equals("0") && v017Service.Check(zap.getZsl().getRsltd())) {
                                    Element pr = getPrElement("X_0600/04301", schet,
                                            zap, null, null, zap.getZsl().getRsltd(),
                                            "Ошибка соответствия записи c справочником V017");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соответствия записи в справочнике X_0600/04301");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_0600_04600)) {
                                if (v010Service.Check(zap.getZsl().getIdsp())) {
                                    Element pr = getPrElement("X_0600/04600", schet,
                                            zap, null, null, zap.getZsl().getIdsp(),
                                            "Ошибка соответствия записи c справочником V010");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соответствия записи в справочнике X_0600/04600");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_05500)) {
                                if (!zap.getZsl().getSumv().equals(zap.getZsl().getSl().getSumm())) {
                                    Element pr = getPrElement("H_0600/05500", schet,
                                            zap, zap.getZsl().getSl(), null, zap.getZsl().getSl().getSumm(),
                                            "SUM_V не равно сумме значений SUM_M вложенных элементов SL");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка H_0600/05500");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_0700_05701)) {
                                if (zap.getZsl().getPotk().equals("0") && zap.getZsl().getSl().getDs1().isEmpty()) {
                                    Element pr = getPrElement("X_0700/05701", schet,
                                            zap, zap.getZsl().getSl(), null, zap.getZsl().getSl().getDs1(),
                                            "DS1 Обязательно к заполнению кодом до уровня подрубрики " +
                                                    "в соответствии со справочником МКБ, если ZL_LIST/ZAP/Z_SL/P_OTK=0");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка X_0700/05701");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_0700_06001)) {
                                if (zap.getZsl().getPotk().equals("0") && zap.getZsl().getSl().getPrdn().isEmpty()) {
                                    Element pr = getPrElement("X_0700/06001", schet,
                                            zap, zap.getZsl().getSl(), null, zap.getZsl().getSl().getPrdn(),
                                            "PR_D_N Обязательно к заполнению, если ZL_LIST/ZAP/Z_SL/P_OTK=0");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка X_0700/06001");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }

                            if (zap.getZsl().getSl().getNaz() != null){
                                for (MPDNaz naz : zap.getZsl().getSl().getNaz()){
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_0900_07400)) {
                                        if (v029Service.Check(naz.getNazv()) && naz.getNazr().equals("3")) {
                                            Element pr = getPrElement("X_0900/07400", schet,
                                                    zap, zap.getZsl().getSl(), null, naz.getNazv(),
                                                    "NAZ_V Заполняется в соответствии с классификатором методов" +
                                                            " диагностического исследования V029, если NAZ_R=3.");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соответствия записи в справочнике X_0900/07400");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_0900_07500)) {
                                        if (v001Service.Check(naz.getNazusl())
                                                && (naz.getNazr().equals("3") && zap.getZsl().getSl().getDsonk().equals("1"))) {
                                            Element pr = getPrElement("X_0900/07400", schet,
                                                    zap, zap.getZsl().getSl(), null, naz.getNazusl(),
                                                    "NAZ_USL Заполняется в соответствии с номенклатурой" +
                                                            " медицинских услуг (V001) только при направлении на" +
                                                            " обследование в случае подозрения на" +
                                                            " ЗНО (NAZ_R=3 и DS_ONK=1)");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соответствия записи в справочнике X_0900/07400");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_0900_07600)) {
                                        if (naz.getNaprdate().isEmpty()
                                                && ((naz.getNazr().equals("3") || naz.getNazr().equals("2"))
                                                && zap.getZsl().getSl().getDsonk().equals("1"))) {
                                            Element pr = getPrElement("X_0900/07600", schet,
                                                    zap, zap.getZsl().getSl(), null, naz.getNaprdate(),
                                                    "NAPR_DATE Заполнение обязательно если оформления " +
                                                            "направления в случае подозрения на ЗНО: на консультацию" +
                                                            " в другую МО или на обследование (NAZ_R={2,3} и DS_ONK=1)");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка X_0900/07600");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_0900_07800)) {
                                        if (f003Service.Check(naz.getNaprmo())
                                                && (naz.getNazr().equals("3") && zap.getZsl().getSl().getDsonk().equals("1"))) {
                                            Element pr = getPrElement("X_0900/07800", schet,
                                                    zap, zap.getZsl().getSl(), null, naz.getNazusl(),
                                                    "NAPR_MO Заполняется в соответствии со справочником F003." +
                                                            " Заполнение обязательно только в случаях оформления " +
                                                            "направления в случае подозрения на ЗНО: " +
                                                            "на консультацию в другую МО или на обследование " +
                                                            "(NAZ_R={2,3} и DS_ONK=1)");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соответствия записи в справочнике X_0900/07800");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_0900_07900)) {
                                        if (v020Service.Check(naz.getNazpk())
                                                && (naz.getNazr().equals("6") || naz.getNazr().equals("5"))) {
                                            Element pr = getPrElement("X_0900/07900", schet,
                                                    zap, zap.getZsl().getSl(), null, naz.getNazusl(),
                                                    "NAZ_PMP Заполняется, если в NAZ_R проставлен код 6. Классификатор V020.");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соответствия записи в справочнике X_0900/07900");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                }
                            }
                            if (zap.getZsl().getSl().getUsl() != null){
                                for (MPDUsl usl : zap.getZsl().getSl().getUsl()){
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_1000_08100)) {
                                        if (f003Service.Check(usl.getLpu())) {
                                            Element pr = getPrElement("X_1000/08100", schet,
                                                    zap, zap.getZsl().getSl(), usl, usl.getLpu(),
                                                    "Ошибка соответствия записи c справочником F003");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соответствия записи в справочнике X_1000/08100");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                }
                            }
                            if (zap.getZsl().getSank() != null){
                                for (Sank sank : zap.getZsl().getSank()){
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_1100_09400)) {
                                        if (f006Service.Check(sank.getStip())) {
                                            Element pr = getPrElement("X_1100/09400", schet,
                                                    zap, zap.getZsl().getSl(), null, sank.getStip(),
                                                    "Ошибка соответствия записи в справочнике F006");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соответствия записи в справочнике X_1100/09400");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (sank.getSlid() != null){
                                        for (String slid : sank.getSlid()){
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_1100_09500)) {
                                                if (!sank.getSsum().equals("0") && slid.isEmpty()) {
                                                    Element pr = getPrElement("X_1100/09500", schet,
                                                            zap, zap.getZsl().getSl(), null, slid,
                                                            "SL_ID Обязательно к заполнению, если S_SUM не равна 0");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи в справочнике X_1100/09500");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_1100_09600)) {
                                        if (!sank.getSsum().equals("0") && f014Service.Check(sank.getSosn())) {
                                            Element pr = getPrElement("X_1100/09600", schet,
                                                    zap, zap.getZsl().getSl(), null, sank.getSosn(),
                                                    "SL_ID Обязательно к заполнению, если S_SUM не равна 0");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соответствия записи в справочнике X_1100/09600");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (sank.getCodeexp() != null){
                                        for (String codeexp : sank.getCodeexp()){
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.X_1100_09900)) {
                                                if (Integer.parseInt(sank.getStip()) >= 30 && f004Service.Check(codeexp)) {
                                                    Element pr = getPrElement("XX_1100/09900", schet,
                                                            zap, zap.getZsl().getSl(), null, codeexp,
                                                            "CODE_EXP Обязательно к заполнению в соответствии с " +
                                                                    "F004 (Реестр экспертов качества медицинской " +
                                                                    "помощи, Приложение А) для экспертиз качества" +
                                                                    " медицинской помощи (S_TIP>=30)");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи в справочнике X_1100/09900");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Document doc = new Document(flk_p);
        PrintWriter out = new PrintWriter("D:\\V" + zglv.getFilename() + ".xml");
        out.println(doc.toXML());
        out.close();
        return resultTestExam;
    }

    private BufferedReader getHBBufferedReader(String strURL) throws IOException {
        URL url = null;
        try {
            url = new URL(strURL);
        } catch (MalformedURLException e) {
            //e.printStackTrace();
            //System.out.println(e);
        }
        assert url != null;
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        return new BufferedReader(new InputStreamReader(con.getInputStream()));
    }

    private Element getPrElement(String oshib, Schet schet, MPDZap zap, MPDSl sl,
                                 MPDUsl usl, String znPol, String comment) {
        Element pr = new Element("PR");
        Element elOshib = new Element("OSHIB");
        elOshib.appendChild(oshib);
        pr.appendChild(elOshib);
        Element elNzap = new Element("N_ZAP");
        if (zap == null){
            elNzap.appendChild("");
        } else {
            elNzap.appendChild(zap.getNzap());
        }
        pr.appendChild(elNzap);
        Element elIdcase = new Element("IDCASE");
        if (sl == null){
            elIdcase.appendChild("");
        } else {
            elIdcase.appendChild(zap.getZsl().getIdcase());
        }
        pr.appendChild(elIdcase);
        Element elIdserv = new Element("IDSERV");
        if (usl == null) {
            elIdserv.appendChild("");
        } else {
            elIdserv.appendChild(usl.getIdserv());
        }
        pr.appendChild(elIdserv);
        Element elNhistory = new Element("NHISTORY");
        if (sl == null) {
            elNhistory.appendChild("");
        } else {
            elNhistory.appendChild(sl.getNhistory());
        }
        pr.appendChild(elNhistory);

//        Element elTyp = new Element("TYP");
//        elTyp.appendChild("Требует уточнения");
//        pr.appendChild(elTyp);
        Element elZnpol = new Element("ZN_POL");
        elZnpol.appendChild(znPol);
        pr.appendChild(elZnpol);
        Element elNschet = new Element("NSCHET");
        elNschet.appendChild(schet.getNschet());
        pr.appendChild(elNschet);
        Element elIdpac = new Element("ID_PAC");
        elIdpac.appendChild(zap.getPacient().getIdpac());
        pr.appendChild(elIdpac);
        Element elComment = new Element("COMMENT");
        elComment.appendChild(comment);
        pr.appendChild(elComment);
        return pr;
    }
}
