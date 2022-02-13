package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V010;
import ru.tfoms.tfomsapp.domain.HandBook.V012;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V010Service {
    public List<V010> getV010s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V010> listV010 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V010 v010 = new V010();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDSP" -> v010.setIdsp(handBookValues.getValue());
                    case "SPNAME" -> v010.setSpname(handBookValues.getValue());
                    case "DATEBEG" -> v010.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v010.setDateend(handBookValues.getValue());
                }
            }
            listV010.add(v010);
        }
        return listV010;
    }
}
