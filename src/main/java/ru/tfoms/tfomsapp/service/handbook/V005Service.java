package ru.tfoms.tfomsapp.service.handbook;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.handbook.F002;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.V005;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class V005Service {
    public List<V005> getV005s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V005> listV005 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues) {
            V005 v005 = new V005();
            for (HandBookValues handBookValues : handBooksValues) {
                switch (handBookValues.getColumn()) {
                    case "IDPOL" -> v005.setIdpol(handBookValues.getValue());
                    case "POLNAME" -> v005.setPolname(handBookValues.getValue());
                }
            }
            listV005.add(v005);
        }
        return listV005;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V005Service v005Service = new V005Service();
        List<V005> v005s = v005Service.getV005s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V005&filters=IDPOL%7C" + par));
        for (V005 v005 : v005s){
            if (v005.getIdpol().equals(par)){
                return false;
            }
        }
        return true;
    }
}
