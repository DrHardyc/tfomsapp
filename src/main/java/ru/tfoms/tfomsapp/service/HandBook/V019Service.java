package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V008;
import ru.tfoms.tfomsapp.domain.HandBook.V018;
import ru.tfoms.tfomsapp.domain.HandBook.V019;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V019Service {
    public List<V019> getV019s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V019> listV019 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues) {
            V019 v019 = new V019();
            for (HandBookValues handBookValues : handBooksValues) {
                switch (handBookValues.getColumn()) {
                    case "IDHM" -> v019.setIdhm(handBookValues.getValue());
                    case "HMNAME" -> v019.setHmname(handBookValues.getValue());
                    case "DIAG" -> v019.setDiag(handBookValues.getValue());
                    case "HVID" -> v019.setHvid(handBookValues.getValue());
                    case "HGR" -> v019.setHgr(handBookValues.getValue());
                    case "HMODP" -> v019.setHmodp(handBookValues.getValue());
                    case "IDMODP" -> v019.setIdmodp(handBookValues.getValue());
                    case "DATEBEG" -> v019.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v019.setDateend(handBookValues.getValue());
                }
            }
            listV019.add(v019);
        }
        return listV019;
    }

    public boolean CheckV019(List<V019> v019s, String par) {
        for (V019 v019 : v019s){
            if (v019.getIdhm().equals(par)){
                return false;
            }
        }
        return true;
    }
}
