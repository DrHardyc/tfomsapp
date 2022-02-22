package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V001;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V001Service {
    public List<V001> getV001s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V001> listV001 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V001 v001 = new V001();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID" -> v001.setId(handBookValues.getValue());
                    case "S_CODE" -> v001.setS_code(handBookValues.getValue());
                    case "NAME" -> v001.setName(handBookValues.getValue());
                    case "REL" -> v001.setRel(handBookValues.getValue());
                    case "DATEOUT" -> v001.setDateout(handBookValues.getValue());
                }
            }
            listV001.add(v001);
        }
        return listV001;
    }

    public boolean CheckV001(List<V001> v001s, String par) {
        for (V001 v001 : v001s){
            if (v001.getS_code().equals(par)){
                return false;
            }
        }
        return true;
    }
}
