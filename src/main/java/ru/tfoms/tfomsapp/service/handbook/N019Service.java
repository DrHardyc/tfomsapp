package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.N019;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N019Service {
    public List<N019> getN019s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N019> listN019 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues) {
            N019 n019 = new N019();
            for (HandBookValues handBookValues : handBooksValues) {
                switch (handBookValues.getColumn()) {
                    case "ID_CONS" -> n019.setId_cons(handBookValues.getValue());
                    case "CONS_NAME" -> n019.setCons_name(handBookValues.getValue());
                    case "DATEBEG" -> n019.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n019.setDateedn(handBookValues.getValue());
                }
            }
            listN019.add(n019);
        }
        return listN019;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N019Service f002Service = new N019Service();
        List<N019> n019s = f002Service.getN019s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N019&filters=ID_CONS%7C" + par));
        for (N019 n019 : n019s){
            if (n019.getId_cons().equals(par)){
                return false;
            }
        }
        return true;
    }
}
