package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.N007;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N007Service {
    public List<N007> getN007s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N007> listN007 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N007 n007 = new N007();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_Mrf" -> n007.setId_mrf(handBookValues.getValue());
                    case "Mrf_NAME" -> n007.setMrf_name(handBookValues.getValue());
                    case "DATEBEG" -> n007.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n007.setDateend(handBookValues.getValue());
                }
            }
            listN007.add(n007);
        }
        return listN007;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N007Service n007Service = new N007Service();
        List<N007> n007s = n007Service.getN007s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N007&filters=ID_Mrf%7C" + par));

        for (N007 n007 : n007s){
            if (n007.getId_mrf().equals(par)){
                return false;
            }
        }
        return true;
    }
}
