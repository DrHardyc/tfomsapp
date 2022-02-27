package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.N014;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N014Service {
    public List<N014> getN014s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N014> listN014 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N014 n014 = new N014();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_THir" -> n014.setId_thir(handBookValues.getValue());
                    case "THir_NAME" -> n014.setThir_name(handBookValues.getValue());
                    case "DATEBEG" -> n014.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n014.setDateend(handBookValues.getValue());
                }
            }
            listN014.add(n014);
        }
        return listN014;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N014Service n014Service = new N014Service();
        List<N014> n014s = n014Service.getN014s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N014&filters=ID_THir%7C" + par));

        for (N014 n014 : n014s){
            if (n014.getId_thir().equals(par)){
                return false;
            }
        }
        return true;
    }
}
