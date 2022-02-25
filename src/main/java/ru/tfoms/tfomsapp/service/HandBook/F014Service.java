package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F002;
import ru.tfoms.tfomsapp.domain.HandBook.F014;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V024;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class F014Service {
    public List<F014> getF014s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<F014> listF014 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            F014 f014 = new F014();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "Kod" -> f014.setKod(handBookValues.getValue());
                    case "IDVID" -> f014.setIdvid(handBookValues.getValue());
                    case "Naim" -> f014.setNaim(handBookValues.getValue());
                    case "Osn" -> f014.setOsn(handBookValues.getValue());
                    case "Komment" -> f014.setKomment(handBookValues.getValue());
                    case "K_NO" -> f014.setK_no(handBookValues.getValue());
                    case "K_SH" -> f014.setK_sh(handBookValues.getValue());
                    case "KodPG" -> f014.setKodpg(handBookValues.getValue());
                    case "DATEBEG" -> f014.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> f014.setDateend(handBookValues.getValue());
                }
            }
            listF014.add(f014);
        }
        return listF014;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        F014Service f014Service = new F014Service();
        List<F014> f014s = f014Service.getF014s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F014&filters=Osn%7C" + par));

        for (F014 f014 : f014s){
            if (f014.getOsn().equals(par)){
                return false;
            }
        }
        return true;
    }
}
