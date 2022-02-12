package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F003;
import ru.tfoms.tfomsapp.domain.HandBook.F008;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class F003Service {
    public List<F003> getF003s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<F003> listF003 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            F003 f003 = new F003();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "TF_OKATO" -> f003.setTf_okato(handBookValues.getValue());
                    case "mcod" -> f003.setMcod(handBookValues.getValue());
                    case "NAM_MOP" -> f003.setNam_mop(handBookValues.getValue());
                    case "NAM_MOK" -> f003.setNam_mok(handBookValues.getValue());
                    case "INN" -> f003.setInn(handBookValues.getValue());
                    case "OGRN" -> f003.setOgrn(handBookValues.getValue());
                    case "KPP" -> f003.setKpp(handBookValues.getValue());
                    case "INDEX_J" -> f003.setIndex_j(handBookValues.getValue());
                    case "ADDR_J" -> f003.setAddr_j(handBookValues.getValue());
                    case "OKOPF" -> f003.setOkopf(handBookValues.getValue());
                    case "VEDPRI" -> f003.setVedpri(handBookValues.getValue());
                    case "ORG" -> f003.setOrg(handBookValues.getValue());
                    case "FAM_RUK" -> f003.setFam_ruk(handBookValues.getValue());
                    case "IM_RUK" -> f003.setIm_ruk(handBookValues.getValue());
                    case "OT_RUK" -> f003.setOt_ruk(handBookValues.getValue());
                    case "PHONE1" -> f003.setPhone1(handBookValues.getValue());
                    case "PHONE2" -> f003.setPhone2(handBookValues.getValue());
                    case "FAX1" -> f003.setFax1(handBookValues.getValue());
                    case "FAX2" -> f003.setFax2(handBookValues.getValue());
                    case "E_MAIL1" -> f003.setE_mail1(handBookValues.getValue());
                    case "E_MAIL2" -> f003.setE_mail2(handBookValues.getValue());
                    case "WWW" -> f003.setWww(handBookValues.getValue());
                    case "D_EDIT" -> f003.setD_edit(handBookValues.getValue());
                    case "D_BEGIN" -> f003.setD_begin(handBookValues.getValue());
                    case "D_END" -> f003.setD_end(handBookValues.getValue());
                }
            }
            listF003.add(f003);
        }
        return listF003;
    }
}
