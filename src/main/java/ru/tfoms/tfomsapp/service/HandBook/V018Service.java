package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V012;
import ru.tfoms.tfomsapp.domain.HandBook.V018;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V018Service {
    public List<V018> getV018s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V018> listV018 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V018 v018 = new V018();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDHVID" -> v018.setIdhvid(handBookValues.getValue());
                    case "HVIDNAME" -> v018.setHvidname(handBookValues.getValue());
                    case "DATEBEG" -> v018.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v018.setDateend(handBookValues.getValue());
                }
            }
            listV018.add(v018);
        }
        return listV018;
    }

    public boolean CheckV018(List<V018> v018s, String par) {
        if (par.isEmpty()) return false;
        for (V018 v018 : v018s){
            if (v018.getIdhvid().equals(par)){
                return false;
            }
        }
        return true;
    }
}
