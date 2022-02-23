package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F002;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class F002Service {

    public List<F002> getF002s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<F002> listF002 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues) {
            F002 f002 = new F002();
            for (HandBookValues handBookValues : handBooksValues) {
                switch (handBookValues.getColumn()) {
                    case "smocod" -> f002.setSmocod(handBookValues.getValue());
                    case "Ogrn" -> f002.setOgrn(handBookValues.getValue());
                    case "KPP" -> f002.setKpp(handBookValues.getValue());
                    case "nam_smop" -> f002.setNam_smop(handBookValues.getValue());
                    case "nam_smok" -> f002.setNam_smok(handBookValues.getValue());
                    case "addr_f" -> f002.setAddr_f(handBookValues.getValue());
                    case "fam_ruk" -> f002.setFam_ruk(handBookValues.getValue());
                    case "im_ruk" -> f002.setIm_ruk(handBookValues.getValue());
                    case "ot_ruk" -> f002.setOt_ruk(handBookValues.getValue());
                    case "phone" -> f002.setPhone(handBookValues.getValue());
                    case "fax" -> f002.setFax(handBookValues.getValue());
                    case "hot_line" -> f002.setHot_line(handBookValues.getValue());
                    case "e_mail" -> f002.setE_mail(handBookValues.getValue());
                    case "n_doc" -> f002.setN_doc(handBookValues.getValue());
                    case "d_start" -> f002.setD_start(handBookValues.getValue());
                    case "date_e" -> f002.setDate_e(handBookValues.getValue());
                    case "d_begin" -> f002.setD_begin(handBookValues.getValue());
                    case "d_end" -> f002.setD_end(handBookValues.getValue());
                }
            }
            listF002.add(f002);
        }
        return listF002;
    }

    public boolean CheckF002(List<F002> f002s, String par){
        if (par.isEmpty()) return false;
        for (F002 f002 : f002s){
            if (f002.getSmocod().equals(par)){
                return false;
            }
        }
        return true;
    }
}
