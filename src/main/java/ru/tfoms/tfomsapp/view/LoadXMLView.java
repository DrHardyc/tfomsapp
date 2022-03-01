package ru.tfoms.tfomsapp.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tfoms.tfomsapp.domain.file.ds.*;
import ru.tfoms.tfomsapp.domain.file.mp.MPSl;
import ru.tfoms.tfomsapp.domain.file.mp.MPUsl;
import ru.tfoms.tfomsapp.domain.file.mp.MPZap;
import ru.tfoms.tfomsapp.domain.file.mp.MPZllist;
import ru.tfoms.tfomsapp.domain.file.mpd.MPDUsl;
import ru.tfoms.tfomsapp.domain.file.mpd.MPDZap;
import ru.tfoms.tfomsapp.domain.file.mpd.MPDZllist;
import ru.tfoms.tfomsapp.domain.file.onk.ONKSl;
import ru.tfoms.tfomsapp.domain.file.onk.ONKUsl;
import ru.tfoms.tfomsapp.domain.file.onk.ONKZap;
import ru.tfoms.tfomsapp.domain.file.onk.ONKZllist;
import ru.tfoms.tfomsapp.domain.file.pd.PDPers;
import ru.tfoms.tfomsapp.domain.file.pd.PDPerslist;
import ru.tfoms.tfomsapp.domain.file.vmp.VMPSl;
import ru.tfoms.tfomsapp.domain.file.vmp.VMPUsl;
import ru.tfoms.tfomsapp.domain.file.vmp.VMPZap;
import ru.tfoms.tfomsapp.domain.file.vmp.VMPZllist;
import ru.tfoms.tfomsapp.domain.pg.Rate;
import ru.tfoms.tfomsapp.repo.pg.RateRepo;
import ru.tfoms.tfomsapp.service.file.ds.DSZllistService;
import ru.tfoms.tfomsapp.service.file.ds.GenerateDSXML;
import ru.tfoms.tfomsapp.service.file.mp.GenerateMPXML;
import ru.tfoms.tfomsapp.service.file.mp.MPZLListService;
import ru.tfoms.tfomsapp.service.file.mpd.GenerateMPDXML;
import ru.tfoms.tfomsapp.service.file.mpd.MPDZllistService;
import ru.tfoms.tfomsapp.service.file.onk.GenerateONKXML;
import ru.tfoms.tfomsapp.service.file.onk.ONKZllistService;
import ru.tfoms.tfomsapp.service.file.pd.GeneratePDXML;
import ru.tfoms.tfomsapp.service.file.pd.PDPerslistService;
import ru.tfoms.tfomsapp.service.file.vmp.GenerateVMPXML;
import ru.tfoms.tfomsapp.service.file.vmp.VMPZllistService;

import javax.annotation.security.PermitAll;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Route("loadxml")
@PermitAll
public class LoadXMLView extends VerticalLayout {
    @Autowired
    RateRepo rateRepo;

    private PDPerslist pdPerslist = null;
    private final List<DSZllist> dsZllists = new ArrayList<>();
    private MPZllist zllMP = null;
    private VMPZllist zllVMP = null;
    private MPDZllist zllMPD = null;
    private ONKZllist zllONK = null;

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

        tfURL.setHeight("200");
        MultiFileMemoryBuffer multiFileMemoryBuffer = new MultiFileMemoryBuffer();
        Upload multiFileUpload = new Upload(multiFileMemoryBuffer);

