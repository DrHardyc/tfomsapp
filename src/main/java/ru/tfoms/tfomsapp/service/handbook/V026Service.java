package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.V026;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V026Service {
    public List<V026> getV026s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V026> listV026 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues) {
            V026 v026 = new V026();
            for (HandBookValues handBookValues : handBooksValues) {
                switch (handBookValues.getColumn()) {
                    case "IDUMP" -> v026.setIdump(handBookValues.getValue());
                    case "K_KPG" -> v026.setK_kpg(handBookValues.getValue());
                    case "N_KPG" -> v026.setN_kpg(handBookValues.getValue());
                    case "KOEF_Z" -> v026.setKoef_z(handBookValues.getValue());
                    case "DATEBEG" -> v026.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v026.setDateend(handBookValues.getValue());
                }
            }
            listV026.add(v026);
        }
        return listV026;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V026Service v026Service = new V026Service();
        List<V026> v026s = v026Service.getV026s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V026&filters=IDUMP%7C" + par));

        for (V026 v026 : v026s){
            if (v026.getK_kpg().equals(par)){
                return false;
            }
        }
        return true;
    }
}
