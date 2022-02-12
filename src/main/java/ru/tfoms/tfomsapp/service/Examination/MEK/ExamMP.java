package ru.tfoms.tfomsapp.service.Examination.MEK;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.*;
import ru.tfoms.tfomsapp.domain.MEK.MP.*;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPers;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPerslist;
import ru.tfoms.tfomsapp.service.HandBook.*;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class ExamMP {
    private final O002Service o002Service = new O002Service();
    private final F008Service f008Service = new F008Service();
    private final F002Service f002Service = new F002Service();
    private final V006Service v006Service = new V006Service();
    private final V008Service v008Service = new V008Service();
    private final V014Service v014Service = new V014Service();
    private final F003Service f003Service = new F003Service();
    private final V009Service v009Service = new V009Service();
    private final V012Service v012Service = new V012Service();
    private final V010Service v010Service = new V010Service();
    private final V002Service v002Service = new V002Service();
    private final V020Service v020Service = new V020Service();
    private final V025Service v025Service = new V025Service();
    private final ServiceUtil su = new ServiceUtil();
    public void exam(PDPerslist persList) throws IOException {
        List<O002> o002 = o002Service.getO002(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/structure?identifier=o002"));
        List<F008> f008s = f008Service.getF008s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F008"));
        List<F002> f002s = f002Service.getF002s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/structure?identifier=F002"));
        List<V006> v006s = v006Service.getF008s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/structure?identifier=V006"));
        List<V008> v008s = v008Service.getV008s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/structure?identifier=V008"));
        List<V014> v014s = v014Service.getF008s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/structure?identifier=V014"));
        List<F003> f003s = f003Service.getF003s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/structure?identifier=F003"));
        List<V009> v009s = v009Service.getV009s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/structure?identifier=V009"));
        List<V012> v012s = v012Service.getV012s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/structure?identifier=V012"));
        List<V010> v010s = v010Service.getV010s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/structure?identifier=V010"));
        List<V002> v002s = v002Service.getV002s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/structure?identifier=V002"));
        List<V020> v020s = v020Service.getV020s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/structure?identifier=V020"));
        List<V025> v025s = v025Service.getV010s(getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/structure?identifier=V025"));
        for (PDPers pacient : persList.getPers()){

            for (MPZap zap : pacient.getMpZap()){
                //H_0500/02600
                if (!ChekF008(f008s, zap.getPacient().getVpolis())){
                    su.showMessagesEx("Ошибка H_0500/02600");
                }
                //H_0500/03000
                if (!ChekF002(f002s, zap.getPacient().getSmo())){
                    su.showMessagesEx("Ошибка H_0500/03000");
                }
                //H_0500/03101
                if (zap.getPacient().getEnp().isEmpty() && zap.getPacient().getVpolis().equals("3")){
                    su.showMessagesEx("Ошибка H_0500/03101");
                }
                //H_0500/02801
                if (!zap.getPacient().getVpolis().equals("3")&&zap.getPacient().getNpolis().isEmpty()){
                    su.showMessagesEx("Ошиюка H_0500/02801");
                }
                //H_0600/03900
                if (!ChekV006(v006s, zap.getZsl().getUslok())){
                    su.showMessagesEx("Ошибка H_0600/03900");
                }
                //H_0600/04000
                if (!ChekV008(v008s, zap.getZsl().getVidpom())){
                    su.showMessagesEx("Ошибка H_0600/04000");
                }
                //H_0600/04100
                if (!ChekV014(v014s, zap.getZsl().getForpom())){
                    su.showMessagesEx("Ошибка H_0600/04100");
                }
                //C_0600/04202
                if ((zap.getZsl().getNprmo().isEmpty())&&(zap.getZsl().getForpom().equals("1")
                            ||zap.getZsl().getUslok().equals("1")||zap.getZsl().getUslok().equals("2"))){
                    su.showMessagesEx("Ошибка C_0600/04202");
                }
                //H_0600/04200
                if (zap.getZsl().getNprmo().isEmpty()
                        && ((zap.getZsl().getForpom().equals("3")
                        && zap.getZsl().getUslok().equals("1"))||zap.getZsl().getUslok().equals("2"))){
                    su.showMessagesEx("Ошибка H_0600/04200");
                } else {
                    if (!CheckF003(f003s, zap.getZsl().getNprmo())){
                        su.showMessagesEx("Ошибка H_0600/04200");
                    }
                }
                //H_0600/04300
                if (zap.getZsl().getNprdate().isEmpty()
                        && ((zap.getZsl().getForpom().equals("3")
                        && zap.getZsl().getUslok().equals("1"))||zap.getZsl().getUslok().equals("2"))){
                    su.showMessagesEx("Ошибка H_0600/04200");
                }
                //H_0600/04400
                if (!CheckF003(f003s, zap.getZsl().getLpu())){
                    su.showMessagesEx("Ошибка H_0600/04400");
                }
                //H_0600/04900
                if (!ChekV009(v009s, zap.getZsl().getRslt())){
                    su.showMessagesEx("Ошибка H_0600/04900");
                }
                //H_0600/05000
                if (!CheckV012(v012s, zap.getZsl().getIshod())){
                    su.showMessagesEx("Ошибка H_0600/05000");
                }
                //H_0600/05400
                if (!CheckV010(v010s, zap.getZsl().getIdsp())){
                    su.showMessagesEx("Ошибка H_0600/05400");
                }


                double sumv = 0.00;
                for (MPSl sl : zap.getZsl().getSl()){
                    sumv =+ Double.parseDouble(sl.getSumm());

                    //H_0700/06300
                    if (!CheckV002(v002s, sl.getProfil())){
                        su.showMessagesEx("Ошибка H_0700/06300");
                    }

                    //H_0700/06400
                    if (sl.getProfilk().isEmpty()
                            && (zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2"))){
                        su.showMessagesEx("Ошибка H_0700/06400");
                    } else {
                        if (!ChekV020(v020s, sl.getProfilk())){
                            su.showMessagesEx("Ошибка H_0700/06400");
                        }
                    }
                    //H_0700/06600
                    if (sl.getPcel().isEmpty() && zap.getZsl().getUslok().equals("3")){
                        su.showMessagesEx("Ошибка H_0700/06600");
                    } else {
                        if (!CheckV025(v025s, sl.getPcel())){
                            su.showMessagesEx("Ошибка H_0700/06600");
                        }
                    }
                    //H_0700/06800
                    if (sl.getNhistory().isEmpty()
                            && (zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2"))){
                        su.showMessagesEx("Ошибка H_0700/06800");
                    }
                    //H_0700/07100
                    if (sl.getKd().isEmpty()
                            && (zap.getZsl().getUslok().equals("1") || zap.getZsl().getUslok().equals("2"))){
                        su.showMessagesEx("Ошибка H_0700/07100");
                    }
                    //H_0700/07302
                    //остановка на данном правиле!
                }
                //H_0600/05500
                if (Double.parseDouble(zap.getZsl().getSumv()) != sumv){
                    su.showMessagesEx("Ошибка //H_0600/05500");
                }
            }
        }
    }

    private boolean CheckV025(List<V025> v025s, String pcel) {
        for (V025 v025 : v025s){
            if (v025.getIdpc().equals(pcel)){
                return true;
            }
        }
        return false;
    }

    private boolean ChekV020(List<V020> v020s, String profilk) {
        for (V020 v020 : v020s){
            if (v020.getIdk_pr().equals(profilk)){
                return true;
            }
        }
        return false;
    }

    private boolean CheckV002(List<V002> v002s, String profil) {
        for (V002 v002 : v002s){
            if (v002.getIdpr().equals(profil)){
                return true;
            }
        }
        return false;
    }

    private boolean CheckV010(List<V010> v010s, String idsp) {
        for (V010 v010 : v010s){
            if (v010.getIdsp().equals(idsp)){
                return true;
            }
        }
        return false;
    }

    private boolean CheckV012(List<V012> v012s, String ishod) {
        for (V012 v012 : v012s){
            if (v012.getIdiz().equals(ishod)){
                return true;
            }
        }
        return false;
    }
    private boolean ChekV009(List<V009> v009s, String rslt) {
        for (V009 v009 : v009s){
            if (v009.getIdrmp().equals(rslt)){
                return true;
            }
        }
        return false;
    }
    private boolean CheckF003(List<F003> f003s, String nprmo) {
        for (F003 f003 : f003s){
            if (f003.getMcod().equals(nprmo)){
                return true;
            }
        }
        return false;
    }
    private boolean ChekV014(List<V014> v014s, String forpom) {
        for (V014 v014 : v014s){
            if (v014.getIdfrmmp().equals(forpom)){
                return true;
            }
        }
        return false;
    }
    private boolean ChekV008(List<V008> v008s, String vidpom) {
        for (V008 v008 : v008s){
            if (v008.getIdvmp().equals(vidpom)){
                return true;
            }
        }
        return false;
    }
    private boolean ChekV006(List<V006> v006s, String uslok) {
        for (V006 v006 : v006s){
            if (v006.getIdump().equals(uslok)){
                return true;
            }
        }
        return false;
    }
    private boolean ChekF008(List<F008> f008s, String strSearch){
        for (F008 f008 : f008s){
            if (f008.getIddoc().equals(strSearch)){
                return true;

            }
        }
        return false;
    }
    private boolean ChekF002(List<F002> f002s, String strSearch){
        for (F002 f002 : f002s){
            if (f002.getSmocod().equals(strSearch)){
                return true;
            }
        }
        return false;
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
