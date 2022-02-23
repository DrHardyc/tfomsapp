package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.N016;
import ru.tfoms.tfomsapp.domain.HandBook.N018;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N016Service {
    public List<N016> getN016s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N016> listN016 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N016 n016 = new N016();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_TLek_V" -> n016.setId_tlek_v(handBookValues.getValue());
                    case "TLek_NAME_V" -> n016.setTlek_name_v(handBookValues.getValue());
                    case "DATEBEG" -> n016.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n016.setDateend(handBookValues.getValue());
                }
            }
            listN016.add(n016);
        }
        return listN016;
    }

    public boolean CheckN016(List<N016> n016s, String par) {
        if (par.isEmpty()) return false;
        for (N016 n016 : n016s){
            if (n016.getId_tlek_v().equals(par)){
                return false;
            }
        }
        return true;
    }
}
