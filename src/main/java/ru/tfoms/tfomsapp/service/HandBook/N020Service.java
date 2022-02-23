package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.N020;
import ru.tfoms.tfomsapp.domain.HandBook.V027;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N020Service {
    public List<N020> getN020s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N020> listN020 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N020 n020 = new N020();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_LEKP" -> n020.setId_lekp(handBookValues.getValue());
                    case "MNN" -> n020.setMnn(handBookValues.getValue());
                    case "DATEBEG" -> n020.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n020.setDateend(handBookValues.getValue());
                }
            }
            listN020.add(n020);
        }
        return listN020;
    }

    public boolean CheckN020(List<N020> n020s, String par) {
        if (par.isEmpty()) return false;
        for (N020 n020 : n020s){
            if (n020.getId_lekp().equals(par)){
                return false;
            }
        }
        return true;
    }
}