        String[] fileName = new String[]{"", ""};
        multiFileUpload.setAcceptedFileTypes(".xml");
        multiFileUpload.addSucceededListener(event -> {
                if (event.getFileName().indexOf("I") == 1){
                    DSZllistService dsZllistService = new DSZllistService();
                    DSZllist dsZllist = dsZllistService.loadDSZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
                    dsZllists.add(dsZllist);
                    System.out.println("Загрузка DS успешно завершена");
                } else if (event.getFileName().contains("HM") && !event.getFileName().contains("LHM")){
                    MPZLListService mpzlListService = new MPZLListService();
                    zllMP = mpzlListService.loadMPZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
                    System.out.println("Загрузка MP успешно завершена");
                } else if (event.getFileName().contains("УТОЧНИТЬ1")){
                    VMPZllistService vmpZllistService = new VMPZllistService();
                    zllVMP = vmpZllistService.loadVMPZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
                    System.out.println("Загрузка VMP успешно завершена");
                } else if (event.getFileName().contains("УТОЧНИТЬ2")){
                    MPDZllistService mpdZllistService = new MPDZllistService();
                    zllMPD = mpdZllistService.loadVMPZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
                    System.out.println("Загрузка MPD успешно завершена");
                } else if (event.getFileName().contains("УТОЧНИТЬ3")){
                    ONKZllistService onkZllistService = new ONKZllistService();
                    zllONK = onkZllistService.loadONKZllist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
                    System.out.println("Загрузка ONK успешно завершена");
                } else if (event.getFileName().contains("LM") || event.getFileName().contains("LHM")){
                    PDPerslistService pdPerslistService = new PDPerslistService();
                    pdPerslist = pdPerslistService.loadPDPerslist(multiFileMemoryBuffer.getInputStream(event.getFileName()));
                    System.out.println("Загрузка PD успешно завершена");
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
            Rate rate = new Rate();
            rate.setGender(1);
            rate.setAge(18);
            rate.setRatename("DF");
            rateRepo.save(rate);
            List<Rate> rates = new ArrayList<>();
            rates = rateRepo.findAll();


//            merger();
//            MPExam mpExam = new MPExam();
//            try {
//                mpExam.exam(pdPerslist, zllMP.getZglv(), zllMP.getSchet(), ExamParam.All);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Проверка завершена");
        });

        add(multiFileUpload, btnGenFiles, statusLabel, statusSyncZap, statusSyncPacient, tfURL, btnMerge);

    }

