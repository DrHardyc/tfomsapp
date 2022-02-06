package ru.tfoms.tfomsapp.service.MEK.VMP;

import nu.xom.Document;
import nu.xom.Element;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateVMPXML {

    public void generate(String dirName){
        Random random = new Random();
        Element zlList = new Element("ZL_LIST");

        Element zglv = new Element("ZGLV");
        Element version = new Element("VERSION");
        version.appendChild("version | " + generateRandomString(7));
        zglv.appendChild(version);
        Element date = new Element("DATE");
        date.appendChild("data | " + random.nextInt(100000));
        zglv.appendChild(date);
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
            //pacient
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
            Element stokato = new Element("ST_OKATO");
            stokato.appendChild("stokato | " + random.nextInt(9999999));
            pacient.appendChild(stokato);
            Element smo = new Element("SMO");
            smo.appendChild("smo | " + random.nextInt(99999));
            pacient.appendChild(smo);
            Element smoogrn = new Element("SMO_OGRN");
            smoogrn.appendChild("smoogrn |" + random.nextInt(99999999));
            pacient.appendChild(smoogrn);
            Element smook = new Element("SMO_OK");
            smook.appendChild("smook | " + random.nextInt(99999));
            Element smonam = new Element("SMO_NAM");
            pacient.appendChild(smook);
            smonam.appendChild("smonam | " + generateRandomString(20));
            pacient.appendChild(smonam);
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
                vnovm.appendChild("vnovm | " + random.nextInt(30));
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
            zsl.appendChild(vbp);
            vbp.appendChild("vbp | " + random.nextInt(1));
            for (int iSl = 0; iSl < 2; iSl++){
                Element sl = new Element("SL");
                Element slid = new Element("SL_ID");
                slid.appendChild("slid | " + random.nextInt(99999));
                sl.appendChild(slid);
                Element vidhmp = new Element("VID_HMP");
                vidhmp.appendChild("vidhmp | " + generateRandomString(9999));
                sl.appendChild(vidhmp);
                Element metodhmp = new Element("METOD_HMP");
                metodhmp.appendChild("metodhmp | " + generateRandomString(20));
                sl.appendChild(metodhmp);
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
                Element tald = new Element("TAL_D");
                tald.appendChild("tald | " + random.nextInt(99999));
                sl.appendChild(tald);
                Element talnum = new Element("TAL_NUM");
                talnum.appendChild("talnum | " + random.nextInt(9999));
                sl.appendChild(talnum);
                Element talp = new Element("TAL_P");
                talp.appendChild("talp |" + random.nextInt(999999));
                sl.appendChild(talp);
                Element nhistory = new Element("NHISTORY");
                nhistory.appendChild("nhistory | " + random.nextInt(9));
                sl.appendChild(nhistory);
                Element date1 = new Element("DATE_1");
                date1.appendChild("date1 | " + random.nextInt(999999));
                sl.appendChild(date1);
                Element date2 = new Element("DATE_2");
                date2.appendChild("date2 | " + random.nextInt(999999));
                sl.appendChild(date2);
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
                Element dsonk = new Element("DS_ONK");
                dsonk.appendChild("dsonk | " + generateRandomString(10));
                sl.appendChild(dsonk);
                for (int iCodemes1 = 0; iCodemes1 < 2; iCodemes1++){
                    Element codemes1 = new Element("CODE_MES1");
                    codemes1.appendChild("codemes1 | " + random.nextInt(999999));
                    sl.appendChild(codemes1);
                }
                Element codemes2 = new Element("CODE_MES2");
                codemes2.appendChild("codemes2 | " + random.nextInt(9999));
                sl.appendChild(codemes2);
                for (int iNapr = 0; iNapr < 2; iNapr++) {
                    Element napr = new Element("NAPR");
                    Element naprdate = new Element("NAPR_DATE");
                    naprdate.appendChild("naprdate | " + random.nextInt(999999));
                    napr.appendChild(naprdate);
                    Element naprmo = new Element("NAPR_MO");
                    naprmo.appendChild("naprmo | " + random.nextInt(9999));
                    napr.appendChild(naprmo);
                    Element naprv = new Element("NAPR_V");
                    naprv.appendChild("naprv | " + generateRandomString(15));
                    napr.appendChild(naprv);
                    Element metissl = new Element("MET_ISSL");
                    metissl.appendChild("metissl | " + generateRandomString(17));
                    napr.appendChild(metissl);
                    Element naprusl = new Element("NAPR_USL");
                    naprusl.appendChild("naprusl | " + generateRandomString(15));
                    napr.appendChild(naprusl);
                    sl.appendChild(napr);
                }
                for (int iCons = 0; iCons < 2; iCons++){
                    Element cons = new Element("CONS");
                    Element prcons = new Element("PR_CONS");
                    prcons.appendChild("prcons | " + generateRandomString(10));
                    cons.appendChild(prcons);
                    Element dtcons = new Element("DT_CONS");
                    dtcons.appendChild("dtcons | " + random.nextInt(999999));
                    cons.appendChild(dtcons);
                    sl.appendChild(cons);
                }
                Element onksl = new Element("ONK_SL");
                    Element ds1t = new Element("DS1_T");
                    ds1t.appendChild("ds1t | " + generateRandomString(10));
                    onksl.appendChild(ds1t);
                    Element stad = new Element("STAD");
                    stad.appendChild("stad | " + random.nextInt(9));
                    onksl.appendChild(stad);
                    Element onkt = new Element("ONK_T");
                    onkt.appendChild("onkt | " + random.nextInt(99));
                    onksl.appendChild(onkt);
                    Element onkn = new Element("ONK_N");
                    onkn.appendChild("onkn | " + random.nextInt(999));
                    onksl.appendChild(onkn);
                    Element onkm = new Element("ONK_M");
                    onkm.appendChild("onkm | " + generateRandomString(10));
                    onksl.appendChild(onkm);
                    Element mtstz = new Element("MTSTZ");
                    mtstz.appendChild("mtstz | " + generateRandomString(7));
                    onksl.appendChild(mtstz);
                    Element sod = new Element("SOD");
                    sod.appendChild("sod | " + random.nextInt(9999));
                    onksl.appendChild(sod);
                    Element kfr = new Element("K_FR");
                    kfr.appendChild("kfr | " + random.nextInt(9999));
                    onksl.appendChild(kfr);
                    Element weionkusl = new Element("WEI");
                    weionkusl.appendChild("wei | " + random.nextInt(99));
                    onksl.appendChild(weionkusl);
                    Element hei = new Element("HEI");
                    hei.appendChild("hei |" + random.nextInt(9999));
                    onksl.appendChild(hei);
                    Element bsa = new Element("BSA");
                    bsa.appendChild("bsa | " + random.nextInt(999));
                    onksl.appendChild(bsa);
                    for (int iBdiag = 0; iBdiag < 2; iBdiag++){
                        Element bdiag = new Element("B_DIAG");
                        Element diagdate = new Element("DIAG_DATE");
                        diagdate.appendChild("diagdate | " + random.nextInt(999999));
                        bdiag.appendChild(diagdate);
                        Element diagtip = new Element("DIAG_TIP");
                        diagtip.appendChild("diagtip | " + random.nextInt(9999));
                        bdiag.appendChild(diagtip);
                        Element diagcode = new Element("DIAG_CODE");
                        diagcode.appendChild("diagcode | " + random.nextInt(99999));
                        bdiag.appendChild(diagcode);
                        Element diagrslt = new Element("DIAG_RSLT");
                        diagrslt.appendChild("diagrslt | " + generateRandomString(12));
                        bdiag.appendChild(diagrslt);
                        Element recrslt = new Element("REC_RSLT");
                        recrslt.appendChild("recrslt | " + generateRandomString(999));
                        bdiag.appendChild(recrslt);
                        onksl.appendChild(bdiag);
                    }
                    for (int iBprot = 0; iBprot < 2; iBprot++){
                        Element bprot = new Element("B_PROT");
                        Element prot = new Element("PROT");
                        prot.appendChild("prot | " + random.nextInt(999));
                        bprot.appendChild(prot);
                        Element dprot = new Element("D_PROT");
                        dprot.appendChild("dprot | " + random.nextInt(999999));
                        bprot.appendChild(dprot);
                        onksl.appendChild(bprot);
                    }
                    for (int iOnkusl = 0; iOnkusl < 2; iOnkusl++){
                        Element onkusl = new Element("ONK_USL");
                        Element usltip = new Element("USL_TIP");
                        usltip.appendChild("usltip | " + generateRandomString(9));
                        onkusl.appendChild(usltip);
                        Element hirtip = new Element("HIR_TIP");
                        hirtip.appendChild("hirtip | " + generateRandomString(8));
                        onkusl.appendChild(hirtip);
                        Element lektipl = new Element("LEK_TIP_L");
                        lektipl.appendChild("lektipl | " + generateRandomString(9));
                        onkusl.appendChild(lektipl);
                        Element lektipv = new Element("LEK_TIP_V");
                        lektipv.appendChild("lektipv | " + generateRandomString(12));
                        onkusl.appendChild(lektipv);
                        for (int iLekpr = 0; iLekpr < 2; iLekpr++){
                            Element lekpr = new Element("LEK_PR");
                            Element regnum = new Element("REGNUM");
                            regnum.appendChild("regnum | " + random.nextInt(999999));
                            lekpr.appendChild(regnum);
                            Element codesh = new Element("CODE_SH");
                            codesh.appendChild("codesh | " + random.nextInt(99999));
                            lekpr.appendChild(codesh);
                            for(int iDateinj = 0; iDateinj < 2; iDateinj++){
                                Element dateinj = new Element("DATE_INJ");
                                dateinj.appendChild("dateinj | " + random.nextInt(999999));
                                lekpr.appendChild(dateinj);
                            }
                            onkusl.appendChild(lekpr);
                        }
                        Element pptr = new Element("PPTR");
                        pptr.appendChild("pptr | " + generateRandomString(8));
                        onkusl.appendChild(pptr);
                        Element luchtip = new Element("LUCH_TIP");
                        luchtip.appendChild("luchtip | " + generateRandomString(11));
                        onkusl.appendChild(luchtip);
                        onksl.appendChild(onkusl);
                    }
                sl.appendChild(onksl);
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
                for (int iUsl = 0; iUsl < 2; iUsl++){
                    Element usl = new Element("USL");
                    Element idserv = new Element("IDSERV");
                    idserv.appendChild("idserv | " + random.nextInt(99999));
                    usl.appendChild(idserv);
                    Element lpuUsl = new Element("LPU");
                    lpuUsl.appendChild("lpuUsl | " + random.nextInt(9999));
                    usl.appendChild(lpuUsl);
                    Element lpu1Uslusl = new Element("LPU_1");
                    lpu1Uslusl.appendChild("lpu1Usl | " + random.nextInt(9999));
                    usl.appendChild(lpu1Uslusl);
                    Element podrUsl = new Element("PODR");
                    podrUsl.appendChild("podrUsl | " + random.nextInt(99999));
                    usl.appendChild(podrUsl);
                    Element profilUsl = new Element("PROFIL");
                    profilUsl.appendChild("profilUsl | " + generateRandomString(10));
                    usl.appendChild(profilUsl);
                    Element vidvmeusl = new Element("VID_VME");
                    vidvmeusl.appendChild("vidvme | " + generateRandomString(12));
                    usl.appendChild(vidvmeusl);
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
                    Element prvsusl = new Element("PRVS");
                    prvsusl.appendChild("prvsusl | " + generateRandomString(10));
                    usl.appendChild(prvsusl);
                    Element codemdusl = new Element("CODE_MD");
                    codemdusl.appendChild("codemd | " + random.nextInt(9999));
                    usl.appendChild(codemdusl);
                    Element comentu = new Element("COMENTU");
                    comentu.appendChild("comentu | " + generateRandomString(5));
                    usl.appendChild(comentu);
                    sl.appendChild(usl);
                }
                sl.appendChild(summ);
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
            PrintWriter out = new PrintWriter(dirName);
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
