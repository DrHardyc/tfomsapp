package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.V009;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V009Service {
    public List<V009> getV009s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V009> listV009 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V009 v009 = new V009();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDRMP" -> v009.setIdrmp(handBookValues.getValue());
                    case "RMPNAME" -> v009.setRmpname(handBookValues.getValue());
                    case "DL_USLOV" -> v009.setDl_uslov(handBookValues.getValue());
                    case "DATEBEG" -> v009.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v009.setDateend(handBookValues.getValue());
                }
            }
            listV009.add(v009);
        }
        return listV009;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V009Service v009Service = new V009Service();
        List<V009> v009s = v009Service.getV009s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V009&filters=IDRMP%7C" + par));

        for (V009 v009 : v009s){
            if (v009.getIdrmp().equals(par)){
                return false;
            }
        }
        return true;
    }
}
