package ru.tfoms.tfomsapp.service.HandBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.HandBook.HBQ018;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookValues;
import ru.tfoms.tfomsapp.domain.HandBook.Handbook;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class HBQ018Service {

    public List<HBQ018> getHbq018(BufferedReader in) throws Exception {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<HBQ018> listHBQ018 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            HBQ018 hbq018 = new HBQ018();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "SYS_RECORDID" -> hbq018.setSysrecordid(handBookValues.getValue());
                    case "SYS_HASH" -> hbq018.setSyshash(handBookValues.getValue());
                    case "IDZAP" -> hbq018.setIdzap(handBookValues.getValue());
                    case "ID_EL" -> hbq018.setId_el(handBookValues.getValue());
                    case "TYPE_D" -> hbq018.setType_d(handBookValues.getValue());
                    case "TYPE_E" -> hbq018.setType_e(handBookValues.getValue());
                    case "FORM_E" -> hbq018.setForm_e(handBookValues.getValue());
                    case "MXLEN_E" -> hbq018.setMxlen_e(handBookValues.getValue());
                    case "NAME_E" -> hbq018.setName_e(handBookValues.getValue());
                    case "DESC_E" -> hbq018.setDesc_e(handBookValues.getValue());
                    case "DATEBEG" -> hbq018.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> hbq018.setDateend(handBookValues.getValue());
                    case "version" -> hbq018.setVersion(handBookValues.getValue());
                }
            }
            listHBQ018.add(hbq018);
        }
        return listHBQ018;
    }
}
