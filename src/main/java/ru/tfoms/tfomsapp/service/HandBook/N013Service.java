package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.N013;
import ru.tfoms.tfomsapp.domain.HandBook.N018;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N013Service {
    public List<N013> getN013s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N013> listN013 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N013 n013 = new N013();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_TLech" -> n013.setId_tlech(handBookValues.getValue());
                    case "TLech_NAME" -> n013.setTlech_name(handBookValues.getValue());
                    case "DATEBEG" -> n013.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n013.setDateend(handBookValues.getValue());
                }
            }
            listN013.add(n013);
        }
        return listN013;
    }

    public boolean CheckN013(List<N013> n013s, String par) {
        if (par.isEmpty()) return false;
        for (N013 n013 : n013s){
            if (n013.getId_tlech().equals(par)){
                return false;
            }
        }
        return true;
    }
}
