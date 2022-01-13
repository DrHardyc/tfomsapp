package ru.tfoms.tfomsapp.service;

import nu.xom.*;
import ru.tfoms.tfomsapp.domain.MEK.Pacient;
import ru.tfoms.tfomsapp.view.LoadXMLView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PacientService extends Thread {
    private final InputStream resourceAsStream;
    private final LoadXMLView loadXMLView;
    public ArrayList<Pacient> listPacient = new ArrayList<>();

    private final ServiceUtil su = new ServiceUtil();

    public PacientService(InputStream resourceAsStream, LoadXMLView loadXMLView) {
        this.resourceAsStream = resourceAsStream;
        this.loadXMLView = loadXMLView;
    }

    @Override
    public void run() {
        Document doc = null;
        Builder parser = new Builder(false);
        try {
            doc = parser.build(resourceAsStream);
        } catch (ParsingException | IOException e) {
            e.printStackTrace();
        }
        if(doc == null){
            return;
        }
        Element html = doc.getRootElement();

        Elements htmlChilds = html.getChildElements();
        loadXMLView.getUI().get().access(() -> {
            loadXMLView.progressBarPacient.setMax(htmlChilds.size());
        });

        int countPacient = 0;
        for (Element pacient : htmlChilds) {
            if(pacient.getLocalName().equals("PERS")){
                Pacient essPacient = new Pacient();
                Elements childs = pacient.getChildElements();
                for (Element child : childs) {
                    switch (child.getLocalName()){
                        case "ID_PAC" -> essPacient.setIdpack(su.getChildValueByName(child, "ID_PAC"));
                        case "FAM" -> essPacient.setFam(su.getChildValueByName(child, "FAM"));
                        case "IM" -> essPacient.setIm(su.getChildValueByName(child, "IM"));
                        case "OT" -> essPacient.setOt(su.getChildValueByName(child, "OT"));
                        case "W" -> essPacient.setW(su.getChildValueByName(child, "W"));
                        case "DR" -> essPacient.setDr(su.getChildValueByName(child, "DR"));
                        case "FAM_P" -> essPacient.setFamp(su.getChildValueByName(child, "FAM_P"));
                        case "OT_P" -> essPacient.setOtp(su.getChildValueByName(child, "OT_P"));
                        case "W_P" -> essPacient.setWp(su.getChildValueByName(child, "W_P"));
                        case "DR_P" -> essPacient.setDrp(su.getChildValueByName(child, "DR_P"));
                        case "MR" -> essPacient.setMr(su.getChildValueByName(child, "MR"));
                        case "DOCTYPE" -> essPacient.setDoctype(su.getChildValueByName(child, "DOCTYPE"));
                        case "DOCSER" -> essPacient.setDocser(su.getChildValueByName(child, "DOCSER"));
                        case "DOCNUM" -> essPacient.setDocnum(su.getChildValueByName(child, "DOCNUM"));
                        case "DOCDATE" -> essPacient.setDocdate(su.getChildValueByName(child, "DOCDATE"));
                        case "DOCORG" -> essPacient.setDocorg(su.getChildValueByName(child, "DOCORG"));
                        case "SNILS" -> essPacient.setSnils(su.getChildValueByName(child, "SNILS"));
                        case "OKATOG" -> essPacient.setOkatog(su.getChildValueByName(child, "OKATOG"));
                        case "OKATOP" -> essPacient.setOkatop(su.getChildValueByName(child, "OKATOP"));
                        case "ADRES" -> essPacient.setAdres(su.getChildValueByName(child, "ADRES"));
                        case "WORKER" -> essPacient.setWorker(su.getChildValueByName(child, "WORKER"));
                        case "LPU_P" -> essPacient.setLpup(su.getChildValueByName(child, "LPU_P"));
                        case "TEL" -> essPacient.setTel(su.getChildValueByName(child, "TEL"));
                    }
                }
                listPacient.add(essPacient);
                countPacient++;
            }

            int finalCountPacient = countPacient;
            loadXMLView.getUI().get().access(() -> {
                loadXMLView.progressPacient.setText("Создание сущностей пациентов: " + finalCountPacient + " / " + htmlChilds.size());
                loadXMLView.progressBarPacient.setValue(finalCountPacient);
            });

            //            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }
}
