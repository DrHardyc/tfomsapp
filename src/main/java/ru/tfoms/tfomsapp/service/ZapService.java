package ru.tfoms.tfomsapp.service;

import nu.xom.*;
import ru.tfoms.tfomsapp.domain.MEK.Zap;
import ru.tfoms.tfomsapp.view.LoadXMLView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ZapService extends Thread {
    private final InputStream resourceAsStream;
    private final LoadXMLView loadXMLView;
    public ArrayList<Zap> listZap = new ArrayList<>();

    private final ServiceUtil su = new ServiceUtil();
    private final SluchService sluchService = new SluchService();
    private final ZappacientService zappacientService = new ZappacientService();

    public ZapService(InputStream resourceAsStream, LoadXMLView loadXMLView) {
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
        if (doc == null){
            return;
        }
        Element html = doc.getRootElement();

        Element head = html.getFirstChildElement("ZAP");
        if (head != null) {
            Elements zl_lists = html.getChildElements();
            int countZap = 1;
            loadXMLView.getUI().get().access(() -> {
                loadXMLView.progressBarZap.setMax(zl_lists.size());
            });
            for (Element zl_list : zl_lists) {
                int finalCountZap = countZap;
                loadXMLView.getUI().get().access(() -> {
                    loadXMLView.progressZap.setText("Создание сущностей случаев: " + finalCountZap + " / " + zl_lists.size());
                    loadXMLView.progressBarZap.setValue(finalCountZap);
                });
                if (zl_list.getLocalName().equals("ZAP")) {
                    Elements zaps = zl_list.getChildElements();
                    Zap essZap = new Zap();
                    for (Element zap : zaps) {
                        switch (zap.getLocalName()) {
                            case "N_ZAP" -> essZap.setNzap(Integer.parseInt(su.getChildValueByName(zap, "N_ZAP")));
                            case "PR_NOV" -> essZap.setPrnov(Integer.parseInt(su.getChildValueByName(zap, "PR_NOV")));
                            case "PACIENT" -> essZap.setZapPacient(zappacientService.LoadZappacient(zap));
                            case "SLUCH" -> essZap.setSluch(sluchService.LoadSluch(zap));
                        }
                    }
                    countZap++;
                    listZap.add(essZap);
                }
            }
        }
    }
}
