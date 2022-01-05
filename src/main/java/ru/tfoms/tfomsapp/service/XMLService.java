package ru.tfoms.tfomsapp.service;

import nu.xom.*;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Pacient;
import ru.tfoms.tfomsapp.domain.MEK.Zap;
import ru.tfoms.tfomsapp.view.LoadXMLView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@Service
public class XMLService {
    private final ServiceUtil su = new ServiceUtil();
    private final SluchService sluchService = new SluchService();
    private final ZappacientService zappacientService = new ZappacientService();
    private int countZap;

    public ArrayList LoadZap(InputStream resourceAsStream, LoadXMLView loadXMLView) throws ParsingException, IOException, InterruptedException {
        ArrayList<Zap> listZap = new ArrayList<>();
        Document doc;
        Builder parser = new Builder(false);
        doc = parser.build(resourceAsStream);
        Element html = doc.getRootElement();

        Element head = html.getFirstChildElement("ZAP");
        if (head != null){
            Elements zl_lists = html.getChildElements();
            countZap = 0;
            new Thread(() -> {
                for (Element zl_list : zl_lists){
                    if (zl_list.getLocalName().equals("ZGLV")){
                        Elements zglvs = zl_list.getChildElements();
                        for (Element zglv : zglvs){
                            if (zglv.getLocalName().equals("SD_Z")){
                                loadXMLView.progressBar.setMax(Double.parseDouble(zglv.getValue()));
                            }
                        }
                        countZap++;
                    }
                    loadXMLView.getUI().get().access(() -> loadXMLView.progress.setText(String.valueOf(countZap)));
                    loadXMLView.getUI().get().access(() -> loadXMLView.progressBar.setValue(countZap));
                    //TimeUnit.SECONDS.sleep(1);
                    if (zl_list.getLocalName().equals("ZAP")){
                        Elements zaps = zl_list.getChildElements();
                        Zap essZap = new Zap();
                        for (Element zap : zaps){
                            switch (zap.getLocalName()) {
                                case "N_ZAP" -> essZap.setNzap(Integer.parseInt(su.getChildValueByName(zap, "N_ZAP")));
                                case "PR_NOV" -> essZap.setPrnov(Integer.parseInt(su.getChildValueByName(zap, "PR_NOV")));
                                case "PACIENT" -> essZap.setZapPcient(zappacientService.LoadZappacient(zap));
                                case "SLUCH" -> essZap.setSluch(sluchService.LoadSluch(zap));
                            }
                        }
                        countZap++;
                        listZap.add(essZap);
                    }
                }
            }).start();
        }
        return listZap;
    }

    public ArrayList LoadPacient(InputStream resourceAsStream) throws ParsingException, IOException {
        Pacient essPacient = new Pacient();
        ArrayList<Pacient> listPacient = new ArrayList<>();
        Document doc;
        Builder parser = new Builder(false);
        doc = parser.build(resourceAsStream);
        Element html = doc.getRootElement();

        //делаем для проверка, что документ тот который нам нужен
        Element head = html.getFirstChildElement("PERS");
        if (head != null) {
            Elements pacients = html.getChildElements();
            for (Element pacient : pacients) {
                essPacient.setIdpack(Long.valueOf(getChildByName(pacient, "ID_PAC").getValue()));
                essPacient.setFam(getChildByName(pacient, "FAM").getValue());
                essPacient.setIm(getChildByName(pacient, "IM").getValue());
                essPacient.setOt(getChildByName(pacient, "OT").getValue());
                essPacient.setW(getChildByName(pacient, "W").getValue());
                essPacient.setDr(getChildByName(pacient, "DR").getValue());
                essPacient.setSnils(Long.valueOf(getChildByName(pacient, "SNILS").getValue()));
                essPacient.setAdres(getChildByName(pacient, "ADRES").getValue());
                essPacient.setWorker(getChildByName(pacient, "WORKER").getValue());
                essPacient.setLpup(getChildByName(pacient, "LPU_P").getValue());
                listPacient.add(essPacient);
            }
        }
        return listPacient;
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
