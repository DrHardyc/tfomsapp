package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.V006;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V006Service {
    public List<V006> getV006s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V006> listV006 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V006 v006 = new V006();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDUMP" -> v006.setIdump(handBookValues.getValue());
                    case "UMPNAME" -> v006.setUmpname(handBookValues.getValue());
                    case "DATEBEG" -> v006.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v006.setDateend(handBookValues.getValue());
                }
            }
            listV006.add(v006);
        }
        return listV006;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V006Service v006Service = new V006Service();
        List<V006> v006s = v006Service.getV006s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V006&filters=IDUMP%7C" + par));

        for (V006 v006 : v006s){
            if (v006.getIdump().equals(par)) return false;
        }
        return true;
    }
}
