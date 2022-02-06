package ru.tfoms.tfomsapp.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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
import org.hibernate.boot.archive.spi.InputStreamAccess;
import ru.tfoms.tfomsapp.domain.HandBook.HBQ018;
import ru.tfoms.tfomsapp.domain.MEK.*;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSZap;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSZllist;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSZsl;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPZsl;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPers;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPerslist;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPZsl;
import ru.tfoms.tfomsapp.service.MEK.DS.DSZllistService;
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


@Route("loadxml")
@PermitAll
public class LoadXMLView extends VerticalLayout {

    private int filesCounter = 0;
    private PDPerslist pdPerslist = new PDPerslist();
    private DSZllist dsZllist = new DSZllist();
    private Zllist zllMP = new Zllist();
    private Zllist zllVMP = new Zllist();
    private Zllist zllMPD = new Zllist();
    private Zllist zllONK = new Zllist();

    public Dialog dialog = new Dialog();
    public boolean syncZlList;
    public boolean syncZap;
    public boolean syncPacient;

    public ProgressBar progressBarZap = new ProgressBar();
    public ProgressBar progressBarPacient = new ProgressBar();
    public Label progressZap = new Label("");
    public Label progressPacient = new Label("");
    public Button btnGenFiles = new Button("Генерация файлов");
    public Button btnMerge = new Button("Слияние");
    public Label statusLabel = new Label();
    public Label statusSyncZap = new Label();
    public Label statusSyncPacient = new Label();
    public TextField tfURL = new TextField();

    public LoadXMLView(){
        InputStream isMP;
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
            ZllistService zllistService = new ZllistService();
            switch (event.getFileName()) {
                case "DS.xml" -> {
                    DSZllistService dsZllistService = new DSZllistService();
                    dsZllist = dsZllistService.loadDSZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
                    System.out.println("Загрузка DS успешно завершена");
                }
                case "MP.xml" -> {
                    zllMP = zllistService.loadZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()), "MP");
                    System.out.println("Загрузка MP успешно завершена");
                }
                case "VMP.xml" -> {
                    zllVMP = zllistService.loadZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()), "VMP");
                    System.out.println("Загрузка VMP успешно завершена");
                }
                case "MPD.xml" -> {
                    zllMPD = zllistService.loadZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()), "MPD");
                    System.out.println("Загрузка MPD успешно завершена");
                }
                case "ONK.xml" -> {
                    zllONK = zllistService.loadZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()), "ONK");
                    System.out.println("Загрузка ONK успешно завершена");
                }
                case "PD.xml" -> {
                    PDPerslistService pdPerslistService = new PDPerslistService();
                    pdPerslist = pdPerslistService.loadPDPerslist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
                    System.out.println("Загрузка PD успешно завершена");
                }
            }
            System.out.println("Загрузка успешно завершена");
            btnMerge.setEnabled(true);
        });

        btnGenFiles.addClickListener(event -> {
            GenerateDSXML generateDSXML = new GenerateDSXML();
            generateDSXML.generate("C:\\Users\\dr_ha\\Google Диск\\ТФОМС\\genfiles\\DS.xml");
            GeneratePDXML generatePDXML = new GeneratePDXML();
            generatePDXML.generate("C:\\Users\\dr_ha\\Google Диск\\ТФОМС\\genfiles\\PD.xml");
            GenerateVMPXML generateVMPXML = new GenerateVMPXML();
            generateVMPXML.generate("C:\\Users\\dr_ha\\Google Диск\\ТФОМС\\genfiles\\VMP.xml");
            GenerateMPXML generateMPXML = new GenerateMPXML();
            generateMPXML.generate("C:\\Users\\dr_ha\\Google Диск\\ТФОМС\\genfiles\\MP.xml");
            GenerateONKXML generateONKXML = new GenerateONKXML();
            generateONKXML.generate("C:\\Users\\dr_ha\\Google Диск\\ТФОМС\\genfiles\\ONK.xml");
            GenerateMPDXML generateMPDXML = new GenerateMPDXML();
            generateMPDXML.generate("C:\\Users\\dr_ha\\Google Диск\\ТФОМС\\genfiles\\MPD.xml");

        });
        btnMerge.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnMerge.setEnabled(false);
        btnMerge.addClickListener(event -> {
            merger();
        });

        add(multiFileUpload, btnGenFiles, statusLabel, statusSyncZap, statusSyncPacient, tfURL, hbq018Grid, btnMerge);

    }

    private void merger(){
        for (PDPers pdPers : pdPerslist.getPers()){
            for(Zap zap : zllMP.getZaps()){
                // Заполняем доп. свединями
                addMoreInfo(zap, zllMP, dsZllist);
                if (pdPers.getIdpac().equals(zap.getPacient().getIdpac())
                        &&pdPerslist.getZglv().getFilename1().equals(zllMP.getZglv().getFilename())){
                    pdPers.setMpZap(zap);
                }
            }
            System.out.println("MP");
            for(Zap zap : zllMPD.getZaps()){
                // Заполняем доп. свединями
                addMoreInfo(zap, zllMPD, dsZllist);
                if (pdPers.getIdpac().equals(zap.getPacient().getIdpac())
                        &&pdPerslist.getZglv().getFilename1().equals(zllMPD.getZglv().getFilename())){
                    pdPers.setMpZap(zap);
                }
            }
            System.out.println("MPD");
            for(Zap zap : zllVMP.getZaps()){
                // Заполняем доп. свединями
                addMoreInfo(zap, zllVMP, dsZllist);
                if (pdPers.getIdpac().equals(zap.getPacient().getIdpac())
                        &&pdPerslist.getZglv().getFilename1().equals(zllVMP.getZglv().getFilename())){
                    pdPers.setMpZap(zap);
                }
            }
            System.out.println("VMP");
            for(Zap zap : zllONK.getZaps()){
                // Заполняем доп. свединями
                addMoreInfo(zap, zllONK, dsZllist);
                if (pdPers.getIdpac().equals(zap.getPacient().getIdpac())
                        &&pdPerslist.getZglv().getFilename1().equals(zllONK.getZglv().getFilename())){
                    pdPers.setMpZap(zap);
                }
            }
            System.out.println("ONK");
        }
        System.out.println("Сдияние завершено.");
    }

    private void addMoreInfo(Zap zap, Zllist zllist, DSZllist dsZllist) {
        for (DSZap dsZap : dsZllist.getZaps()){
            for (DSZsl dsZsl : dsZap.getZsl())
            if (dsZap.getFilename1().equals(zllist.getZglv().getFilename())
                    &&dsZsl.getIdcase().equals(zap.getZsl().getIdcase())){
                zap.getZsl().setDsZsl(dsZsl);
            }
        }
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

