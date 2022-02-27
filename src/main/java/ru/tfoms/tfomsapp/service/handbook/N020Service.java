package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.N020;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N020Service {
    public List<N020> getN020s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N020> listN020 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N020 n020 = new N020();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_LEKP" -> n020.setId_lekp(handBookValues.getValue());
                    case "MNN" -> n020.setMnn(handBookValues.getValue());
                    case "DATEBEG" -> n020.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n020.setDateend(handBookValues.getValue());
                }
            }
            listN020.add(n020);
        }
        return listN020;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N020Service n020Service = new N020Service();
        List<N020> n020s = n020Service.getN020s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N020&filters=ID_LEKP%7C" + par));

        for (N020 n020 : n020s){
            if (n020.getId_lekp().equals(par)){
                return false;
            }
        }
        return true;
    }
}
