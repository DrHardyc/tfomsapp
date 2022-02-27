package ru.tfoms.tfomsapp.service.examination.flk;

import nu.xom.Document;
import nu.xom.Element;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.examination.ExamParam;
import ru.tfoms.tfomsapp.domain.file.mp.*;
import ru.tfoms.tfomsapp.domain.file.*;
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
public class MPExam {
    private final F002Service f002Service = new F002Service();
    private final F003Service f003Service = new F003Service();
    private final F004Service f004Service = new F004Service();
    private final F006Service f006Service = new F006Service();
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

        if (schet != null) {
            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0300_00900)) {
                if (f003Service.Check(schet.getCodemo())) {
                    Element pr = getPrElement("H_0300/00900", schet,
                            null, null, null, schet.getCodemo(),
                            "Ошибка соответствия записи c справочником F003");
                    flk_p.appendChild(pr);
                    su.showMessagesEx("Ошибка соответствия записи в справочнике H_0300/00900");
                    resultTestExam = ResultTestExam.Failed;
                }
            }
            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0300_01400)) {
                if (f002Service.Check(schet.getPlat()) && !schet.getPlat().isEmpty()) {
                    Element pr = getPrElement("H_0300/01400", schet,
                            null, null, null, schet.getPlat(),
                            "Ошибка соответствия записи c справочником F002");
                    flk_p.appendChild(pr);
                    su.showMessagesEx("Ошибка соответствия записи в справочнике H_0300/01400");
                    resultTestExam = ResultTestExam.Failed;
                }
            }
        }
        if (persList != null) {
            for (PDPers pers : persList.getPers()) {
                if (pers != null) {
                    //============================
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
                    //=============================
                    if (pers.getMpZap() != null) {
                        for (MPZap zap : pers.getMpZap()) {
                            //==========================================================================
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
                            //=========================================================================
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0500_02600)) {
                                if (f011Service.Check(zap.getPacient().getVpolis())) {
                                    Element pr = getPrElement("L_0300/02200", schet,
                                            zap, null, null, zap.getPacient().getVpolis(),
                                            "Ошибка соответствия записи c справочником F011");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника L_0300/02200");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0500_03000)) {
                                if (f002Service.Check(zap.getPacient().getSmo())) {
                                    Element pr = getPrElement("H_0500/03000", schet,
                                            zap, null, null, zap.getPacient().getSmo(),
                                            "Ошибка соответствия записи c справочником F002");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника H_0500/03000");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0500_03101)) {
                                if (zap.getPacient().getEnp().isEmpty() && zap.getPacient().getVpolis().equals("3")) {
                                    Element pr = getPrElement("H_0500/03101", schet,
                                            zap, null, null, zap.getPacient().getEnp(),
                                            "Поле ENP не может быть пустым если VPOLIS = 3");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка H_0500/03101");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0500_02801)) {
                                if (!zap.getPacient().getVpolis().equals("3") && zap.getPacient().getNpolis().isEmpty()) {
                                    Element pr = getPrElement("H_0500/02801", schet,
                                            zap, null, null, zap.getPacient().getEnp(),
                                            "Поле NPOLIS не может быть пустым если VPOLIS = 3");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошиюка H_0500/02801");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_03900)) {
                                if (v006Service.Check(zap.getZsl().getUslok())) {
                                    Element pr = getPrElement("H_0600/03900", schet,
                                            zap, null, null, zap.getZsl().getUslok(),
                                            "Ошибка соответствия записи c справочником V006");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника H_0600/03900");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_04000)) {
                                if (v008Service.Check(zap.getZsl().getVidpom())) {
                                    Element pr = getPrElement("H_0600/04000", schet,
                                            zap, null, null, zap.getZsl().getVidpom(),
                                            "Ошибка соответствия записи c справочником V008");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника H_0600/04000");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_04100)) {
                                if (v014Service.Check(zap.getZsl().getForpom())) {
                                    Element pr = getPrElement("H_0600/04100", schet,
                                            zap, null, null, zap.getZsl().getForpom(),
                                            "Ошибка соответствия записи c справочником V014");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника H_0600/04100");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_04200)) {
                                if (zap.getZsl().getNprmo().isEmpty()
                                        && ((zap.getZsl().getForpom().equals("3")
                                        && zap.getZsl().getUslok().equals("1")) || zap.getZsl().getUslok().equals("2"))) {
                                    Element pr = getPrElement("H_0600/04200", schet,
                                            zap, null, null, zap.getZsl().getNprmo(),
                                            "NPR_MO не может быть пустым если (USL_OK = 1 или USK_OK = 2) и FOR_POM = 3");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка H_0600/04200");
                                    resultTestExam = ResultTestExam.Failed;
                                } else {
                                    if (f003Service.Check(zap.getZsl().getNprmo())) {
                                        Element pr = getPrElement("H_0600/04200", schet,
                                                zap, null, null, zap.getZsl().getNprmo(),
                                                "Ошибка соответствия записи c справочником F003");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника H_0600/04200");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_04300)) {
                                if (zap.getZsl().getNprdate().isEmpty()
                                        && ((zap.getZsl().getForpom().equals("3")
                                        && zap.getZsl().getUslok().equals("1")) || zap.getZsl().getUslok().equals("2"))) {
                                    Element pr = getPrElement("H_0600/04300", schet,
                                            zap, null, null, zap.getZsl().getNprdate(),
                                            "NPR_DATE не может быть пустым если (USL_OK = 1 или USK_OK = 2) и FOR_POM = 3");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка H_0600/04300");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_04400)) {
                                if (f003Service.Check(zap.getZsl().getLpu())) {
                                    Element pr = getPrElement("H_0600/04400", schet,
                                            zap, null, null, zap.getZsl().getLpu(),
                                            "Ошибка соответствия записи c справочником F003");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника H_0600/04400");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_04900)) {
                                if (v009Service.Check(zap.getZsl().getRslt())) {
                                    Element pr = getPrElement("H_0600/04900", schet,
                                            zap, null, null, zap.getZsl().getRslt(),
                                            "Ошибка соответствия записи c справочником V009");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника H_0600/04900");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_05000)) {
                                if (v012Service.Check(zap.getZsl().getIshod())) {
                                    Element pr = getPrElement("H_0600/05000", schet,
                                            zap, null, null, zap.getZsl().getIshod(),
                                            "Ошибка соответствия записи c справочником V012");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника H_0600/05000");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_05400)) {
                                if (v010Service.Check(zap.getZsl().getIdsp())) {
                                    Element pr = getPrElement("H_0600/05400", schet,
                                            zap, null, null, zap.getZsl().getIdsp(),
                                            "Ошибка соответствия записи c справочником V010");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника H_0600/05400");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }

                            double sumv = 0.00;
                            for (MPSl sl : zap.getZsl().getSl()) {
                                sumv = sumv + Double.parseDouble(sl.getSumm());

                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_06300)) {
                                    if (v002Service.Check(sl.getProfil())) {
                                        Element pr = getPrElement("H_0700/06300", schet,
                                                zap, sl, null, sl.getProfil(),
                                                "Ошибка соответствия записи c справочником V002");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника H_0700/06300");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_06400)) {
                                    if (sl.getProfilk().isEmpty()
                                            && (zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2"))) {
                                        Element pr = getPrElement("H_0700/06400", schet,
                                                zap, sl, null, sl.getProfilk(),
                                                "PROFIL_K не может быть пустым если USL_OK = 1 или USK_OK = 2");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника H_0700/06400");
                                        resultTestExam = ResultTestExam.Failed;
                                    } else {
                                        if (v020Service.Check(sl.getProfilk())) {
                                            Element pr = getPrElement("H_0700/06300", schet,
                                                    zap, sl, null, sl.getProfilk(),
                                                    "Ошибка соответствия записи c справочником V020");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соотвествия справочника H_0700/06400");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_06600)) {
                                    if (sl.getPcel().isEmpty() && zap.getZsl().getUslok().equals("3")) {
                                        Element pr = getPrElement("H_0700/06600", schet,
                                                zap, sl, null, sl.getPcel(),
                                                "P_CEL не может быть пустым если USL_OK = 3");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка H_0700/06600");
                                        resultTestExam = ResultTestExam.Failed;
                                    } else {
                                        if (v025Service.Check(sl.getPcel())) {
                                            Element pr = getPrElement("H_0700/06600", schet,
                                                    zap, sl, null, sl.getPcel(),
                                                    "Ошибка соответствия записи c справочником V025");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соотвествия справочника H_0700/06600");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_06800)) {
                                    if (sl.getNhistory().isEmpty()
                                            && (zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2"))) {
                                        Element pr = getPrElement("H_0700/06800", schet,
                                                zap, sl, null, sl.getNhistory(),
                                                "P_CEL не может быть пустым если USL_OK = 1 или USL_OK = 2");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка H_0700/06800");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_07100)) {
                                    if (sl.getKd().isEmpty()
                                            && (zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2"))) {
                                        Element pr = getPrElement("H_0700/07100", schet,
                                                zap, sl, null, sl.getKd(),
                                                "P_CEL не может быть пустым если USL_OK = 1 или USL_OK = 2");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка H_0700/07100");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_07302)) {
                                    for (int iDs1 = 0; iDs1 < 10; iDs1++) {
                                        if (sl.getDs1().contains("D0" + iDs1) || sl.getDs1().contains("D45")
                                                || sl.getDs1().contains("D46") || sl.getDs1().contains("D47")
                                                || sl.getDs1().contains("C")) {
                                            Element pr = getPrElement("H_0700/07302", schet,
                                                    zap, sl, null, sl.getDs1(),
                                                    "Не допускаются следующие значения:1. первый символ кода основного диагноза «С»;2. код основного диагноза входит в диапазон D00-D09 или D45-D47");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка H_0700/07302");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_07601)) {
                                    if (sl.getCzab().isEmpty()
                                            && sl.getDs1().contains("Z")
                                            && (sl.getDs1().equals("D11.0") || sl.getDs1().equals("D11.9"))) {
                                        Element pr = getPrElement("H_0700/07601", schet,
                                                zap, sl, null, sl.getDs1(),
                                                "C_ZAB не может быть пустым, если основной диагноз (DS1) не входит в рубрику Z и не соответствует кодам диагноза U11 и U11.9");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка H_0700/07601");
                                        resultTestExam = ResultTestExam.Failed;
                                    } else {
                                        if (v027Service.Check(sl.getCzab())) {
                                            Element pr = getPrElement("H_0700/07601", schet,
                                                    zap, sl, null, sl.getCzab(),
                                                    "Ошибка соответствия записи c справочником V027");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соотвествия справочника H_0700/07601");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_07700)) {
                                    if (sl.getPcel().equals("1.3") && sl.getDn().isEmpty()) {
                                        Element pr = getPrElement("H_0700/07700", schet,
                                                zap, sl, null, sl.getDs1(),
                                                "P_CEL не может быть пустым, если P_CEL=1.3");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка H_0700/07700");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_08201)) {
                                    if (v021Service.Check(sl.getPrvs())) {
                                        Element pr = getPrElement("H_0700/08201", schet,
                                                zap, sl, null, sl.getPrvs(),
                                                "Ошибка соответствия записи c справочником V021");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника H_0700/08201");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (sl.getKsgkpg() != null) {
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0800_09300)
                                            || examParam.equals(ExamParam.H_0800_09000)) {
                                        if ((!sl.getKsgkpg().getNksg().isEmpty() && !sl.getKsgkpg().getNkpg().isEmpty())
                                                || (sl.getKsgkpg().getNksg().isEmpty() && sl.getKsgkpg().getNkpg().isEmpty())) {
                                            Element pr = getPrElement("H_0800/09300 | H_0800/09000", schet,
                                                    zap, sl, null, sl.getKsgkpg().getNksg(),
                                                    "N_KSG и N_KPG не могут быть одновременно пустыми или заполненными");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка H_0800/09000 или H_0800/09300");
                                            resultTestExam = ResultTestExam.Failed;
                                        } else if (!sl.getKsgkpg().getNkpg().isEmpty()
                                                && v026Service.Check(sl.getKsgkpg().getNkpg())) {
                                            Element pr = getPrElement("H_0800/09300", schet,
                                                    zap, sl, null, sl.getKsgkpg().getNkpg(),
                                                    "Ошибка соответствия записи c справочником V026");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соотвествия справочника H_0800/09300");
                                            resultTestExam = ResultTestExam.Failed;
                                        }

                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0800_09900)) {
                                        if (sl.getKsgkpg().getCrit().size() != 0) {
                                            if (v024Service.Check(sl.getKsgkpg().getCrit())) {
                                                for (String crit : sl.getKsgkpg().getCrit()) {
                                                    Element pr = getPrElement("H_0800/09900", schet,
                                                            zap, sl, null, crit,
                                                            "Ошибка соответствия записи c справочником V024");
                                                    flk_p.appendChild(pr);
                                                }
                                                su.showMessagesEx("Ошибка соотвествия справочника H_0800/09900");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1100_13300)) {
                                        if (sl.getWei().isEmpty() && (sl.getDs1().equals("U07.1") || sl.getDs1().equals("U07.2"))
                                                && Integer.parseInt(sl.getReab()) != 1
                                                && CheckCrit(sl.getKsgkpg().getCrit(), "STT5")
                                                && zap.getZsl().getUslok().equals("1")
                                                && CheckDS2(sl.getDs2())
                                                && GetAge(pers.getDr(), sl.getDate1()) >= 18) {
                                            Element pr = getPrElement("H_1100/13300", schet,
                                                    zap, sl, null, sl.getWei(),
                                                    "WEI не может быть пустым, " +
                                                            "если в DS1 указано значение заболевания " +
                                                            "(U07.1 или U07.2) и REAB <> 1 и CRIT <> STT5 и USL_OK = 1 и DS2 <> IN (O00-O99, Z34-Z35) " +
                                                            "и возраст пациента на дату начала лечения больше или равно 18 лет");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка H_1100/13300");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0800_10200)) {
                                        if (sl.getKsgkpg().getSlkoef() != null) {
                                            if (sl.getKsgkpg().getSlkoef().isEmpty() && !sl.getKsgkpg().getItsl().isEmpty()) {
                                                for (Slkoef slkoef : sl.getKsgkpg().getSlkoef()) {
                                                    Element pr = getPrElement("H_0800/10200", schet,
                                                            zap, sl, null, slkoef.getIdsl(),
                                                            "SL_KOEF обязательно к заполнению при наличии IT_SL");
                                                    flk_p.appendChild(pr);
                                                }
                                                su.showMessagesEx("Ошибка H_0800/10200");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1100_13400)
                                            || examParam.equals(ExamParam.H_1100_13600)) {
                                        if ((sl.getLekpr() == null || sl.getLekpr().isEmpty()) && (sl.getDs1().equals("U07.1") || sl.getDs1().equals("U07.2"))
                                                && Integer.parseInt(sl.getReab()) != 1
                                                && CheckCrit(sl.getKsgkpg().getCrit(), "STT5")
                                                && zap.getZsl().getUslok().equals("1")
                                                && CheckDS2(sl.getDs2())
                                                && GetAge(pers.getDr(), sl.getDate1()) >= 18) {
                                            Element pr = getPrElement("H_1100/13400", schet,
                                                    zap, sl, null, "",
                                                    "LEK_PR не может быть пустым, " +
                                                            "если в DS1 указано значение заболевания " +
                                                            "(U07.1 или U07.2) и REAB <> 1 и CRIT <> STT5 и USL_OK = 1 и DS2 <> IN (O00-O99, Z34-Z35) " +
                                                            "и возраст пациента на дату начала лечения больше или равно 18 лет");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка H_1100/13400");
                                            resultTestExam = ResultTestExam.Failed;
                                        } else {
                                            for (MPLekpr lekpr : sl.getLekpr()) {
                                                for (String crit : sl.getKsgkpg().getCrit()) {
                                                    if (lekpr.getCodesh().isEmpty()
                                                            && (sl.getDs1().equals("V07.1") || sl.getDs1().equals("V07.2"))
                                                            && Integer.parseInt(sl.getReab()) != 0
                                                            && !crit.equals("STT5")
                                                            && zap.getZsl().getUslok().equals("0")
                                                            && DS2CheckInH_1100_13600(sl.getDs2())) {
                                                        Element pr = getPrElement("H_1100/13600", schet,
                                                                zap, sl, null, lekpr.getCodesh(),
                                                                "CODE_SH не может быть пустым, если в DS1 " +
                                                                        "указано значение заболевания (U07.1 или U07.2) и REAB <> 1 " +
                                                                        "и CRIT <> STT5 и USL_OK = 1 и DS2 <> IN (O00-O99, Z34-Z35) " +
                                                                        "и возраст пациента на дату начала лечения больше или равно 18 лет.");
                                                        flk_p.appendChild(pr);
                                                        su.showMessagesEx("Ошибка H_1100/13600");
                                                        resultTestExam = ResultTestExam.Failed;
                                                    } else {
                                                        if (v032Service.Check(lekpr.getCodesh())) {
                                                            su.showMessagesEx("Ошибка соотвествия справочника H_1100/13600");
                                                            resultTestExam = ResultTestExam.Failed;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }


                                for (MPUsl usl : sl.getUsl()) {
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1000_10600)) {
                                        if (f003Service.Check(usl.getLpu())) {
                                            Element pr = getPrElement("H_1000/10600", schet,
                                                    zap, sl, usl, usl.getLpu(),
                                                    "Ошибка соответствия записи c справочником F003");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соотвествия справочника H_1000/10600");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1000_10900)) {
                                        if (v002Service.Check(usl.getProfil())) {
                                            Element pr = getPrElement("H_1000/10900", schet,
                                                    zap, sl, usl, usl.getProfil(),
                                                    "Ошибка соответствия записи c справочником V002");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соотвествия справочника H_1000/10900");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1000_11000)) {
                                        if (v001Service.Check(usl.getVidvme())) {
                                            Element pr = getPrElement("H_1000/11000", schet,
                                                    zap, sl, usl, usl.getVidvme(),
                                                    "Ошибка соответствия записи c справочником V001");
                                            flk_p.appendChild(pr);
                                            su.showMessagesEx("Ошибка соотвествия справочника H_1000/11000");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                    for (Mrusln mrusln : usl.getMruslns()) {
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1000_11904)) {
                                            if (v021Service.Check(mrusln.getPrvs())) {
                                                Element pr = getPrElement("H_1000/11904", schet,
                                                        zap, sl, usl, mrusln.getPrvs(),
                                                        "Ошибка соответствия записи c справочником V021");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соотвествия справочника H_1000/11904");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }
                                    for (MPMeddev meddev : usl.getMeddev()) {
                                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1100_14400)) {
                                            if (v036Service.Check(meddev)) {
                                                Element pr = getPrElement("H_1100/14400", schet,
                                                        zap, sl, usl, meddev.getCodemeddev(),
                                                        "Ошибка соответствия записи c справочником V036");
                                                flk_p.appendChild(pr);
                                                su.showMessagesEx("Ошибка соотвествия справочника H_1100/14400");
                                                resultTestExam = ResultTestExam.Failed;
                                            }
                                        }
                                    }
                                }
                            }
                            for (Sank sank : zap.getZsl().getSank()) {
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1100_12500)) {
                                    if (f006Service.Check(sank.getStip())) {
                                        Element pr = getPrElement("H_1100/12500", schet,
                                                zap, null, null, sank.getStip(),
                                                "Ошибка соответствия записи c справочником F006");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка H_1100/12500");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1100_12600)) {
                                    if (!sank.getSsum().equals("0") && sank.getSlid().isEmpty()) {
                                        for (String slid : sank.getSlid()) {
                                            Element pr = getPrElement("H_1100/12600", schet,
                                                    zap, null, null, slid,
                                                    "SL_ID не может быть пустым если S_SUM=0");
                                            flk_p.appendChild(pr);
                                        }
                                        su.showMessagesEx("Ошибка H_1100/12600");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1100_12700)) {
                                    if (f014Service.Check(sank.getSosn())) {
                                        Element pr = getPrElement("H_1100/12700", schet,
                                                zap, null, null, sank.getSosn(),
                                                "Ошибка соответствия записи c справочником F014");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка H_1100/12700");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1100_13000)) {
                                    if ((Integer.parseInt(sank.getStip()) >= 30) && sank.getCodeexp().isEmpty()) {
                                        Element pr = getPrElement("H_1100/12600", schet,
                                                zap, null, null, "",
                                                "CODE_EXP не может быть пустым если S_TIP больше или равно 30");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка H_1100/13000");
                                        resultTestExam = ResultTestExam.Failed;
                                    } else {
                                        for (String codeexp : sank.getCodeexp()) {
                                            if (f004Service.Check(codeexp)) {
                                                Element pr = getPrElement("H_1100/13000", schet,
                                                        zap, null, null, codeexp,
                                                        "Ошибка соответствия записи c справочником F004");
                                                flk_p.appendChild(pr);
                                            }
                                            su.showMessagesEx("Ошибка H_1100/13000");
                                            resultTestExam = ResultTestExam.Failed;
                                        }
                                    }
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_05500)) {
                                if (Double.parseDouble(zap.getZsl().getSumv()) != sumv) {
                                    Element pr = getPrElement("H_0600/05500", schet,
                                            zap, null, null, zap.getZsl().getSumv(),
                                            "SUM_V не равно сумме значений SUM_M вложенных элементов SL |  ук сум :"
                                                    + zap.getZsl().getSumv() + " | слож сумма: " + sumv);
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка H_0600/05500");
                                    resultTestExam = ResultTestExam.Failed;
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

    private Element getPrElement(String oshib, Schet schet, MPZap zap, MPSl sl,
                                 MPUsl usl, String znPol, String comment) {
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

    private int GetAge(String dr, String date1) {
        LocalDate dateDr = LocalDate.parse(dr);
        LocalDate dateDate1 = LocalDate.parse(date1);
        long age = ChronoUnit.YEARS.between(dateDr, dateDate1);
        return (int) age;
    }

    private boolean CheckDS2(List<String> ds2s) {
        if (ds2s == null || ds2s.size() == 0) return false;
        for (String ds2 : ds2s) {
            for (int iDs2 = 0; iDs2 < 100; iDs2++) {
                if (iDs2 < 10) {
                    if (ds2.equals("O0" + iDs2)) {
                        return false;
                    }
                } else {
                    if (ds2.equals("O" + iDs2)) {
                        return false;
                    }
                }
            }
            if (ds2.equals("Z34") || ds2.equals("Z35")) {
                return false;
            }
        }
        return true;
    }

    private boolean CheckCrit(List<String> crits, String stt5) {
        for (String crit : crits) {
            if (crit.equals(stt5)) {
                return false;
            }
        }
        return true;
    }

    private boolean DS2CheckInH_1100_13600(List<String> ds2s) {
        for (String ds2 : ds2s) {
            for (int iDs2 = 0; iDs2 < 100; iDs2++) {
                if (ds2.equals("O0" + iDs2)) {
                    return false;
                }
                if (ds2.equals("Z34") || (ds2.equals("Z35"))) {
                    return false;
                }
            }
        }
        return true;
    }

}


