package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.V025;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V025Service {
    public List<V025> getV025s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V025> listV025 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V025 v025 = new V025();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDPC" -> v025.setIdpc(handBookValues.getValue());
                    case "N_PC" -> v025.setN_pc(handBookValues.getValue());
                    case "DATEBEG" -> v025.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v025.setDateend(handBookValues.getValue());
                }
            }
            listV025.add(v025);
        }
        return listV025;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V025Service v025Service = new V025Service();
        List<V025> v025s = v025Service.getV025s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V025&filters=IDPC%7C" + par));

        for (V025 v025 : v025s){
            if (v025.getIdpc().equals(par)){
                return false;
            }
        }
        return true;
    }
}
