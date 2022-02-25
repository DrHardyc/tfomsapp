package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F006;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.service.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class F006Service {
    public List<F006> getF006s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<F006> listF006 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            F006 f006 = new F006();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "IDVID" -> f006.setIdvid(handBookValues.getValue());
                    case "VIDNAME" -> f006.setVidname(handBookValues.getValue());
                    case "DATEBEG" -> f006.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> f006.setDateend(handBookValues.getValue());
                }
            }
            listF006.add(f006);
        }
        return listF006;
    }

    public boolean Check(String par) throws IOException {
        if (par.isEmpty()) return false;
        ServiceUtil su = new ServiceUtil();
        F006Service f006Service = new F006Service();
        List<F006> f006s = f006Service.getF006s(su
                .getHBBufferedReader("http://nsi.ffoms.ru/nsi-int/api/data?identifier=F006&filters=IDVID%7C" + par));

        for (F006 f006  : f006s){
            if (f006.getIdvid().equals(par)){
                return false;
            }
        }
        return true;
    }
}
