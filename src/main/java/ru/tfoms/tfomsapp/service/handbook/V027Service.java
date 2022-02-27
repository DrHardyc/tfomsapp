package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.V027;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V027Service {
    public List<V027> getV027s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V027> listV027 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V027 v027 = new V027();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDCZ" -> v027.setIdcz(handBookValues.getValue());
                    case "N_CZ" -> v027.setN_cz(handBookValues.getValue());
                    case "DATEBEG" -> v027.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v027.setDateend(handBookValues.getValue());
                }
            }
            listV027.add(v027);
        }
        return listV027;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V027Service v027Service = new V027Service();
        List<V027> v027s = v027Service.getV027s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V027&filters=IDCZ%7C" + par));

        for (V027 v027 : v027s){
            if (v027.getIdcz().equals(par)){
                return false;
            }
        }
        return true;
    }

}
