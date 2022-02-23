package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V010;
import ru.tfoms.tfomsapp.domain.HandBook.V020;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V020Service {
    public List<V020> getV020s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V020> listV020 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V020 v020 = new V020();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDK_PR" -> v020.setIdk_pr(handBookValues.getValue());
                    case "K_PRNAME" -> v020.setK_prname(handBookValues.getValue());
                    case "DATEBEG" -> v020.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v020.setDateend(handBookValues.getValue());
                }
            }
            listV020.add(v020);
        }
        return listV020;
    }

    public boolean CheckV020(List<V020> v020s, String par) {
        if (par.isEmpty()) return false;
        for (V020 v020 : v020s){
            if (v020.getIdk_pr().equals(par)){
                return false;
            }
        }
        return true;
    }
}
