package ru.tfoms.tfomsapp.service.HandBook;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.N002;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class N002Service {
    public List<N002> getN002s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N002> listN002 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N002 n002 = new N002();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_St" -> n002.setId_st(handBookValues.getValue());
                    case "DS_St" -> n002.setDs_st(handBookValues.getValue());
                    case "KOD_St" -> n002.setKod_st(handBookValues.getValue());
                    case "DATEBEG" -> n002.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n002.setDateend(handBookValues.getValue());
                }
            }
            listN002.add(n002);
        }
        return listN002;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N002Service n002Service = new N002Service();
        List<N002> n002s = n002Service.getN002s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N002&filters=ID_St%7C" + par));

        for (N002 n002 : n002s){
            if (n002.getId_st().equals(par)){
                return false;
            }
        }
        return true;
    }
}
