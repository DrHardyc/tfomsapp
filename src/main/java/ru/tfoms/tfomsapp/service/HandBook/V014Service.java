package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F008;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V014;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V014Service {
    public List<V014> getV014s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V014> listV014 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V014 v014 = new V014();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDFRMMP" -> v014.setIdfrmmp(handBookValues.getValue());
                    case "FRMMPNAME" -> v014.setFrmmpname(handBookValues.getValue());
                    case "DATEBEG" -> v014.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v014.setDateend(handBookValues.getValue());
                }
            }
            listV014.add(v014);
        }
        return listV014;
    }

    public boolean CheckV014(List<V014> v014s, String par) {
        for (V014 v014 : v014s){
            if (v014.getIdfrmmp().equals(par)){
                return false;
            }
        }
        return true;
    }
}
