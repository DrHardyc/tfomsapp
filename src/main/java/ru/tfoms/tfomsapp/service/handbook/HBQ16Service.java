package ru.tfoms.tfomsapp.service.handbook;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.handbook.HBQ016;
import ru.tfoms.tfomsapp.domain.handbook.HandBookValues;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HBQ16Service {

    public List<HBQ016> gethbq016(BufferedReader in) throws IOException {
        List<List<HandBookValues>> listHandBooksValues = new HandBookService().getHandBook(in).getDirValues();
        ArrayList<HBQ016> listHBQ016 = new ArrayList<>();
        for (List<HandBookValues> handBooksValues : listHandBooksValues){
            HBQ016 hbq016 = new HBQ016();
            for (HandBookValues handBookValues : handBooksValues){
                switch (handBookValues.getColumn()) {
                    case "SYS_RECORDID" -> hbq016.setSysrecordid(handBookValues.getValue());
                    case "SYS_HASH" -> hbq016.setSyshash(handBookValues.getValue());
                    case "ID_TEST" -> hbq016.setId_test(handBookValues.getValue());
                    case "ID_EL" -> hbq016.setId_el(handBookValues.getValue());
                    case "DESC_TEST" -> hbq016.setDesc_test(handBookValues.getValue());
                    case "TYPE_D" -> hbq016.setType_d(handBookValues.getValue());
                    case "NSI_OBJ" -> hbq016.setNsi_obj(handBookValues.getValue());
                    case "NSI_EL" -> hbq016.setNsi_el(handBookValues.getValue());
                    case "USL_TEST" -> hbq016.setUsl_test(handBookValues.getValue());
                    case "VAL_EL" -> hbq016.setVal_el(handBookValues.getValue());
                    case "COMMENT" -> hbq016.setComment(handBookValues.getValue());
                    case "DATEBEG" -> hbq016.setDatebeg(handBookValues.getValue());
                    case "DATEEND" -> hbq016.setDateend(handBookValues.getValue());
                }
            }
            listHBQ016.add(hbq016);
        }
        return listHBQ016;
    }
}
