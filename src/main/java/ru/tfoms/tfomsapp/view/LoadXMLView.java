package ru.tfoms.tfomsapp.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.Route;
import ru.tfoms.tfomsapp.domain.HandBook.F008;
import ru.tfoms.tfomsapp.domain.HandBook.HBQ018;
import ru.tfoms.tfomsapp.domain.MEK.DS.*;
import ru.tfoms.tfomsapp.domain.MEK.MP.*;
import ru.tfoms.tfomsapp.domain.MEK.MPD.*;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKSl;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKUsl;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKZap;
import ru.tfoms.tfomsapp.domain.MEK.ONK.ONKZllist;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPers;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPerslist;
import ru.tfoms.tfomsapp.domain.MEK.VMP.*;
import ru.tfoms.tfomsapp.service.HandBook.F008Service;
import ru.tfoms.tfomsapp.service.MEK.DS.DSZllistService;
import ru.tfoms.tfomsapp.service.MEK.DS.GenerateDSXML;
import ru.tfoms.tfomsapp.service.MEK.MP.GenerateMPXML;
import ru.tfoms.tfomsapp.service.MEK.MP.MPZLListService;
import ru.tfoms.tfomsapp.service.MEK.MPD.GenerateMPDXML;
import ru.tfoms.tfomsapp.service.MEK.MPD.MPDZllistService;
import ru.tfoms.tfomsapp.service.MEK.ONK.GenerateONKXML;
import ru.tfoms.tfomsapp.service.MEK.ONK.ONKZllistService;
import ru.tfoms.tfomsapp.service.MEK.PD.GeneratePDXML;
import ru.tfoms.tfomsapp.service.MEK.PD.PDPerslistService;
import ru.tfoms.tfomsapp.service.MEK.VMP.GenerateVMPXML;
import ru.tfoms.tfomsapp.service.MEK.VMP.VMPZllistService;

import javax.annotation.security.PermitAll;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Route("loadxml")
@PermitAll
public class LoadXMLView extends VerticalLayout {

    private int filesCounter = 0;
    private PDPerslist pdPerslist = new PDPerslist();
    private DSZllist dsZllist = new DSZllist();
    private MPZllist zllMP = new MPZllist();
    private VMPZllist zllVMP = new VMPZllist();
    private MPDZllist zllMPD = new MPDZllist();
    private ONKZllist zllONK = new ONKZllist();

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
            switch (event.getFileName()) {
                case "DS.xml" -> {
                    DSZllistService dsZllistService = new DSZllistService();
                    dsZllist = dsZllistService.loadDSZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
                    System.out.println("Загрузка DS успешно завершена");
                }
                case "MP.xml" -> {
                    MPZLListService mpzlListService = new MPZLListService();
                    zllMP = mpzlListService.loadMPZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
                    System.out.println("Загрузка MP успешно завершена");
                }
                case "VMP.xml" -> {
                    VMPZllistService vmpZllistService = new VMPZllistService();
                    zllVMP = vmpZllistService.loadVMPZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
                    System.out.println("Загрузка VMP успешно завершена");
                }
                case "MPD.xml" -> {
                    MPDZllistService mpdZllistService = new MPDZllistService();
                    zllMPD = mpdZllistService.loadVMPZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
                    System.out.println("Загрузка MPD успешно завершена");
                }
                case "ONK.xml" -> {
                    ONKZllistService onkZllistService = new ONKZllistService();
                    zllONK = onkZllistService.loadONKZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
                    System.out.println("Загрузка ONK успешно завершена");
                }
                case "PD.xml" -> {
                    PDPerslistService pdPerslistService = new PDPerslistService();
                    pdPerslist = pdPerslistService.loadPDPerslist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
                    System.out.println("Загрузка PD успешно завершена");
                }
            }
            System.out.println("Загрузка успешно завершена");
            //btnMerge.setEnabled(true);
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
        //btnMerge.setEnabled(false);

        btnMerge.addClickListener(event -> {
            for(int i = 0; i < 10; i++){
                System.out.println("D0" + i);
            }
            //merger();
        });

