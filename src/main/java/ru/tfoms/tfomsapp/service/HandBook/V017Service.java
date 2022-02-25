package ru.tfoms.tfomsapp.service.HandBook;

import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.N001;
import ru.tfoms.tfomsapp.domain.HandBook.V017;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class V017Service {
    private List<V017> getV017s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V017> listV017 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V017 v017 = new V017();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDDR" -> v017.setIddr(handBookValues.getValue());
                    case "DRNAME" -> v017.setDrname(handBookValues.getValue());
                    case "DATEBEG" -> v017.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v017.setDateend(handBookValues.getValue());
                }
            }
            listV017.add(v017);
        }
        return listV017;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V017Service v017Service = new V017Service();
        List<V017> v017s = v017Service.getV017s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V017&filters=IDDR%7C" + par));

        for (V017 v017 : v017s){
            if (v017.getIddr().equals(par)){
                return false;
            }
        }
        return true;
    }
}
