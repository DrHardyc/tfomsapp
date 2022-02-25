package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F002;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.N010;
import ru.tfoms.tfomsapp.domain.HandBook.N018;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N010Service {
    public List<N010> getN010s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N010> listN010 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N010 n010 = new N010();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_Igh" -> n010.setId_igh(handBookValues.getValue());
                    case "KOD_Igh" -> n010.setKod_igh(handBookValues.getValue());
                    case "Igh_NAME" -> n010.setIgh_name(handBookValues.getValue());
                    case "DATEBEG" -> n010.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n010.setDateend(handBookValues.getValue());
                }
            }
            listN010.add(n010);
        }
        return listN010;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N010Service n010Service = new N010Service();
        List<N010> n010s = n010Service.getN010s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N010&filters=ID_Igh%7C" + par));

        for (N010 n010 : n010s){
            if (n010.getId_igh().equals(par)){
                return false;
            }
        }
        return true;
    }
}
