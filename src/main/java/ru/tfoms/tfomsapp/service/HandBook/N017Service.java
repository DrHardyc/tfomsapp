package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F002;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.N017;
import ru.tfoms.tfomsapp.domain.HandBook.N018;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N017Service {
    public List<N017> getN017s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N017> listN017 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N017 n017 = new N017();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_TLuch" -> n017.setId_tluch(handBookValues.getValue());
                    case "TLuch_NAME" -> n017.setTluch_name(handBookValues.getValue());
                    case "DATEBEG" -> n017.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n017.setDateend(handBookValues.getValue());
                }
            }
            listN017.add(n017);
        }
        return listN017;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N017Service n017Service = new N017Service();
        List<N017> n017s = n017Service.getN017s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N017&filters=ID_TLuch%7C" + par));

        for (N017 n017 : n017s){
            if (n017.getId_tluch().equals(par)){
                return false;
            }
        }
        return true;
    }
}
