package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F008;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V008;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V008Service {
    public List<V008> getV008s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V008> listV008 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V008 v008 = new V008();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDVMP" -> v008.setIdvmp(handBookValues.getValue());
                    case "VMPNAME" -> v008.setVmpname(handBookValues.getValue());
                    case "DATEBEG" -> v008.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v008.setDateend(handBookValues.getValue());
                }
            }
            listV008.add(v008);
        }
        return listV008;
    }

    public boolean CheckV008(List<V008> v008s, String par) {
        for (V008 v008 : v008s){
            if (v008.getIdvmp().equals(par)){
                return false;
            }
        }
        return true;
    }
}
