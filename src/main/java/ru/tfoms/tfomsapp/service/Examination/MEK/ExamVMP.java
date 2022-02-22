package ru.tfoms.tfomsapp.service.Examination.MEK;

import nu.xom.Document;
import nu.xom.Element;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.Exam.ExamParam;
import ru.tfoms.tfomsapp.domain.HandBook.*;
import ru.tfoms.tfomsapp.domain.MEK.Cons;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPSl;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPUsl;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPZap;
import ru.tfoms.tfomsapp.domain.MEK.Napr;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKOnksl;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPers;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPerslist;
import ru.tfoms.tfomsapp.domain.MEK.Schet;
import ru.tfoms.tfomsapp.domain.MEK.VMP.*;
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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ExamVMP {

    private final F002Service f002Service = new F002Service();
    private final F003Service f003Service = new F003Service();
    private final F004Service f004Service = new F004Service();
    private final F006Service f006Service = new F006Service();
    private final F008Service f008Service = new F008Service();
    private final F014Service f014Service = new F014Service();
    private final N018Service n018Service = new N018Service();
    private final N002Service n002Service = new N002Service();
    private final N003Service n003Service = new N003Service();
    private final N004Service n004Service = new N004Service();
    private final N005Service n005Service = new N005Service();
    private final N007Service n007Service = new N007Service();
    private final N008Service n008Service = new N008Service();
    private final N010Service n010Service = new N010Service();
    private final N011Service n011Service = new N011Service();
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
    private final V025Service v025Service = new V025Service();
    private final V026Service v026Service = new V026Service();
    private final V027Service v027Service = new V027Service();
    private final V028Service v028Service = new V028Service();
    private final V029Service v029Service = new V029Service();
    private final V032Service v032Service = new V032Service();
    private final V036Service v036Service = new V036Service();
    private final ServiceUtil su = new ServiceUtil();

    public ResultTestExam exam(PDPerslist persList, Zglv zglv, Schet schet, ExamParam examParam) throws IOException {
        ResultTestExam resultTestExam = ResultTestExam.Success;
        List<F002> f002s = f002Service.getF002s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F002"));
        List<F003> f003s = f003Service.getF003s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F003"));
        List<F004> f004s = f004Service.getF004s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F004"));
        List<F006> f006s = f006Service.getF006s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F006"));
        List<F008> f008s = f008Service.getF008s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F008"));
        List<F014> f014s = f014Service.getF014s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F014"));
        List<N018> n018s = n018Service.getN018s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N018"));
        List<N002> n002s = n002Service.getN002s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N002"));
        List<N003> n003s = n003Service.getN003s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N003"));
        List<N004> n004s = n004Service.getN004s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N004"));
        List<N005> n005s = n005Service.getN005s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N005"));
        List<N007> n007s = n007Service.getN007s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N007"));
        List<N008> n008s = n008Service.getN008s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N008"));
        List<N010> n010s = n010Service.getN010s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N010"));
        List<N011> n011s = n011Service.getN011s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N011"));
        List<V001> v001s = v001Service.getV001s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V001"));
        List<V002> v002s = v002Service.getV002s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V002"));
        List<V006> v006s = v006Service.getV006s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V006"));
        List<V008> v008s = v008Service.getV008s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V008"));
        List<V009> v009s = v009Service.getV009s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V009"));
        List<V010> v010s = v010Service.getV010s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V010"));
        List<V012> v012s = v012Service.getV012s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V012"));
        List<V014> v014s = v014Service.getV014s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V014"));
        List<V018> v018s = v018Service.getV018s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V018"));
        List<V019> v019s = v019Service.getV019s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V019"));
        List<V020> v020s = v020Service.getV020s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V020"));
        List<V021> v021s = v021Service.getV021s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V021"));
        List<V024> v024s = v024Service.getV024s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V024"));
        List<V025> v025s = v025Service.getV025s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V025"));
        List<V026> v026s = v026Service.getV026s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V026"));
        List<V027> v027s = v027Service.getV027s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V027"));
        List<V028> v028s = v028Service.getV028s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V028"));
        List<V029> v029s = v029Service.getV029s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V029"));
        List<V032> v032s = v032Service.getV032s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V032"));
        List<V036> v036s = v036Service.getV036s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V036"));

        Element flk_p = new Element("FLK_P");
        Element fname = new Element("FNAME");
        fname.appendChild("V" + zglv.getFilename() );
        flk_p.appendChild(fname);
        Element fname_i = new Element("FNAME_I");
        fname_i.appendChild(zglv.getFilename());
        flk_p.appendChild(fname_i);

        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0300_00900)){
            if (f003Service.CheckF003(f003s, schet.getCodemo())){
                Element pr = getPrElement("T_0300/00900", schet,
                        null, null, null, schet.getCodemo(),
                        "Ошибка соответствия записи c справочником F003");
                flk_p.appendChild(pr);
                su.showMessagesEx("Ошибка соответствия записи в справочнике T_0300/00900");
                resultTestExam = ResultTestExam.Failed;
            }
        }
        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0300_01400)){
            if (f002Service.CheckF002(f002s, schet.getPlat()) && !schet.getPlat().isEmpty()){
                Element pr = getPrElement("T_0300/01400", schet,
                        null, null, null, schet.getPlat(),
                        "Ошибка соответствия записи c справочником F002");
                flk_p.appendChild(pr);
                su.showMessagesEx("Ошибка соответствия записи в справочнике T_0300/01400");
                resultTestExam = ResultTestExam.Failed;
            }
        }

        for (PDPers pers : persList.getPers()){

            for (VMPZap zap : pers.getVmpZap()){
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0500_02600)){
                    if (f008Service.CheckF008(f008s, zap.getPacient().getVpolis()) ){
                        Element pr = getPrElement("T_0500/02600", schet,
                                zap, null, null, zap.getPacient().getVpolis(),
                                "Ошибка соответствия записи c справочником F008");
                        flk_p.appendChild(pr);
                        su.showMessagesEx("Ошибка соотвествия справочника T_0500/02600");
                        resultTestExam = ResultTestExam.Failed;
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0500_03000)){
                    if (f002Service.CheckF002(f002s, zap.getPacient().getSmo())){
                        Element pr = getPrElement("T_0500/03000", schet,
                                zap, null, null, zap.getPacient().getSmo(),
                                "Ошибка соответствия записи c справочником F002");
                        flk_p.appendChild(pr);
                        su.showMessagesEx("Ошибка соотвествия справочника T_0500/03000");
                        resultTestExam = ResultTestExam.Failed;
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_03800)){
                    if (v006Service.CheckV006(v006s, zap.getZsl().getUslok())){
                        Element pr = getPrElement("T_0600/03800", schet,
                                zap, null, null, zap.getZsl().getUslok(),
                                "Ошибка соответствия записи c справочником V006");
                        flk_p.appendChild(pr);
                        su.showMessagesEx("Ошибка соотвествия справочника T_0600/03800");
                        resultTestExam = ResultTestExam.Failed;
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_03900)){
                    if (v008Service.CheckV008(v008s, zap.getZsl().getVidpom())){
                        Element pr = getPrElement("T_0600/03900", schet,
                                zap, null, null, zap.getZsl().getVidpom(),
                                "Ошибка соответствия записи c справочником V006");
                        flk_p.appendChild(pr);
                        su.showMessagesEx("Ошибка соотвествия справочника T_0600/03900");
                        resultTestExam = ResultTestExam.Failed;
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_04000)){
                    if (v014Service.CheckV014(v014s, zap.getZsl().getForpom())){
                        Element pr = getPrElement("T_0600/04000", schet,
                                zap, null, null, zap.getZsl().getForpom(),
                                "Ошибка соответствия записи c справочником V014");
                        flk_p.appendChild(pr);
                        su.showMessagesEx("Ошибка соотвествия справочника T_0600/04000");
                        resultTestExam = ResultTestExam.Failed;
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_04300)){
                    if (f003Service.CheckF003(f003s, zap.getZsl().getLpu())){
                        Element pr = getPrElement("T_0600/04300", schet,
                                zap, null, null, zap.getZsl().getLpu(),
                                "Ошибка соответствия записи c справочником F003");
                        flk_p.appendChild(pr);
                        su.showMessagesEx("Ошибка соотвествия справочника T_0600/04300");
                        resultTestExam = ResultTestExam.Failed;
                    }
                }

                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_04800)){
                    if (v009Service.CheckV009(v009s, zap.getZsl().getRslt())){
                        Element pr = getPrElement("T_0600/04800", schet,
                                zap, null, null, zap.getZsl().getRslt(),
                                "Ошибка соответствия записи c справочником V009");
                        flk_p.appendChild(pr);
                        su.showMessagesEx("Ошибка соотвествия справочника T_0600/04800");
                        resultTestExam = ResultTestExam.Failed;
                    }
                }

                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_04900)){
                    if (v012Service.CheckV012(v012s, zap.getZsl().getIshod())){
                        Element pr = getPrElement("T_0600/04900", schet,
                                zap, null, null, zap.getZsl().getIshod(),
                                "Ошибка соответствия записи c справочником V012");
                        flk_p.appendChild(pr);
                        su.showMessagesEx("Ошибка соотвествия справочника T_0600/04900");
                        resultTestExam = ResultTestExam.Failed;
                    }
                }

                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_05200)){
                    if (v010Service.CheckV010(v010s, zap.getZsl().getIdsp())){
                        Element pr = getPrElement("T_0600/05200", schet,
                                zap, null, null, zap.getZsl().getIdsp(),
                                "Ошибка соответствия записи c справочником V010");
                        flk_p.appendChild(pr);
                        su.showMessagesEx("Ошибка соотвествия справочника T_0600/05200");
                        resultTestExam = ResultTestExam.Failed;
                    }
                }

                double sumv = 0.00;
                for (VMPSl sl : zap.getZsl().getSl()){
                    sumv = sumv + Double.parseDouble(sl.getSumm());

                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_04102)){
                        if (zap.getZsl().getNprmo().isEmpty() && (zap.getZsl().getForpom().equals("3")
                                && zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2")
                                || CheckDS1(sl.getDs1()))){
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
                            if (f003Service.CheckF003(f003s, zap.getZsl().getNprmo())){
                                Element pr = getPrElement("T_0600/04102", schet,
                                        zap, sl, null, zap.getZsl().getNprmo(),
                                        "Ошибка соответствия записи c справочником F003");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_0600/04102");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_04202)){
                        if (zap.getZsl().getNprdate().isEmpty() && (zap.getZsl().getForpom().equals("3")
                                && zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2")
                                || CheckDS1(sl.getDs1()))){
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
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_05900)){
                        if (v018Service.CheckV018(v018s, sl.getVidhmp())){
                            Element pr = getPrElement("T_0700/05900", schet,
                                    zap, sl, null, sl.getVidhmp(),
                                    "Ошибка соответствия записи c справочником V018");
                            flk_p.appendChild(pr);
                            su.showMessagesEx("Ошибка соотвествия справочника T_0700/05900");
                            resultTestExam = ResultTestExam.Failed;
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_06000)){
                        if (v019Service.CheckV019(v019s, sl.getVidhmp())){
                            Element pr = getPrElement("T_0700/06000", schet,
                                    zap, sl, null, sl.getMetodhmp(),
                                    "Ошибка соответствия записи c справочником V019");
                            flk_p.appendChild(pr);
                            su.showMessagesEx("Ошибка соотвествия справочника T_0700/06000");
                            resultTestExam = ResultTestExam.Failed;
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_06300)){
                        if (v002Service.CheckV002(v002s, sl.getProfil())){
                            Element pr = getPrElement("T_0700/06300", schet,
                                    zap, sl, null, sl.getProfil(),
                                    "Ошибка соответствия записи c справочником V002");
                            flk_p.appendChild(pr);
                            su.showMessagesEx("Ошибка соотвествия справочника T_0700/06300");
                            resultTestExam = ResultTestExam.Failed;
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_06400)){
                        if (v020Service.CheckV020(v020s, sl.getProfilk())){
                            Element pr = getPrElement("T_0700/06400", schet,
                                    zap, sl, null, sl.getProfilk(),
                                    "Ошибка соответствия записи c справочником V020");
                            flk_p.appendChild(pr);
                            su.showMessagesEx("Ошибка соотвествия справочника T_0700/06400");
                            resultTestExam = ResultTestExam.Failed;
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_07602)){
                        if (sl.getCzab().isEmpty() && CheckDS1(sl.getDs1())){
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
                            if (v027Service.CheckV027(v027s, sl.getCzab())) {
                                Element pr = getPrElement("T_0700/07602", schet,
                                        zap, sl, null, sl.getCzab(),
                                        "Ошибка соответствия записи c справочником V027");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_0700/07602");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_08102)){
                        if (sl.getCons().isEmpty() && sl.getDsonk().equals("1") && CheckDS1(sl.getDs1())){
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
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_08202)){
                        if (sl.getOnksl() == null && CheckDS1(sl.getDs1())){
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
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_08301)){
                        if (v021Service.CheckV021(v021s, sl.getPrvs())){
                            Element pr = getPrElement("T_0700/08301", schet,
                                    zap, sl, null, sl.getPrvs(),
                                    "Ошибка соответствия записи c справочником V021");
                            flk_p.appendChild(pr);
                            su.showMessagesEx("Ошибка соотвествия справочника T_0700/08301");
                            resultTestExam = ResultTestExam.Failed;
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0700_08702)){
                        if (sl.getTarif().isEmpty() && CheckDS1(sl.getDs1())){
                            Element pr = getPrElement("T_0700/08702", schet,
                                    zap, sl, null, sl.getTarif(),
                                    "TARIF не может быть пустым если " +
                                            " первый символ кода основного диагноза - «С» или код" +
                                            " основного диагноза входит в диапазон D00-D09 или D45-D47");
                            flk_p.appendChild(pr);
                            su.showMessagesEx("Ошибка соотвествия справочника T_0700/08702");
                            resultTestExam = ResultTestExam.Failed;
                        }
                    }

                    if (sl.getUsl() != null){

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
                        for (Napr napr : sl.getNapr()){
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0800_09200)){
                                if (f003Service.CheckF003(f003s, napr.getNaprmo())){
                                    Element pr = getPrElement("T_0800/09200", schet,
                                            zap, sl, null, napr.getNaprmo(),
                                            "Ошибка соответствия записи c справочником F003");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника T_0800/09200");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0800_09300)){
                                if (v028Service.CheckV028(v028s, napr.getNaprv())){
                                    Element pr = getPrElement("T_0800/09300", schet,
                                            zap, sl, null, napr.getNaprv(),
                                            "Ошибка соответствия записи c справочником V028");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника T_0800/09300");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0800_09400)){
                                if (napr.getNaprv().equals("3") && v029Service.CheckV029(v029s, napr.getMetissl())){
                                    Element pr = getPrElement("T_0800/09400", schet,
                                            zap, sl, null, napr.getMetissl(),
                                            "Ошибка соответствия записи c справочником V029");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника T_0800/09400");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0800_09500)){
                                if (!napr.getMetissl().isEmpty() && v001Service.CheckV001(v001s, napr.getNaprusl())){
                                    Element pr = getPrElement("T_0800/09500", schet,
                                            zap, sl, null, napr.getMetissl(),
                                            "Ошибка соответствия записи c справочником V001");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника T_0800/09500");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                        }

                    if (sl.getCons() != null){
                        for (Cons cons : sl.getCons()){
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0900_09600)){
                                if (v019Service.CheckV019(v019s, cons.getPrcons())){
                                    Element pr = getPrElement("T_0900/09600", schet,
                                            zap, sl, null, cons.getPrcons(),
                                            "Ошибка соответствия записи c справочником V019");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника T_0900/09600");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0900_09700)){
                                if (cons.getDtcons().isEmpty() && (cons.getPrcons().equals("1")
                                        || cons.getPrcons().equals("2") || cons.getPrcons().equals("3"))){
                                    Element pr = getPrElement("T_0900/09700", schet,
                                            zap, sl, null, cons.getPrcons(),
                                            "DT_CONS обязательно к заполнению, если консилиум проведен (PR_CONS={1,2,3})");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника T_0900/09700");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                        }
                    }
                    if (sl.getOnksl() != null){
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1000_09800)){
                            if (n018Service.CheckN018(n018s, sl.getOnksl().getDs1t())){
                                Element pr = getPrElement("T_1000/09800", schet,
                                        zap, sl, null, sl.getOnksl().getDs1t(),
                                        "Ошибка соответствия записи c справочником V018");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_1000/09800");
                                resultTestExam = ResultTestExam.Failed;
                            }
                        }
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1000_09900)){
                            if (sl.getOnksl().getStad().isEmpty() && (sl.getOnksl().getDs1t().equals("0")
                                    || sl.getOnksl().getDs1t().equals("1") || sl.getOnksl().getDs1t().equals("2"))){
                                Element pr = getPrElement("T_1000/09900", schet,
                                        zap, sl, null, sl.getOnksl().getStad(),
                                        "STAD обязательно к заполнению при проведении " +
                                                "противоопухолевого лечения (DS1_T={0,1,2})");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_1000/09900");
                                resultTestExam = ResultTestExam.Failed;
                            } else {
                                if (n002Service.CheckN002(n002s, sl.getOnksl().getStad())) {
                                    Element pr = getPrElement("T_1000/09900", schet,
                                            zap, sl, null, sl.getOnksl().getStad(),
                                            "Ошибка соответствия записи c справочником N002");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника T_1000/09900");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                        }
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1000_10000)){
                            if (sl.getOnksl().getOnkt().isEmpty() && sl.getOnksl().getDs1t().equals("0")
                                    && GetAge(pers.getDr(), sl.getDate1()) > 18){
                                Element pr = getPrElement("T_1000/10000", schet,
                                        zap, sl, null, sl.getOnksl().getOnkt(),
                                        "ONK_T обязательно к заполнению при первичном лечении (DS1_T=0) " +
                                                "для пациентов, возраст которых на дату начала лечения более 18 лет");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_1000/10000");
                                resultTestExam = ResultTestExam.Failed;
                            } else {
                                if (n003Service.CheckN003(n003s, sl.getOnksl().getOnkt())) {
                                    Element pr = getPrElement("T_1000/10000", schet,
                                            zap, sl, null, sl.getOnksl().getOnkt(),
                                            "Ошибка соответствия записи c справочником N003");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника T_1000/10000");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                        }
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1000_10100)){
                            if (sl.getOnksl().getOnkn().isEmpty() && sl.getOnksl().getDs1t().equals("0")
                                    && GetAge(pers.getDr(), sl.getDate1()) > 18){
                                Element pr = getPrElement("T_1000/10100", schet,
                                        zap, sl, null, sl.getOnksl().getOnkn(),
                                        "ONK_N обязательно к заполнению при первичном лечении (DS1_T=0) " +
                                                "для пациентов, возраст которых на дату начала лечения более 18 лет");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_1000/10100");
                                resultTestExam = ResultTestExam.Failed;
                            } else {
                                if (n004Service.CheckN004(n004s, sl.getOnksl().getOnkn())) {
                                    Element pr = getPrElement("T_1000/10000", schet,
                                            zap, sl, null, sl.getOnksl().getOnkn(),
                                            "Ошибка соответствия записи c справочником N004");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника T_1000/10100");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                        }
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1000_10200)){
                            if (sl.getOnksl().getOnkm().isEmpty() && sl.getOnksl().getDs1t().equals("0")
                                    && GetAge(pers.getDr(), sl.getDate1()) > 18){
                                Element pr = getPrElement("T_1000/10200", schet,
                                        zap, sl, null, sl.getOnksl().getOnkm(),
                                        "ONK_M обязательно к заполнению при первичном лечении (DS1_T=0) " +
                                                "для пациентов, возраст которых на дату начала лечения более 18 лет");
                                flk_p.appendChild(pr);
                                su.showMessagesEx("Ошибка соотвествия справочника T_1000/10000");
                                resultTestExam = ResultTestExam.Failed;
                            } else {
                                if (n005Service.CheckN005(n005s, sl.getOnksl().getOnkn())) {
                                    Element pr = getPrElement("T_1000/10200", schet,
                                            zap, sl, null, sl.getOnksl().getOnkm(),
                                            "Ошибка соответствия записи c справочником N005");
                                    flk_p.appendChild(pr);
                                    su.showMessagesEx("Ошибка соотвествия справочника T_1000/10200");
                                    resultTestExam = ResultTestExam.Failed;
                                }
                            }
                        }
                        if (sl.getOnksl().getOnkusls() != null){
                            for (VMPOnkusl onkusl : sl.getOnksl().getOnkusls()) {
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1000_10400)) {
                                    if (sl.getOnksl().getSod().isEmpty() && (onkusl.getUsltip().equals("3")
                                            && onkusl.getUsltip().equals("4"))) {
                                        Element pr = getPrElement("T_1000/10400", schet,
                                                zap, sl, null, sl.getOnksl().getOnkm(),
                                                "SOD обязательно для заполнения при проведении лучевой или " +
                                                        "химиолучевой терапии (USL_TIP=3 или USL_TIP=4)");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника T_1000/10400");
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
                                        su.showMessagesEx("Ошибка соотвествия справочника T_1000/10400");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                            }
                        }
                        if (sl.getOnksl().getBdiags() != null){
                            for (VMPBdiag bdiag : sl.getOnksl().getBdiags()) {
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1100_11400)){
                                    if (n007Service.CheckN007(n007s, bdiag.getDiagcode()) && bdiag.getDiagtip().equals("1")){
                                        Element pr = getPrElement("T_1100/11400", schet,
                                                zap, sl, null, bdiag.getDiagcode(),
                                                "Ошибка соответствия записи c справочником N007");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника T_1100/11400");
                                        resultTestExam = ResultTestExam.Failed;
                                    } else if (n010Service.CheckN010(n010s, bdiag.getDiagcode()) && bdiag.getDiagtip().equals("2")){
                                        Element pr = getPrElement("T_1100/11400", schet,
                                                zap, sl, null, bdiag.getDiagcode(),
                                                "Ошибка соответствия записи c справочником N010");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника T_1100/11400");
                                        resultTestExam = ResultTestExam.Failed;
                                    }
                                }
                                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_1100_11500)){
                                    if (n008Service.CheckN008(n008s, bdiag.getDiagrlst()) && bdiag.getDiagtip().equals("1")){
                                        Element pr = getPrElement("T_1100/11500", schet,
                                                zap, sl, null, bdiag.getDiagcode(),
                                                "Ошибка соответствия записи c справочником N008");
                                        flk_p.appendChild(pr);
                                        su.showMessagesEx("Ошибка соотвествия справочника T_1100/11500");
                                        resultTestExam = ResultTestExam.Failed;
                                    } else if (n011Service.CheckN011(n011s, bdiag.getDiagcode()) && bdiag.getDiagtip().equals("2")){
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

                    }
                }

                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.T_0600_05300)){
                    if (Double.parseDouble(zap.getZsl().getSumv()) != sumv || zap.getZsl().getSumv().isEmpty()
                            || Double.parseDouble(zap.getZsl().getSumv()) == 0){
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
        elIdpac.appendChild(zap.getPacient().getIdpac());
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
