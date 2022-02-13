package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.O002;
import ru.tfoms.tfomsapp.domain.HandBook.V026;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class V026Service {
    public List<V026> getV026s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<V026> listV026 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues) {
            V026 v026 = new V026();
            for (HandBookValues handBookValues : handBooksValues) {
                switch (handBookValues.getColumn()) {
                    case "IDUMP" -> v026.setIdump(handBookValues.getValue());
                    case "K_KPG" -> v026.setK_kpg(handBookValues.getValue());
                    case "N_KPG" -> v026.setN_kpg(handBookValues.getValue());
                    case "KOEF_Z" -> v026.setKoef_z(handBookValues.getValue());
                    case "DATEBEG" -> v026.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> v026.setDateend(handBookValues.getValue());
                }
            }
            listV026.add(v026);
        }
        return listV026;
    }
}
