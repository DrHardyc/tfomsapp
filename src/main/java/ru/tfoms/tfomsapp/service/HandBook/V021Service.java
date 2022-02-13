package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V020;
import ru.tfoms.tfomsapp.domain.HandBook.V021;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V021Service {
    public List<V021> getV021s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V021> listV021 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V021 v021 = new V021();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDSPEC" -> v021.setIdspec(handBookValues.getValue());
                    case "SPECNAME" -> v021.setSpecname(handBookValues.getValue());
                    case "POSTNAME" -> v021.setPostname(handBookValues.getValue());
                    case "IDPOST_MZ" -> v021.setIdpost_mz(handBookValues.getValue());
                    case "DATEBEG" -> v021.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v021.setDateend(handBookValues.getValue());
                }
            }
            listV021.add(v021);
        }
        return listV021;
    }
}
