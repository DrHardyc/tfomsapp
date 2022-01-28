package ru.tfoms.tfomsapp.view;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.util.SharedUtil;

import javax.annotation.security.PermitAll;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

@Route("loadcsv")
@PermitAll
public class LoadCSVView extends VerticalLayout {

    Grid<String[]> grid = new Grid<>();

    public LoadCSVView() {

        MemoryBuffer buffer = new MemoryBuffer();
        Upload upload = new Upload(buffer);

        upload.setAcceptedFileTypes(".csv");
        upload.addSucceededListener(e -> {
            displayCsv(buffer.getInputStream());
        });
        add(upload, grid);
//        InputStreamReader csvFileReader = new InputStreamReader(
//                Objects.requireNonNull(getClass().getResourceAsStream("input.csv")),
//                StandardCharsets.UTF_8
//        );
    }
    private void displayCsv(InputStream resourceAsStream) {
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader reader = new CSVReaderBuilder(new InputStreamReader(resourceAsStream, Charset.forName("windows-1251"))).withCSVParser(parser).build();

        try {
            List<String[]> entries = reader.readAll();
            // Assume the first row contains headers
            String[] headers = entries.get(0);

            // Setup a grid with random data
            for (int i = 0; i < headers.length; i++) {
                final int columnIndex = i;
                String header = headers[i];
                String humanReadableHeader = SharedUtil.camelCaseToHumanFriendly(header);
                grid.addColumn(str -> str[columnIndex]).setHeader(humanReadableHeader);

            }
            grid.setItems(entries.subList(1, entries.size()));
        } catch (IOException | CsvException e) {
            grid.addColumn(nop -> "Unable to load CSV: " + e.getMessage()).setHeader("Failed to import CSV file");
        }
    }
}