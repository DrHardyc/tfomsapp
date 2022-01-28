package ru.tfoms.tfomsapp.service.MEK.MP;

import nu.xom.Document;
import nu.xom.Element;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateMPXML {

    public void generate(){
        Random random = new Random();
        Element zlList = new Element("ZL_LIST");

        Element zglv = new Element("ZGLV");
        Element version = new Element("VERSION");
        version.appendChild("version | " + generateRandomString(7));
        zglv.appendChild(version);
        Element data = new Element("DATA");
        data.appendChild("data | " + random.nextInt(100000));
        zglv.appendChild(data);
        Element filename = new Element("FILENAME");
        filename.appendChild("filename | " + generateRandomString(10));
        zglv.appendChild(filename);
        Element sdz = new Element("SD_Z");
        sdz.appendChild("sdz | " + random.nextInt(10000));
        zglv.appendChild(sdz);
        zlList.appendChild(zglv);

        Element schet = new Element("SCHET");
        Element code = new Element("CODE");
        code.appendChild("code | " + random.nextInt(9999));
        schet.appendChild(code);
        Element codemo = new Element("CODE_MO");
        codemo.appendChild("codemo | " + random.nextInt(9999));
        schet.appendChild(codemo);
        Element year = new Element("YEAR");
        year.appendChild("year | " + random.nextInt(9999));
        schet.appendChild(year);
        Element month = new Element("MONTH");
        month.appendChild("month | " + random.nextInt(99));
        schet.appendChild(month);
        Element nschet = new Element("NSCHET");
        nschet.appendChild("nschet | " + random.nextInt(999999999));
        schet.appendChild(nschet);
        Element dschet = new Element("DSCHET");
        dschet.appendChild("dschet | " + random.nextInt(999999999));
        schet.appendChild(dschet);
        Element plat = new Element("PLAT");
        plat.appendChild("plat | " + random.nextInt(99999999));
        schet.appendChild(plat);
        Element summav = new Element("SUMMAV");
        summav.appendChild("summav | " + random.nextInt(99999) );
        schet.appendChild(summav);
        Element coments = new Element("COMENTS");
        coments.appendChild("coments | " + "");
        schet.appendChild(coments);
        Element summap = new Element("SUMMAP");
        summap.appendChild("summap | " + random.nextInt(99999));
        schet.appendChild(summap);
        Element sankmek = new Element("SANK_MEK");
        sankmek.appendChild("sankmek | " + random.nextInt(99999));
        schet.appendChild(sankmek);
        Element sankmee = new Element("SANK_MEE");
        sankmee.appendChild("sankmee | " + random.nextInt(99999));
        schet.appendChild(sankmee);
        Element sankekmp = new Element("SANK_EKMP");
        sankekmp.appendChild("sankekmp | " + random.nextInt(99999));
        schet.appendChild(sankekmp);
        zlList.appendChild(schet);

        for (int i = 0; i < 10; i++) {
            Element zap = new Element("ZAP");
            Element nzap = new Element("N_ZAP");
            nzap.appendChild("nzap | " + (i + 1));
            zap.appendChild(nzap);
            Element prnov = new Element("PR_NOV");
            prnov.appendChild("prnov | " + random.nextInt(1));
            zap.appendChild(prnov);

            //Pacient
            Element pacient = new Element("PACIENT");
            Element idpac = new Element("ID_PAC");
            idpac.appendChild("idpac | " + random.nextInt(99999999));
            pacient.appendChild(idpac);
            Element vpolis = new Element("VPOLIS");
            vpolis.appendChild("vpolis | " + generateRandomString(9));
            pacient.appendChild(vpolis);
            Element spolis = new Element("SPOLIS");
            spolis.appendChild("spolic | " + random.nextInt(999999999));
            pacient.appendChild(spolis);
            Element npolis = new Element("NPOLIS");
            npolis.appendChild("npolis | " + random.nextInt(99999999));
            pacient.appendChild(npolis);
            Element enp = new Element("ENP");
            enp.appendChild("enp | " + random.nextInt(9999999));
            pacient.appendChild(enp);
            Element stokato = new Element("ST_OKATO");
            stokato.appendChild("stokato | " + random.nextInt(9999999));
            pacient.appendChild(stokato);
            Element smo = new Element("SMO");
            smo.appendChild("smo | " + random.nextInt(99999));
            pacient.appendChild(smo);
            Element smonam = new Element("SMO_NAM");
            smonam.appendChild("smo_nam | " + generateRandomString(20));
            pacient.appendChild(smonam);
            Element inv = new Element("INV");
            inv.appendChild("inv | " + random.nextInt(5));
            pacient.appendChild(inv);
            Element mse = new Element("MSE");
            mse.appendChild("mse | " + random.nextInt(1));
            pacient.appendChild(mse);
            Element novor = new Element("NOVOR");
            novor.appendChild("novor | " + random.nextInt(1));
            pacient.appendChild(novor);
            Element vnovd = new Element("VNOV_D");
            vnovd.appendChild("vnovd | " + random.nextInt(99));
            pacient.appendChild(vnovd);
            zap.appendChild(pacient);
            //Z_SL
            Element zsl = new Element("Z_SL");
            Element idcase = new Element("IDCASE");
            idcase.appendChild("idcase | " + random.nextInt(999));
            zsl.appendChild(idcase);
            Element uslok = new Element("USL_OK");
            uslok.appendChild("uslok | " + generateRandomString(10));
            zsl.appendChild(uslok);
            Element vidpom = new Element("VIDPOM");
            vidpom.appendChild("vidpom | " + generateRandomString(10));
            zsl.appendChild(vidpom);
            Element forpom = new Element("FOR_POM");
            forpom.appendChild("forpom | " + generateRandomString(12));
            zsl.appendChild(forpom);
            Element nprmo = new Element("NPR_MO");
            nprmo.appendChild("nprmo | " + random.nextInt(4));
            zsl.appendChild(nprmo);
            Element nprdate = new Element("NPR_DATE");
            nprdate.appendChild("npdate | " + random.nextInt(4));
            zsl.appendChild(nprdate);
            Element lpu = new Element("LPU");
            lpu.appendChild("lpu | " + random.nextInt(4));
            zsl.appendChild(lpu);
            Element datez1 = new Element("DATE_Z_1");
            datez1.appendChild("datez1 | " + random.nextInt(999999));
            zsl.appendChild(datez1);
            Element datez2 = new Element("DATE_Z_2");
            datez2.appendChild("datez2 | " + random.nextInt(999999));
            zsl.appendChild(datez2);
            Element kdz = new Element("KD_Z");
            kdz.appendChild("kdz | " + random.nextInt(150));
            zsl.appendChild(kdz);
            for (int iVnovm = 0; iVnovm < 2; iVnovm++){
                Element vnovm = new Element("VNOV_M");
                vnovm.appendChild("vnov | " + random.nextInt(30));
                zsl.appendChild(vnovm);
            }
            Element rslt = new Element("RSLT");
            rslt.appendChild("rslt | " + random.nextInt(999));
            zsl.appendChild(rslt);
            Element ishod = new Element("ISHOD");
            ishod.appendChild("ishod | " + random.nextInt(999));
            zsl.appendChild(ishod);
            for (int iSluch = 0; iSluch < 2; iSluch++){
                Element ossluch = new Element("OS_SLUCH");
                ossluch.appendChild("osluch | " + random.nextInt(30));
                zsl.appendChild(ossluch);
            }
            Element vbp = new Element("VB_P");
            vbp.appendChild("vbp | " + random.nextInt(1));
            zsl.appendChild(vbp);
            for (int iSl = 0; iSl < 2; iSl++){
                Element sl = new Element("SL");
                Element slid = new Element("SL_ID");
                slid.appendChild("slid | " + random.nextInt(99999));
                sl.appendChild(slid);
                Element lpu1 = new Element("LPU_1");
                lpu1.appendChild("lpu1 | " + random.nextInt(999));
                sl.appendChild(lpu1);
                Element podr = new Element("PODR");
                podr.appendChild("podr | " + random.nextInt(9999));
                sl.appendChild(podr);
                Element profil = new Element("PROFIL");
                profil.appendChild("profil |" + random.nextInt(4));
                sl.appendChild(profil);
                Element profilk = new Element("PROFIL_K");
                profilk.appendChild("profilk | " + random.nextInt(4));
                sl.appendChild(profilk);
                Element det = new Element("DET");
                det.appendChild("det | " + random.nextInt(1));
                sl.appendChild(det);
                Element pcel = new Element("P_CEL");
                pcel.appendChild("pcel | " + generateRandomString(20));
                sl.appendChild(pcel);
                Element nhistory = new Element("NHISTORY");
                nhistory.appendChild("nhistory | " + random.nextInt(9));
                sl.appendChild(nhistory);
                Element pper = new Element("P_PER");
                pper.appendChild("pper | " + random.nextInt(10));
                sl.appendChild(pper);
                Element date1 = new Element("DATE_1");
                date1.appendChild("date1 | " + random.nextInt(999999));
                sl.appendChild(date1);
                Element date2 = new Element("DATE_2");
                date2.appendChild("date2 | " + random.nextInt(999999));
                sl.appendChild(date2);
                Element kd = new Element("KD");
                kd.appendChild("kd | " + random.nextInt(365));
                sl.appendChild(kd);
                Element wei = new Element("WEI");
                wei.appendChild("wei | " + random.nextInt(200));
                sl.appendChild(wei);
                Element ds0 = new Element("DS0");
                ds0.appendChild("ds0 | " + generateRandomString(20));
                sl.appendChild(ds0);
                Element ds1 = new Element("DS1");
                ds1.appendChild("ds1 | " + generateRandomString(20));
                sl.appendChild(ds1);
                for (int iDs2 = 0; iDs2 < 2; iDs2++){
                    Element ds2 = new Element("DS2");
                    ds2.appendChild("ds2 | " + generateRandomString(18));
                    sl.appendChild(ds2);
                }
                for (int iDs3 = 0; iDs3 < 3; iDs3++){
                    Element ds3 = new Element("DS3");
                    ds3.appendChild("ds3 | " + generateRandomString(12));
                    sl.appendChild(ds3);
                }
                Element czab = new Element("C_ZAB");
                czab.appendChild("czab | " + generateRandomString(10));
                sl.appendChild(czab);
                Element dn = new Element("DN");
                dn.appendChild("dn | " + random.nextInt(4));
                sl.appendChild(dn);
                for (int iCodemes1 = 0; iCodemes1 < 2; iCodemes1++){
                    Element codemes1 = new Element("CODE_MES1");
                    codemes1.appendChild("codemes1 | " + random.nextInt(999999));
                    sl.appendChild(codemes1);
                }
                Element codemes2 = new Element("CODE_MES2");
                codemes2.appendChild("codemes2 | " + random.nextInt(9999));
                sl.appendChild(codemes2);
                for (int iKsgkpg = 0; iKsgkpg < 3; iKsgkpg++){
                    Element ksgkpg = new Element("KSG_KPG");
                    Element nksg = new Element("N_KSG");
                    nksg.appendChild("nksg  | " + random.nextInt(99));
                    ksgkpg.appendChild(nksg);
                    Element verksg = new Element("VER_KSG");
                    verksg.appendChild("verksg | " + random.nextInt(999999));
                    ksgkpg.appendChild(verksg);
                    Element ksgpg = new Element("KSG_PG");
                    ksgpg.appendChild("ksgpg | " + random.nextInt(1));
                    ksgkpg.appendChild(ksgpg);
                    Element nkpg = new Element("N_KPG");
                    nkpg.appendChild("nkpg | " + random.nextInt(9999));
                    ksgkpg.appendChild(nkpg);
                    Element koefz = new Element("KOEF_Z");
                    koefz.appendChild("koef | " + random.nextInt(20));
                    ksgkpg.appendChild(koefz);
                    Element koefup = new Element("KOEF_UP");
                    koefup.appendChild("koefup | " + random.nextInt(99));
                    ksgkpg.appendChild(koefup);
                    Element bztsz = new Element("BZTSZ");
                    bztsz.appendChild("bztsz | " + random.nextInt(30));
                    ksgkpg.appendChild(bztsz);
                    Element koefd = new Element("KOEF_D");
                    koefd.appendChild("koefs | " + random.nextInt(20));
                    ksgkpg.appendChild(koefd);
                    Element koefu = new Element("KOEF_U");
                    koefu.appendChild("koefu | " + random.nextInt(20));
                    ksgkpg.appendChild(koefu);
                    Element crit = new Element("CRIT");
                    crit.appendChild("crit | " + random.nextInt(99999999));
                    ksgkpg.appendChild(crit);
                    Element slk = new Element("SL_K");
                    slk.appendChild("slk | " + random.nextInt(1));
                    ksgkpg.appendChild(slk);
                    Element itsl = new Element("IT_SL");
                    itsl.appendChild("itsl | " + random.nextInt(30));
                    ksgkpg.appendChild(itsl);
                    //SL_KOEF
                    for (int iSlkoef = 0; iSlkoef < 2; iSlkoef++){
                        Element slkoef = new Element("SL_KOEF");
                        Element idsl = new Element("IDSL");
                        idsl.appendChild("idsl | " + random.nextInt(9));
                        slkoef.appendChild(idsl);
                        Element zsl1 = new Element("Z_SL");
                        zsl1.appendChild("zsl1 | " + random.nextInt(9));
                        slkoef.appendChild(zsl1);
                        ksgkpg.appendChild(slkoef);
                    }
                    //!SL_KOEF
                    sl.appendChild(ksgkpg);
                }
                Element reab = new Element("REAB");
                reab.appendChild("reab | " + random.nextInt(2));
                sl.appendChild(reab);
                Element prvs = new Element("PRVS");
                prvs.appendChild("prvs | " + generateRandomString(12));
                sl.appendChild(prvs);
                Element versspec = new Element("VERS_SPEC");
                versspec.appendChild("versspec | " + generateRandomString(8));
                sl.appendChild(versspec);
                Element iddokt = new Element("IDDOKT");
                iddokt.appendChild("iddokt | " + random.nextInt(9999999));
                sl.appendChild(iddokt);
                Element edcol = new Element("ED_COL");
                edcol.appendChild("edcol | " + random.nextInt(9999));
                sl.appendChild(edcol);
                Element tarif = new Element("TARIF");
                tarif.appendChild("tarif | " + random.nextInt(4444));
                sl.appendChild(tarif);
                Element summ = new Element("SUM_M");
                summ.appendChild("summ | " + random.nextInt(9999999));
                sl.appendChild(summ);
                for (int iLekpr = 0; iLekpr < 2; iLekpr++){
                    Element lekpr = new Element("LEK_PR");
                    Element datainj = new Element("DATE_INJ");
                    datainj.appendChild("datainj | " + random.nextInt(999999));
                    lekpr.appendChild(datainj);
                    Element codesh = new Element("CODE_SH");
                    codesh.appendChild("cadesh | " + random.nextInt(999));
                    lekpr.appendChild(codesh);
                    Element regnum = new Element("REGNUM");
                    regnum.appendChild("regnum | " + random.nextInt(999999) );
                    lekpr.appendChild(regnum);
                    Element codemark = new Element("COD_MARK");
                    codemark.appendChild("codemark | " + random.nextInt(999999999));
                    lekpr.appendChild(codemark);
                    //LEK_DOSE
                    Element lekdose = new Element("LEK_DOSE");
                        Element edizm = new Element("ED_IZM");
                        edizm.appendChild("edizm | " + generateRandomString(3));
                        lekdose.appendChild(edizm);
                        Element doseinj = new Element("DOSE_INJ");
                        doseinj.appendChild("doseinj | " + random.nextInt(999999));
                        lekdose.appendChild(doseinj);
                        Element methodinj = new Element("METHOD_INJ");
                        methodinj.appendChild("methodinj | " + generateRandomString(12));
                        Element colinj = new Element("COL_INJ");
                        lekdose.appendChild(methodinj);
                        colinj.appendChild("colinkj | " + random.nextInt(99));
                        lekdose.appendChild(colinj);
                    lekpr.appendChild(lekdose);
                    //!LEK_DOSE
                    sl.appendChild(lekpr);
                }
                for (int iUsl = 0; iUsl < 2; iUsl++){
                    Element usl = new Element("USL");
                    Element idserv = new Element("IDSERV");
                    idserv.appendChild("idserv | " + random.nextInt(99999));
                    usl.appendChild(idserv);
                    Element lpuUsl = new Element("LPU");
                    lpuUsl.appendChild("lpuUsl | " + random.nextInt(9999));
                    usl.appendChild(lpuUsl);
                    Element lpu1Usl = new Element("LPU_1");
                    lpu1Usl.appendChild("lpu1Usl | " + random.nextInt(9999));
                    usl.appendChild(lpu1Usl);
                    Element podrUsl = new Element("PODR");
                    podrUsl.appendChild("podrUsl | " + random.nextInt(99999));
                    usl.appendChild(podrUsl);
                    Element profilUsl = new Element("PROFIL");
                    profilUsl.appendChild("profilUsl | " + generateRandomString(10));
                    usl.appendChild(profilUsl);
                    Element vidvme = new Element("VID_VME");
                    vidvme.appendChild("vidvme | " + generateRandomString(12));
                    usl.appendChild(vidvme);
                    Element detUsl = new Element("DET");
                    detUsl.appendChild("detUsl | " + random.nextInt(1));
                    usl.appendChild(detUsl);
                    Element datein = new Element("DATE_IN");
                    datein.appendChild("datein | " + random.nextInt(9999));
                    usl.appendChild(datein);
                    Element dateout = new Element("DATE_OUT");
                    dateout.appendChild("dateout | " + random.nextInt(9999));
                    usl.appendChild(dateout);
                    Element ds = new Element("DS");
                    ds.appendChild("ds | " + generateRandomString(20));
                    usl.appendChild(ds);
                    Element codeusl = new Element("CODE_USL");
                    codeusl.appendChild("codeusl | " + random.nextInt(999));
                    usl.appendChild(codeusl);
                    Element kolusl = new Element("KOL_USL");
                    kolusl.appendChild("kolusl | " + random.nextInt(9));
                    usl.appendChild(kolusl);
                    Element tarifUsl = new Element("TARIF");
                    tarifUsl.appendChild("tarifUsl | " + random.nextInt(20));
                    usl.appendChild(tarifUsl);
                    Element sumvusl = new Element("SUMV_USL");
                    sumvusl.appendChild("sumvusl | " + random.nextInt(999999));
                    usl.appendChild(sumvusl);
                    //MED_DEV
                    for (int iMeddev = 0; iMeddev < 2; iMeddev++) {
                        Element meddev = new Element("MED_DEV");
                        Element datemed = new Element("DATE_MED");
                        datemed.appendChild("datemed | " + random.nextInt(999999));
                        meddev.appendChild(datemed);
                        Element codemeddev = new Element("CODE_MEDDEV");
                        codemeddev.appendChild("codemeddev | " + random.nextInt(999999));
                        meddev.appendChild(codemeddev);
                        Element numberser = new Element("NUMBER_SER");
                        numberser.appendChild("numberser | " + random.nextInt(999999) + random.nextInt(99999));
                        meddev.appendChild(numberser);
                        usl.appendChild(meddev);
                    }
                    //!MED_DEV
                    //MR_USL_N
                    for (int iMrusln = 0; iMrusln < 2; iMrusln++){
                        Element mrusln = new Element("MR_USL_N");
                        Element mrn = new Element("MR_N");
                        mrn.appendChild("mrn | " + iMrusln + 1);
                        mrusln.appendChild(mrn);
                        Element prvsMrUsln = new Element("PRVS");
                        prvsMrUsln.appendChild("prvsMrUsln | " + generateRandomString(15));
                        mrusln.appendChild(prvsMrUsln);
                        Element codemd = new Element("CODE_MD");
                        codemd.appendChild("codemd | " + random.nextInt(999999));
                        mrusln.appendChild(codemd);
                        usl.appendChild(mrusln);
                    }
                    //!MR_USL_N
                    Element npl = new Element("NPL");
                    npl.appendChild("npl | " + random.nextInt(4));
                    usl.appendChild(npl);
                    Element comentu = new Element("COMENTU");
                    comentu.appendChild("comentu | " + generateRandomString(5));
                    usl.appendChild(comentu);
                    sl.appendChild(usl);
                }
                Element comentsl = new Element("COMENTSL");
                comentsl.appendChild("comentsl | " + generateRandomString(15));
                sl.appendChild(comentsl);
                zsl.appendChild(sl);
            }
            Element idsp = new Element("IDSP");
            idsp.appendChild("idsp | " + random.nextInt(99));
            zsl.appendChild(idsp);
            Element sumv = new Element("SUMV");
            sumv.appendChild("sumv | " + random.nextInt(999999));
            zsl.appendChild(sumv);
            Element oplata = new Element("OPLATA");
            oplata.appendChild("oplata | " + random.nextInt(3));
            zsl.appendChild(oplata);
            Element sump = new Element("SUMP");
            sump.appendChild("sump | " + random.nextInt(999999));
            zsl.appendChild(sump);
            for (int iSank = 0; iSank < 2; iSank++){
                Element sank = new Element("SANK");
                Element scode = new Element("S_CODE");
                scode.appendChild("scode | " + random.nextInt(999));
                sank.appendChild(scode);
                Element ssum = new Element("S_SUM");
                ssum.appendChild("ssum | " + random.nextInt(9999));
                sank.appendChild(ssum);
                Element stip = new Element("S_TIP");
                stip.appendChild("stip | " + random.nextInt(999));
                sank.appendChild(stip);
                for (int iSlid = 0; iSlid < 2; iSlid++){
                    Element slid = new Element("SL_ID");
                    slid.appendChild("slid | " + random.nextInt(99999));
                    sank.appendChild(slid);
                }
                Element sosnt = new Element("S_OSN");
                sosnt.appendChild("sosnt | " + random.nextInt(7777));
                sank.appendChild(sosnt);
                Element dateact = new Element("DATE_ACT");
                dateact.appendChild("dateact | " + random.nextInt(99999));
                sank.appendChild(dateact);
                Element numact = new Element("NUM_ACT");
                numact.appendChild("numact | " + random.nextInt(999999));
                sank.appendChild(numact);
                for (int iCodeexp = 0; iCodeexp < 2; iCodeexp++){
                    Element codeexp = new Element("CODE_EXP");
                    codeexp.appendChild("codeexp | " + random.nextInt(999999));
                    sank.appendChild(codeexp);
                }
                Element scom = new Element("S_COM");
                scom.appendChild("scom | " + generateRandomString(12));
                sank.appendChild(scom);
                Element sist = new Element("S_IST");
                sist.appendChild("sist | " + generateRandomString(11));
                sank.appendChild(sist);
                zsl.appendChild(sank);
            }
            Element sankit = new Element("SANK_IT");
            sankit.appendChild("sankit |" + random.nextInt(999999));
            zsl.appendChild(sankit);
            zap.appendChild(zsl);
            zlList.appendChild(zap);

        }

        Document doc = new Document(zlList);

        try {
//            Files.write(Paths.get("C:\\test.xml"), Collections.singleton(doc.toXML()));
            PrintWriter out = new PrintWriter("C:\\MP.xml");
            out.println(doc.toXML());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //        Document doc = new Document(root);
//        String result = doc.toXML();
//        System.out.println(result);
    }

    private String generateRandomString(int targetStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
