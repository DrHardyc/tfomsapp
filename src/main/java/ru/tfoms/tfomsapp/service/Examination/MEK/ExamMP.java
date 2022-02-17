package ru.tfoms.tfomsapp.service.Examination.MEK;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.Exam.ExamParam;
import ru.tfoms.tfomsapp.domain.HandBook.*;
import ru.tfoms.tfomsapp.domain.MEK.MP.*;
import ru.tfoms.tfomsapp.domain.MEK.Mrusln;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPers;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPerslist;
import ru.tfoms.tfomsapp.domain.MEK.Sank;
import ru.tfoms.tfomsapp.service.HandBook.*;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ExamMP {
    private final O002Service o002Service = new O002Service();
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

    public void exam(PDPerslist persList, ExamParam examParam) throws IOException {
        List<O002> o002s = o002Service.getO002s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=o002"));
        List<F002> f002s = f002Service.getF002s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F002"));
        List<F003> f003s = f003Service.getF003s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F003"));
        List<F004> f004s = f004Service.getF004s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F004"));
        List<F006> f006s = f006Service.getF006s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F006"));
        List<F008> f008s = f008Service.getF008s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F008"));
        List<F014> f014s = f014Service.getF014s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F014"));
        List<V001> v001s = v001Service.getV001s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V001"));
        List<V002> v002s = v002Service.getV002s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V002"));
        List<V006> v006s = v006Service.getV006s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V006"));
        List<V008> v008s = v008Service.getV008s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V008"));
        List<V009> v009s = v009Service.getV009s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V009"));
        List<V010> v010s = v010Service.getV010s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V010"));
        List<V012> v012s = v012Service.getV012s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V012"));
        List<V014> v014s = v014Service.getV014s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V014"));
        List<V020> v020s = v020Service.getV020s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V020"));
        List<V021> v021s = v021Service.getV021s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V021"));
        List<V024> v024s = v024Service.getV024s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V024"));
        List<V025> v025s = v025Service.getV025s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V025"));
        List<V026> v026s = v026Service.getV026s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V026"));
        List<V027> v027s = v027Service.getV027s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V027"));
        List<V032> v032s = v032Service.getV032s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V032"));
        List<V036> v036s = v036Service.getV036s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V036"));

        for (PDPers pacient : persList.getPers()){

            for (MPZap zap : pacient.getMpZap()){
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0500_02600)){
                    if (zap.getPacient().getVpolis() != null){
                        if (CheckF008(f008s, zap.getPacient().getVpolis()) ){
                            su.showMessagesEx("Ошибка соотвествия справочника H_0500/02600");
                        }
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0500_03000)){
                    if (CheckF002(f002s, zap.getPacient().getSmo())){
                        su.showMessagesEx("Ошибка соотвествия справочника H_0500/03000");
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0500_03101)){
                    if (zap.getPacient().getEnp().isEmpty() && zap.getPacient().getVpolis().equals("3")){
                        su.showMessagesEx("Ошибка H_0500/03101");
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0500_02801)){
                    if (zap.getPacient().getVpolis().equals("3") && zap.getPacient().getNpolis().isEmpty()){
                        su.showMessagesEx("Ошиюка H_0500/02801");
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_03900)){
                    if (CheckV006(v006s, zap.getZsl().getUslok())){
                        su.showMessagesEx("Ошибка соотвествия справочника H_0600/03900");
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_04000)){
                    if (CheckV008(v008s, zap.getZsl().getVidpom())){
                        su.showMessagesEx("Ошибка соотвествия справочника H_0600/04000");
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_04100)){
                    if (CheckV014(v014s, zap.getZsl().getForpom())){
                        su.showMessagesEx("Ошибка соотвествия справочника H_0600/04100");
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_04200)){
                    if (zap.getZsl().getNprmo().isEmpty()
                            && ((zap.getZsl().getForpom().equals("3")
                            && zap.getZsl().getUslok().equals("1"))||zap.getZsl().getUslok().equals("2"))){
                        su.showMessagesEx("Ошибка H_0600/04200");
                    } else {
                        if (CheckF003(f003s, zap.getZsl().getNprmo())){
                            su.showMessagesEx("Ошибка соотвествия справочника H_0600/04200");
                        }
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_04300)){
                    if (zap.getZsl().getNprdate().isEmpty()
                            && ((zap.getZsl().getForpom().equals("3")
                            && zap.getZsl().getUslok().equals("1"))||zap.getZsl().getUslok().equals("2"))){
                        su.showMessagesEx("Ошибка H_0600/04200");
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_04400)){
                    if (CheckF003(f003s, zap.getZsl().getLpu())){
                        su.showMessagesEx("Ошибка соотвествия справочника H_0600/04400");
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_04900)){
                    if (CheckV009(v009s, zap.getZsl().getRslt())){
                        su.showMessagesEx("Ошибка соотвествия справочника H_0600/04900");
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_05000)){
                    if (CheckV012(v012s, zap.getZsl().getIshod())){
                        su.showMessagesEx("Ошибка соотвествия справочника H_0600/05000");
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_05400)){
                    //H_0600/05400
                    if (CheckV010(v010s, zap.getZsl().getIdsp())){
                        su.showMessagesEx("Ошибка соотвествия справочника H_0600/05400");
                    }
                }

                double sumv = 0.00;
                for (MPSl sl : zap.getZsl().getSl()){
                    sumv =+ Double.parseDouble(sl.getSumm());

                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_06300)){
                        if (CheckV002(v002s, sl.getProfil())){
                            su.showMessagesEx("Ошибка соотвествия справочника H_0700/06300");
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_06400)){
                        if (sl.getProfilk().isEmpty()
                                && (zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2"))){
                            su.showMessagesEx("Ошибка соотвествия справочника H_0700/06400");
                        } else {
                            if (CheckV020(v020s, sl.getProfilk())){
                                su.showMessagesEx("Ошибка соотвествия справочника H_0700/06400");
                            }
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_06600)){
                        if (sl.getPcel().isEmpty() && zap.getZsl().getUslok().equals("3")){
                            su.showMessagesEx("Ошибка H_0700/06600");
                        } else {
                            if (CheckV025(v025s, sl.getPcel())){
                                su.showMessagesEx("Ошибка соотвествия справочника H_0700/06600");
                            }
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_06800)){
                        if (sl.getNhistory().isEmpty()
                                && (zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2"))){
                            su.showMessagesEx("Ошибка H_0700/06800");
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_07100)){
                        if (sl.getKd().isEmpty()
                                && (zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2"))){
                            su.showMessagesEx("Ошибка H_0700/07100");
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_07302)){
                        for(int iDs1 = 0; iDs1 < 10; iDs1++){
                            if (sl.getDs1().contains("D0" + iDs1) || sl.getDs1().contains("D45")
                                    || sl.getDs1().contains("D46") || sl.getDs1().contains("D47")
                                    || sl.getDs1().contains("C")){
                                su.showMessagesEx("Ошибка H_0700/07302");
                            };
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_07601)){
                        if (sl.getCzab().isEmpty()
                                && sl.getDs1().contains("Z")
                                && (sl.getDs1().equals("D11.0") || sl.getDs1().equals("D11.9"))){
                            su.showMessagesEx("Ошибка H_0700/07600");
                        } else {
                            if (CheckV027(v027s, sl.getCzab())){
                                su.showMessagesEx("Ошибка соотвествия справочника H_0700/07600");
                            }
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_07700)){
                        if (sl.getPcel().equals("1.3") && sl.getDn().isEmpty()){
                            su.showMessagesEx("Ошибка H_0700/07700");
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0700_08201)){
                        if (CheckV021(v021s, sl.getPrvs())){
                            su.showMessagesEx("Ошибка соотвествия справочника H_0700/08201");
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0800_09000)
                            || examParam.equals(ExamParam.H_0800_09300)) {
                        if (!sl.getKsgkpg().getNksg().isEmpty() && !sl.getKsgkpg().getNkpg().isEmpty()){
                            su.showMessagesEx("Ошибка H_0800/09000 или H_0800/09300");
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0800_09300)){
                        if (CheckV026(v026s, sl.getKsgkpg().getNkpg())){
                            su.showMessagesEx("Ошибка соотвествия справочника H_0800/09300");
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0800_09900)){
                        if (CheckV024(v024s, sl.getKsgkpg().getCrit())){
                            su.showMessagesEx("Ошибка соотвествия справочника H_0800/09900");
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0800_10200)){
                        if (!sl.getKsgkpg().getSlkoef().isEmpty() && sl.getKsgkpg().getItsl().isEmpty()){
                            su.showMessagesEx("Ошибка H_0800/10200");
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1100_13300)){
                        if (sl.getWei().isEmpty() && (sl.getDs1().equals("U07.1") || sl.getDs1().equals("U07.2"))
                                && Integer.parseInt(sl.getReab()) != 1
                                && CheckCrit(sl.getKsgkpg().getCrit(), "STT5")
                                && zap.getZsl().getUslok().equals("1")
                                && CheckDS2(sl.getDs2())
                                && GetAge(pacient.getDr(), sl.getDate1()) >= 18){
                            su.showMessagesEx("Ошибка H_1100/13300");
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1100_13400)){
                        if ((sl.getLekpr() == null || sl.getLekpr().isEmpty()) && (sl.getDs1().equals("U07.1") || sl.getDs1().equals("U07.2"))
                                && Integer.parseInt(sl.getReab()) != 1
                                && CheckCrit(sl.getKsgkpg().getCrit(), "STT5")
                                && zap.getZsl().getUslok().equals("1")
                                && CheckDS2(sl.getDs2())
                                && GetAge(pacient.getDr(), sl.getDate1()) >= 18){
                            su.showMessagesEx("Ошибка H_1100/13300");
                        }
                    }

                    for (MPUsl usl : sl.getUsl()){
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1000_10600)){
                            if (CheckF003(f003s, usl.getLpu())){
                                su.showMessagesEx("Ошибка соотвествия справочника H_1000/10600");
                            }
                        }
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1000_10900)){
                            if (CheckV002(v002s, usl.getProfil())){
                                su.showMessagesEx("Ошибка соотвествия справочника H_1000/10900");
                            }
                        }
                        if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1000_11000)){
                            if (CheckV001(v001s, usl.getVidvme())){
                                su.showMessagesEx("Ошибка соотвествия справочника H_1000/11000");
                            }
                        }
                        for (Mrusln mrusln : usl.getMruslns()){
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1000_11904)){
                                if (CheckV021(v021s, mrusln.getPrvs())){
                                    su.showMessagesEx("Ошибка соотвествия справочника H_1000/11904");
                                }
                            }
                        }
                        for (MPLekpr lekpr : sl.getLekpr()){
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1100_13600)){
                                for (String crit : sl.getKsgkpg().getCrit()){
                                    if (lekpr.getCodesh().isEmpty()
                                            && (sl.getDs1().equals("V07.1") || sl.getDs1().equals("V07.2"))
                                            && Integer.parseInt(sl.getReab()) != 0
                                            && !crit.equals("STT5")
                                            && zap.getZsl().getUslok().equals("0")
                                            && DS2CheckInH_1100_13600(sl.getDs2())){
                                        su.showMessagesEx("Ошибка H_1100/13600");
                                    } else {
                                        if (CheckV032(v032s, lekpr.getCodesh())){
                                            su.showMessagesEx("Ошибка соотвествия справочника H_1100/13600");
                                        }
                                    }
                                }
                            }
                        }
                        for (MPMeddev meddev : usl.getMeddev()){
                            if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1100_14400)){
                                if (CheckV036(v036s, meddev)){
                                    su.showMessagesEx("Ошибка соотвествия справочника H_1100/14400");
                                }
                            }
                        }
                    }
                }
                for (Sank sank : zap.getZsl().getSank()){
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1100_12500)){
                        if (!sank.getSsum().equals("0") && sank.getSlid().isEmpty()){
                            su.showMessagesEx("Ошибка H_1100/12500");
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1100_12700)){
                        if (CheckF014(f014s, sank.getSosn())){
                            su.showMessagesEx("Ошибка H_1100/12700");
                        }
                    }
                    if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_1100_13000)){
                        if ((Integer.parseInt(sank.getStip()) >= 30) && sank.getCodeexp().isEmpty()){
                            su.showMessagesEx("Ошибка H_1100/13000");
                        } else {
                            if (CheckF004(f004s, sank.getCodeexp())){
                                su.showMessagesEx("Ошибка H_1100/13000");
                            }
                        }
                    }
                }
                if (examParam.equals(ExamParam.All) || examParam.equals(ExamParam.H_0600_05500)){
                    if (Double.parseDouble(zap.getZsl().getSumv()) != sumv){
                        su.showMessagesEx("Ошибка //H_0600/05500");
                    }
                }
            }
        }
    }

    private int GetAge(String dr, String date1) {
        LocalDate dateDr = LocalDate.parse(dr);
        LocalDate dateDate1 = LocalDate.parse(date1);
        long age = ChronoUnit.YEARS.between(dateDr, dateDate1);
        return (int) age;
    }

    private boolean CheckDS2(List<String> ds2s) {
        for (String ds2 : ds2s){
            for (int iDs2 = 0; iDs2 < 100; iDs2++){
                if (iDs2 < 10){
                    if (ds2.equals("O0" + iDs2)){
                        return false;
                    }
                }else {
                    if (ds2.equals("O" + iDs2)){
                        return false;
                    }
                }
            }
            if (ds2.equals("Z34") || ds2.equals("Z35")){
                return false;
            }
        }
        return true;
    }

    private boolean CheckCrit(List<String> crits, String stt5) {
        for (String crit : crits){
            if (crit.equals(stt5)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV036(List<V036> v036s, MPMeddev meddev) {
        for (V036 v036 : v036s){
            if (v036.getS_code().equals(meddev.getCodemeddev())){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV032(List<V032> v032s, String codesh) {
        for (V032 v032 : v032s){
                if (v032.getSchedruggrcd().equals(codesh)){
                    return false;
                }
        }
        return true;
    }

    private boolean DS2CheckInH_1100_13600(List<String> ds2s) {
        for (String ds2 : ds2s){
            for (int iDs2 = 0; iDs2 < 100; iDs2++){
                if (ds2.equals("O0" + iDs2)){
                    return false;
                }
                if (ds2.equals("Z34") || (ds2.equals("Z35"))){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean CheckF004(List<F004> f004s, List<String> codeexps) {
        for (F004 f004 : f004s){
            for (String codeexp : codeexps){
                if (f004.getN_expert().equals(codeexp)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean CheckF014(List<F014> f014s, String sosn) {
        for (F014 f014 : f014s){
            if (f014.getOsn().equals(sosn)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV001(List<V001> v001s, String vidvme) {
        for (V001 v001 : v001s){
            if (v001.getS_code().equals(vidvme)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV024(List<V024> v024s, List<String> crits) {
        for (V024 v024 : v024s){
            for (String crit : crits){
                if (v024.getIddkk().equals(crit)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean CheckV026(List<V026> v026s, String nkpg) {
        for (V026 v026 : v026s){
            if (v026.getK_kpg().equals(nkpg)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV021(List<V021> v021s, String prvs) {
        for (V021 v021 : v021s){
            if (v021.getIdpost_mz().equals(prvs)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV027(List<V027> v027s, String czab) {
        for (V027 v027 : v027s){
            if (v027.getIdcz().equals(czab)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV025(List<V025> v025s, String pcel) {
        for (V025 v025 : v025s){
            if (v025.getIdpc().equals(pcel)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV020(List<V020> v020s, String profilk) {
        for (V020 v020 : v020s){
            if (v020.getIdk_pr().equals(profilk)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV002(List<V002> v002s, String profil) {
        for (V002 v002 : v002s){
            if (v002.getIdpr().equals(profil)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV010(List<V010> v010s, String idsp) {
        for (V010 v010 : v010s){
            if (v010.getIdsp().equals(idsp)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV012(List<V012> v012s, String ishod) {
        for (V012 v012 : v012s){
            if (v012.getIdiz().equals(ishod)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV009(List<V009> v009s, String rslt) {
        for (V009 v009 : v009s){
            if (v009.getIdrmp().equals(rslt)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckF003(List<F003> f003s, String nprmo) {
        for (F003 f003 : f003s){
            if (f003.getMcod().equals(nprmo)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV014(List<V014> v014s, String forpom) {
        for (V014 v014 : v014s){
            if (v014.getIdfrmmp().equals(forpom)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV008(List<V008> v008s, String vidpom) {
        for (V008 v008 : v008s){
            if (v008.getIdvmp().equals(vidpom)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckV006(List<V006> v006s, String uslok) {
        for (V006 v006 : v006s){
            if (v006.getIdump().equals(uslok)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckF008(List<F008> f008s, String strSearch){
        for (F008 f008 : f008s){
            if (strSearch.isEmpty()){
                return true;
            }
            if (f008.getIddoc().equals(strSearch)){
                return false;
            }
        }
        return true;
    }

    private boolean CheckF002(List<F002> f002s, String strSearch){
        for (F002 f002 : f002s){
            if (f002.getSmocod().equals(strSearch)){
                return false;
            }
        }
        return true;
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
