package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.V010;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V010Service {
    public List<V010> getV010s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V010> listV010 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V010 v010 = new V010();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDSP" -> v010.setIdsp(handBookValues.getValue());
                    case "SPNAME" -> v010.setSpname(handBookValues.getValue());
                    case "DATEBEG" -> v010.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v010.setDateend(handBookValues.getValue());
                }
            }
            listV010.add(v010);
        }
        return listV010;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V010Service v010Service = new V010Service();
        List<V010> v010s = v010Service.getV010s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V010&filters=IDSP%7C" + par));

        for (V010 v010 : v010s){
            if (v010.getIdsp().equals(par)){
                return false;
            }
        }
        return true;
    }
}
