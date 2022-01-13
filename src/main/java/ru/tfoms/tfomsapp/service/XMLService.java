package ru.tfoms.tfomsapp.service;

import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import nu.xom.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Pacient;
import ru.tfoms.tfomsapp.domain.MEK.Zap;
import ru.tfoms.tfomsapp.view.LoadXMLView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class XMLService {

    public boolean syncZap;
    public boolean syncPacient;

    public boolean waitThreads = false;
    public boolean waitZapThread = false;
    public boolean waitPacientThread = false;

    private final ServiceUtil su = new ServiceUtil();
    private final SluchService sluchService = new SluchService();
    private final ZappacientService zappacientService = new ZappacientService();

    public void loadFiles(MultiFileMemoryBuffer multiFileMemoryBuffer, String fileName, LoadXMLView loadXMLView) {
        syncZap = false;
        syncPacient = false;
//        if (fileName.substring(0, 2).contains("HM")) {
//           cfLoadZap = LoadZap(multiFileMemoryBuffer.getInputStream(fileName), loadXMLView);
//        }
//        if (fileName.substring(0, 2).contains("LM")) {
//            cfLoadPacient = LoadPacient(multiFileMemoryBuffer.getInputStream(fileName), loadXMLView);
//        }
//
//        CompletableFuture.allOf(cfLoadZap, cfLoadPacient).join();
//        while (!(cfLoadZap.isDone()&& cfLoadPacient.isDone())){
//            Thread.onSpinWait();
//            loadXMLView.getUI().get().push();
//        }
        loadXMLView.getUI().get().access(() ->
                loadXMLView.statusLabel.setText("Потоки завершены!"));
    }

//    @Async
//    public CompletableFuture<ArrayList<Zap>> LoadZap(InputStream inputStream, LoadXMLView loadXMLView){
//        ArrayList<Zap> listZap = new ArrayList<>();
//        Document doc = null;
//        Builder parser = new Builder(false);
//        try {
//            doc = parser.build(inputStream);
//        } catch (ParsingException | IOException e) {
//            e.printStackTrace();
//        }
//        assert doc != null;
//        Element html = doc.getRootElement();
//
//        Element head = html.getFirstChildElement("ZAP");
//        if (head != null){
//            Elements zl_lists = html.getChildElements();
//            int countZap = 1;
//            loadXMLView.getUI().get().access(() -> {
//                loadXMLView.progressBarZap.setMax(zl_lists.size());
//            });
//            for (Element zl_list : zl_lists){
//                int finalCountZap = countZap;
//                loadXMLView.getUI().get().access(() -> {
//                    loadXMLView.progressZap.setText("Создание сущностей случаев: " + finalCountZap + " / " + zl_lists.size());
//                    loadXMLView.progressBarZap.setValue(finalCountZap);
//                });
//                if (zl_list.getLocalName().equals("ZAP")){
//                    Elements zaps = zl_list.getChildElements();
//                    Zap essZap = new Zap();
//                    for (Element zap : zaps){
//                        switch (zap.getLocalName()) {
//                            case "N_ZAP" -> essZap.setNzap(Integer.parseInt(su.getChildValueByName(zap, "N_ZAP")));
//                            case "PR_NOV" -> essZap.setPrnov(Integer.parseInt(su.getChildValueByName(zap, "PR_NOV")));
//                            case "PACIENT" -> essZap.setZapPacient(zappacientService.LoadZappacient(zap));
//                            case "SLUCH" -> essZap.setSluch(sluchService.LoadSluch(zap));
//                        }
//                    }
//                    countZap++;
//                    listZap.add(essZap);
//                }
//            }
//        }
//        loadXMLView.getUI().get().access(() ->
//                loadXMLView.statusSyncZap.setText("Поток ZAP завершен!"));
//        return CompletableFuture.completedFuture(listZap);
//    }
//
//    @Async
//    public CompletableFuture<ArrayList<Pacient>> LoadPacient(InputStream inputStream, LoadXMLView loadXMLView){
//        Pacient essPacient = new Pacient();
//        ArrayList<Pacient> listPacient = new ArrayList<>();
//        Document doc = null;
//        Builder parser = new Builder(false);
//        try {
//            doc = parser.build(inputStream);
//        } catch (ParsingException | IOException e) {
//            e.printStackTrace();
//        }
//        assert doc != null;
//        Element html = doc.getRootElement();
//
//        Elements pacients = html.getChildElements();
//        loadXMLView.getUI().get().access(() -> {
//            loadXMLView.progressBarPacient.setMax(pacients.size());
//        });
//
//        int countPacient = 0;
//        for (Element pacinet : pacients) {
//            Elements childs = pacinet.getChildElements();
//            for (Element child : childs) {
//                essPacient.setIdpack(su.getChildValueByName(child, "ID_PAC"));
//                essPacient.setFam(su.getChildValueByName(child, "FAM"));
//                essPacient.setIm(su.getChildValueByName(child, "IM"));
//                essPacient.setOt(su.getChildValueByName(child, "OT"));
//                essPacient.setW(su.getChildValueByName(child, "W"));
//                essPacient.setDr(su.getChildValueByName(child, "DR"));
//                essPacient.setSnils(su.getChildValueByName(child, "SNILS"));
//                essPacient.setAdres(su.getChildValueByName(child, "ADRES"));
//                essPacient.setWorker(su.getChildValueByName(child, "WORKER"));
//                essPacient.setLpup(su.getChildValueByName(child, "LPU_P"));
//
//            }
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            listPacient.add(essPacient);
//            countPacient++;
//            int finalCountPacient = countPacient;
//            loadXMLView.getUI().get().access(() -> {
//                loadXMLView.progressPacient.setText("Создание сущностей пациентов: " + finalCountPacient + " / " + pacients.size());
//                loadXMLView.progressBarPacient.setValue(finalCountPacient);
//            });
//        }
//        loadXMLView.getUI().get().access(() ->
//                loadXMLView.statusSyncPacient.setText("Поток Pacient завершен!"));
//        return CompletableFuture.completedFuture(listPacient);
//    }
}


