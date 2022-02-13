package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V032;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V032Service {
    public List<V032> getV032s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V032> listV032 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V032 v032 = new V032();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "SCHEDRUGGRCD" -> v032.setSchedruggrcd(handBookValues.getValue());
                    case "NAME" -> v032.setName(handBookValues.getValue());
                    case "SCHEMCODE" -> v032.setShemcode(handBookValues.getValue());
                    case "DATEBEG" -> v032.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v032.setDateend(handBookValues.getValue());
                }
            }
            listV032.add(v032);
        }
        return listV032;
    }
}
