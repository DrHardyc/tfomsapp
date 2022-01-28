package ru.tfoms.tfomsapp.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.Route;
import ru.tfoms.tfomsapp.domain.HandBook.HBQ018;
import ru.tfoms.tfomsapp.domain.MEK.*;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSZllist;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSZsl;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPerslist;
import ru.tfoms.tfomsapp.service.MEK.DS.DSZllistService;
import ru.tfoms.tfomsapp.service.MEK.DS.DSZslService;
import ru.tfoms.tfomsapp.service.MEK.DS.GenerateDSXML;
import ru.tfoms.tfomsapp.service.MEK.MP.GenerateMPXML;
import ru.tfoms.tfomsapp.service.MEK.MPD.GenerateMPDXML;
import ru.tfoms.tfomsapp.service.MEK.ONK.GenerateONKXML;
import ru.tfoms.tfomsapp.service.MEK.PD.GeneratePDXML;
import ru.tfoms.tfomsapp.service.MEK.PD.PDPerslistService;
import ru.tfoms.tfomsapp.service.MEK.VMP.GenerateVMPXML;
import ru.tfoms.tfomsapp.service.MEK.ZllistService;

import javax.annotation.security.PermitAll;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


@Route("loadxml")
@PermitAll
public class LoadXMLView extends VerticalLayout {

    private int filesCounter = 0;
    private ArrayList<Zap> listZaps = new ArrayList<>();

    public boolean syncZlList;
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
        Dialog dialog = new Dialog();
        dialog.setCloseOnOutsideClick(false);
        dialog.setDraggable(true);
        dialog.setModal(true);
        //dialog.setResizable(true);
        dialog.add(progressZap, progressBarZap, progressPacient, progressBarPacient);

        Grid<HBQ018> hbq018Grid = new Grid<>();
        hbq018Grid.addColumn(HBQ018::getSysrecordid).setHeader("SYS_RECORDID");
        hbq018Grid.addColumn(HBQ018::getSyshash).setHeader("SYS_HASH");
        hbq018Grid.addColumn(HBQ018::getName_e).setHeader("NAME_E");
        hbq018Grid.addColumn(HBQ018::getDesc_e).setHeader("DESC_E");
//        dirValuesGrid.addColumn(DirValues::getResultCode).setHeader("Result Code");
//        dirValuesGrid.addColumn(DirValues::getTotal).setHeader("Total");

        tfURL.setHeight("200");
        MultiFileMemoryBuffer multiFileMemoryBuffer = new MultiFileMemoryBuffer();
        Upload multiFileUpload = new Upload(multiFileMemoryBuffer);

        String[] fileName = new String[]{"", ""};
        multiFileUpload.setAcceptedFileTypes(".xml");
        multiFileUpload.addSucceededListener(event -> {
            DSZllistService dsZslService = new DSZllistService();
            DSZllist dsZllist = dsZslService.loadDSZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
//            PDPerslistService pdPerslistService = new PDPerslistService();
//            PDPerslist pdPerslist = pdPerslistService.loadPDPerslist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
//            ZllistService zllistService = new ZllistService();
//            Zllist zllist = zllistService.loadZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()), "PD");
            System.out.println("Загрузка успешно завершена");
            //loadXMLFiles(dialog, multiFileMemoryBuffer, fileName, event);
        });

        button.addClickListener(event -> {
            GenerateDSXML generateDSXML = new GenerateDSXML();
            generateDSXML.generate();

//            GeneratePDXML generatePDXML = new GeneratePDXML();
//            generatePDXML.generate();
//            GenerateVMPXML generateVMPXML = new GenerateVMPXML();
//            generateVMPXML.generate();
        });

        add(multiFileUpload, button, statusLabel, statusSyncZap, statusSyncPacient, tfURL, hbq018Grid);

    }

    private void loadXMLFiles(Dialog dialog, MultiFileMemoryBuffer multiFileMemoryBuffer, String[] fileName, SucceededEvent event) {
        filesCounter = multiFileMemoryBuffer.getFiles().size();
        if (event.getFileName().substring(0, 2).contains("HM"))
            fileName[0] = event.getFileName();
        else if (event.getFileName().substring(0, 2).contains("LM"))
            fileName[1] = event.getFileName();

        dialog.open();

        syncZlList = false;
        new Thread(() -> {


            syncZlList = true;
        }).start();

        while (!syncZlList){
            this.getUI().get().push();
        }
//        listZaps = MPZapService.listMPZap;
//        listPacients = pacientService.listPacient;
        dialog.close();
    }

    private BufferedReader getHBBufferedReader(String strURL) throws IOException {
        URL url = null;
        try {
            url = new URL(strURL);
        } catch (MalformedURLException e) {
            //e.printStackTrace();
            //System.out.println(e);
        }
        assert url != null;
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        return new BufferedReader(new InputStreamReader(con.getInputStream()));
    }

}

