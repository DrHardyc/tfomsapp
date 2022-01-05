package ru.tfoms.tfomsapp.view;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Route;
import nu.xom.ParsingException;
import ru.tfoms.tfomsapp.service.XMLService;

import javax.annotation.security.PermitAll;
import java.io.IOException;

//@Push
@Route("loadxml")
@PermitAll
public class LoadXMLView extends VerticalLayout {
    private final UI ui = new UI();
    private final Label label = new Label("test");
    private final Label labelDoc = new Label("clear label Doc");
    //Button button = new Button("Load");
    public ProgressBar progressBar = new ProgressBar();
    public Label progress = new Label("");

    public LoadXMLView(){
        XMLService xmlService = new XMLService();
        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);

        upload.setAcceptedFileTypes(".xml");
        upload.addSucceededListener(e -> {
            try {
                xmlService.LoadZap(buffer.getInputStream(), this);
            } catch (ParsingException | IOException | InterruptedException parsingException) {
                parsingException.printStackTrace();
            }
        });

        //button.addClickListener(e -> LoadXML());
        add(label, upload, labelDoc, progress, progressBar);
    }
}
