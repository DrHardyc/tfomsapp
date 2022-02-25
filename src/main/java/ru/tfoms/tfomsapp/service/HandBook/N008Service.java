package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F002;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.N008;
import ru.tfoms.tfomsapp.domain.HandBook.N018;
import ru.tfoms.tfomsapp.service.ServiceUtil;

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

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N008Service n008Service = new N008Service();
        List<N008> n008s = n008Service.getN008s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N008&filters=ID_R_M%7C" + par));

        for (N008 n018 : n008s){
            if (n018.getId_r_m().equals(par)){
                return false;
            }
        }
        return true;
    }
}
