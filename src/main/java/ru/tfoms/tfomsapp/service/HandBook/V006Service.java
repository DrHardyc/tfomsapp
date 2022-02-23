package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F008;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V006;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V006Service {
    public List<V006> getV006s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V006> listV006 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V006 v006 = new V006();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDUMP" -> v006.setIdump(handBookValues.getValue());
                    case "UMPNAME" -> v006.setUmpname(handBookValues.getValue());
                    case "DATEBEG" -> v006.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v006.setDateend(handBookValues.getValue());
                }
            }
            listV006.add(v006);
        }
        return listV006;
    }

    public boolean CheckV006(List<V006> v006s, String par) {
        if (par.isEmpty()) return false;
        for (V006 v006 : v006s){
            if (v006.getIdump().equals(par)) return false;
        }
        return true;
    }
}
