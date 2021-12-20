package ru.tfoms.tfomsapp.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Route;
import nu.xom.*;

import javax.annotation.security.PermitAll;
import java.io.IOException;
import java.io.InputStream;

@Route("loadxml")
@PermitAll
public class LoadXMLView extends VerticalLayout {
    Label label = new Label("test");
    Label labelDoc = new Label("clear label Doc");
    Button button = new Button("Load");

    public LoadXMLView(){
        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);

        upload.setAcceptedFileTypes(".xml");
        upload.addSucceededListener(e -> {
            LoadXML(buffer.getInputStream());
        });

        //button.addClickListener(e -> LoadXML());
        add(label, upload, labelDoc);
    }

    private void LoadXML(InputStream resourceAsStream){
        Document doc = null;
        try {
            Builder parser = new Builder(false);
            doc = parser.build(resourceAsStream);
            Element html = doc.getRootElement();
            Element head = html.getFirstChildElement("Документ");
            labelDoc.setText(html.getAttributeValue("КолДок"));
        }
        catch (ValidityException ex) {
            label.setText("Cafe con Leche is invalid today. (Somewhat embarrassing.)");
        }
        catch (ParsingException ex) {
            label.setText("Cafe con Leche is malformed today. (How embarrassing!)");
        }
        catch (IOException ex) {
            label.setText("Could not connect to Cafe con Leche. The site may be down.");
        }
    }

}
