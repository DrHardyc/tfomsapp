package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.N001;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N001Service {
    public List<N001> getN001s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N001> listN001 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N001 n001 = new N001();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_PrOt" -> n001.setId_prot(handBookValues.getValue());
                    case "PrOt_NAME" -> n001.setProt_name(handBookValues.getValue());
                    case "DATEBEG" -> n001.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n001.setDateend(handBookValues.getValue());
                }
            }
            listN001.add(n001);
        }
        return listN001;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N001Service n001Service = new N001Service();
        List<N001> n001s = n001Service.getN001s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N001&filters=ID_PrOt%7C" + par));

        for (N001 n001 : n001s){
            if (n001.getId_prot().equals(par)){
                return false;
            }
        }
        return true;
    }
}
