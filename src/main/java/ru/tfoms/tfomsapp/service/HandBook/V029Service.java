package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V008;
import ru.tfoms.tfomsapp.domain.HandBook.V029;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V029Service {
    public List<V029> getV029s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V029> listV029 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V029 v029 = new V029();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDMET" -> v029.setIdmet(handBookValues.getValue());
                    case "N_MET" -> v029.setN_met(handBookValues.getValue());
                    case "DATEBEG" -> v029.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v029.setDateend(handBookValues.getValue());
                }
            }
            listV029.add(v029);
        }
        return listV029;
    }

    public boolean CheckV029(List<V029> v029s, String par) {
        if (par.isEmpty()) return false;
        for (V029 v029 : v029s){
            if (v029.getIdmet().equals(par)){
                return false;
            }
        }
        return true;
    }
}
