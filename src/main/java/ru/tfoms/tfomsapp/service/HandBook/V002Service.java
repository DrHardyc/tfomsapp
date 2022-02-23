package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V002;
import ru.tfoms.tfomsapp.domain.HandBook.V010;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V002Service {
    public List<V002> getV002s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V002> listV002 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V002 v002 = new V002();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDPR" -> v002.setIdpr(handBookValues.getValue());
                    case "PRNAME" -> v002.setPrname(handBookValues.getValue());
                    case "DATEBEG" -> v002.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v002.setDateend(handBookValues.getValue());
                }
            }
            listV002.add(v002);
        }
        return listV002;
    }

    public boolean CheckV002(List<V002> v002s, String par) {
        if (par.isEmpty()) return false;
        for (V002 v002 : v002s){
            if (v002.getIdpr().equals(par)){
                return false;
            }
        }
        return true;
    }
}
