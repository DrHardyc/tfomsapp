package ru.tfoms.tfomsapp.service.handbook;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.F002;
import ru.tfoms.tfomsapp.domain.handbook.F011;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class F011Service {
    public List<F011> getF011s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<F011> listF011 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues) {
            F011 f011 = new F011();
            for (HandBookValues handBookValues : handBooksValues) {
                switch (handBookValues.getColumn()) {
                    case "IDDoc" -> f011.setIddoc(handBookValues.getValue());
                    case "DocName" -> f011.setDocname(handBookValues.getValue());
                    case "DocSer" -> f011.setDocser(handBookValues.getValue());
                    case "DocNum" -> f011.setDocnum(handBookValues.getValue());
                    case "DATEBEG" -> f011.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> f011.setDateend(handBookValues.getValue());
                }
            }
            listF011.add(f011);
        }
        return listF011;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        F011Service f011Service = new F011Service();
        List<F011> f011s = f011Service.getF011s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F011&filters=IDDoc%7C" + par));
        for (F011 f011 : f011s){
            if (f011.getIddoc().equals(par)){
                return false;
            }
        }
        return true;
    }
}
