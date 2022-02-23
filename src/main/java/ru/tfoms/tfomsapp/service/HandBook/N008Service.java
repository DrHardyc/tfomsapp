package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.N008;
import ru.tfoms.tfomsapp.domain.HandBook.N018;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N008Service {
    public List<N008> getN008s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N008> listN008 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N008 n008 = new N008();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_R_M" -> n008.setId_r_m(handBookValues.getValue());
                    case "ID_Mrf" -> n008.setId_mrf(handBookValues.getValue());
                    case "R_M_NAME" -> n008.setR_m_name(handBookValues.getValue());
                    case "DATEBEG" -> n008.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n008.setDateend(handBookValues.getValue());
                }
            }
            listN008.add(n008);
        }
        return listN008;
    }

    public boolean CheckN008(List<N008> n008s, String par) {
        if (par.isEmpty()) return false;
        for (N008 n018 : n008s){
            if (n018.getId_r_m().equals(par)){
                return false;
            }
        }
        return true;
    }
}
