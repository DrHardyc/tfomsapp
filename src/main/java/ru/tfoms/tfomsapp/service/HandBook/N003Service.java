package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.N003;
import ru.tfoms.tfomsapp.domain.HandBook.N018;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N003Service {
    public List<N003> getN003s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N003> listN003 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N003 n003 = new N003();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_T" -> n003.setId_t(handBookValues.getValue());
                    case "DS_T" -> n003.setDs_t(handBookValues.getValue());
                    case "KOD_T" -> n003.setKod_t(handBookValues.getValue());
                    case "T_NAME" -> n003.setT_name(handBookValues.getValue());
                    case "DATEBEG" -> n003.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n003.setDateend(handBookValues.getValue());
                }
            }
            listN003.add(n003);
        }
        return listN003;
    }

    public boolean CheckN003(List<N003> n003s, String par) {
        if (par.isEmpty()) return false;
        for (N003 n003 : n003s){
            if (n003.getId_t().equals(par)){
                return false;
            }
        }
        return true;
    }
}
