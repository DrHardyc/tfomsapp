package ru.tfoms.tfomsapp.service.Examination.MEK;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V014;
import ru.tfoms.tfomsapp.domain.HandBook.V024;
import ru.tfoms.tfomsapp.service.HandBook.HandBookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V024Service {
    public List<V024> getV024s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V024> listV024 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V024 v024 = new V024();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDDKK" -> v024.setIddkk(handBookValues.getValue());
                    case "DKKNAME" -> v024.setDkkname(handBookValues.getValue());
                    case "DATEBEG" -> v024.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v024.setDateend(handBookValues.getValue());
                }
            }
            listV024.add(v024);
        }
        return listV024;
    }
}
