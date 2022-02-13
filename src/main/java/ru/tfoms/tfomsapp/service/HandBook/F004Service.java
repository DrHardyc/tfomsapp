package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.F004;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class F004Service {
    public List<F004> getF004s(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<F004> listF004 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            F004 f004 = new F004();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "TF_OKATO" -> f004.setTf_okato(handBookValues.getValue());
                    case "N_EXPERT" -> f004.setN_expert(handBookValues.getValue());
                    case "FAM" -> f004.setFam(handBookValues.getValue());
                    case "IM" -> f004.setIm(handBookValues.getValue());
                    case "OT" -> f004.setOt(handBookValues.getValue());
                    case "SNILS" -> f004.setSnils(handBookValues.getValue());
                    case "PHONE1" -> f004.setPhone1(handBookValues.getValue());
                    case "PHONE2" -> f004.setPhone2(handBookValues.getValue());
                    case "E_MAIL1" -> f004.setE_mail1(handBookValues.getValue());
                    case "E_MAIL2" -> f004.setE_mail2(handBookValues.getValue());
                    case "DATE_REG" -> f004.setDate_reg(handBookValues.getValue());
                }
            }
            listF004.add(f004);
        }
        return listF004;
    }
}
