package ru.tfoms.tfomsapp.service.handbook;

import ru.tfoms.tfomsapp.domain.handbook.F008;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class F008Service {
    public List<F008> getF008s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<F008> listF008 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            F008 f008 = new F008();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDDOC" -> f008.setIddoc(handBookValues.getValue());
                    case "DOCNAME" -> f008.setDocname(handBookValues.getValue());
                    case "DATEBEG" -> f008.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> f008.setDateend(handBookValues.getValue());
                }
            }
            listF008.add(f008);
        }
        return listF008;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        F008Service f008Service = new F008Service();
        List<F008> f008s = f008Service.getF008s(su.getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F008&filters=IDDOC%7C" + par));

        for (F008 f008 : f008s){
            if (f008.getIddoc().equals(par)){
                return false;
            }
        }
        return true;
    }
}
