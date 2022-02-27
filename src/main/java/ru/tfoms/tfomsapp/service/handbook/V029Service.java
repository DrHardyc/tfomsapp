package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.V029;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V029Service {
    public List<V029> getV029s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V029> listV029 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V029 v029 = new V029();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDMET" -> v029.setIdmet(handBookValues.getValue());
                    case "N_MET" -> v029.setN_met(handBookValues.getValue());
                    case "DATEBEG" -> v029.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v029.setDateend(handBookValues.getValue());
                }
            }
            listV029.add(v029);
        }
        return listV029;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V029Service v029Service = new V029Service();
        List<V029> v029s = v029Service.getV029s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V029&filters=IDMET%7C" + par));

        for (V029 v029 : v029s){
            if (v029.getIdmet().equals(par)){
                return false;
            }
        }
        return true;
    }
}
