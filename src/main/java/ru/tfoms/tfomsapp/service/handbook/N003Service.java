package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.N003;
import ru.tfoms.tfomsapp.service.ServiceUtil;

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

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N003Service n003Service = new N003Service();
        List<N003> n003s = n003Service.getN003s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N003&filters=ID_T%7C" + par));

        for (N003 n003 : n003s){
            if (n003.getId_t().equals(par)){
                return false;
            }
        }
        return true;
    }
}
