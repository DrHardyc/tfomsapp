package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.N015;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N015Service {
    public List<N015> getN015s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N015> listN015 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N015 n015 = new N015();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_TLek_L" -> n015.setId_tlek_l(handBookValues.getValue());
                    case "TLek_NAME_L" -> n015.setTlek_name_l(handBookValues.getValue());
                    case "DATEBEG" -> n015.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n015.setDateend(handBookValues.getValue());
                }
            }
            listN015.add(n015);
        }
        return listN015;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N015Service n015Service = new N015Service();
        List<N015> n015s = n015Service.getN015s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N015&filters=ID_TLek_L%7C" + par));

        for (N015 n015 : n015s){
            if (n015.getId_tlek_l().equals(par)){
                return false;
            }
        }
        return true;
    }
}
