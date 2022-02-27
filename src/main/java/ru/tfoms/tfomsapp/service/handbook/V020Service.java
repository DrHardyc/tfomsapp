package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.V020;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V020Service {
    public List<V020> getV020s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V020> listV020 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V020 v020 = new V020();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDK_PR" -> v020.setIdk_pr(handBookValues.getValue());
                    case "K_PRNAME" -> v020.setK_prname(handBookValues.getValue());
                    case "DATEBEG" -> v020.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v020.setDateend(handBookValues.getValue());
                }
            }
            listV020.add(v020);
        }
        return listV020;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V020Service v020Service = new V020Service();
        List<V020> v020s = v020Service.getV020s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V020&filters=IDK_PR%7C" + par));

        for (V020 v020 : v020s){
            if (v020.getIdk_pr().equals(par)){
                return false;
            }
        }
        return true;
    }
}
