package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F002;
import ru.tfoms.tfomsapp.domain.HandBook.F008;
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
                    case "SMOCOD" -> f002.setSmocod(handBookValues.getValue());
                    case "OGRN" -> f002.setOgrn(handBookValues.getValue());
                    case "KPP" -> f002.setKpp(handBookValues.getValue());
                    case "NAM_SMOP" -> f002.setNam_smop(handBookValues.getValue());
                    case "NAM_SMOK" -> f002.setNam_smok(handBookValues.getValue());
                    case "ADDR_F" -> f002.setAddr_f(handBookValues.getValue());
                    case "FAM_RUK" -> f002.setFam_ruk(handBookValues.getValue());
                    case "IM_RUK" -> f002.setIm_ruk(handBookValues.getValue());
                    case "OT_RUK" -> f002.setOt_ruk(handBookValues.getValue());
                    case "PHONE" -> f002.setPhone(handBookValues.getValue());
                    case "FAX" -> f002.setFax(handBookValues.getValue());
                    case "HOT_LINE" -> f002.setHot_line(handBookValues.getValue());
                    case "E_MAIL" -> f002.setE_mail(handBookValues.getValue());
                    case "N_DOC" -> f002.setN_doc(handBookValues.getValue());
                    case "D_START" -> f002.setD_start(handBookValues.getValue());
                    case "DATE_E" -> f002.setDate_e(handBookValues.getValue());
                    case "D_BEGIN" -> f002.setD_begin(handBookValues.getValue());
                    case "D_END" -> f002.setD_end(handBookValues.getValue());
                }
            }
            listF002.add(f002);
        }
        return listF002;
    }
}
