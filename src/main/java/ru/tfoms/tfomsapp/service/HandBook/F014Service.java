package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F014;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.V024;

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

    public boolean CheckF014(List<F014> f014s, String sosn) {
        for (F014 f014 : f014s){
            if (f014.getOsn().equals(sosn)){
                return false;
            }
        }
        return true;
    }
}
