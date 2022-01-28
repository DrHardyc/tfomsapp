package ru.tfoms.tfomsapp.service.MEK.PD;

import nu.xom.Document;
import nu.xom.Element;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GeneratePDXML {

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
        Element filename1 = new Element("FILENAME1");
        filename1.appendChild("filename1 | " + random.nextInt(10000));
        zglv.appendChild(filename1);
        zlList.appendChild(zglv);

        for (int iPers = 0; iPers < 5; iPers++) {
            Element pers = new Element("PERS");
            Element idpac = new Element("ID_PAC");
            idpac.appendChild("idpac | " + random.nextInt(99999));
            pers.appendChild(idpac);
            Element fam = new Element("FAM");
            fam.appendChild("fam | " + generateRandomString(7));
            pers.appendChild(fam);
            Element im = new Element("IM");
            im.appendChild("im | " + generateRandomString(6));
            pers.appendChild(im);
            Element ot = new Element("OT");
            ot.appendChild("ot | " + generateRandomString(9));
            pers.appendChild(ot);
            Element w = new Element("W");
            w.appendChild("w | " + generateRandomString(1));
            pers.appendChild(w);
            Element dr = new Element("DR");
            dr.appendChild("dr | " + generateRandomString(7));
            pers.appendChild(dr);
            for (int iDost = 0; iDost < 2; iDost++) {
                Element dost = new Element("DOST");
                dost.appendChild("dost | " + random.nextInt(9999));
                pers.appendChild(dost);
            }
            Element tel = new Element("TEL");
            tel.appendChild("tel | " + random.nextInt(999999999));
            pers.appendChild(tel);
            Element famp = new Element("FAM_P");
            famp.appendChild("famp | " + generateRandomString(7));
            pers.appendChild(famp);
            Element imp = new Element("IM_P");
            imp.appendChild("imp | " + generateRandomString(7));
            pers.appendChild(imp);
            Element otp = new Element("OT_P");
            otp.appendChild("otp | " + generateRandomString(7));
            pers.appendChild(otp);
            Element wp = new Element("W_P");
            wp.appendChild("wp | " + random.nextInt(1));
            pers.appendChild(wp);
            Element drp = new Element("DR_P");
            drp.appendChild("drp | " + random.nextInt(999999));
            pers.appendChild(drp);
            for (int iDostp = 0; iDostp < 2; iDostp++) {
                Element dostp = new Element("DOST_P");
                dostp.appendChild("dostp | " + random.nextInt(9999));
                pers.appendChild(dostp);
            }
            Element mr = new Element("MR");
            mr.appendChild("mr | " + generateRandomString(12));
            pers.appendChild(mr);
            Element doctype = new Element("DOCTYPE");
            doctype.appendChild("doctype | " + random.nextInt(99));
            pers.appendChild(doctype);
            Element docser = new Element("DOCSER");
            docser.appendChild("docser | " + random.nextInt(9999));
            pers.appendChild(docser);
            Element docnum = new Element("DOCNUM");
            docnum.appendChild("docnum | " + random.nextInt(999999));
            pers.appendChild(docnum);
            Element docdate = new Element("DOCDATE");
            docdate.appendChild("docdate | " + random.nextInt(999999));
            pers.appendChild(docdate);
            Element docorg = new Element("DOCORG");
            docorg.appendChild("docorg | " + generateRandomString(15));
            pers.appendChild(docorg);
            Element snils = new Element("SNILS");
            snils.appendChild("snils | " + random.nextInt(99999999));
            pers.appendChild(snils);
            Element okatog = new Element("OKATOG");
            okatog.appendChild("okatog | " + random.nextInt(9999999));
            pers.appendChild(okatog);
            Element okatop = new Element("OKATOP");
            okatop.appendChild("okatop | " + random.nextInt(9999999));
            pers.appendChild(okatop);
            Element comentp = new Element("COMENTP");
            comentp.appendChild("comentp | " + generateRandomString(12));
            pers.appendChild(comentp);
            zlList.appendChild(pers);
        }


        Document doc = new Document(zlList);

        try {
//            Files.write(Paths.get("C:\\test.xml"), Collections.singleton(doc.toXML()));
            PrintWriter out = new PrintWriter("C:\\PD.xml");
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
