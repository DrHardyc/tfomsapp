package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.N018;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N018Service {
    public List<N018> getN018s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N018> listN018 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N018 n018 = new N018();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_REAS" -> n018.setId_reas(handBookValues.getValue());
                    case "REAS_NAME" -> n018.setReas_name(handBookValues.getValue());
                    case "DATEBEG" -> n018.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n018.setDateend(handBookValues.getValue());
                }
            }
            listN018.add(n018);
        }
        return listN018;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N018Service n018Service = new N018Service();
        List<N018> n018s = n018Service.getN018s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N018&filters=smocod%7C" + par));

        for (N018 n018 : n018s){
            if (n018.getId_reas().equals(par)){
                return false;
            }
        }
        return true;
    }
}
