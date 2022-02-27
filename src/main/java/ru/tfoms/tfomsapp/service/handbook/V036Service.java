package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.V036;
import ru.tfoms.tfomsapp.domain.file.mp.MPMeddev;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V036Service {
    public List<V036> getV036s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V036> listV036 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V036 v036 = new V036();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "S_CODE" -> v036.setS_code(handBookValues.getValue());
                    case "NAME" -> v036.setName(handBookValues.getValue());
                    case "Parameter" -> v036.setParameter(handBookValues.getValue());
                    case "COMMENT" -> v036.setComment(handBookValues.getValue());
                    case "DATEBEG" -> v036.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v036.setDateend(handBookValues.getValue());
                }
            }
            listV036.add(v036);
        }
        return listV036;
    }

    public boolean Check(MPMeddev par) throws IOException {
        if (par == null) return false;
        ServiceUtil su = new ServiceUtil();
        V036Service v036Service = new V036Service();
        List<V036> v036s = v036Service.getV036s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V036&filters=S_CODE%7C" + par));

        for (V036 v036 : v036s){
            if (v036.getS_code().equals(par.getCodemeddev())){
                return false;
            }
        }
        return true;
    }
}
