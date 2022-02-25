package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F002;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V032;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V032Service {
    public List<V032> getV032s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V032> listV032 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            V032 v032 = new V032();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ScheDrugGrCd" -> v032.setSchedruggrcd(handBookValues.getValue());
                    case "Name" -> v032.setName(handBookValues.getValue());
                    case "SchemCode" -> v032.setShemcode(handBookValues.getValue());
                    case "DATEBEG" -> v032.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v032.setDateend(handBookValues.getValue());
                }
            }
            listV032.add(v032);
        }
        return listV032;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        V032Service v032Service = new V032Service();
        List<V032> v032s = v032Service.getV032s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=V032&filters=ScheDrugGrCd%7C" + par));

        for (V032 v032 : v032s){
            if (v032.getSchedruggrcd().equals(par)){
                return false;
            }
        }
        return true;
    }
}
