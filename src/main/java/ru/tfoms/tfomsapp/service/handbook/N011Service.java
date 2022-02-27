package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.domain.handbook.N011;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class N011Service {
    public List<N011> getN011s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<N011> listN011 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            N011 n011 = new N011();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "ID_R_I" -> n011.setId_r_i(handBookValues.getValue());
                    case "ID_Igh" -> n011.setId_igh(handBookValues.getValue());
                    case "KOD_R_I" -> n011.setKod_r_i(handBookValues.getValue());
                    case "R_I_NAME" -> n011.setR_i_name(handBookValues.getValue());
                    case "DATEBEG" -> n011.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> n011.setDateend(handBookValues.getValue());
                }
            }
            listN011.add(n011);
        }
        return listN011;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        N011Service n011Service = new N011Service();
        List<N011> n011s = n011Service.getN011s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=N011&filters=ID_R_I%7C" + par));

        for (N011 n011 : n011s){
            if (n011.getId_r_i().equals(par)){
                return false;
            }
        }
        return true;
    }
}
