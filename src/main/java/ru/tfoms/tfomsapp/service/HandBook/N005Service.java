package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.N005;
import ru.tfoms.tfomsapp.domain.HandBook.N018;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N005Service {
    public List<N005> getN005s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N005> listN005 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N005 n005 = new N005();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_M" -> n005.setId_m(handBookValues.getValue());
                    case "DS_M" -> n005.setDs_m(handBookValues.getValue());
                    case "KOD_M" -> n005.setKod_m(handBookValues.getValue());
                    case "M_NAME" -> n005.setM_name(handBookValues.getValue());
                    case "DATEBEG" -> n005.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n005.setDateend(handBookValues.getValue());
                }
            }
            listN005.add(n005);
        }
        return listN005;
    }

    public boolean CheckN005(List<N005> n005s, String par) {
        for (N005 n005 : n005s){
            if (n005.getId_m().equals(par)){
                return false;
            }
        }
        return true;
    }
}
