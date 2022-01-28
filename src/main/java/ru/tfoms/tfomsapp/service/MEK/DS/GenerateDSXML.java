package ru.tfoms.tfomsapp.service.MEK.DS;

import nu.xom.Document;
import nu.xom.Element;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateDSXML {

    public void generate(){
        Random random = new Random();
        Element zlList = new Element("ZL_LIST");

        Element zglv = new Element("ZGLV");
            Element version = new Element("VERSION");
            version.appendChild("version | " + generateRandomString(7));
            zglv.appendChild(version);
            Element date = new Element("DATE");
            date.appendChild("date | " + random.nextInt(100000));
            zglv.appendChild(date);
            Element filename = new Element("FILENAME");
            filename.appendChild("filename | " + generateRandomString(10));
            zglv.appendChild(filename);
            Element sdz = new Element("SD_Z");
            sdz.appendChild("sdz | " + random.nextInt(10000));
            zglv.appendChild(sdz);
            Element test = new Element("TEST");
            test.appendChild("TEST | " + random.nextInt(10000));
            zglv.appendChild(test);
            Element verpo = new Element("VER_PO");
            verpo.appendChild("verpo | " + random.nextInt(10000));
            zglv.appendChild(verpo);
        zlList.appendChild(zglv);

        for (int i = 0; i < 10; i++) {
            Element zap = new Element("ZAP");
            Element nzap = new Element("N_ZAP");
            nzap.appendChild("nzap | " + (i + 1));
            zap.appendChild(nzap);
            Element filename1 = new Element("FILENAME1");
            filename1.appendChild("filename1 | " + generateRandomString(12));
            zap.appendChild(filename1);
            //Z_SL
            Element zsl = new Element("Z_SL");
                Element idcase = new Element("IDCASE");
                idcase.appendChild("idcase | " + random.nextInt(999));
                zsl.appendChild(idcase);
                for (int iSl = 0; iSl < 2; iSl++){
                    Element sl = new Element("SL");
                    Element slid = new Element("SL_ID");
                    slid.appendChild("slid | " + random.nextInt(99999));
                    sl.appendChild(slid);
                    for (int iUsl = 0; iUsl < 2; iUsl++){
                        Element usl = new Element("USL");
                        Element idserv = new Element("IDSERV");
                        idserv.appendChild("idserv | " + random.nextInt(99999));
                        usl.appendChild(idserv);
                        Element fzub = new Element("F_ZUB");
                        fzub.appendChild("fzub | " + generateRandomString(12));
                        usl.appendChild(fzub);
                        Element viszub = new Element("VIS_ZUB");
                        viszub.appendChild("viszub | " + random.nextInt(99));
                        usl.appendChild(viszub);
                        Element pranast = new Element("PR_ANAST");
                        pranast.appendChild("pranast | " + random.nextInt(4));
                        usl.appendChild(pranast);

                        sl.appendChild(usl);
                    }
                    Element celobsl = new Element("CEL_OBSL");
                    celobsl.appendChild("celobsl | " + random.nextInt(10));
                    sl.appendChild(celobsl);
                    Element polvis = new Element("POL_VIS");
                    polvis.appendChild("polvis | " + random.nextInt(5));
                    sl.appendChild(polvis);
                    Element homvis = new Element("HOM_VIS");
                    homvis.appendChild("homvis | " + random.nextInt(1));
                    sl.appendChild(homvis);
                    Element specend = new Element("SPEC_END");
                    specend.appendChild("specend | " + random.nextInt(5));
                    sl.appendChild(specend);
                    Element cel1 = new Element("CEL1");
                    cel1.appendChild("cel1 | " + random.nextInt(9));
                    sl.appendChild(cel1);
                    Element typemn = new Element("TYPE_MN");
                    typemn.appendChild("typemn | " + random.nextInt(9));
                    sl.appendChild(typemn);
                    Element obr = new Element("OBR");
                    obr.appendChild("obr" + random.nextInt(1));
                    sl.appendChild(obr);
                    Element timev = new Element("TIMEV");
                    timev.appendChild("timev | " + random.nextInt(9999));
                    sl.appendChild(timev);
                    Element timep = new Element("TIMEP");
                    timep.appendChild("timep | " + random.nextInt(9999));
                    sl.appendChild(timep);
                    Element tl = new Element("TL");
                    tl.appendChild("tl | " + random.nextInt(1));
                    sl.appendChild(tl);
                    Element vidtr = new Element("VIDTR");
                    vidtr.appendChild("vidtr | " + random.nextInt(7));
                    sl.appendChild(vidtr);
                    Element kslpp = new Element("KSLP_P");
                    kslpp.appendChild("kslpp | " + random.nextInt(9));
                    sl.appendChild(kslpp);
                    Element bartel = new Element("BARTEL");
                    bartel.appendChild("bartel | " + random.nextInt(999));
                    sl.appendChild(bartel);
                    Element perspost = new Element("PERS_POST");
                    perspost.appendChild("perspost | " + random.nextInt(4));
                    sl.appendChild(perspost);
                    Element dater1 = new Element("DATE_R1");
                    dater1.appendChild("dater1 | " + random.nextInt(999999));
                    sl.appendChild(dater1);
                    Element dater2 = new Element("DATE_R2");
                    dater2.appendChild("dater2 | " + random.nextInt(999999));
                    sl.appendChild(dater2);
                    Element sost = new Element("SOST");
                    sost.appendChild("sost | " + generateRandomString(12));
                    sl.appendChild(sost);
                    zsl.appendChild(sl);
                }
                Element nprnom = new Element("NPR_NOM");
                nprnom.appendChild("nprnom | " + random.nextInt(9999));
                zsl.appendChild(nprnom);
                Element extr = new Element("EXTR");
                extr.appendChild("extr | " + random.nextInt(2));
                zsl.appendChild(extr);
            zap.appendChild(zsl);
            zlList.appendChild(zap);
        }

        Document doc = new Document(zlList);

        try {
//            Files.write(Paths.get("C:\\test.xml"), Collections.singleton(doc.toXML()));
            PrintWriter out = new PrintWriter("C:\\DS.xml");
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
