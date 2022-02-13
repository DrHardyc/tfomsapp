package ru.tfoms.tfomsapp.service.HandBook;

import ru.tfoms.tfomsapp.domain.HandBook.F008;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.O002;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class F008Service {
    public List<F008> getF008s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<F008> listF008 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            F008 f008 = new F008();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDDOC" -> f008.setIddoc(handBookValues.getValue());
                    case "DOCNAME" -> f008.setDocname(handBookValues.getValue());
                    case "DATEBEG" -> f008.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> f008.setDateend(handBookValues.getValue());
                }
            }
            listF008.add(f008);
        }
        return listF008;
    }
}
