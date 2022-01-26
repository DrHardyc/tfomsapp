package ru.tfoms.tfomsapp.service.MEK;

import nu.xom.Document;
import nu.xom.Element;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateTestXML {

    public void generate(){
        Random random = new Random();
        Element zlList = new Element("ZL_LIST");

        Element zglv = new Element("ZGLV");
        Element version = new Element("VERSION");
        Element data = new Element("DATA");
        Element filename = new Element("FILENAME");
        Element sdz = new Element("SD_Z");
        version.appendChild("version | " + generateRandomString(7));
        data.appendChild("data | " + random.nextInt(100000));
        filename.appendChild("filename | " + generateRandomString(10));
        sdz.appendChild("sdz | " + random.nextInt(10000));
        zglv.appendChild(filename);
        zglv.appendChild(data);
        zglv.appendChild(version);
        zglv.appendChild(sdz);
        zlList.appendChild(zglv);

        Element schet = new Element("SCHET");
        Element code = new Element("CODE");
        Element codemo = new Element("CODE_MO");
        Element year = new Element("YEAR");
        Element month = new Element("MONTH");
        Element nschet = new Element("NSCHET");
        Element dschet = new Element("DSCHET");
        Element plat = new Element("PLAT");
        Element summav = new Element("SUMMAV");
        Element coments = new Element("COMENTS");
        Element summap = new Element("SUMMAP");
        Element sankmek = new Element("SANK_MEK");
        Element sankmee = new Element("SANK_MEE");
        Element sankekmp = new Element("SANK_EKMP");
        code.appendChild("code | " + random.nextInt(9999));
        codemo.appendChild("codemo | " + random.nextInt(9999));
        year.appendChild("year | " + random.nextInt(9999));
        month.appendChild("month | " + random.nextInt(99));
        nschet.appendChild("nschet | " + random.nextInt(999999999));
        dschet.appendChild("dschet | " + random.nextInt(999999999));
        plat.appendChild("plat | " + random.nextInt(99999999));
        summav.appendChild("summav | " + random.nextInt(99999) );
        coments.appendChild("coments | " + "");
        summap.appendChild("summap | " + random.nextInt(99999));
        sankmek.appendChild("sankmek | " + random.nextInt(99999));
        sankmee.appendChild("sankmee | " + random.nextInt(99999));
        sankekmp.appendChild("sankekmp | " + random.nextInt(99999));
        schet.appendChild(code);
        schet.appendChild(codemo);
        schet.appendChild(year);
        schet.appendChild(month);
        schet.appendChild(nschet);
        schet.appendChild(dschet);
        schet.appendChild(plat);
        schet.appendChild(summav);
        schet.appendChild(coments);
        schet.appendChild(summap);
        schet.appendChild(sankmek);
        schet.appendChild(sankmee);
        schet.appendChild(sankekmp);
        zlList.appendChild(schet);

        for (int i = 0; i < 10; i++) {
            Element zap = new Element("ZAP");
            Element nzap = new Element("N_ZAP");
            Element prnov = new Element("PR_NOV");
            Element pacient = new Element("PACIENT");
            Element zsl = new Element("Z_SL");
            nzap.appendChild("nzap | " + (i + 1));
            prnov.appendChild("prnov | " + random.nextInt(1));
            //pacient
            Element idpac = new Element("ID_PAC");
            Element vpolis = new Element("VPOLIS");
            Element spolis = new Element("SPOLIS");
            Element npolis = new Element("NPOLIS");
            Element enp = new Element("ENP");
            Element stokato = new Element("ST_OKATO");
            Element smo = new Element("SMO");
            Element smonam = new Element("SMO_NAM");
            Element inv = new Element("INV");
            Element mse = new Element("MSE");
            Element novor = new Element("NOVOR");
            Element vnovd = new Element("VNOV_D");
            idpac.appendChild("idpac | " + random.nextInt(99999999));
            vpolis.appendChild("vpolis | " + generateRandomString(9));
            spolis.appendChild("spolic | " + random.nextInt(999999999));
            npolis.appendChild("npolis | " + random.nextInt(99999999));
            enp.appendChild("enp | " + random.nextInt(9999999));
            stokato.appendChild("stokato | " + random.nextInt(9999999));
            smo.appendChild("smo | " + random.nextInt(99999));
            smonam.appendChild("smo_nam | " + generateRandomString(20));
            inv.appendChild("inv | " + random.nextInt(5));
            mse.appendChild("mse | " + random.nextInt(1));
            novor.appendChild("novor | " + random.nextInt(1));
            vnovd.appendChild("vnovd | " + random.nextInt(99));
            pacient.appendChild(idpac);
            pacient.appendChild(vpolis);
            pacient.appendChild(spolis);
            pacient.appendChild(npolis);
            pacient.appendChild(enp);
            pacient.appendChild(stokato);
            pacient.appendChild(smo);
            pacient.appendChild(smonam);
            pacient.appendChild(inv);
            pacient.appendChild(mse);
            pacient.appendChild(novor);
            pacient.appendChild(vnovd);
            //Z_SL
            Element idcase = new Element("IDCASE");
            Element uslok = new Element("USL_OK");
            Element vidpom = new Element("VIDPOM");
            Element forpom = new Element("FOR_POM");
            Element nprmo = new Element("NPR_MO");
            Element nprdate = new Element("NPR_DATE");
            Element lpu = new Element("LPU");
            Element datez1 = new Element("DATE_Z_1");
            Element datez2 = new Element("DATE_Z_2");
            Element kdz = new Element("KD_Z");
            //VNOV_M
            for (int iVnovm = 0; i < 2; i++){
                Element vnovm = new Element("VNOV_M");
                vnovm.appendChild("vnov | " + random.nextInt(30));
                zsl.appendChild(vnovm);
            }
            //!VNOV_M
            Element rslt = new Element("RSLT");
            Element ishod = new Element("ISHOD");
            //OS_SLUCH
            for (int iSluch = 0; iSluch < 2; iSluch++){
                Element ossluch = new Element("OS_SLUCH");
                ossluch.appendChild("osluch | " + random.nextInt(30));
                zsl.appendChild(ossluch);
            }
            //!OS_SLUCH
            Element vbp = new Element("VB_P");
            //SL
            for (int iSl = 0; iSl < 2; iSl++){
                Element sl = new Element("SL");
                Element slid = new Element("SL_ID");
                Element lpu1 = new Element("LPU_1");
                Element podr = new Element("PODR");
                Element profil = new Element("PROFIL");
                Element profilk = new Element("PROFIL_K");
                Element det = new Element("DET");
                Element pcel = new Element("P_CEL");
                Element nhistory = new Element("NHISTORY");
                Element pper = new Element("P_PER");
                Element date1 = new Element("DATE_1");
                Element date2 = new Element("DATE_2");
                Element kd = new Element("KD");
                Element wei = new Element("WEI");
                Element ds0 = new Element("DS0");
                Element ds1 = new Element("DS1");
                //DS2
                for (int iDs2 = 0; iDs2 < 2; iDs2++){
                    Element ds2 = new Element("DS2");
                    ds2.appendChild("ds2 | " + generateRandomString(18));
                    sl.appendChild(ds2);
                }
                //!DS2
                //DS3
                for (int iDs3 = 0; iDs3 < 3; iDs3++){
                    Element ds3 = new Element("DS3");
                    ds3.appendChild("ds3 | " + generateRandomString(12));
                    sl.appendChild(ds3);
                }
                //!DS3
                Element czab = new Element("C_ZAB");
                Element dn = new Element("DN");
                //CODE_MES1
                for (int iCodemes1 = 0; iCodemes1 < 2; iCodemes1++){
                    Element codemes1 = new Element("CODE_MES1");
                    codemes1.appendChild("codemes1 | " + random.nextInt(999999));
                    sl.appendChild(codemes1);
                }
                //!CODE_MES1
                Element codemes2 = new Element("CODE_MES2");
                //KSG_KPG
                for (int iKsgkpg = 0; iKsgkpg < 3; iKsgkpg++){
                    Element ksgkpg = new Element("KSG_KPG");
                    Element nksg = new Element("N_KSG");
                    Element verksg = new Element("VER_KSG");
                    Element ksgpg = new Element("KSG_PG");
                    Element nkpg = new Element("N_KPG");
                    Element koefz = new Element("KOEF_Z");
                    Element koefup = new Element("KOEF_UP");
                    Element bztsz = new Element("BZTSZ");
                    Element koefd = new Element("KOEF_D");
                    Element koefu = new Element("KOEF_U");
                    Element crit = new Element("CRIT");
                    Element slk = new Element("SL_K");
                    Element itsl = new Element("IT_SL");
                    //SL_KOEF
                    for (int iSlkoef = 0; iSlkoef < 2; iSlkoef++){
                        Element slkoef = new Element("SL_KOEF");
                        Element idsl = new Element("IDSL");
                        Element zsl1 = new Element("Z_SL");
                        idsl.appendChild("idsl | " + random.nextInt(9));
                        zsl1.appendChild("zsl1 | " + random.nextInt(9));
                        slkoef.appendChild(idsl);
                        slkoef.appendChild(zsl1);
                        ksgkpg.appendChild(slkoef);
                    }
                    //!SL_KOEF
                    nksg.appendChild("nksg  | " + random.nextInt(99));
                    verksg.appendChild("verksg | " + random.nextInt(999999));
                    ksgpg.appendChild("ksgpg | " + random.nextInt(1));
                    nkpg.appendChild("nkpg | " + random.nextInt(9999));
                    koefz.appendChild("koef | " + random.nextInt(20));
                    koefup.appendChild("koefup | " + random.nextInt(99));
                    bztsz.appendChild("bztsz | " + random.nextInt(30));
                    koefd.appendChild("koefs | " + random.nextInt(20));
                    koefu.appendChild("koefu | " + random.nextInt(20));
                    crit.appendChild("crit | " + random.nextInt(99999999));
                    slk.appendChild("slk | " + random.nextInt(1));
                    itsl.appendChild("itsl | " + random.nextInt(30));
                    ksgkpg.appendChild(nksg);
                    ksgkpg.appendChild(verksg);
                    ksgkpg.appendChild(ksgpg);
                    ksgkpg.appendChild(nkpg);
                    ksgkpg.appendChild(koefz);
                    ksgkpg.appendChild(koefup);
                    ksgkpg.appendChild(bztsz);
                    ksgkpg.appendChild(koefd);
                    ksgkpg.appendChild(koefu);
                    ksgkpg.appendChild(crit);
                    ksgkpg.appendChild(slk);
                    ksgkpg.appendChild(itsl);

                    sl.appendChild(ksgkpg);
                }

                //!KSG_KPG
                Element reab = new Element("REAB");
                Element prvs = new Element("PRVS");
                Element versspec = new Element("VERS_SPEC");
                Element iddokt = new Element("IDDOKT");
                Element edcol = new Element("ED_COL");
                Element tarif = new Element("TARIF");
                Element summ = new Element("SUM_M");
                //LEK_PR
                for (int iLekpr = 0; iLekpr < 2; iLekpr++){
                    Element lekpr = new Element("LEK_PR");
                    Element datainj = new Element("DATE_INJ");
                    Element codesh = new Element("CODE_SH");
                    Element regnum = new Element("REGNUM");
                    Element codemark = new Element("COD_MARK");
                    //LEK_DOSE
                    Element lekdose = new Element("LEK_DOSE");
                    Element edizm = new Element("ED_IZM");
                    Element doseinj = new Element("DOSE_INJ");
                    Element methodinj = new Element("METHOD_INJ");
                    Element colinj = new Element("COL_INJ");
                    edizm.appendChild("edizm | " + generateRandomString(3));
                    doseinj.appendChild("doseinj | " + random.nextInt(999999));
                    methodinj.appendChild("methodinj | " + generateRandomString(12));
                    colinj.appendChild("colinkj | " + random.nextInt(99));
                    lekdose.appendChild(edizm);
                    lekdose.appendChild(doseinj);
                    lekdose.appendChild(methodinj);
                    lekdose.appendChild(colinj);
                    lekpr.appendChild(lekdose);
                    //!LEK_DOSE
                    datainj.appendChild("datainj | " + random.nextInt(999999));
                    codesh.appendChild("cadesh | " + random.nextInt(999));
                    regnum.appendChild("regnum | " + random.nextInt(999999) );
                    codemark.appendChild("codemark | " + random.nextInt(999999999));
                    lekpr.appendChild(datainj);
                    lekpr.appendChild(codesh);
                    lekpr.appendChild(regnum);
                    lekpr.appendChild(codemark);
                    sl.appendChild(lekpr);
                }
                //!LEK_PR
                //USL
                for (int iUsl = 0; iUsl < 2; iUsl++){
                    Element usl = new Element("USL");
                    Element idserv = new Element("IDSERV");
                    Element lpuUsl = new Element("LPU");
                    Element lpu1Usl = new Element("LPU_1");
                    Element podrUsl = new Element("PODR");
                    Element profilUsl = new Element("PROFIL");
                    Element vidvme = new Element("VID_VME");
                    Element detUsl = new Element("DET");
                    Element datein = new Element("DATE_IN");
                    Element dateout = new Element("DATE_OUT");
                    Element ds = new Element("DS");
                    Element codeusl = new Element("CODE_USL");
                    Element kolusl = new Element("KOL_USL");
                    Element tarifUsl = new Element("TARIF");
                    Element sumvusl = new Element("SUMV_USL");
                    //MED_DEV
                    for (int iMeddev = 0; iMeddev < 2; iMeddev++) {
                        Element meddev = new Element("MED_DEV");
                        Element datemed = new Element("DATE_MED");
                        Element codemeddev = new Element("CODE_MEDDEV");
                        Element numberser = new Element("NUMBER_SER");
                        datemed.appendChild("datemed | " + random.nextInt(999999));
                        codemeddev.appendChild("codemeddev | " + random.nextInt(999999));
                        numberser.appendChild("numberser | " + random.nextInt(999999) + random.nextInt(99999));
                        meddev.appendChild(datemed);
                        meddev.appendChild(codemeddev);
                        meddev.appendChild(numberser);
                        usl.appendChild(meddev);
                    }
                    //!MED_DEV
                    //MR_USL_N
                    for (int iMrusln = 0; iMrusln < 2; iMrusln++){
                        Element mrusln = new Element("MR_USL_N");
                        Element mrn = new Element("MR_N");
                        Element prvsMrUsln = new Element("PRVS");
                        Element codemd = new Element("CODE_MD");
                        mrn.appendChild("mrn | " + iMrusln + 1);
                        prvsMrUsln.appendChild("prvsMrUsln | " + generateRandomString(15));
                        codemd.appendChild("codemd | " + random.nextInt(999999));
                        mrusln.appendChild(mrn);
                        mrusln.appendChild(prvsMrUsln);
                        mrusln.appendChild(codemd);
                        usl.appendChild(mrusln);
                    }
                    //!MR_USL_N
                    Element npl = new Element("NPL");
                    Element comentu = new Element("COMENTU");
                    idserv.appendChild("idserv | " + random.nextInt(99999));
                    lpuUsl.appendChild("lpuUsl | " + random.nextInt(9999));
                    lpu1Usl.appendChild("lpu1Usl | " + random.nextInt(9999));
                    podrUsl.appendChild("podrUsl | " + random.nextInt(99999));
                    profilUsl.appendChild("profilUsl | " + generateRandomString(10));
                    vidvme.appendChild("vidvme | " + generateRandomString(12));
                    detUsl.appendChild("detUsl | " + random.nextInt(1));
                    datein.appendChild("datein | " + random.nextInt(9999));
                    dateout.appendChild("dateout | " + random.nextInt(9999));
                    ds.appendChild("ds | " + generateRandomString(20));
                    codeusl.appendChild("codeusl | " + random.nextInt(999));
                    kolusl.appendChild("kolusl | " + random.nextInt(9));
                    tarifUsl.appendChild("tarifUsl | " + random.nextInt(20));
                    sumvusl.appendChild("sumvusl | " + random.nextInt(999999));
                    npl.appendChild("npl | " + random.nextInt(4));
                    comentu.appendChild("comentu | " + generateRandomString(5));
                    usl.appendChild(idserv);
                    usl.appendChild(lpuUsl);
                    usl.appendChild(lpu1Usl);
                    usl.appendChild(podrUsl);
                    usl.appendChild(profilUsl);
                    usl.appendChild(vidvme);
                    usl.appendChild(detUsl);
                    usl.appendChild(datein);
                    usl.appendChild(dateout);
                    usl.appendChild(ds);
                    usl.appendChild(codeusl);
                    usl.appendChild(kolusl);
                    usl.appendChild(tarifUsl);
                    usl.appendChild(sumvusl);
                    usl.appendChild(npl);
                    usl.appendChild(comentu);

                    sl.appendChild(usl);
                }
                //!USL
                Element comentsl = new Element("COMENTSL");
                slid.appendChild("slid | " + random.nextInt(99999));
                lpu1.appendChild("lpu1 | " + random.nextInt(999));
                podr.appendChild("podr | " + random.nextInt(9999));
                profil.appendChild("profil |" + random.nextInt(4));
                profilk.appendChild("profilk | " + random.nextInt(4));
                det.appendChild("det | " + random.nextInt(1));
                pcel.appendChild("pcel | " + generateRandomString(20));
                nhistory.appendChild("nhistory | " + random.nextInt(9));
                pper.appendChild("pper | " + random.nextInt(10));
                date1.appendChild("date1 | " + random.nextInt(999999));
                date2.appendChild("date2 | " + random.nextInt(999999));
                kd.appendChild("kd | " + random.nextInt(365));
                wei.appendChild("wei | " + random.nextInt(200));
                ds0.appendChild("ds0 | " + generateRandomString(20));
                ds1.appendChild("ds1 | " + generateRandomString(20));
                czab.appendChild("czab | " + generateRandomString(10));
                dn.appendChild("dn | " + random.nextInt(4));
                codemes2.appendChild("codemes2 | " + random.nextInt(9999));
                reab.appendChild("reab | " + random.nextInt(2));
                prvs.appendChild("prvs | " + generateRandomString(12));
                versspec.appendChild("versspec | " + generateRandomString(8));
                iddokt.appendChild("iddokt | " + random.nextInt(9999999));
                edcol.appendChild("edcol | " + random.nextInt(9999));
                tarif.appendChild("tarif | " + random.nextInt(4444));
                summ.appendChild("summ | " + random.nextInt(9999999));
                comentsl.appendChild("comentsl | " + generateRandomString(15));

                sl.appendChild(slid);
                sl.appendChild(lpu1);
                sl.appendChild(podr);
                sl.appendChild(profil);
                sl.appendChild(profilk);
                sl.appendChild(det);
                sl.appendChild(pcel);
                sl.appendChild(nhistory);
                sl.appendChild(pper);
                sl.appendChild(date1);
                sl.appendChild(date2);
                sl.appendChild(kd);
                sl.appendChild(wei);
                sl.appendChild(ds0);
                sl.appendChild(ds1);
                sl.appendChild(czab);
                sl.appendChild(dn);
                sl.appendChild(codemes2);
                sl.appendChild(reab);
                sl.appendChild(prvs);
                sl.appendChild(versspec);
                sl.appendChild(iddokt);
                sl.appendChild(edcol);
                sl.appendChild(tarif);
                sl.appendChild(summ);
                sl.appendChild(comentsl);

                zsl.appendChild(sl);
            }

            //!SL
            Element idsp = new Element("IDSP");
            Element sumv = new Element("SUMV");
            Element oplata = new Element("OPLATA");
            Element sump = new Element("SUMP");
            //SANK
            for (int iSank = 0; iSank < 2; iSank++){
                Element sank = new Element("SANK");
                Element scode = new Element("S_CODE");
                Element ssum = new Element("S_SUM");
                Element stip = new Element("S_TIP");
                //SL_ID
                for (int iSlid = 0; iSlid < 2; iSlid++){
                    Element slid = new Element("SL_ID");
                    slid.appendChild("slid | " + random.nextInt(99999));
                    sank.appendChild(slid);
                }
                //!SL_ID
                Element sosnt = new Element("S_OSN");
                Element dateact = new Element("DATE_ACT");
                Element numact = new Element("NUM_ACT");
                //CODE_EXP
                for (int iCodeexp = 0; iCodeexp < 2; iCodeexp++){
                    Element codeexp = new Element("CODE_EXP");
                    codeexp.appendChild("codeexp | " + random.nextInt(999999));
                    sank.appendChild(codeexp);
                }

                //!CODE_EXP
                Element scom = new Element("S_COM");
                Element sist = new Element("S_IST");
                scode.appendChild("scode | " + random.nextInt(999));
                ssum.appendChild("ssum | " + random.nextInt(9999));
                stip.appendChild("stip | " + random.nextInt(999));
                sosnt.appendChild("sosnt | " + random.nextInt(7777));
                dateact.appendChild("dateact | " + random.nextInt(99999));
                numact.appendChild("numact | " + random.nextInt(999999));
                scom.appendChild("scom | " + generateRandomString(12));
                sist.appendChild("sist | " + generateRandomString(11));
                sank.appendChild(scode);
                sank.appendChild(ssum);
                sank.appendChild(stip);
                sank.appendChild(sosnt);
                sank.appendChild(dateact);
                sank.appendChild(numact);
                sank.appendChild(scom);
                sank.appendChild(sist);

                zsl.appendChild(sank);
            }

            //!SANK
            Element sankit = new Element("SANK_IT");
            idcase.appendChild("idcase | " + random.nextInt(999));
            uslok.appendChild("uslok | " + generateRandomString(10));
            vidpom.appendChild("vidpom | " + generateRandomString(10));
            forpom.appendChild("forpom | " + generateRandomString(12));
            nprmo.appendChild("nprmo | " + random.nextInt(4));
            nprdate.appendChild("npdate | " + random.nextInt(4));
            lpu.appendChild("lpu | " + random.nextInt(4));
            datez1.appendChild("datez1 | " + random.nextInt(999999));
            datez2.appendChild("datez2 | " + random.nextInt(999999));
            kdz.appendChild("kdz | " + random.nextInt(150));
            rslt.appendChild("rslt | " + random.nextInt(999));
            ishod.appendChild("ishod | " + random.nextInt(999));
            vbp.appendChild("vbp | " + random.nextInt(1));
            idsp.appendChild("idsp | " + random.nextInt(99));
            sumv.appendChild("sumv | " + random.nextInt(999999));
            oplata.appendChild("oplata | " + random.nextInt(3));
            sump.appendChild("sump | " + random.nextInt(999999));
            sankit.appendChild("sankit |" + random.nextInt(999999));
            zsl.appendChild(idcase);
            zsl.appendChild(uslok);
            zsl.appendChild(vidpom);
            zsl.appendChild(forpom);
            zsl.appendChild(nprmo);
            zsl.appendChild(nprdate);
            zsl.appendChild(lpu);
            zsl.appendChild(datez1);
            zsl.appendChild(datez2);
            zsl.appendChild(kdz);
            zsl.appendChild(rslt);
            zsl.appendChild(ishod);
            zsl.appendChild(vbp);
            zsl.appendChild(idsp);
            zsl.appendChild(sumv);
            zsl.appendChild(oplata);
            zsl.appendChild(sump);
            zsl.appendChild(sankit);

            zap.appendChild(zsl);
            zap.appendChild(nzap);
            zap.appendChild(prnov);
            zap.appendChild(pacient);

            zlList.appendChild(zap);

        }

        Document doc = new Document(zlList);

        try {
//            Files.write(Paths.get("C:\\test.xml"), Collections.singleton(doc.toXML()));
            PrintWriter out = new PrintWriter("C:\\test.xml");
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
