package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.O002;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class O002Service {
    public ArrayList<O002> getO002s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<O002> listO002 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            O002 o002 = new O002();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "TER" -> o002.setTer(handBookValues.getValue());
                    case "KOD1" -> o002.setKod1(handBookValues.getValue());
                    case "KOD2" -> o002.setKod2(handBookValues.getValue());
                    case "KOD3" -> o002.setKod3(handBookValues.getValue());
                    case "RAZDEL" -> o002.setRazdel(handBookValues.getValue());
                    case "NAME1" -> o002.setName1(handBookValues.getValue());
                    case "CENTRUM" -> o002.setCentrum(handBookValues.getValue());
                    case "NOMDESCR" -> o002.setNomdescr(handBookValues.getValue());
                    case "NOMACT" -> o002.setNomakt(handBookValues.getValue());
                    case "STATUS" -> o002.setStatus(handBookValues.getValue());
                    case "DATEUTV" -> o002.setDateutv(handBookValues.getValue());
                    case "DATEVVED" -> o002.setDatevved(handBookValues.getValue());
                }
            }
            listO002.add(o002);
        }
        return listO002;
    }
}
