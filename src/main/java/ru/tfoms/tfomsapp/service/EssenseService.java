package ru.tfoms.tfomsapp.service;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.progressbar.ProgressBar;
import nu.xom.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@Service
public class EssenseService {

    private final int [] RSLT200 = {407, 408, 409, 410, 411, 412, 413, 414, 417};
    private final int [] RSLT220 = {202, 203, 204, 205, 206, 207, 208};
    private final int [] RSLT211 = {102, 103, 104, 105, 106, 109, 108,107, 110};
    private final int [] RSLT331 = {105, 106};
    private final int [] RSLT341 = {205, 206};
    private final int [] RSLT361 = {405, 406};

    public void ExamEssense(InputStream resourceAsStream, ProgressBar progressBar){
        Document doc = null;
        try {
            Builder parser = new Builder(false);
            doc = parser.build(resourceAsStream);
            Element html = doc.getRootElement();
            Element head = html.getFirstChildElement("Документ");
            if (head != null){
                String docCount = html.getAttributeValue("КолДок");
                return;
            }
            head = html.getFirstChildElement("ZGLV");
            if (head != null){
                Elements zl_lists = html.getChildElements();
                for (Element zl_list : zl_lists){
                    if (zl_list.getLocalName().equals("ZGLV")){
                        progressBar.setMax(Double.parseDouble(getChildByName(zl_list, "SD_Z").getValue()));
                    }
                    if (zl_list.getLocalName().equals("ZAP")){
                        String nomZap = getChildByName(zl_list, "N_ZAP").getValue();
                        progressBar.setValue(Double.parseDouble(nomZap));
                        Elements zaps = zl_list.getChildElements();
                        for (Element zap : zaps){
                            if (zap.getLocalName().equals("SLUCH")){
                                int rslt = Integer.parseInt(getChildByName(zap, "RSLT").getValue());
                                int ishod = Integer.parseInt(getChildByName(zap, "ISHOD").getValue());
                                //RLST
                                if (Arrays.binarySearch(RSLT200, rslt) > -1 && (ishod != 402)){
                                    System.out.println("Ошбика! Номер записи: " + nomZap +
                                            ".\nПравило 003K.00.0200.\nRSLT = " + rslt +
                                            "\nISHOD = " + ishod);
                                }
                                if (Arrays.binarySearch(RSLT220, rslt) > -1 && (ishod == 201)){
                                    System.out.println("Ошбика! Номер записи: " + nomZap +
                                            ".\nПравило 003K.00.0220.\nRSLT = " + rslt +
                                            "\nISHOD = " + ishod);
                                }
                                if (Arrays.binarySearch(RSLT211, rslt) > -1 && (ishod == 101)){
                                    System.out.println("Ошбика! Номер записи: " + nomZap +
                                            ".\nПравило 003K.00.0211.\nRSLT = " + rslt +
                                            "\nISHOD = " + ishod);
                                }
                                if (Arrays.binarySearch(RSLT331, rslt) > -1 && (ishod != 104)){
                                    System.out.println("Ошбика! Номер записи: " + nomZap +
                                            ".\nПравило 003K.00.0331.\nRSLT = " + rslt +
                                            "\nISHOD = " + ishod);
                                }
                                if (Arrays.binarySearch(RSLT341, rslt) > -1 && (ishod != 204)){
                                    System.out.println("Ошбика! Номер записи: " + nomZap +
                                            ".\nПравило 003K.00.0341.\nRSLT = " + rslt +
                                            "\nISHOD = " + ishod);
                                }
                                if (rslt == 313 && (ishod != 305)){
                                    System.out.println("Ошбика! Номер записи: " + nomZap +
                                            ".\nПравило 003K.00.0305.\nRSLT = " + rslt +
                                            "\nISHOD = " + ishod);
                                }
                                if (Arrays.binarySearch(RSLT361, rslt) > -1 && (ishod != 403)){
                                    System.out.println("Ошбика! Номер записи: " + nomZap +
                                            ".\nПравило 003K.00.0361.\nRSLT = " + rslt +
                                            "\nISHOD = " + ishod);
                                }
                                //USL_OK

                            }
                        }
                    }
                }
            }
        }
        catch (ValidityException ex) {
            Notification.show("Cafe con Leche is invalid today. (Somewhat embarrassing.)");
        }
        catch (ParsingException ex) {
            Notification.show("Cafe con Leche is malformed today. (How embarrassing!)");
        }
        catch (IOException ex) {
            Notification.show("Could not connect to Cafe con Leche. The site may be down.");
        }
        int test = 0;
    }

    private Element getChildByName(Element element, String name) {
        Element returnElement = null;
        Elements children = element.getChildElements();
        for (int i = 0; i < children.size();  i++) {
            if (children.get(i).getLocalName().equals(name)){
                returnElement = children.get(i);
            }
        }
        return returnElement;
    }

}
