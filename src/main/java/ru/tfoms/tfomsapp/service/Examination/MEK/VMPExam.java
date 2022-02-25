package ru.tfoms.tfomsapp.service.Examination.MEK;

import nu.xom.Document;
import nu.xom.Element;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.Exam.ExamParam;
import ru.tfoms.tfomsapp.domain.MEK.*;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPers;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPerslist;
import ru.tfoms.tfomsapp.domain.MEK.VMP.*;
import ru.tfoms.tfomsapp.service.HandBook.*;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class VMPExam {

    private final F002Service f002Service = new F002Service();
    private final F003Service f003Service = new F003Service();
    private final F004Service f004Service = new F004Service();
    private final F006Service f006Service = new F006Service();
    private final F008Service f008Service = new F008Service();
    private final F014Service f014Service = new F014Service();
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
    private final N020Service n020Service = new N020Service();
    private final V001Service v001Service = new V001Service();
    private final V002Service v002Service = new V002Service();
    private final V006Service v006Service = new V006Service();
    private final V008Service v008Service = new V008Service();
    private final V009Service v009Service = new V009Service();
    private final V010Service v010Service = new V010Service();
    private final V012Service v012Service = new V012Service();
    private final V014Service v014Service = new V014Service();
    private final V018Service v018Service = new V018Service();
    private final V019Service v019Service = new V019Service();
    private final V020Service v020Service = new V020Service();
    private final V021Service v021Service = new V021Service();
    private final V024Service v024Service = new V024Service();
    private final V027Service v027Service = new V027Service();
    private final V028Service v028Service = new V028Service();
    private final V029Service v029Service = new V029Service();
    private final ServiceUtil su = new ServiceUtil();

    public ResultTestExam exam(PDPerslist persList, Zglv zglv, Schet schet, ExamParam examParam) throws IOException {
        ResultTestExam resultTestExam = ResultTestExam.Success;

        Element flk_p = new Element("FLK_P");
        Element fname = new Element("FNAME");
        if (zglv != null){
            fname.appendChild("V" + zglv.getFilename() );
            flk_p.appendChild(fname);
            Element fname_i = new Element("FNAME_I");
            fname_i.appendChild(zglv.getFilename());
            flk_p.appendChild(fname_i);
        }

        if (schet != null){
            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0300_00900)){
                if (f003Service.Check(schet.getCodemo())){
                    Element pr = getPrElement("T_0300/00900", schet,
                            null, null, null, schet.getCodemo(),
                            "Ошибка соответствия записи c справочником F003");
                    flk_p.appendChild(pr);
                    su.showMessagesEx("Ошибка соответствия записи в справочнике T_0300/00900");
                    resultTestExam = ResultTestExam.Failed;
                }
            }
            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0300_01400)){
                if (f002Service.Check(schet.getPlat())){
                    Element pr = getPrElement("T_0300/01400", schet,
                            null, null, null, schet.getPlat(),
                            "Ошибка соответствия записи c справочником F002");
                    flk_p.appendChild(pr);
                    su.showMessagesEx("Ошибка соответствия записи в справочнике T_0300/01400");
                    resultTestExam = ResultTestExam.Failed;
                }
            }
        }

        if (persList != null && persList.getPers() != null) {
            for (PDPers pers : persList.getPers()) {
                if (pers.getVmpZap() != null) {
                    for (VMPZap zap : pers.getVmpZap()) {
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0500_02600)) {
                            if (f008Service.Check(zap.getPacient().getVpolis())) {
                                Element pr = getPrElement("T_0500/02600", schet,
                                        zap, null, null, zap.getPacient().getVpolis(),
                                        "Ошибка соответствия записи c справочником F008");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_0500/02600");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0500_03000)) {
                            if (f002Service.Check(zap.getPacient().getSmo())) {
                                Element pr = getPrElement("T_0500/03000", schet,
                                        zap, null, null, zap.getPacient().getSmo(),
                                        "Ошибка соответствия записи c справочником F002");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_0500/03000");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_03800)) {
                            if (v006Service.Check(zap.getZsl().getUslok())) {
                                Element pr = getPrElement("T_0600/03800", schet,
                                        zap, null, null, zap.getZsl().getUslok(),
                                        "Ошибка соответствия записи c справочником V006");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_0600/03800");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_03900)) {
                            if (v008Service.Check(zap.getZsl().getVidpom())) {
                                Element pr = getPrElement("T_0600/03900", schet,
                                        zap, null, null, zap.getZsl().getVidpom(),
                                        "Ошибка соответствия записи c справочником V008");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_0600/03900");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_04000)) {
                            if (v014Service.Check(zap.getZsl().getForpom())) {
                                Element pr = getPrElement("T_0600/04000", schet,
                                        zap, null, null, zap.getZsl().getForpom(),
                                        "Ошибка соответствия записи c справочником V014");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_0600/04000");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_04300)) {
                            if (f003Service.Check(zap.getZsl().getLpu())) {
                                Element pr = getPrElement("T_0600/04300", schet,
                                        zap, null, null, zap.getZsl().getLpu(),
                                        "Ошибка соответствия записи c справочником F003");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_0600/04300");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }

                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_04800)) {
                            if (v009Service.Check(zap.getZsl().getRslt())) {
                                Element pr = getPrElement("T_0600/04800", schet,
                                        zap, null, null, zap.getZsl().getRslt(),
                                        "Ошибка соответствия записи c справочником V009");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_0600/04800");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }

                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_04900)) {
                            if (v012Service.Check(zap.getZsl().getIshod())) {
                                Element pr = getPrElement("T_0600/04900", schet,
                                        zap, null, null, zap.getZsl().getIshod(),
                                        "Ошибка соответствия записи c справочником V012");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_0600/04900");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }

                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_05200)) {
                            if (v010Service.Check(zap.getZsl().getIdsp())) {
                                Element pr = getPrElement("T_0600/05200", schet,
                                        zap, null, null, zap.getZsl().getIdsp(),
                                        "Ошибка соответствия записи c справочником V010");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_0600/05200");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }

                        double sumv = 0.00;
                        if (zap.getZsl().getSl() != null) {
                            for (VMPSl sl : zap.getZsl().getSl()) {
                                sumv = sumv + Double.parseDouble(sl.getSumm());

                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_04102)) {
                                    if (zap.getZsl().getNprmo().isEmpty() && (zap.getZsl().getForpom().equals("3")
                                            && zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2")
                                            || CheckDS1(sl.getDs1()))) {
                                        Element pr = getPrElement("T_0600/04102", schet,
                                                zap, sl, null, zap.getZsl().getNprmo(),
                                                " MPR_MO не может быть пустыи если : 1. плановая медицинской помощи в условиях " +
                                                        "стационара (FOR_POM=3 и USL_OK = 1); 2. в условиях дневного стационара " +
                                                        "(USL_OK =2);3. медицинской помощи при подозрении на злокачественное " +
                                                        "новообразование или установленном диагнозе злокачественного новообразования " +
                                                        "(первый символ кода основного диагноза - «С» или код основного диагноза " +
                                                        "входит в диапазон D00-D09 или D45-D47) при направлении из другой МО");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка T_0600/04102");
                                        resultTestExam = ResultTestExam.Failed;
                                    } else {
                                        if (f003Service.Check(zap.getZsl().getNprmo())) {
                                            Element pr = getPrElement("T_0600/04102", schet,
                                                    zap, sl, null, zap.getZsl().getNprmo(),
                                                    "Ошибка соответствия записи c справочником F003");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соотвествия справочника T_0600/04102");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_04202)) {
                                    if (zap.getZsl().getNprdate().isEmpty() && (zap.getZsl().getForpom().equals("3")
                                            && zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2")
                                            || CheckDS1(sl.getDs1()))) {
                                        Element pr = getPrElement("T_0600/04202", schet,
                                                zap, sl, null, zap.getZsl().getNprdate(),
                                                " NPR_DATE не может быть пустыи если : 1. плановая медицинской помощи в условиях " +
                                                        "стационара (FOR_POM=3 и USL_OK = 1); 2. в условиях дневного стационара " +
                                                        "(USL_OK =2);3. медицинской помощи при подозрении на злокачественное " +
                                                        "новообразование или установленном диагнозе злокачественного новообразования " +
                                                        "(первый символ кода основного диагноза - «С» или код основного диагноза " +
                                                        "входит в диапазон D00-D09 или D45-D47) при направлении из другой МО");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка T_0600/04102");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_05900)) {
                                    if (v018Service.Check(sl.getVidhmp())) {
                                        Element pr = getPrElement("T_0700/05900", schet,
                                                zap, sl, null, sl.getVidhmp(),
                                                "Ошибка соответствия записи c справочником V018");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника T_0700/05900");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_06000)) {
                                    if (v019Service.Check(sl.getVidhmp())) {
                                        Element pr = getPrElement("T_0700/06000", schet,
                                                zap, sl, null, sl.getMetodhmp(),
                                                "Ошибка соответствия записи c справочником V019");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника T_0700/06000");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_06300)) {
                                    if (v002Service.Check(sl.getProfil())) {
                                        Element pr = getPrElement("T_0700/06300", schet,
                                                zap, sl, null, sl.getProfil(),
                                                "Ошибка соответствия записи c справочником V002");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника T_0700/06300");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_06400)) {
                                    if (v020Service.Check(sl.getProfilk())) {
                                        Element pr = getPrElement("T_0700/06400", schet,
                                                zap, sl, null, sl.getProfilk(),
                                                "Ошибка соответствия записи c справочником V020");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника T_0700/06400");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_07602)) {
                                    if (sl.getCzab().isEmpty() && CheckDS1(sl.getDs1())) {
                                        Element pr = getPrElement("T_0700/07602", schet,
                                                zap, sl, null, sl.getCzab(),
                                                "C_ZAB не может быть пустым если " +
                                                        " при установленном диагнозе злокачественного новообразования " +
                                                        "(первый символ кода основного диагноза - «С» или код основного диагноза " +
                                                        "входит в диапазон D00-D09 или D45-D47)");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка T_0700/07602");
                                        resultTestExam = ResultTestExam.Failed;
                                    } else {
                                        if (v027Service.Check(sl.getCzab())) {
                                            Element pr = getPrElement("T_0700/07602", schet,
                                                    zap, sl, null, sl.getCzab(),
                                                    "Ошибка соответствия записи c справочником V027");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соотвествия справочника T_0700/07602");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_08102)) {
                                    if (sl.getCons().isEmpty() && sl.getDsonk().equals("1") && CheckDS1(sl.getDs1())) {
                                        Element pr = getPrElement("T_0700/08102", schet,
                                                zap, sl, null, sl.getProfilk(),
                                                "CONS не может быть пустым если DS_ONK=1 или " +
                                                        " первый символ кода основного диагноза - «С» или код" +
                                                        " основного диагноза входит в диапазон D00-D09 или D45-D47");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка T_0700/08102");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_08202)) {
                                    if (sl.getOnksl() == null && CheckDS1(sl.getDs1())) {
                                        Element pr = getPrElement("T_0700/08102", schet,
                                                zap, sl, null, "",
                                                "ONK_SL не может быть пустым если " +
                                                        " первый символ кода основного диагноза - «С» или код" +
                                                        " основного диагноза входит в диапазон D00-D09 или D45-D47");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка T_0700/08102");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_08301)) {
                                    if (v021Service.Check(sl.getPrvs())) {
                                        Element pr = getPrElement("T_0700/08301", schet,
                                                zap, sl, null, sl.getPrvs(),
                                                "Ошибка соответствия записи c справочником V021");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника T_0700/08301");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_08702)) {
                                    if (sl.getTarif().isEmpty() && CheckDS1(sl.getDs1())) {
                                        Element pr = getPrElement("T_0700/08702", schet,
                                                zap, sl, null, sl.getTarif(),
                                                "TARIF не может быть пустым если " +
                                                        " первый символ кода основного диагноза - «С» или код" +
                                                        " основного диагноза входит в диапазон D00-D09 или D45-D47");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка T_0700/08702");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }

                                if (sl.getUsl() != null) {

                                } else {
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_08902)) {
                                        if (CheckDS1(sl.getDs1())) {
                                            Element pr = getPrElement("T_0700/08902", schet,
                                                    zap, sl, null, "",
                                                    "USL не может быть пустым если " +
                                                            " первый символ кода основного диагноза - «С» или код" +
                                                            " основного диагноза входит в диапазон D00-D09 или D45-D47");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка T_0700/08902");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                }
                                if (sl.getNapr() != null)
                                    for (Napr napr : sl.getNapr()) {
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0800_09200)) {
                                            if (f003Service.Check(napr.getNaprmo())) {
                                                Element pr = getPrElement("T_0800/09200", schet,
                                                        zap, sl, null, napr.getNaprmo(),
                                                        "Ошибка соответствия записи c справочником F003");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соотвествия справочника T_0800/09200");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0800_09300)) {
                                            if (v028Service.Check(napr.getNaprv())) {
                                                Element pr = getPrElement("T_0800/09300", schet,
                                                        zap, sl, null, napr.getNaprv(),
                                                        "Ошибка соответствия записи c справочником V028");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соотвествия справочника T_0800/09300");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0800_09400)) {
                                            if (napr.getNaprv().equals("3") && v029Service.Check(napr.getMetissl())) {
                                                Element pr = getPrElement("T_0800/09400", schet,
                                                        zap, sl, null, napr.getMetissl(),
                                                        "Ошибка соответствия записи c справочником V029");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соотвествия справочника T_0800/09400");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0800_09500)) {
                                            if (!napr.getMetissl().isEmpty() && v001Service.Check(napr.getNaprusl())) {
                                                Element pr = getPrElement("T_0800/09500", schet,
                                                        zap, sl, null, napr.getMetissl(),
                                                        "Ошибка соответствия записи c справочником V001");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соотвествия справочника T_0800/09500");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }

                                if (sl.getCons() != null) {
                                    for (Cons cons : sl.getCons()) {
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0900_09600)) {
                                            if (v019Service.Check(cons.getPrcons())) {
                                                Element pr = getPrElement("T_0900/09600", schet,
                                                        zap, sl, null, cons.getPrcons(),
                                                        "Ошибка соответствия записи c справочником V019");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соотвествия справочника T_0900/09600");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0900_09700)) {
                                            if (cons.getDtcons().isEmpty() && (cons.getPrcons().equals("1")
                                                    || cons.getPrcons().equals("2") || cons.getPrcons().equals("3"))) {
                                                Element pr = getPrElement("T_0900/09700", schet,
                                                        zap, sl, null, cons.getPrcons(),
                                                        "DT_CONS обязательно к заполнению, если консилиум проведен (PR_CONS={1,2,3})");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка T_0900/09700");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }
                                }
                                if (sl.getOnksl() != null) {
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1000_09800)) {
                                        if (n018Service.Check(sl.getOnksl().getDs1t())) {
                                            Element pr = getPrElement("T_1000/09800", schet,
                                                    zap, sl, null, sl.getOnksl().getDs1t(),
                                                    "Ошибка соответствия записи c справочником V018");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соотвествия справочника T_1000/09800");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1000_09900)) {
                                        if (sl.getOnksl().getStad().isEmpty() && (sl.getOnksl().getDs1t().equals("0")
                                                || sl.getOnksl().getDs1t().equals("1") || sl.getOnksl().getDs1t().equals("2"))) {
                                            Element pr = getPrElement("T_1000/09900", schet,
                                                    zap, sl, null, sl.getOnksl().getStad(),
                                                    "STAD обязательно к заполнению при проведении " +
                                                            "противоопухолевого лечения (DS1_T={0,1,2})");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка T_1000/09900");
                                            resultTestExam = ResultTestExam.Failed;
                                        } else {
                                            if (n002Service.Check(sl.getOnksl().getStad())) {
                                                Element pr = getPrElement("T_1000/09900", schet,
                                                        zap, sl, null, sl.getOnksl().getStad(),
                                                        "Ошибка соответствия записи c справочником N002");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соотвествия справочника T_1000/09900");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1000_10000)) {
                                        if (sl.getOnksl().getOnkt().isEmpty() && sl.getOnksl().getDs1t().equals("0")
                                                && GetAge(pers.getDr(), sl.getDate1()) > 18) {
                                            Element pr = getPrElement("T_1000/10000", schet,
                                                    zap, sl, null, sl.getOnksl().getOnkt(),
                                                    "ONK_T обязательно к заполнению при первичном лечении (DS1_T=0) " +
                                                            "для пациентов, возраст которых на дату начала лечения более 18 лет");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка T_1000/10000");
                                            resultTestExam = ResultTestExam.Failed;
                                        } else {
                                            if (n003Service.Check(sl.getOnksl().getOnkt())) {
                                                Element pr = getPrElement("T_1000/10000", schet,
                                                        zap, sl, null, sl.getOnksl().getOnkt(),
                                                        "Ошибка соответствия записи c справочником N003");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соотвествия справочника T_1000/10000");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1000_10100)) {
                                        if (sl.getOnksl().getOnkn().isEmpty() && sl.getOnksl().getDs1t().equals("0")
                                                && GetAge(pers.getDr(), sl.getDate1()) > 18) {
                                            Element pr = getPrElement("T_1000/10100", schet,
                                                    zap, sl, null, sl.getOnksl().getOnkn(),
                                                    "ONK_N обязательно к заполнению при первичном лечении (DS1_T=0) " +
                                                            "для пациентов, возраст которых на дату начала лечения более 18 лет");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка T_1000/10100");
                                            resultTestExam = ResultTestExam.Failed;
                                        } else {
                                            if (n004Service.Check(sl.getOnksl().getOnkn())) {
                                                Element pr = getPrElement("T_1000/10000", schet,
                                                        zap, sl, null, sl.getOnksl().getOnkn(),
                                                        "Ошибка соответствия записи c справочником N004");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соотвествия справочника T_1000/10100");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1000_10200)) {
                                        if (sl.getOnksl().getOnkm().isEmpty() && sl.getOnksl().getDs1t().equals("0")
                                                && GetAge(pers.getDr(), sl.getDate1()) > 18) {
                                            Element pr = getPrElement("T_1000/10200", schet,
                                                    zap, sl, null, sl.getOnksl().getOnkm(),
                                                    "ONK_M обязательно к заполнению при первичном лечении (DS1_T=0) " +
                                                            "для пациентов, возраст которых на дату начала лечения более 18 лет");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка T_1000/10000");
                                            resultTestExam = ResultTestExam.Failed;
                                        } else {
                                            if (n005Service.Check(sl.getOnksl().getOnkm())) {
                                                Element pr = getPrElement("T_1000/10200", schet,
                                                        zap, sl, null, sl.getOnksl().getOnkm(),
                                                        "Ошибка соответствия записи c справочником N005");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соотвествия справочника T_1000/10200");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }
                                    if (sl.getOnksl().getOnkusls() != null) {
                                        for (VMPOnkusl onkusl : sl.getOnksl().getOnkusls()) {
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1000_10400)) {
                                                if (sl.getOnksl().getSod().isEmpty() && (onkusl.getUsltip().equals("3")
                                                        && onkusl.getUsltip().equals("4"))) {
                                                    Element pr = getPrElement("T_1000/10400", schet,
                                                            zap, sl, null, sl.getOnksl().getOnkm(),
                                                            "SOD обязательно для заполнения при проведении лучевой или " +
                                                                    "химиолучевой терапии (USL_TIP=3 или USL_TIP=4)");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка T_1000/10400");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1000_10500)) {
                                                if (sl.getOnksl().getKfr().isEmpty() && (onkusl.getUsltip().equals("3")
                                                        && onkusl.getUsltip().equals("4"))) {
                                                    Element pr = getPrElement("T_1000/10400", schet,
                                                            zap, sl, null, sl.getOnksl().getKfr(),
                                                            "K_FR обязательно для заполнения при проведении лучевой или " +
                                                                    "химиолучевой терапии (USL_TIP=3 или USL_TIP=4)");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка T_1000/10400");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1300_11900)) {
                                                if (n013Service.Check(onkusl.getUsltip())) {
                                                    Element pr = getPrElement("T_1300/11900", schet,
                                                            zap, sl, null, onkusl.getUsltip(),
                                                            "Ошибка соответствия записи c справочником N013");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соотвествия справочника T_1300/11900");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1300_12000)) {
                                                if (!onkusl.getUsltip().equals("1") && !onkusl.getHirtip().isEmpty()) {
                                                    Element pr = getPrElement("T_1300/12000", schet,
                                                            zap, sl, null, onkusl.getHirtip(),
                                                            "HIR_TIP не подлежит заполнению при USL_TIP не равном 1");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка T_1300/12000");
                                                    resultTestExam = ResultTestExam.Failed;
                                                } else {
                                                    if (n014Service.Check(onkusl.getHirtip())) {
                                                        Element pr = getPrElement("T_1300/12000", schet,
                                                                zap, sl, null, onkusl.getHirtip(),
                                                                "Ошибка соответствия записи c справочником N014");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка соотвествия справочника T_1300/12000");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1300_12100)) {
                                                if (!onkusl.getUsltip().equals("2") && !onkusl.getLektipl().isEmpty()) {
                                                    Element pr = getPrElement("T_1300/12100", schet,
                                                            zap, sl, null, onkusl.getLektipl(),
                                                            "LEK_TIP_L не подлежит заполнению при USL_TIP не равном 2");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка T_1300/12100");
                                                    resultTestExam = ResultTestExam.Failed;
                                                } else {
                                                    if (n015Service.Check(onkusl.getLektipl())) {
                                                        Element pr = getPrElement("T_1300/12100", schet,
                                                                zap, sl, null, onkusl.getLektipl(),
                                                                "Ошибка соответствия записи c справочником N015");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка соотвествия справочника T_1300/12100");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1300_12200)) {
                                                if (!onkusl.getUsltip().equals("2") && !onkusl.getLektipv().isEmpty()) {
                                                    Element pr = getPrElement("T_1300/12200", schet,
                                                            zap, sl, null, onkusl.getLektipv(),
                                                            "LEK_TIP_V не подлежит заполнению при USL_TIP не равном 2");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка T_1300/12200");
                                                    resultTestExam = ResultTestExam.Failed;
                                                } else {
                                                    if (n016Service.Check(onkusl.getLektipv())) {
                                                        Element pr = getPrElement("T_1300/12200", schet,
                                                                zap, sl, null, onkusl.getLektipv(),
                                                                "Ошибка соответствия записи c справочником N016");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка соотвествия справочника T_1300/12200");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1300_12500)) {
                                                if (onkusl.getUsltip().equals("3") || onkusl.getUsltip().equals("4")) {
                                                    if (n017Service.Check(onkusl.getLuchtip())) {
                                                        Element pr = getPrElement("T_1300/12500", schet,
                                                                zap, sl, null, onkusl.getLuchtip(),
                                                                "Ошибка соответствия записи c справочником N017");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка соотвествия справочника T_1300/12500");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                } else if (!onkusl.getLuchtip().isEmpty()) {
                                                    Element pr = getPrElement("T_1300/12500", schet,
                                                            zap, sl, null, onkusl.getLuchtip(),
                                                            "LUCH_TIP не подлежит заполнению при USL_TIP не равном 3 или 4");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соотвествия справочника T_1300/12500");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                            if (onkusl.getLekpr() != null) {
                                                for (VMPLekpr lekpr : onkusl.getLekpr()){
                                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1400_12600)) {
                                                        if (n020Service.Check(lekpr.getRegnum())) {
                                                            Element pr = getPrElement("T_1400/12600", schet,
                                                                    zap, sl, null, lekpr.getRegnum(),
                                                                    "Ошибка соответствия записи c справочником N020");
                                                            flk_p.appendChild(pr);
                                                            su.showMessagesEx("Ошибка соотвествия справочника T_1400/12600");
                                                            resultTestExam = ResultTestExam.Failed;
                                                        }
                                                    }
                                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1400_12700)) {
                                                        if (GetAge(pers.getDr(), sl.getDate1()) >= 18){
                                                            if (v024Service.Check(lekpr.getCodesh())) {
                                                                Element pr = getPrElement("T_1400/12700", schet,
                                                                        zap, sl, null, lekpr.getCodesh(),
                                                                        "Ошибка соответствия записи c справочником V024");
                                                                flk_p.appendChild(pr);
                                                                su.showMessagesEx("Ошибка соотвествия справочника T_1400/12700");
                                                                resultTestExam = ResultTestExam.Failed;
                                                            }
                                                        } else {
                                                            if (!lekpr.getCodesh().equals("нет")){
                                                                Element pr = getPrElement("T_1400/12700", schet,
                                                                        zap, sl, null, lekpr.getCodesh(),
                                                                        "CODE_SH должен содержать «нет» при злокачественных " +
                                                                                "новообразованиях у пациентов, возраст " +
                                                                                "которых на дату начала лечения менее " +
                                                                                "18 лет, и злокачественных новообразованиях " +
                                                                                "лимфоидной и кроветворной тканей");
                                                                flk_p.appendChild(pr);
                                                                su.showMessagesEx("Ошибка T_1400/12700");
                                                                resultTestExam = ResultTestExam.Failed;
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                if ((examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1300_12300))
                                                        && (onkusl.getUsltip().equals("2") || onkusl.getUsltip().equals("4"))) {
                                                    Element pr = getPrElement("T_1300/12300", schet,
                                                            zap, sl, null, "",
                                                            "LEK_PR обязательно к заполнению при USL_TIP=2 или USL_TIP=4");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка T_1300/12300");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                        }
                                    }
                                    if (sl.getOnksl().getBdiags() != null) {
                                        for (VMPBdiag bdiag : sl.getOnksl().getBdiags()) {
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1100_11400)) {
                                                if (n007Service.Check(bdiag.getDiagcode()) && bdiag.getDiagtip().equals("1")) {
                                                    Element pr = getPrElement("T_1100/11400", schet,
                                                            zap, sl, null, bdiag.getDiagcode(),
                                                            "Ошибка соответствия записи c справочником N007");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соотвествия справочника T_1100/11400");
                                                    resultTestExam = ResultTestExam.Failed;
                                                } else if (n010Service.Check(bdiag.getDiagcode()) && bdiag.getDiagtip().equals("2")) {
                                                    Element pr = getPrElement("T_1100/11400", schet,
                                                            zap, sl, null, bdiag.getDiagcode(),
                                                            "Ошибка соответствия записи c справочником N010");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соотвествия справочника T_1100/11400");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1100_11500)) {
                                                if (n008Service.Check(bdiag.getDiagrlst()) && bdiag.getDiagtip().equals("1")) {
                                                    Element pr = getPrElement("T_1100/11500", schet,
                                                            zap, sl, null, bdiag.getDiagcode(),
                                                            "Ошибка соответствия записи c справочником N008");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соотвествия справочника T_1100/11500");
                                                    resultTestExam = ResultTestExam.Failed;
                                                } else if (n011Service.Check(bdiag.getDiagcode()) && bdiag.getDiagtip().equals("2")) {
                                                    Element pr = getPrElement("T_1100/11500", schet,
                                                            zap, sl, null, bdiag.getDiagcode(),
                                                            "Ошибка соответствия записи c справочником N011");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соотвествия справочника T_1100/11500");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                        }
                                    }
                                    if (sl.getOnksl().getBprots() != null) {
                                        for (VMPBprot bprot : sl.getOnksl().getBprots()) {
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1200_11700)) {
                                                if (n001Service.Check(bprot.getProt())) {
                                                    Element pr = getPrElement("T_1200/11700", schet,
                                                            zap, sl, null, bprot.getProt(),
                                                            "Ошибка соответствия записи c справочником N001");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соотвествия справочника T_1200/11700");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                        }
                                    }
                                    if (sl.getUsl() != null){
                                        for (VMPUsl usl : sl.getUsl()){
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1500_13000)) {
                                                if (f003Service.Check(usl.getLpu())) {
                                                    Element pr = getPrElement("T_1500/13000", schet,
                                                            zap, sl, usl, usl.getLpu(),
                                                            "Ошибка соответствия записи c справочником F003");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соотвествия справочника T_1500/13000");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1500_13300)) {
                                                if (v002Service.Check(usl.getProfil())) {
                                                    Element pr = getPrElement("T_1500/13300", schet,
                                                            zap, sl, usl, usl.getProfil(),
                                                            "Ошибка соответствия записи c справочником V002");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соотвествия справочника T_1500/13300");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }

                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1500_13403)) {
                                                if (sl.getOnksl().getOnkusls() != null){
                                                    for (VMPOnkusl onkusl : sl.getOnksl().getOnkusls()){
                                                        if ((onkusl.getUsltip().equals("1") || onkusl.getUsltip().equals("3")
                                                                || onkusl.getUsltip().equals("4")) && CheckDS1(sl.getDs1())
                                                                && usl.getVidvme().isEmpty()){
                                                            Element pr = getPrElement("T_1500/13403", schet,
                                                                    zap, sl, usl, usl.getVidvme(),
                                                                    "VID_VME обязательно к заполнению при установленном " +
                                                                            "основном диагнозе злокачественного новообразования " +
                                                                            "(первый символ кода основного диагноза -" +
                                                                            " «С» или код основного диагноза входит в " +
                                                                            "диапазон D00-D09 или D45-D47) в случае " +
                                                                            "проведения хирургического лечения, " +
                                                                            "лучевой или химиолучевой терапии (USL_TIP={1,3,4})");
                                                            flk_p.appendChild(pr);
                                                            su.showMessagesEx("Ошибка T_1500/13403");
                                                            resultTestExam = ResultTestExam.Failed;
                                                        }
                                                    }
                                                } else {
                                                    if (v019Service.Check(usl.getVidvme())) {
                                                        Element pr = getPrElement("T_1500/13403", schet,
                                                                zap, sl, usl, usl.getVidvme(),
                                                                "Ошибка соответствия записи c справочником V019");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка соотвествия справочника T_1500/13403");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    }
                                                }
                                            }
                                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1500_14301)) {
                                                if (v021Service.Check(usl.getPrvs())) {
                                                    Element pr = getPrElement("T_1500/14301", schet,
                                                            zap, sl, usl, usl.getPrvs(),
                                                            "Ошибка соответствия записи c справочником V021");
                                                    flk_p.appendChild(pr);
                                                    su.showMessagesEx("Ошибка соотвествия справочника T_1500/14301");
                                                    resultTestExam = ResultTestExam.Failed;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (zap.getZsl().getSanks() != null){
                            for (Sank sank : zap.getZsl().getSanks()){
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1600_14800)) {
                                    if (f006Service.Check(sank.getStip())) {
                                        Element pr = getPrElement("T_1500/14301", schet,
                                                zap, null, null, sank.getStip(),
                                                "Ошибка соответствия записи c справочником F006");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника T_1500/14301");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1600_14900)) {
                                    if (Double.parseDouble(sank.getSsum()) > 0 && sank.getSlid().isEmpty()) {
                                        Element pr = getPrElement("T_1600/14900", schet,
                                                zap, null, null, sank.getStip(),
                                                "SL_ID обязательно к заполнению, если S_SUM не равна 0");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника T_1600/14900");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1600_15000)) {
                                    if (Double.parseDouble(sank.getSsum()) > 0 && sank.getSosn().isEmpty()) {
                                        Element pr = getPrElement("T_1600/15000", schet,
                                                zap, null, null, sank.getStip(),
                                                "S_OSN обязательно к заполнению, если S_SUM не равна 0");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка T_1600/15000");
                                        resultTestExam = ResultTestExam.Failed;
                                    } else {
                                        if (f014Service.Check(sank.getSosn())) {
                                            Element pr = getPrElement("T_1600/15000", schet,
                                                    zap, null, null, sank.getSosn(),
                                                    "Ошибка соответствия записи c справочником F014");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соотвествия справочника T_1600/15000");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1600_15300)) {
                                    if (Integer.parseInt(sank.getStip()) >= 30 && sank.getCodeexp() == null){
                                        Element pr = getPrElement("T_1600/15300", schet,
                                                zap, null, null, "", "CODE_EXP обязательно к заполнению " +
                                                        "для экспертиз качества медицинской помощи (S_TIP>=30)");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника T_1600/15300");
                                        resultTestExam = ResultTestExam.Failed;
                                    } else {
                                        for (String codeexp : sank.getCodeexp()) {
                                            if (f004Service.Check(codeexp)) {
                                                Element pr = getPrElement("T_1600/15300", schet,
                                                        zap, null, null, codeexp,
                                                        "Ошибка соответствия записи c справочником F004");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соотвествия справочника T_1600/15300");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_05300)) {
                            if (Double.parseDouble(zap.getZsl().getSumv()) != sumv || zap.getZsl().getSumv().isEmpty()
                                    || Double.parseDouble(zap.getZsl().getSumv()) == 0) {
                                Element pr = getPrElement("T_0600/05300", schet,
                                        zap, null, null, zap.getZsl().getSumv(),
                                        "SUM_V не равно сумме значений SUM_M вложенных элементов SL");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка T_0600/05300");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }
                    }
                }
            }
        }
        Document doc = new Document(flk_p);
        PrintWriter out = new PrintWriter("C:\\V" + zglv.getFilename() + ".xml");
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

    private boolean CheckDS1(String ds1) {
        if (ds1.contains("C") || ds1.contains("D45") || ds1.contains("D46") || ds1.contains("D47")){
            return false;
        }
        for (int i = 0; i < 10; i++){
            if (ds1.contains("D0" + i)){
                return false;
            }
        }

        return true;
    }

    private Element getPrElement(String oshib, Schet schet, VMPZap zap, VMPSl sl,
                                 VMPUsl usl, String znPol, String comment) {
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
        if (zap == null) {
            elIdpac.appendChild("");
        } else {
            elIdpac.appendChild(zap.getPacient().getIdpac());
        }
        pr.appendChild(elIdpac);

        Element elComment = new Element("COMMENT");
        elComment.appendChild(comment);
        pr.appendChild(elComment);
        return pr;
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
}
