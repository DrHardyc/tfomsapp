package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V009;
import ru.tfoms.tfomsapp.domain.HandBook.V012;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V012Service {
    public List<V012> getV012s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V012> listV012 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V012 v012 = new V012();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDIZ" -> v012.setIdiz(handBookValues.getValue());
                    case "IZNAME" -> v012.setIzname(handBookValues.getValue());
                    case "DL_USLOV" -> v012.setId_uslov(handBookValues.getValue());
                    case "DATEBEG" -> v012.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v012.setDateend(handBookValues.getValue());
                }
            }
            listV012.add(v012);
        }
        return listV012;
    }

    public boolean CheckV012(List<V012> v012s, String par) {
        for (V012 v012 : v012s){
            if (v012.getIdiz().equals(par)){
                return false;
            }
        }
        return true;
    }
}