        add(multiFileUpload, btnGenFiles, statusLabel, statusSyncZap, statusSyncPacient, tfURL, hbq018Grid, btnMerge);

    }

    private void merger(){
        for (PDPers pdPers : pdPerslist.getPers()){
            List<MPZap> mpZaps = new ArrayList<>();
            for(MPZap zap : zllMP.getZap()){
                // Заполняем доп. свединями наши полученные случаи
                for (DSZap dsZap : dsZllist.getZaps()){
                    for (DSZsl dsZsl : dsZap.getZsl()) {
                        if (dsZap.getFilename1().equals(zllMP.getZglv().getFilename())
                                && dsZsl.getIdcase().equals(zap.getZsl().getIdcase())) {
                            zap.getZsl().setDsZsl(dsZsl);
                            for (MPSl mpSl : zap.getZsl().getSl()) {
                                for (DSSl dsSl : dsZsl.getSl()){
                                    if (dsSl.getSlid().equals(mpSl.getSlid())){
                                        mpSl.setDsSl(dsSl);
                                        for (MPUsl mpUsl : mpSl.getUsl()){
                                            for (DSUsl dsUsl : dsSl.getUsl()){
                                                if (dsUsl.getIdserv().equals(mpUsl.getIdserv())){
                                                    mpUsl.setDsUsl(dsUsl);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (pdPers.getIdpac().equals(zap.getPacient().getIdpac())
                        &&pdPerslist.getZglv().getFilename1().equals(zllMP.getZglv().getFilename())){
                    mpZaps.add(zap);
                }
            }
            pdPers.setMpZap(mpZaps);
            System.out.println("MP");

            List<MPDZap> mpdZaps = new ArrayList<>();
            for(MPDZap zap : zllMPD.getZap()){
                // Заполняем доп. свединями наши полученные случаи
                for (DSZap dsZap : dsZllist.getZaps()){
                    for (DSZsl dsZsl : dsZap.getZsl()) {
                        if (dsZap.getFilename1().equals(zllMPD.getZglv().getFilename())
                                && dsZsl.getIdcase().equals(zap.getZsl().getIdcase())) {
                            zap.getZsl().setDsZsl(dsZsl);

                            for (DSSl dsSl : dsZsl.getSl()){
                                if (dsSl.equals(zap.getZsl().getSl())){
                                    zap.getZsl().getSl().setDsSl(dsSl);

                                    for (DSUsl dsUsl : dsSl.getUsl()){
                                        for (MPDUsl mpdUsl : zap.getZsl().getSl().getUsl()){
                                            if (dsUsl.getIdserv().equals(dsUsl.getIdserv())){
                                                mpdUsl.setDsUsl(dsUsl);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //
                if (pdPers.getIdpac().equals(zap.getPacient().getIdpac())
                        &&pdPerslist.getZglv().getFilename1().equals(zllMPD.getZglv().getFilename())){
                    mpdZaps.add(zap);
                }
            }
            pdPers.setMpdZap(mpdZaps);
            System.out.println("MPD");

            List<VMPZap> vmpZap = new ArrayList<>();
            for(VMPZap zap : zllVMP.getZaps()){
                // Заполняем доп. свединями наши полученные случаи
                for (DSZap dsZap : dsZllist.getZaps()){
                    for (DSZsl dsZsl : dsZap.getZsl()) {
                        if (dsZap.getFilename1().equals(zllMPD.getZglv().getFilename())
                                && dsZsl.getIdcase().equals(zap.getZsl().getIdcase())) {
                            zap.getZsl().setDsZsl(dsZsl);
                            for (VMPSl vmpSl : zap.getZsl().getSl()) {
                                for (DSSl dsSl : dsZsl.getSl()){
                                    if (dsSl.getSlid().equals(vmpSl.getSlid())){
                                        vmpSl.setDsSl(dsSl);
                                        for (VMPUsl vmpUsl : vmpSl.getUsl()){
                                            for (DSUsl dsUsl : dsSl.getUsl()){
                                                if (dsUsl.getIdserv().equals(vmpUsl.getIdserv())){
                                                    vmpUsl.setDsUsl(dsUsl);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (pdPers.getIdpac().equals(zap.getPacient().getIdpac())
                        &&pdPerslist.getZglv().getFilename1().equals(zllVMP.getZglv().getFilename())){
                    vmpZap.add(zap);
                }
            }
            pdPers.setVmpZap(vmpZap);
            System.out.println("VMP");

            List<ONKZap> onkZaps = new ArrayList<>();
            for(ONKZap zap : zllONK.getZaps()){
                // Заполняем доп. свединями наши полученные случаи
                for (DSZap dsZap : dsZllist.getZaps()){
                    for (DSZsl dsZsl : dsZap.getZsl()) {
                        if (dsZap.getFilename1().equals(zllMPD.getZglv().getFilename())
                                && dsZsl.getIdcase().equals(zap.getZsl().getIdcase())) {
                            zap.getZsl().setDsZsl(dsZsl);
                            for (ONKSl onkSl : zap.getZsl().getSls()) {
                                for (DSSl dsSl : dsZsl.getSl()){
                                    if (dsSl.getSlid().equals(onkSl.getSlid())){
                                        onkSl.setDsSl(dsSl);
                                        for (ONKUsl onkUsl : onkSl.getUsl()){
                                            for (DSUsl dsUsl : dsSl.getUsl()){
                                                if (dsUsl.getIdserv().equals(onkUsl.getIdserv())){
                                                    onkUsl.setDsUsl(dsUsl);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (pdPers.getIdpac().equals(zap.getPacient().getIdpac())
                        &&pdPerslist.getZglv().getFilename1().equals(zllONK.getZglv().getFilename())){
                    onkZaps.add(zap);
                }
            }
            pdPers.setOnkZap(onkZaps);
            System.out.println("ONK");
        }
        System.out.println("Слияние завершено.");
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

