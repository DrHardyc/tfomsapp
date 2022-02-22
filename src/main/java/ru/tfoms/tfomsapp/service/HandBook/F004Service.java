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
                    case "tf_okato" -> f004.setTf_okato(handBookValues.getValue());
                    case "n_expert" -> f004.setN_expert(handBookValues.getValue());
                    case "fam" -> f004.setFam(handBookValues.getValue());
                    case "im" -> f004.setIm(handBookValues.getValue());
                    case "ot" -> f004.setOt(handBookValues.getValue());
                    case "SNILS" -> f004.setSnils(handBookValues.getValue());
                    case "phone1" -> f004.setPhone1(handBookValues.getValue());
                    case "phone2" -> f004.setPhone2(handBookValues.getValue());
                    case "e_mail1" -> f004.setE_mail1(handBookValues.getValue());
                    case "e_mail2" -> f004.setE_mail2(handBookValues.getValue());
                    case "date_red" -> f004.setDate_reg(handBookValues.getValue());
                }
            }
            listF004.add(f004);
        }
        return listF004;
    }

    public boolean CheckF004(List<F004> f004s, List<String> par) {
        for (F004 f004 : f004s){
            for (String codeexp : par){
                if (f004.getN_expert().equals(codeexp)){
                    return false;
                }
            }
        }
        return true;
    }
}