    private void merger(){
        if (pdPerslist != null) {
            for (PDPers pdPers : pdPerslist.getPers()) {
                for (DSZllist dsZllist : dsZllists) {
                    if (zllMP != null) {
                        progressBarZap.setMax(zllMP.getZap().size());
                        int progress = 0;
                        progressBarZap.setValue(0);
                        List<MPZap> mpZaps = new ArrayList<>();
                        for (MPZap zap : zllMP.getZap()) {
                            progress++;
                            // Заполняем доп. свединями наши полученные случаи
                            for (DSZap dsZap : dsZllist.getZaps()) {
                                for (DSZsl dsZsl : dsZap.getZsl()) {
                                    if (dsZap.getFilename1().equals(zllMP.getZglv().getFilename())
                                            && dsZsl.getIdcase().equals(zap.getZsl().getIdcase())) {
                                        zap.getZsl().setDsZsl(dsZsl);
                                        for (MPSl mpSl : zap.getZsl().getSl()) {
                                            for (DSSl dsSl : dsZsl.getSl()) {
                                                if (dsSl.getSlid().equals(mpSl.getSlid())) {
                                                    mpSl.setDsSl(dsSl);
                                                    for (MPUsl mpUsl : mpSl.getUsl()) {
                                                        for (DSUsl dsUsl : dsSl.getUsl()) {
                                                            if (dsUsl.getIdserv().equals(mpUsl.getIdserv())) {
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
                                    && pdPerslist.getZglv().getFilename1().equals(zllMP.getZglv().getFilename())) {
                                mpZaps.add(zap);
                            }
                        }
                        pdPers.setMpZap(mpZaps);
                        int finalProgress = progress;
                        UI.getCurrent().access(() -> {
                            progressBarZap.setValue(finalProgress);
                        });
                    }

                    if (zllMPD != null) {
                        List<MPDZap> mpdZaps = new ArrayList<>();
                        for (MPDZap zap : zllMPD.getZap()) {
                            // Заполняем доп. свединями наши полученные случаи
                            for (DSZap dsZap : dsZllist.getZaps()) {
                                for (DSZsl dsZsl : dsZap.getZsl()) {
                                    if (dsZap.getFilename1().equals(zllMPD.getZglv().getFilename())
                                            && dsZsl.getIdcase().equals(zap.getZsl().getIdcase())) {
                                        zap.getZsl().setDsZsl(dsZsl);

                                        for (DSSl dsSl : dsZsl.getSl()) {
                                            if (dsSl.equals(zap.getZsl().getSl())) {
                                                zap.getZsl().getSl().setDsSl(dsSl);

                                                for (DSUsl dsUsl : dsSl.getUsl()) {
                                                    for (MPDUsl mpdUsl : zap.getZsl().getSl().getUsl()) {
                                                        if (dsUsl.getIdserv().equals(dsUsl.getIdserv())) {
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
                                    && pdPerslist.getZglv().getFilename1().equals(zllMPD.getZglv().getFilename())) {
                                mpdZaps.add(zap);
                            }
                        }
                        pdPers.setMpdZap(mpdZaps);
                        System.out.println("MPD");
                    }

                    if (zllVMP != null) {
                        List<VMPZap> vmpZap = new ArrayList<>();
                        for (VMPZap zap : zllVMP.getZaps()) {
                            // Заполняем доп. свединями наши полученные случаи
                            for (DSZap dsZap : dsZllist.getZaps()) {
                                for (DSZsl dsZsl : dsZap.getZsl()) {
                                    if (dsZap.getFilename1().equals(zllMPD.getZglv().getFilename())
                                            && dsZsl.getIdcase().equals(zap.getZsl().getIdcase())) {
                                        zap.getZsl().setDsZsl(dsZsl);
                                        for (VMPSl vmpSl : zap.getZsl().getSl()) {
                                            for (DSSl dsSl : dsZsl.getSl()) {
                                                if (dsSl.getSlid().equals(vmpSl.getSlid())) {
                                                    vmpSl.setDsSl(dsSl);
                                                    for (VMPUsl vmpUsl : vmpSl.getUsl()) {
                                                        for (DSUsl dsUsl : dsSl.getUsl()) {
                                                            if (dsUsl.getIdserv().equals(vmpUsl.getIdserv())) {
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
                                    && pdPerslist.getZglv().getFilename1().equals(zllVMP.getZglv().getFilename())) {
                                vmpZap.add(zap);
                            }
                        }
                        pdPers.setVmpZap(vmpZap);
                        System.out.println("VMP");
                    }

                    if (zllONK != null) {
                        List<ONKZap> onkZaps = new ArrayList<>();
                        for (ONKZap zap : zllONK.getZaps()) {
                            // Заполняем доп. свединями наши полученные случаи
                            for (DSZap dsZap : dsZllist.getZaps()) {
                                for (DSZsl dsZsl : dsZap.getZsl()) {
                                    if (dsZap.getFilename1().equals(zllMPD.getZglv().getFilename())
                                            && dsZsl.getIdcase().equals(zap.getZsl().getIdcase())) {
                                        zap.getZsl().setDsZsl(dsZsl);
                                        for (ONKSl onkSl : zap.getZsl().getSls()) {
                                            for (DSSl dsSl : dsZsl.getSl()) {
                                                if (dsSl.getSlid().equals(onkSl.getSlid())) {
                                                    onkSl.setDsSl(dsSl);
                                                    for (ONKUsl onkUsl : onkSl.getUsl()) {
                                                        for (DSUsl dsUsl : dsSl.getUsl()) {
                                                            if (dsUsl.getIdserv().equals(onkUsl.getIdserv())) {
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
                                    && pdPerslist.getZglv().getFilename1().equals(zllONK.getZglv().getFilename())) {
                                onkZaps.add(zap);
                            }
                        }
                        pdPers.setOnkZap(onkZaps);
                        System.out.println("ONK");
                    }
                }
            }
        }
        System.out.println("Слияние завершено.");
    }


}

