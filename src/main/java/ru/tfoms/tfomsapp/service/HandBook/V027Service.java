package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V014;
import ru.tfoms.tfomsapp.domain.HandBook.V027;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V027Service {
    public List<V027> getV027s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V027> listV027 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V027 v027 = new V027();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ISCZ" -> v027.setIdcz(handBookValues.getValue());
                    case "N_CZ" -> v027.setN_cz(handBookValues.getValue());
                    case "DATEBEG" -> v027.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v027.setDateend(handBookValues.getValue());
                }
            }
            listV027.add(v027);
        }
        return listV027;
    }
}
