package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.V014;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V014Service {
    public List<V014> getV014s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V014> listV014 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V014 v014 = new V014();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDFRMMP" -> v014.setIdfrmmp(handBookValues.getValue());
                    case "FRMMPNAME" -> v014.setFrmmpname(handBookValues.getValue());
                    case "DATEBEG" -> v014.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v014.setDateend(handBookValues.getValue());
                }
            }
            listV014.add(v014);
        }
        return listV014;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V014Service v014Service = new V014Service();
        List<V014> v014s = v014Service.getV014s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V014&filters=IDFRMMP%7C" + par));

        for (V014 v014 : v014s){
            if (v014.getIdfrmmp().equals(par)){
                return false;
            }
        }
        return true;
    }
}
