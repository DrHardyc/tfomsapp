package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.N004;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N004Service {
    public List<N004> getN004s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N004> listN004 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N004 n004 = new N004();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_N" -> n004.setId_n(handBookValues.getValue());
                    case "DS_N" -> n004.setDs_n(handBookValues.getValue());
                    case "KOD_N" -> n004.setKod_n(handBookValues.getValue());
                    case "N_NAME" -> n004.setN_name(handBookValues.getValue());
                    case "DATEBEG" -> n004.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n004.setDateend(handBookValues.getValue());
                }
            }
            listN004.add(n004);
        }
        return listN004;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N004Service n004Service = new N004Service();
        List<N004> n004s = n004Service.getN004s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N004&filters=ID_N%7C" + par));

        for (N004 n004 : n004s){
            if (n004.getId_n().equals(par)){
                return false;
            }
        }
        return true;
    }
}
