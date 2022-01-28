package ru.tfoms.tfomsapp.service.MEK.MPD;

import nu.xom.Document;
import nu.xom.Element;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateMPDXML {

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
            Element disp = new Element("DISP");
            disp.appendChild("disp | " + generateRandomString(10));
            schet.appendChild(disp);
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
                Element novor = new Element("NOVOR");
                novor.appendChild("novor | " + random.nextInt(1));
                pacient.appendChild(novor);
            zap.appendChild(pacient);
            //Z_SL
            Element zsl = new Element("Z_SL");
                Element idcase = new Element("IDCASE");
                idcase.appendChild("idcase | " + random.nextInt(999));
                zsl.appendChild(idcase);
                Element vidpom = new Element("VIDPOM");
                vidpom.appendChild("vidpom | " + generateRandomString(10));
                zsl.appendChild(vidpom);
                Element lpu = new Element("LPU");
                lpu.appendChild("lpu | " + random.nextInt(4));
                zsl.appendChild(lpu);
                Element vbr = new Element("VBR");
                vbr.appendChild("vbr | " + random.nextInt(1));
                zsl.appendChild(vbr);
                Element datez1 = new Element("DATE_Z_1");
                datez1.appendChild("datez1 | " + random.nextInt(999999));
                zsl.appendChild(datez1);
                Element datez2 = new Element("DATE_Z_2");
                datez2.appendChild("datez2 | " + random.nextInt(999999));
                zsl.appendChild(datez2);
                Element potk = new Element("P_OTK");
                potk.appendChild("potk | " + random.nextInt(1));
                zsl.appendChild(potk);
                Element rsltd = new Element("RSLT_D");
                rsltd.appendChild("rsltd | " + random.nextInt(4));
                zsl.appendChild(rsltd);
                for (int iSluch = 0; iSluch < 2; iSluch++){
                    Element ossluch = new Element("OS_SLUCH");
                    ossluch.appendChild("osluch | " + random.nextInt(30));
                    zsl.appendChild(ossluch);
                }
                for (int iSl = 0; iSl < 2; iSl++){
                    Element sl = new Element("SL");
                    Element slid = new Element("SL_ID");
                    slid.appendChild("slid | " + random.nextInt(99999));
                    sl.appendChild(slid);
                    Element lpu1 = new Element("LPU_1");
                    lpu1.appendChild("lpu1 | " + random.nextInt(999));
                    sl.appendChild(lpu1);
                    Element nhistory = new Element("NHISTORY");
                    nhistory.appendChild("nhistory | " + random.nextInt(9));
                    sl.appendChild(nhistory);
                    Element date1 = new Element("DATE_1");
                    date1.appendChild("date1 | " + random.nextInt(999999));
                    sl.appendChild(date1);
                    Element date2 = new Element("DATE_2");
                    date2.appendChild("date2 | " + random.nextInt(999999));
                    sl.appendChild(date2);
                    Element ds1 = new Element("DS1");
                    ds1.appendChild("ds1 | " + generateRandomString(20));
                    sl.appendChild(ds1);
                    Element ds1pr = new Element("DS1_PR");
                    ds1pr.appendChild("ds1pr | " + random.nextInt(5));
                    sl.appendChild(ds1pr);
                    Element dsonk = new Element("DS_ONK");
                    dsonk.appendChild("dsonk | " + random.nextInt(9));
                    sl.appendChild(dsonk);
                    Element prdn = new Element("PR_D_N");
                    prdn.appendChild("prdn | " + random.nextInt(4));
                    sl.appendChild(prdn);
                    for (int iDs2n = 0; iDs2n < 2; iDs2n++) {
                        Element ds2n = new Element("DS2_N");
                        Element ds2ds2n = new Element("DS2");
                        ds2ds2n.appendChild("ds2ds2n | " + random.nextInt(99999));
                        ds2n.appendChild(ds2ds2n);
                        Element ds2pr = new Element("DS2_PR");
                        ds2pr.appendChild("ds2pr | " + generateRandomString(10));
                        ds2n.appendChild(ds2pr);
                        Element prds2n = new Element("PR_DS2_N");
                        prds2n.appendChild("prds2n | " + generateRandomString(10));
                        ds2n.appendChild(prds2n);
                        sl.appendChild(ds2n);
                    }
                    for (int iNaz = 0; iNaz < 3; iNaz++){
                        Element naz = new Element("NAZ");
                        Element nazn = new Element("NAZ_N");
                        nazn.appendChild("nazn | " + random.nextInt(9999));
                        naz.appendChild(nazn);
                        Element nazr = new Element("NAZ_R");
                        nazr.appendChild("nazr | " + random.nextInt(99));
                        naz.appendChild(nazr);
                        Element naziddokt = new Element("NAZ_IDDOKT");
                        naziddokt.appendChild("naziddokt | " + random.nextInt(99999));
                        naz.appendChild(naziddokt);
                        Element nazv = new Element("NAZ_V");
                        nazv.appendChild("nazv | " + generateRandomString(12));
                        naz.appendChild(nazv);
                        Element nazusl = new Element("NAZ_USL");
                        nazusl.appendChild("nazusl | " + generateRandomString(12));
                        naz.appendChild(nazusl);
                        Element naprdate = new Element("NAPR_DATE");
                        naprdate.appendChild("naprdate | " + random.nextInt(999999));
                        naz.appendChild(naprdate);
                        Element naprmo = new Element("NAPR_MO");
                        naprmo.appendChild("naprmo | " + random.nextInt(99));
                        naz.appendChild(naprmo);
                        Element nazpmp = new Element("NAZ_PMP");
                        nazpmp.appendChild("nazpmp | " + generateRandomString(9));
                        naz.appendChild(nazpmp);
                        Element nazpk = new Element("NAZ_PK");
                        nazpk.appendChild("nazpk | " + generateRandomString(10));
                        naz.appendChild(nazpk);
                        sl.appendChild(naz);
                    }
                    Element edcol = new Element("ED_COL");
                    edcol.appendChild("edcol | " + random.nextInt(9999));
                    sl.appendChild(edcol);
                    Element tarif = new Element("TARIF");
                    tarif.appendChild("tarif | " + random.nextInt(4444));
                    sl.appendChild(tarif);
                    Element summ = new Element("SUM_M");
                    summ.appendChild("summ | " + random.nextInt(9999999));
                    sl.appendChild(summ);
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
                        Element datein = new Element("DATE_IN");
                        datein.appendChild("datein | " + random.nextInt(9999));
                        usl.appendChild(datein);
                        Element dateout = new Element("DATE_OUT");
                        dateout.appendChild("dateout | " + random.nextInt(9999));
                        usl.appendChild(dateout);
                        Element potkusl = new Element("P_OTK");
                        potkusl.appendChild("potkusl | " + random.nextInt(9));
                        usl.appendChild(potkusl);
                        Element codeusl = new Element("CODE_USL");
                        codeusl.appendChild("codeusl | " + random.nextInt(9999));
                        usl.appendChild(codeusl);
                        Element tarifUsl = new Element("TARIF");
                        tarifUsl.appendChild("tarifUsl | " + random.nextInt(20));
                        usl.appendChild(tarifUsl);
                        Element sumvusl = new Element("SUMV_USL");
                        sumvusl.appendChild("sumvusl | " + random.nextInt(999999));
                        usl.appendChild(sumvusl);
                        Element mrusln = new Element("MR_USL_N");
                            Element mrn = new Element("MR_N");
                            mrn.appendChild("mrn | " + random.nextInt(12));
                            mrusln.appendChild(mrn);
                            Element prvs = new Element("PRVS");
                            prvs.appendChild("prvs | " + random.nextInt(999));
                            mrusln.appendChild(prvs);
                            Element codemd = new Element("CODE_MD");
                            codemd.appendChild("codemd | " + random.nextInt(12));
                            mrusln.appendChild(codemd);
                        usl.appendChild(mrusln);
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
            PrintWriter out = new PrintWriter("C:\\MPD.xml");
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
