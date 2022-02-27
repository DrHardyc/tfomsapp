package ru.tfoms.tfomsapp.service.examination.flk;

import nu.xom.Document;
import nu.xom.Element;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.examination.ExamParam;
import ru.tfoms.tfomsapp.domain.file.*;
import ru.tfoms.tfomsapp.domain.file.onk.*;
import ru.tfoms.tfomsapp.domain.file.pd.PDPers;
import ru.tfoms.tfomsapp.domain.file.pd.PDPerslist;
import ru.tfoms.tfomsapp.service.handbook.*;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ONKExam {
    private final F002Service f002Service = new F002Service();
    private final F003Service f003Service = new F003Service();
    private final F004Service f004Service = new F004Service();
    private final F006Service f006Service = new F006Service();
    private final F008Service f008Service = new F008Service();
    private final F011Service f011Service = new F011Service();
    private final F014Service f014Service = new F014Service();
    private final V001Service v001Service = new V001Service();
    private final V002Service v002Service = new V002Service();
    private final V005Service v005Service = new V005Service();
    private final V006Service v006Service = new V006Service();
    private final V008Service v008Service = new V008Service();
    private final V009Service v009Service = new V009Service();
    private final V010Service v010Service = new V010Service();
    private final V012Service v012Service = new V012Service();
    private final V014Service v014Service = new V014Service();
    private final V020Service v020Service = new V020Service();
    private final V021Service v021Service = new V021Service();
    private final V024Service v024Service = new V024Service();
    private final V025Service v025Service = new V025Service();
    private final V026Service v026Service = new V026Service();
    private final V027Service v027Service = new V027Service();
    private final V028Service v028Service = new V028Service();
    private final V029Service v029Service = new V029Service();
    private final V032Service v032Service = new V032Service();
    private final N001Service n001Service = new N001Service();
    private final N002Service n002Service = new N002Service();
    private final N003Service n003Service = new N003Service();
    private final N004Service n004Service = new N004Service();
    private final N005Service n005Service = new N005Service();
    private final N007Service n007Service = new N007Service();
    private final N008Service n008Service = new N008Service();
    private final N010Service n010Service = new N010Service();
    private final N011Service n011Service = new N011Service();
    private final N013Service n013Service = new N013Service();
    private final N014Service n014Service = new N014Service();
    private final N015Service n015Service = new N015Service();
    private final N016Service n016Service = new N016Service();
    private final N017Service n017Service = new N017Service();
    private final N018Service n018Service = new N018Service();
    private final N019Service n019Service = new N019Service();
    private final N020Service n020Service = new N020Service();
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

        if (schet != null){
            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0300_00900)) {
                if (f003Service.Check(schet.getCodemo())) {
                    Element pr = getPrElement("C_0300/00900", schet,
                            null, null, null, schet.getCodemo(),
                            "Ошибка соответствия записи c справочником F003");
                    flk_p.appendChild(pr);
                    su.showMessagesEx("Ошибка соответствия записи в справочнике C_0300/00900");
                    resultTestExam = ResultTestExam.Failed;
                }
            }
            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0300_01400)) {
                if (f002Service.Check(schet.getPlat()) && !schet.getPlat().isEmpty()) {
                    Element pr = getPrElement("C_0300/01400", schet,
                            null, null, null, schet.getPlat(),
                            "Ошибка соответствия записи c справочником F002");
                    flk_p.appendChild(pr);
                    su.showMessagesEx("Ошибка соответствия записи в справочнике C_0300/01400");
                    resultTestExam = ResultTestExam.Failed;
                }
            }
        }
        if (persList != null){
            for (PDPers pers : persList.getPers()){
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.L_0300_01100)) {
                    if (v005Service.Check(pers.getW())) {
                        Element pr = getPrElement("L_0300/01100", null,
                                null, null, null, pers.getW(),
                                "Ошибка соответствия записи c справочником V005");
                        flk_p.appendChild(pr);
                        su.showMessagesEx("Ошибка соответствия записи в справочнике L_0300/01100");
                        resultTestExam = ResultTestExam.Failed;
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.L_0300_02200)) {
                    if (f011Service.Check(pers.getDoctype())) {
                        Element pr = getPrElement("L_0300/02200", null,
                                null, null, null, pers.getDoctype(),
                                "Ошибка соответствия записи в справочнике F011");
                        flk_p.appendChild(pr);
                        su.showMessagesEx("Ошибка соответствия записи в справочнике L_0300/02200");
                        resultTestExam = ResultTestExam.Failed;
                    }
                }
                if (pers.getOnkZap() != null) {
                    for (ONKZap zap : pers.getOnkZap()) {
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.L_0300_01800)) {
                            if (pers.getWp().isEmpty() && !zap.getPacient().getNovor().equals("0")) {
                                Element pr = getPrElement("L_0300/01800", null,
                                        null, null, null, pers.getW(),
                                        "W_P Реквизит указывается обязательно, " +
                                                "если значение поля NOVOR отлично от нуля.");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соответствия записи в справочнике L_0300/01800");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0400_02402)) {
                            if (f008Service.Check(zap.getPacient().getVpolis())) {
                                Element pr = getPrElement("C_0400/02402", schet,
                                        zap, null, null, zap.getPacient().getVpolis(),
                                        "Ошибка соответствия записи c справочником F008");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соответствия записи в справочнике C_0400/02402");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0500_03000)) {
                            if (f002Service.Check(zap.getPacient().getSmo())) {
                                Element pr = getPrElement("C_0500/03000", schet,
                                        zap, null, null, zap.getPacient().getSmo(),
                                        "Ошибка соответствия записи c справочником F002");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соответствия записи в справочнике C_0500/03000");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }

                        if (zap.getZsl() != null){
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0600_03900)) {
                                if (v006Service.Check(zap.getZsl().getUslok())) {
                                    Element pr = getPrElement("C_0600/03900", schet,
                                            zap, null, null, zap.getZsl().getUslok(),
                                            "Ошибка соответствия записи c справочником V006");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соответствия записи в справочнике C_0600/03900");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0600_04000)) {
                                if (v008Service.Check(zap.getZsl().getVidpom())) {
                                    Element pr = getPrElement("C_0600/04000", schet,
                                            zap, null, null, zap.getZsl().getVidpom(),
                                            "Ошибка соответствия записи c справочником V008");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соответствия записи в справочнике C_0600/04000");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0600_04100)) {
                                if (v014Service.Check(zap.getZsl().getVidpom())) {
                                    Element pr = getPrElement("C_0600/04100", schet,
                                            zap, null, null, zap.getZsl().getVidpom(),
                                            "Ошибка соответствия записи c справочником V014");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соответствия записи в справочнике C_0600/04100");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0600_04202)) {
                                if (zap.getZsl().getNprmo().isEmpty()
                                        && (zap.getZsl().getForpom().equals("3") && zap.getZsl().getUslok().equals("1"))
                                        || zap.getZsl().getUslok().equals("2") || CheckDS1(zap.getZsl().getSls())) {
                                    Element pr = getPrElement("C_0600/04202", schet,
                                            zap, null, null, zap.getZsl().getNprmo(),
                                            "NPR_MO Заполнение обязательно в случаях оказания: " +
                                                    "1. плановой медицинской помощи в условиях стационара (FOR_POM=3 и USL_OK = 1); " +
                                                    "2. в условиях дневного стационара (USL_OK =2) " +
                                                    "3. медицинской помощи при подозрении на злокачественное" +
                                                    " новообразование, или установленном основном диагнозе " +
                                                    "злокачественного новообразования (первый символ кода основного" +
                                                    " диагноза - «С», или код основного диагноза входит в диапазон" +
                                                    " D00-D09 или D45-D47) при направлении из другой МО");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка C_0600/04202");
                                    resultTestExam = ResultTestExam.Failed;
                                } else {
                                    if (f003Service.Check(zap.getZsl().getVidpom())) {
                                        Element pr = getPrElement("C_0600/04202", schet,
                                                zap, null, null, zap.getZsl().getNprmo(),
                                                "Ошибка соответствия записи c справочником F003");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соответствия записи в справочнике C_0600/04202");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0600_04302)) {
                                if (zap.getZsl().getNprdate().isEmpty()
                                        && (zap.getZsl().getForpom().equals("3") && zap.getZsl().getUslok().equals("1"))
                                        || zap.getZsl().getUslok().equals("2") || CheckDS1(zap.getZsl().getSls())) {
                                    Element pr = getPrElement("C_0600/04302", schet,
                                            zap, null, null, zap.getZsl().getNprdate(),
                                            "NPR_DATE Заполнение обязательно в случаях оказания: " +
                                                    "1. плановой медицинской помощи в условиях стационара (FOR_POM=3 и USL_OK = 1); " +
                                                    "2. в условиях дневного стационара (USL_OK =2) " +
                                                    "3. медицинской помощи при подозрении на злокачественное" +
                                                    " новообразование, или установленном основном диагнозе " +
                                                    "злокачественного новообразования (первый символ кода основного" +
                                                    " диагноза - «С», или код основного диагноза входит в диапазон" +
                                                    " D00-D09 или D45-D47) при направлении из другой МО");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка C_0600/04302");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0600_04400)) {
                                if (f003Service.Check(zap.getZsl().getLpu())) {
                                    Element pr = getPrElement("C_0600/04400", schet,
                                            zap, null, null, zap.getZsl().getLpu(),
                                            "Ошибка соответствия записи c справочником F003");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соответствия записи в справочнике C_0600/04400");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0600_04900)) {
                                if (v009Service.Check(zap.getZsl().getRslt())) {
                                    Element pr = getPrElement("C_0600/04900", schet,
                                            zap, null, null, zap.getZsl().getRslt(),
                                            "Ошибка соответствия записи c справочником V009");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соответствия записи в справочнике C_0600/04900");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0600_05000)) {
                                if (v012Service.Check(zap.getZsl().getRslt())) {
                                    Element pr = getPrElement("C_0600/05000", schet,
                                            zap, null, null, zap.getZsl().getRslt(),
                                            "Ошибка соответствия записи c справочником V012");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соответствия записи в справочнике C_0600/05000");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0600_05400)) {
                                if (v010Service.Check(zap.getZsl().getIdsp())) {
                                    Element pr = getPrElement("C_0600/05400", schet,
                                            zap, null, null, zap.getZsl().getIdsp(),
                                            "Ошибка соответствия записи c справочником V010");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соответствия записи в справочнике C_0600/05400");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (zap.getZsl().getSls() != null){
                                double sumv = 0.00;
                                for (ONKSl sl : zap.getZsl().getSls()){
                                    sumv = sumv + Double.parseDouble(sl.getSumm());

                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0700_06300)) {
                                        if (v002Service.Check(sl.getProfil())) {
                                            Element pr = getPrElement("C_0700/06300", schet,
                                                    zap, sl, null, sl.getProfil(),
                                                    "Ошибка соответствия записи c справочником V002");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соответствия записи в справочнике C_0700/06300");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0700_06400)) {
                                        if (sl.getProfilk().isEmpty()
                                                && (zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2"))){
                                            Element pr = getPrElement("C_0700/06400", schet,
                                                    zap, sl, null, sl.getProfilk(),
                                                    "Ошибка соответствия записи c справочником V002");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соответствия записи в справочнике C_0700/06400");
                                            resultTestExam = ResultTestExam.Failed;
                                        } else {
                                            if (v020Service.Check(sl.getProfilk())) {
                                                Element pr = getPrElement("C_0700/06400", schet,
                                                        zap, sl, null, sl.getProfilk(),
                                                        "Ошибка соответствия записи c справочником V002");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соответствия записи в справочнике C_0700/06400");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0700_06600)) {
                                        if (sl.getPcel().isEmpty() && zap.getZsl().getUslok().equals("3")){
                                            Element pr = getPrElement("C_0700/06600", schet,
                                                    zap, sl, null, sl.getPcel(),
                                                    "Ошибка соответствия записи c справочником V025");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соответствия записи в справочнике C_0700/06600");
                                            resultTestExam = ResultTestExam.Failed;
                                        } else {
                                            if (v025Service.Check(sl.getProfilk())) {
                                                Element pr = getPrElement("C_0700/06600", schet,
                                                        zap, sl, null, sl.getProfilk(),
                                                        "Ошибка соответствия записи c справочником V002");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соответствия записи в справочнике C_0700/06600");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0700_06800)) {
                                        if (sl.getPper().isEmpty()
                                                && (zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2"))) {
                                            Element pr = getPrElement("C_0700/06800", schet,
                                                    zap, sl, null, sl.getPper(),
                                                    "P_PER Обязательно к заполнению следующими значениями для" +
                                                            " дневного и круглосуточного стационара " +
                                                            "(USL_OK=1 или USL_OK=2): " +
                                                            "1 – Самостоятельно " +
                                                            "2 – СМП " +
                                                            "3 – Перевод из другой МО " +
                                                            "4 – Перевод внутри МО с другого профиля");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка C_0700/06800");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0700_07100)) {
                                        if (sl.getKd().isEmpty()
                                                && (zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2"))) {
                                            Element pr = getPrElement("C_0700/07100", schet,
                                                    zap, sl, null, sl.getKd(),
                                                    "KD Обязательно к заполнению для круглосуточного и дневного" +
                                                            " стационара (USL_OK=1 или USL_OK=2)");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка C_0700/07100");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0700_07602)) {
                                        if (sl.getCzab().isEmpty() && CheckDS1_1(sl)) {
                                            Element pr = getPrElement("C_0700/07602", schet,
                                                    zap, sl, null, sl.getCzab(),
                                                    "C_ZAB Обязательно к заполнению при установленном диагнозе " +
                                                            "злокачественного новообразования (первый символ кода " +
                                                            "основного диагноза - «С» или код основного диагноза входит" +
                                                            " в диапазон D00-D09 или D45-D47) для круглосуточного " +
                                                            "стационара, дневного стационара, амбулаторной помощи");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка C_0700/07602");
                                            resultTestExam = ResultTestExam.Failed;
                                        } else {
                                            if (v027Service.Check(sl.getProfilk())) {
                                                Element pr = getPrElement("C_0700/07602", schet,
                                                        zap, sl, null, sl.getProfilk(),
                                                        "Ошибка соответствия записи c справочником V027");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соответствия записи в справочнике C_0700/07602");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0700_07800)) {
                                        if (sl.getDn().isEmpty() && sl.getPcel().equals("1.3")) {
                                            Element pr = getPrElement("C_0700/07800", schet,
                                                    zap, sl, null, sl.getDn(),
                                                    "DN Обязательно для заполнения, если P_CEL=1.3");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка C_0700/07800");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (sl.getNapr() == null){
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0700_08102)) {
                                            if (CheckDS1_1(sl)){
                                                Element pr = getPrElement("C_0700/08102", schet,
                                                        zap, sl, null, "",
                                                        "NAPR Обязательно к заполнению в случае оформления " +
                                                                "направления при подозрении на злокачественное " +
                                                                "новообразование (DS_ONK=1) или установленном " +
                                                                "диагнозе злокачественного новообразования " +
                                                                "(первый символ кода основного диагноза " +
                                                                "- «С» или код основного диагноза входит в" +
                                                                " диапазон D00-D09 или D45-D47)");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка C_0700/08102");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    } else {
                                        for (Napr napr : sl.getNapr()) {
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0800_09500)) {
                                                if (f003Service.Check(napr.getNaprmo())) {
                                                    Element pr = getPrElement("C_0800/09500", schet,
                                                            zap, sl, null, napr.getNaprmo(),
                                                            "Ошибка соответствия записи c справочником f003");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи c справочником C_0800/09500");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0800_09600)) {
                                                if (v028Service.Check(napr.getNaprv())) {
                                                    Element pr = getPrElement("C_0800/09600", schet,
                                                            zap, sl, null, napr.getNaprv(),
                                                            "Ошибка соответствия записи c справочником v028");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи c справочником C_0800/09600");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0800_09700)) {
                                                if (v029Service.Check(napr.getMetissl()) && napr.getNaprv().equals("3")) {
                                                    Element pr = getPrElement("C_0800/09700", schet,
                                                            zap, sl, null, napr.getMetissl(),
                                                            "Ошибка соответствия записи c справочником v029");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи c справочником C_0800/09700");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0800_09800)) {
                                                if (napr.getNaprusl().isEmpty() && !napr.getMetissl().isEmpty()) {
                                                    Element pr = getPrElement("C_0800/09800", schet,
                                                            zap, sl, null, napr.getNaprusl(),
                                                            "NAPR_USL Обязательно к заполнению при заполненном MET_ISSL");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка C_0800/09800");
                                                    resultTestExam = ResultTestExam.Failed;
                                                } else {
                                                    if (v001Service.Check(napr.getNaprusl())) {
                                                        Element pr = getPrElement("C_0800/09800", schet,
                                                                zap, sl, null, napr.getNaprusl(),
                                                                "Ошибка соответствия записи c справочником v001");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка соответствия записи c справочником C_0800/09800");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    if (sl.getCons() == null){
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0700_08202)) {
                                            if (CheckDS1_1(sl)){
                                                Element pr = getPrElement("C_0700/08202", schet,
                                                        zap, sl, null, "",
                                                        "CONS Обязательно к заполнению в случае оформления " +
                                                                "направления при подозрении на злокачественное " +
                                                                "новообразование (DS_ONK=1) или установленном " +
                                                                "диагнозе злокачественного новообразования " +
                                                                "(первый символ кода основного диагноза " +
                                                                "- «С» или код основного диагноза входит в" +
                                                                " диапазон D00-D09 или D45-D47)");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка C_0700/08202");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    } else {
                                        for (Cons cons : sl.getCons()) {
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0900_09900)) {
                                                if (n019Service.Check(cons.getPrcons())) {
                                                    Element pr = getPrElement("C_0900/09900", schet,
                                                            zap, sl, null, cons.getPrcons(),
                                                            "Ошибка соответствия записи c справочником n019");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи c справочником C_0900/09900");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0900_10000)) {
                                                if (cons.getDtcons().isEmpty() && (cons.getPrcons().equals("1")
                                                        || cons.getPrcons().equals("2") || cons.getPrcons().equals("3"))) {
                                                    Element pr = getPrElement("C_0900/10000", schet,
                                                            zap, sl, null, cons.getDtcons(),
                                                            "DT_CONS Обязательно заполнению, " +
                                                                    "если консилиум проведен (PR_CONS={1,2,3})");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка C_0900/10000");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                        }
                                    }
                                    if (sl.getOnksl() != null){
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1000_10100)) {
                                            if (n018Service.Check(sl.getOnksl().getDs1t())) {
                                                Element pr = getPrElement("C_1000/10100", schet,
                                                        zap, sl, null, sl.getOnksl().getDs1t(),
                                                        "Ошибка соответствия записи c справочником n018");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соответствия записи c справочником C_1000/10100");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1000_10200)) {
                                            if (sl.getOnksl().getStad().isEmpty() && (sl.getOnksl().getDs1t().equals("1")
                                                    || sl.getOnksl().getDs1t().equals("2") || sl.getOnksl().getDs1t().equals("3")
                                                    || sl.getOnksl().getDs1t().equals("4"))) {
                                                Element pr = getPrElement("C_1000/10200", schet,
                                                        zap, sl, null, sl.getOnksl().getStad(),
                                                        "STAD Обязательно к заполнению при проведении " +
                                                                "противоопухолевого лечения или " +
                                                                "наблюдении (DS1_T={0,1,2,3,4}).");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка C_1000/10200");
                                                resultTestExam = ResultTestExam.Failed;
                                            } else {
                                                if (n002Service.Check(sl.getOnksl().getStad())) {
                                                    Element pr = getPrElement("C_1000/10200", schet,
                                                            zap, sl, null, sl.getOnksl().getStad(),
                                                            "Ошибка соответствия записи c справочником n002");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи c справочником C_1000/10200");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                        }
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1000_10300)) {
                                            if (sl.getOnksl().getOnkt().isEmpty() && sl.getOnksl().getDs1t().equals("0")
                                                    && GetAge(pers.getDr(), sl.getDate1()) > 18) {
                                                Element pr = getPrElement("C_1000/10300", schet,
                                                        zap, sl, null, sl.getOnksl().getOnkt(),
                                                        "ONK_T Обязательно к заполнению при первичном " +
                                                                "лечении (DS1_T=0) для пациентов, возраст которых" +
                                                                " на дату начала лечения более 18 лет");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка C_1000/10300");
                                                resultTestExam = ResultTestExam.Failed;
                                            } else {
                                                if (n003Service.Check(sl.getOnksl().getOnkt())) {
                                                    Element pr = getPrElement("C_1000/10300", schet,
                                                            zap, sl, null, sl.getOnksl().getOnkt(),
                                                            "Ошибка соответствия записи c справочником n003");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи c справочником C_1000/10300");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                        }
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1000_10400)) {
                                            if (sl.getOnksl().getOnkn().isEmpty() && sl.getOnksl().getDs1t().equals("0")
                                                    && GetAge(pers.getDr(), sl.getDate1()) > 18) {
                                                Element pr = getPrElement("C_1000/10400", schet,
                                                        zap, sl, null, sl.getOnksl().getOnkn(),
                                                        "ONK_N Обязательно к заполнению при первичном лечении " +
                                                                "(DS1_T=0) для пациентов, возраст которых на дату" +
                                                                " начала лечения более 18 лет");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка C_1000/10400");
                                                resultTestExam = ResultTestExam.Failed;
                                            } else {
                                                if (n004Service.Check(sl.getOnksl().getOnkn())) {
                                                    Element pr = getPrElement("C_1000/10400", schet,
                                                            zap, sl, null, sl.getOnksl().getOnkn(),
                                                            "Ошибка соответствия записи c справочником n004");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи c справочником C_1000/10400");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                        }
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1000_10500)) {
                                            if (sl.getOnksl().getOnkm().isEmpty() && sl.getOnksl().getDs1t().equals("0")
                                                    && GetAge(pers.getDr(), sl.getDate1()) > 18) {
                                                Element pr = getPrElement("C_1000/10500", schet,
                                                        zap, sl, null, sl.getOnksl().getOnkm(),
                                                        "ONK_N Обязательно к заполнению при первичном лечении " +
                                                                "(DS1_T=0) для пациентов, возраст которых на дату" +
                                                                " начала лечения более 18 лет");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка C_1000/10500");
                                                resultTestExam = ResultTestExam.Failed;
                                            } else {
                                                if (n005Service.Check(sl.getOnksl().getOnkn())) {
                                                    Element pr = getPrElement("C_1000/10500", schet,
                                                            zap, sl, null, sl.getOnksl().getOnkm(),
                                                            "Ошибка соответствия записи c справочником n005");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи c справочником C_1000/10500");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                        }
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1000_10600)) {
                                            if (!sl.getOnksl().getMtstz().equals("1") && !(sl.getOnksl().getDs1t().equals("1")
                                                    || sl.getOnksl().getDs1t().equals("2"))) {
                                                Element pr = getPrElement("C_1000/10600", schet,
                                                        zap, sl, null, sl.getOnksl().getMtstz(),
                                                        "MTSTZ Используется только при рецидиве или" +
                                                                " прогрессировании (DS1_T=1 или DS1_T=2). " +
                                                                "При выявлении отдалённых метастазов обязательно " +
                                                                "к заполнению значением 1");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка C_1000/10600");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                        if (sl.getOnksl().getOnkusls() == null) {
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1000_11400)){
                                                if (zap.getZsl().getUslok().equals("1") || (zap.getZsl().getUslok().equals("2"))
                                                        && (sl.getOnksl().getDs1t().equals("0") || sl.getOnksl().getDs1t().equals("1")
                                                        || sl.getOnksl().getDs1t().equals("2"))) {
                                                    Element pr = getPrElement("C_1000/11400", schet,
                                                            zap, sl, null, "",
                                                            "ONK_USL Обязательно к заполнению для стационара" +
                                                                    " и дневного стационара (USL_OK=1 или USL_OK=2)" +
                                                                    " при проведении противоопухолевого лечения (DS1_T={0,1,2})");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка C_1000/11400");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                        } else {
                                            for (ONKOnkusl onkOnkusl : sl.getOnksl().getOnkusls()){
                                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1000_10700))                                                {
                                                    if (sl.getOnksl().getSod().isEmpty() && (onkOnkusl.getUsltip().equals("3")
                                                            || onkOnkusl.getUsltip().equals("4"))) {
                                                        Element pr = getPrElement("C_1000/10700", schet,
                                                                zap, sl, null, sl.getOnksl().getSod(),
                                                                "SOD Обязательно для заполнения при проведении" +
                                                                        " лучевой или химиолучевой" +
                                                                        " терапии (USL_TIP=3 или USL_TIP=4)");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка C_1000/10700");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1000_10800))                                                {
                                                    if (sl.getOnksl().getKfr().isEmpty() && (onkOnkusl.getUsltip().equals("3")
                                                            || onkOnkusl.getUsltip().equals("4"))) {
                                                        Element pr = getPrElement("C_1000/10800", schet,
                                                                zap, sl, null, sl.getOnksl().getKfr(),
                                                                "K_FR Обязательно для заполнения при проведении" +
                                                                        " лучевой или химиолучевой" +
                                                                        " терапии (USL_TIP=3 или USL_TIP=4)");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка C_1000/10800");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1300_12200)) {
                                                    if (n013Service.Check(onkOnkusl.getUsltip())) {
                                                        Element pr = getPrElement("C_1200/12200", schet,
                                                                zap, sl, null, onkOnkusl.getUsltip(),
                                                                "Ошибка соответствия записи c справочником n013");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка соответствия записи c справочником C_1200/12200");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1300_12300)) {
                                                    if (!onkOnkusl.getUsltip().equals("1") && !onkOnkusl.getHirtip().isEmpty()){
                                                        Element pr = getPrElement("C_1300/12300", schet,
                                                                zap, sl, null, onkOnkusl.getHirtip(),
                                                                "HIR_TIP Не подлежит заполнению при USL_TIP не равном 1");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка C_1300/12300");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    } else if (n014Service.Check(onkOnkusl.getHirtip()) && onkOnkusl.getUsltip().equals("1")) {
                                                        Element pr = getPrElement("C_1300/12300", schet,
                                                                zap, sl, null, onkOnkusl.getHirtip(),
                                                                "Ошибка соответствия записи c справочником n014");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка соответствия записи c справочником C_1300/12300");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1300_12400)) {
                                                    if (!onkOnkusl.getUsltip().equals("2") && !onkOnkusl.getLektipl().isEmpty()){
                                                        Element pr = getPrElement("C_1300/12400", schet,
                                                                zap, sl, null, onkOnkusl.getLektipl(),
                                                                "LEK_TIP_L Не подлежит заполнению при USL_TIP не равном 2");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка C_1300/12400");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    } else if (n015Service.Check(onkOnkusl.getLektipl()) && onkOnkusl.getUsltip().equals("2")) {
                                                        Element pr = getPrElement("C_1300/12400", schet,
                                                                zap, sl, null, onkOnkusl.getLektipl(),
                                                                "Ошибка соответствия записи c справочником n015");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка соответствия записи c справочником C_1300/12400");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1300_12500)) {
                                                    if (!onkOnkusl.getUsltip().equals("2") && !onkOnkusl.getLektipv().isEmpty()){
                                                        Element pr = getPrElement("C_1300/12500", schet,
                                                                zap, sl, null, onkOnkusl.getLektipv(),
                                                                "HIR_TIP Не подлежит заполнению при USL_TIP не равном 2");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка C_1300/12500");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    } else if (n016Service.Check(onkOnkusl.getLektipv()) && onkOnkusl.getUsltip().equals("2")) {
                                                        Element pr = getPrElement("C_1300/12500", schet,
                                                                zap, sl, null, onkOnkusl.getLektipv(),
                                                                "Ошибка соответствия записи c справочником n016");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка соответствия записи c справочником C_1300/12500");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1300_12800)) {
                                                    if ((onkOnkusl.getUsltip().equals("3") || onkOnkusl.getUsltip().equals("4"))
                                                            && !onkOnkusl.getLuchtip().isEmpty()){
                                                        if (n017Service.Check(onkOnkusl.getLuchtip())){
                                                            Element pr = getPrElement("C_1300/12800", schet,
                                                                    zap, sl, null, onkOnkusl.getLuchtip(),
                                                                    "LUCH_TIP При USL_TIP=3 или USL_TIP=4" +
                                                                            " заполняется в соответствии со справочником N017");
                                                            flk_p.appendChild(pr);
                                                            su.showMessagesEx("Ошибка C_1300/12800");
                                                            resultTestExam = ResultTestExam.Failed;
                                                        }
                                                    } else if (!onkOnkusl.getLuchtip().isEmpty()
                                                            && (!onkOnkusl.getUsltip().equals("3") && !onkOnkusl.getUsltip().equals("4"))){
                                                        Element pr = getPrElement("C_1300/12500", schet,
                                                                zap, sl, null, onkOnkusl.getLektipv(),
                                                                "LUCH_TIP Не подлежит заполнению при USL_TIP не равном 3 или 4");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка C_1300/12800");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                                if (onkOnkusl.getLekprs() == null && (onkOnkusl.getUsltip().equals("2")
                                                        || onkOnkusl.getUsltip().equals("4"))){
                                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1300_12600)) {
                                                        if (!onkOnkusl.getUsltip().equals("2") && !onkOnkusl.getLektipv().isEmpty()){
                                                            Element pr = getPrElement("C_1300/12600", schet,
                                                                    zap, sl, null, onkOnkusl.getLektipv(),
                                                                    "LEK_PR Обязательно к заполнению при USL_TIP=2 или USL_TIP=4");
                                                            flk_p.appendChild(pr);
                                                            su.showMessagesEx("Ошибка C_1300/12600");
                                                            resultTestExam = ResultTestExam.Failed;
                                                        }
                                                    }
                                                } else {
                                                    for (ONKLekpr lekpr : onkOnkusl.getLekprs()) {
                                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1400_12900)) {
                                                            if (n020Service.Check(lekpr.getRegnum())) {
                                                                Element pr = getPrElement("C_1400/12900", schet,
                                                                        zap, sl, null, lekpr.getRegnum(),
                                                                        "Ошибка соответствия записи c справочником N020");
                                                                flk_p.appendChild(pr);
                                                                su.showMessagesEx("Ошибка соответствия записи c справочником C_1400/12900");
                                                                resultTestExam = ResultTestExam.Failed;
                                                            }
                                                        }
                                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1400_13000)) {
                                                            if (v024Service.Check(lekpr.getCodesh())) {
                                                                Element pr = getPrElement("C_1400/13000", schet,
                                                                        zap, sl, null, lekpr.getCodesh(),
                                                                        "Ошибка соответствия записи c справочником V024");
                                                                flk_p.appendChild(pr);
                                                                su.showMessagesEx("Ошибка соответствия записи c справочником C_1400/13000");
                                                                resultTestExam = ResultTestExam.Failed;
                                                            }
                                                        }
                                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1400_13001)) {
                                                            if (v024Service.Check(lekpr.getCodesh()) && GetAge(pers.getDr(), sl.getDate1()) >= 18) {
                                                                Element pr = getPrElement("C_1400/13001", schet,
                                                                        zap, sl, null, lekpr.getCodesh(),
                                                                        "CODE_SH должен заполняться кодом схемы" +
                                                                                " лекарственной терапии в соответствии" +
                                                                                " с классификатором V024 при злокачественных" +
                                                                                " новообразованиях (кроме лимфоидной и кроветворной тканей)" +
                                                                                " у пациентов, возраст которых на" +
                                                                                " дату начала лечения 18 лет и старше");
                                                                flk_p.appendChild(pr);
                                                                su.showMessagesEx("Ошибка соответствия записи c справочником C_1400/13001");
                                                                resultTestExam = ResultTestExam.Failed;
                                                            } else if (GetAge(pers.getDr(), sl.getDate1()) < 18 && lekpr.getCodesh().equals("нет")){
                                                                Element pr = getPrElement("C_1400/13001", schet,
                                                                        zap, sl, null, lekpr.getCodesh(),
                                                                        "CODE_SH должен заполняться значением «нет»" +
                                                                                " при злокачественных новообразованиях " +
                                                                                "у пациентов, возраст которых на дату" +
                                                                                " начала лечения менее 18 лет," +
                                                                                " и злокачественных новообразованиях " +
                                                                                "лимфоидной и кроветворной тканей");
                                                                flk_p.appendChild(pr);
                                                                su.showMessagesEx("Ошибка соответствия записи c справочником C_1400/13001");
                                                                resultTestExam = ResultTestExam.Failed;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (sl.getOnksl().getBdiags() != null){
                                            for (ONKBdiag bdiag : sl.getOnksl().getBdiags()){
                                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1100_11600))                                                {
                                                    if (bdiag.getDiagdate().isEmpty() && (!bdiag.getDiagtip().equals("1")
                                                            || !bdiag.getDiagtip().equals("2"))) {
                                                        Element pr = getPrElement("C_1100/11600", schet,
                                                                zap, sl, null, sl.getOnksl().getKfr(),
                                                                "DIAG_TIP При отсутствии DIAG_ DATE обязательно " +
                                                                        "к заполнению значениями: " +
                                                                        "1 – гистологический признак; " +
                                                                        "2 – маркёр (ИГХ).");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка C_1100/11600");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1100_11700))                                                {
                                                    if (bdiag.getDiagtip().equals("1") && n007Service.Check(bdiag.getDiagcode())) {
                                                        Element pr = getPrElement("C_1100/11700", schet,
                                                                zap, sl, null, bdiag.getDiagcode(),
                                                                "DIAG_CODE При DIAG_TIP=1 заполняется в " +
                                                                        "соответствии со справочником N007");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка C_1100/11700");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    } else if (bdiag.getDiagtip().equals("2") && n010Service.Check(bdiag.getDiagcode())) {
                                                        Element pr = getPrElement("C_1100/11700", schet,
                                                                zap, sl, null, bdiag.getDiagcode(),
                                                                "DIAG_CODE При DIAG_TIP=2 заполняется в " +
                                                                        "соответствии со справочником N010");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка C_1100/11700");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1100_11800))                                                {
                                                    if (bdiag.getDiagtip().equals("1") && n008Service.Check(bdiag.getDiagrlst())) {
                                                        Element pr = getPrElement("C_1100/11800", schet,
                                                                zap, sl, null, bdiag.getDiagrlst(),
                                                                "DIAG_CODE При DIAG_TIP=1 заполняется в " +
                                                                        "соответствии со справочником N008");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка C_1100/11800");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    } else if (bdiag.getDiagtip().equals("2") && n011Service.Check(bdiag.getDiagrlst())) {
                                                        Element pr = getPrElement("C_1100/11800", schet,
                                                                zap, sl, null, bdiag.getDiagcode(),
                                                                "DIAG_CODE При DIAG_TIP=2 заполняется в " +
                                                                        "соответствии со справочником N011");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка C_1100/11800");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                            }
                                        }
                                        if (sl.getOnksl().getBprots() != null){
                                            for (ONKBprot bprot : sl.getOnksl().getBprots()){
                                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1200_12000)) {
                                                    if (n001Service.Check(bprot.getProt())) {
                                                        Element pr = getPrElement("C_1200/12000", schet,
                                                                zap, sl, null, bprot.getProt(),
                                                                "Ошибка соответствия записи c справочником n001");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка соответствия записи c справочником C_1200/12000");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0700_08600)) {
                                        if (v021Service.Check(sl.getPrvs())) {
                                            Element pr = getPrElement("C_0700/08600", schet,
                                                    zap, sl, null, sl.getPrvs(),
                                                    "Ошибка соответствия записи c справочником V021");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка C_0700/08600");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0700_09002)) {
                                        if (sl.getTarif().isEmpty() && CheckDS1_1(sl)){
                                            Element pr = getPrElement("C_0700/09002", schet,
                                                    zap, sl, null, sl.getTarif(),
                                                    "TARIF Обязательно к заполнению при установленном основном " +
                                                            "диагнозе злокачественного новообразования " +
                                                            "(первый символ кода основного диагноза " +
                                                            "- «С» или код основного диагноза входит" +
                                                            " в диапазон D00-D09 или D45-D47)");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка C_0700/09002");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (sl.getKsgkpg() != null){
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1500_13200)) {
                                            if (!sl.getKsgkpg().getNkpg().isEmpty() && !sl.getKsgkpg().getNksg().isEmpty()){
                                                Element pr = getPrElement("C_1500/13200", schet,
                                                        zap, sl, null, sl.getKsgkpg().getNksg(),
                                                        "N_KSG Не подлежит заполнению при заполненном N_KРG");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка C_1500/13200");
                                                resultTestExam = ResultTestExam.Failed;
                                            } else if (v032Service.Check(sl.getKsgkpg().getNksg())) {
                                                Element pr = getPrElement("C_1500/13200", schet,
                                                        zap, sl, null, sl.getKsgkpg().getNksg(),
                                                        "Ошибка соответствия записи c справочником V032");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соответствия записи c справочником C_1500/13200");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1500_13500)) {
                                            if (!sl.getKsgkpg().getNkpg().isEmpty() && !sl.getKsgkpg().getNksg().isEmpty()){
                                                Element pr = getPrElement("C_1500/13500", schet,
                                                        zap, sl, null, sl.getKsgkpg().getNkpg(),
                                                        "N_KPG Не подлежит заполнению при заполненном N_KSG");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка C_1500/13500");
                                                resultTestExam = ResultTestExam.Failed;
                                            } else if (v026Service.Check(sl.getKsgkpg().getNkpg())) {
                                                Element pr = getPrElement("C_1500/13200", schet,
                                                        zap, sl, null, sl.getKsgkpg().getNkpg(),
                                                        "Ошибка соответствия записи c справочником V026");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соответствия записи c справочником C_1500/13500");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                        if (sl.getKsgkpg().getCrit() != null) {
                                            for (String crit : sl.getKsgkpg().getCrit()) {
                                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1500_14100)) {
                                                    if (v024Service.Check(crit)) {
                                                        Element pr = getPrElement("C_1500/14100", schet,
                                                                zap, sl, null, crit,
                                                                "Ошибка соответствия записи c справочником V024");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка соответствия записи c справочником C_1500/14100");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                            }
                                        }
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1500_14400)) {
                                            if (sl.getKsgkpg().getSlkoef() != null && sl.getKsgkpg().getItsl().isEmpty()) {
                                                Element pr = getPrElement("C_1500/14400", schet,
                                                        zap, sl, null, "",
                                                        "SL_KOEF Указывается при наличии IT_SL.");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка C_1500/14400");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }

                                    if (sl.getUsl() == null){
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0700_09202)) {
                                            if (CheckDS1_1(sl)){
                                                Element pr = getPrElement("C_0700/09202", schet,
                                                        zap, sl, null, "",
                                                        "USL Обязательно к заполнению в случае проведения " +
                                                                "хирургического лечения, лучевой или химиолучевой " +
                                                                "терапии, диагностических мероприятий при установленном" +
                                                                " основном диагнозе злокачественного новообразования" +
                                                                " (первый символ кода основного диагноза - «С» или" +
                                                                " код основного диагноза входит в диапазон " +
                                                                "D00-D09 или D45-D47)");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка C_0700/09202");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    } else {
                                        for (ONKUsl usl : sl.getUsl()) {
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1700_14800)) {
                                                if (f003Service.Check(usl.getLpu())) {
                                                    Element pr = getPrElement("C_1700/14800", schet,
                                                            zap, sl, usl, usl.getLpu(),
                                                            "Ошибка соответствия записи c справочником F003");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи c справочником C_1700/14800");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1700_15100)) {
                                                if (v002Service.Check(usl.getProfil())) {
                                                    Element pr = getPrElement("C_1700/15100", schet,
                                                            zap, sl, usl, usl.getLpu(),
                                                            "Ошибка соответствия записи c справочником V002");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи c справочником C_1700/15100");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1700_15202)) {
                                                if (CheckDS1_1(sl) && usl.getVidvme().isEmpty()) {
                                                    Element pr = getPrElement("C_1700/15202", schet,
                                                            zap, sl, usl, usl.getVidvme(),
                                                            "VID_VME Обязательно к заполнению: для услуг диализа; " +
                                                                    "для услуг, условие оказания которых является " +
                                                                    "тарифообразующим; в случае проведения хирургического" +
                                                                    " лечения, лучевой или химиолучевой терапии," +
                                                                    " диагностических мероприятий при установленном " +
                                                                    "основном диагнозе злокачественного новообразования " +
                                                                    "(первый символ кода основного диагноза - «С» или" +
                                                                    " код основного диагноза входит в" +
                                                                    " диапазон D00-D09 или D45-D47)");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи c справочником C_1700/15202");
                                                    resultTestExam = ResultTestExam.Failed;
                                                } else if (v001Service.Check(usl.getVidvme())) {
                                                    Element pr = getPrElement("C_1700/15202", schet,
                                                            zap, sl, usl, usl.getVidvme(),
                                                            "Ошибка соответствия записи c справочником V001");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи c справочником C_1700/15202");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }

                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1700_16100)) {
                                                if (v021Service.Check(usl.getPrvs())) {
                                                    Element pr = getPrElement("C_1700/16100", schet,
                                                            zap, sl, usl, usl.getPrvs(),
                                                            "Ошибка соответствия записи c справочником V021");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи c справочником C_1700/16100");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_0600_05500)) {
                                    if (Double.parseDouble(zap.getZsl().getSumv()) != sumv) {
                                        Element pr = getPrElement("C_0600/05500", schet,
                                                zap, null, null, zap.getZsl().getSumv(),
                                                "SUM_V не равно сумме значений SUM_M вложенных элементов SL");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка C_0600/05500");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                            }
                            if (zap.getZsl().getSanks() != null){
                                for (Sank sank : zap.getZsl().getSanks()){
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1800_16700)) {
                                        if (f006Service.Check(sank.getStip())) {
                                            Element pr = getPrElement("C_1800/16700", schet,
                                                    zap, null, null, sank.getStip(),
                                                    "Ошибка соответствия записи c справочником F006");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соответствия записи c справочником C_1800/16700");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1800_16800)) {
                                        if ((!sank.getSsum().equals("0") && !sank.getSsum().isEmpty()) && sank.getSlid() == null) {
                                            Element pr = getPrElement("C_1800/16800", schet,
                                                    zap, null, null, "",
                                                    "SL_ID Обязательно к заполнению, если S_SUM не равна 0");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка C_1800/16800");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1800_16900)) {
                                        if ((!sank.getSsum().equals("0") && !sank.getSsum().isEmpty()) && sank.getSosn().isEmpty()) {
                                            Element pr = getPrElement("C_1800/16900", schet,
                                                    zap, null, null, "",
                                                    "S_OSN Обязательно к заполнению, если S_SUM не равна 0");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка C_1800/16900");
                                            resultTestExam = ResultTestExam.Failed;
                                        } else if (f014Service.Check(sank.getStip())) {
                                            Element pr = getPrElement("C_1800/16900", schet,
                                                    zap, null, null, sank.getSosn(),
                                                    "Ошибка соответствия записи c справочником F014");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соответствия записи c справочником C_1800/16900");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.C_1800_17200)) {
                                        if (Integer.parseInt(sank.getStip()) >= 30 && sank.getCodeexp() == null) {
                                            Element pr = getPrElement("C_1800/17200", schet,
                                                    zap, null, null, "",
                                                    "CODE_EXP Обязательно к заполнению для экспертиз" +
                                                            " качества медицинской помощи (S_TIP>=30)");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка C_1800/17200");
                                            resultTestExam = ResultTestExam.Failed;
                                        } else {
                                            for (String codeexp : sank.getCodeexp()) {
                                                if (f004Service.Check(codeexp)) {
                                                    Element pr = getPrElement("C_1800/17200", schet,
                                                            zap, null, null, sank.getSosn(),
                                                            "Ошибка соответствия записи c справочником F004");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соответствия записи c справочником C_1800/17200");
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

    private int GetAge(String dr, String date1) {
        LocalDate dateDr = LocalDate.parse(dr);
        LocalDate dateDate1 = LocalDate.parse(date1);
        long age = ChronoUnit.YEARS.between(dateDr, dateDate1);
        return (int) age;
    }

    private Element getPrElement(String oshib, Schet schet, ONKZap zap, ONKSl sl,
                                 ONKUsl usl, String znPol, String comment) {
        Element pr = new Element("PR");
        Element elOshib = new Element("OSHIB");
        elOshib.appendChild(oshib);
        pr.appendChild(elOshib);
        Element elNzap = new Element("N_ZAP");
        if (zap == null) {
            elNzap.appendChild("");
        } else {
            elNzap.appendChild(zap.getNzap());
        }
        pr.appendChild(elNzap);
        Element elIdcase = new Element("IDCASE");
        if (sl == null) {
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

    private boolean CheckDS1(List<ONKSl> sls) {

        if (sls == null) return false;
        for (ONKSl sl : sls) {
            if (sl.getDs1().contains("C") || sl.getDs1().contains("D45") || sl.getDs1().contains("D46") || sl.getDs1().contains("D47")) {
                return false;
            }
            for (int i = 0; i < 10; i++) {
                if (sl.getDs1().contains("D0" + i)) {
                    return false;
                }
            }
        }

        return true;
    }
    private boolean CheckDS1_1(ONKSl sl) {
        if (sl == null) return false;
        if (sl.getDs1().contains("C") || sl.getDs1().contains("D45") || sl.getDs1().contains("D46") || sl.getDs1().contains("D47")) {
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if (sl.getDs1().contains("D0" + i)) {
                return false;
            }
        }

        return true;
    }
}
