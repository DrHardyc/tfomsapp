package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.N016;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N016Service {
    public List<N016> getN016s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N016> listN016 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N016 n016 = new N016();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_TLek_V" -> n016.setId_tlek_v(handBookValues.getValue());
                    case "TLek_NAME_V" -> n016.setTlek_name_v(handBookValues.getValue());
                    case "DATEBEG" -> n016.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n016.setDateend(handBookValues.getValue());
                }
            }
            listN016.add(n016);
        }
        return listN016;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N016Service n016Service = new N016Service();
        List<N016> n016s = n016Service.getN016s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N016&filters=ID_TLek_V%7C" + par));

        for (N016 n016 : n016s){
            if (n016.getId_tlek_v().equals(par)){
                return false;
            }
        }
        return true;
    }
}
