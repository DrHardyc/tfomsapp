package ru.tfoms.tfomsapp.service.Examination.MEK;

import nu.xom.Document;
import nu.xom.Element;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.Exam.ExamParam;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKSl;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKUsl;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKZap;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKZsl;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPers;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPerslist;
import ru.tfoms.tfomsapp.domain.MEK.Schet;
import ru.tfoms.tfomsapp.domain.MEK.Zglv;
import ru.tfoms.tfomsapp.service.HandBook.*;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class ONKExam {
    private final F002Service f002Service = new F002Service();
    private final F003Service f003Service = new F003Service();
    private final F004Service f004Service = new F004Service();
    private final F006Service f006Service = new F006Service();
    private final F008Service f008Service = new F008Service();
    private final F014Service f014Service = new F014Service();
    private final V001Service v001Service = new V001Service();
    private final V002Service v002Service = new V002Service();
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
    private final V032Service v032Service = new V032Service();
    private final V036Service v036Service = new V036Service();
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
                if (pers.getOnkZap() != null) {
                    for (ONKZap zap : pers.getOnkZap()) {
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
                                            "NPRO_MO Заполнение обязательно в случаях оказания: " +
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
}
