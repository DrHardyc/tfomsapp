package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.V028;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V028Service {
    public List<V028> getV028s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V028> listV028 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V028 v028 = new V028();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDVN" -> v028.setIdvn(handBookValues.getValue());
                    case "N_VN" -> v028.setN_vn(handBookValues.getValue());
                    case "DATEBEG" -> v028.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v028.setDateend(handBookValues.getValue());
                }
            }
            listV028.add(v028);
        }
        return listV028;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V028Service v028Service = new V028Service();
        List<V028> v028s = v028Service.getV028s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V028&filters=smocod%7C" + par));

        for (V028 v028 : v028s){
            if (v028.getIdvn().equals(par)){
                return false;
            }
        }
        return true;
    }
}
