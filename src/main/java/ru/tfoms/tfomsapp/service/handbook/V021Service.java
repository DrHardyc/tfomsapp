package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.V021;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V021Service {
    public List<V021> getV021s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V021> listV021 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V021 v021 = new V021();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDSPEC" -> v021.setIdspec(handBookValues.getValue());
                    case "SPECNAME" -> v021.setSpecname(handBookValues.getValue());
                    case "POSTNAME" -> v021.setPostname(handBookValues.getValue());
                    case "IDPOST_MZ" -> v021.setIdpost_mz(handBookValues.getValue());
                    case "DATEBEG" -> v021.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v021.setDateend(handBookValues.getValue());
                }
            }
            listV021.add(v021);
        }
        return listV021;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V021Service v021Service = new V021Service();
        List<V021> v021s = v021Service.getV021s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V021&filters=IDSPEC%7C" + par));

        for (V021 v021 : v021s){
            if (v021.getIdspec().equals(par)){
                return false;
            }
        }
        return true;
    }
}
