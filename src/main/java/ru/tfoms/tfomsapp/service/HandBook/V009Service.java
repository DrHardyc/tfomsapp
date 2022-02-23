package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F008;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V009;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V009Service {
    public List<V009> getV009s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V009> listV009 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V009 v009 = new V009();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDRMP" -> v009.setIdrmp(handBookValues.getValue());
                    case "RMPNAME" -> v009.setRmpname(handBookValues.getValue());
                    case "DL_USLOV" -> v009.setDl_uslov(handBookValues.getValue());
                    case "DATEBEG" -> v009.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v009.setDateend(handBookValues.getValue());
                }
            }
            listV009.add(v009);
        }
        return listV009;
    }

    public boolean CheckV009(List<V009> v009s, String par) {
        if (par.isEmpty()) return false;
        for (V009 v009 : v009s){
            if (v009.getIdrmp().equals(par)){
                return false;
            }
        }
        return true;
    }
}
