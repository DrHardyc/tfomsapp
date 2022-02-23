package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.N010;
import ru.tfoms.tfomsapp.domain.HandBook.N018;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N010Service {
    public List<N010> getN010s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N010> listN010 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N010 n010 = new N010();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_Igh" -> n010.setId_igh(handBookValues.getValue());
                    case "KOD_Igh" -> n010.setKod_igh(handBookValues.getValue());
                    case "Igh_NAME" -> n010.setIgh_name(handBookValues.getValue());
                    case "DATEBEG" -> n010.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n010.setDateend(handBookValues.getValue());
                }
            }
            listN010.add(n010);
        }
        return listN010;
    }

    public boolean CheckN010(List<N010> n010s, String par) {
        if (par.isEmpty()) return false;
        for (N010 n010 : n010s){
            if (n010.getId_igh().equals(par)){
                return false;
            }
        }
        return true;
    }
}
