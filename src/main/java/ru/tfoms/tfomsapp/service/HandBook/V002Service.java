package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F002;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V002;
import ru.tfoms.tfomsapp.domain.HandBook.V010;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V002Service {
    public List<V002> getV002s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V002> listV002 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V002 v002 = new V002();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDPR" -> v002.setIdpr(handBookValues.getValue());
                    case "PRNAME" -> v002.setPrname(handBookValues.getValue());
                    case "DATEBEG" -> v002.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v002.setDateend(handBookValues.getValue());
                }
            }
            listV002.add(v002);
        }
        return listV002;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V002Service v002Service = new V002Service();
        List<V002> v002s = v002Service.getV002s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V002&filters=IDPR%7C" + par));

        for (V002 v002 : v002s){
            if (v002.getIdpr().equals(par)){
                return false;
            }
        }
        return true;
    }
}
