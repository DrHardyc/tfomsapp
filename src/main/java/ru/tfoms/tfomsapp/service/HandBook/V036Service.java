package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V036;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V036Service {
    public List<V036> getV036s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V036> listV036 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V036 v036 = new V036();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "S_CODE" -> v036.setS_code(handBookValues.getValue());
                    case "NAME" -> v036.setName(handBookValues.getValue());
                    case "Parameter" -> v036.setParameter(handBookValues.getValue());
                    case "COMMENT" -> v036.setComment(handBookValues.getValue());
                    case "DATEBEG" -> v036.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v036.setDateend(handBookValues.getValue());
                }
            }
            listV036.add(v036);
        }
        return listV036;
    }
}
