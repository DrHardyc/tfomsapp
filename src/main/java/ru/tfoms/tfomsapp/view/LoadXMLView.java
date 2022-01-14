package ru.tfoms.tfomsapp.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.Route;
import ru.tfoms.tfomsapp.domain.HandBook.HBQ018;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.Handbook;
import ru.tfoms.tfomsapp.service.HandBook.HBQ018Service;
import ru.tfoms.tfomsapp.service.HandBook.HandBookService;

import javax.annotation.security.PermitAll;


@Route("loadxml")
@PermitAll
public class LoadXMLView extends VerticalLayout {

    private int filesCounter = 0;

    public boolean syncZap;
    public boolean syncPacient;

    public ProgressBar progressBarZap = new ProgressBar();
    public ProgressBar progressBarPacient = new ProgressBar();
    public Label progressZap = new Label("");
    public Label progressPacient = new Label("");
    public Button button = new Button("Test");
    public Label statusLabel = new Label();
    public Label statusSyncZap = new Label();
    public Label statusSyncPacient = new Label();
    public TextField tfURL = new TextField();

    public LoadXMLView(){
        Grid<HBQ018> hbq018Grid = new Grid<>();
        hbq018Grid.addColumn(HBQ018::getSysrecordid).setHeader("SYS_RECORDID");
        hbq018Grid.addColumn(HBQ018::getSyshash).setHeader("SYS_HASH");
        hbq018Grid.addColumn(HBQ018::getNamee).setHeader("NAME_E");
        hbq018Grid.addColumn(HBQ018::getDesce).setHeader("DESC_E");
//        dirValuesGrid.addColumn(DirValues::getResultCode).setHeader("Result Code");
//        dirValuesGrid.addColumn(DirValues::getTotal).setHeader("Total");

        tfURL.setHeight("200");
        syncPacient = false;
        syncZap = false;
        MultiFileMemoryBuffer multiFileMemoryBuffer = new MultiFileMemoryBuffer();
        Upload multiFileUpload = new Upload(multiFileMemoryBuffer);

        String[] fileName = new String[]{"", ""};
        multiFileUpload.setAcceptedFileTypes(".xml");
        multiFileUpload.addSucceededListener(event -> {
            filesCounter = multiFileMemoryBuffer.getFiles().size();
            if (event.getFileName().substring(0, 2).contains("HM"))
                fileName[0] = event.getFileName();
            else if (event.getFileName().substring(0, 2).contains("LM"))
                fileName[1] = event.getFileName();
        });

        button.addClickListener(event -> {

            HBQ018Service hbq018Service = new HBQ018Service();

            try {
                hbq018Grid.setItems(hbq018Service.getHbq018(tfURL.getValue()));
            } catch (Exception e) {
                e.printStackTrace();
            }

//           /* CompletableFuture<ArrayList<Zap>> cfLoadZap = new CompletableFuture<>();
//            CompletableFuture<ArrayList<Pacient>> cfLoadPacient = new CompletableFuture<>();
//
//            statusLabel.setText(String.valueOf(filesCounter));
//            cfLoadZap = xmlService.LoadZap(multiFileMemoryBuffer.getInputStream(fileName[0]), this);
//            cfLoadPacient = xmlService.LoadPacient(multiFileMemoryBuffer.getInputStream(fileName[1]), this);*/
//
//            Dialog dialog = new Dialog();
//            dialog.setCloseOnOutsideClick(false);
//            dialog.setDraggable(true);
//            dialog.setModal(true);
//            //dialog.setResizable(true);
//            dialog.add(progressZap, progressBarZap, progressPacient, progressBarPacient);
//            dialog.open();
//            ZapService zapService = new ZapService(multiFileMemoryBuffer.getInputStream(fileName[0]), this);
//            if(!fileName[0].isEmpty()){
//                zapService.start();
//            }
//            PacientService pacientService = new PacientService(multiFileMemoryBuffer.getInputStream(fileName[1]), this);
//            if(!fileName[1].isEmpty()){
//                pacientService.start();
//            }
//
//            new Thread(() -> {
//                try {
//                    zapService.join();
//                    syncZap = true;
//                    pacientService.join();
//                    syncPacient = true;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//
//            while (!(syncZap&&syncPacient)){
//                this.getUI(). get().push();
//            }
//            dialog.close();
//
//            ArrayList<Zap> listZaps = zapService.listZap;
//            ArrayList<Pacient> listPacients = pacientService.listPacient;
//
//            progressBarZap.setVisible(false);
//            progressBarPacient.setValue(0);
//            progressBarPacient.setMax(listPacients.size());
//            progressZap.setText("Сопоставление...");
//            progressPacient.setText("");
//            dialog.open();
//            int progressPacientCount = 0;
//
//            for(Pacient pacient : listPacients) {
//                progressPacientCount++;
//                progressPacient.setText(progressPacientCount + " / " + listPacients.size());
//                progressBarPacient.setValue(progressPacientCount);
//                this.getUI().get().push();
//
//                for(Zap zap : listZaps){
//                    if (zap.getZapPacient().getIdpac().contains(pacient.getIdpack())){
//                        pacient.setZap(zap);
//                    }
//                }
//            }
//            dialog.close();
//            statusLabel.setText("Потоки заверешены!");
        });

        add(multiFileUpload, button, statusLabel, statusSyncZap, statusSyncPacient, tfURL, hbq018Grid);

        //CompletableFuture.allOf(cfLoadZap, cfLoadPacient).join();
    }
}

