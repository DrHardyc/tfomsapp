package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V008;
import ru.tfoms.tfomsapp.domain.HandBook.V028;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V028Service {
    public List<V028> getV028s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V028> listV028 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V028 v028 = new V028();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDVN" -> v028.setIdvn(handBookValues.getValue());
                    case "N_VN" -> v028.setN_vn(handBookValues.getValue());
                    case "DATEBEG" -> v028.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v028.setDateend(handBookValues.getValue());
                }
            }
            listV028.add(v028);
        }
        return listV028;
    }

    public boolean CheckV028(List<V028> v028s, String par) {
        if (par.isEmpty()) return false;
        for (V028 v028 : v028s){
            if (v028.getIdvn().equals(par)){
                return false;
            }
        }
        return true;
    }
}
