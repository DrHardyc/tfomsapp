package ru.tfoms.tfomsapp.service.HandBook;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.tfoms.tfomsapp.domain.HandBook.HBQ018;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookStructure;
import ru.tfoms.tfomsapp.domain.HandBook.HandBookStructureColumns;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class HandBookStructureService {


    private HandBookStructure getHandBookStructureService(BufferedReader in) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(in, HandBookStructure.class);
    }

    public boolean checkingRelevanceStructure(String handBookCode, BufferedReader in) throws Exception {

        HandBookStructure handBookStructure = getHandBookStructureService(in);
        switch (handBookCode){
            case "Q018" -> {
                HBQ018 hbq018 = new HBQ018();

                List<HandBookStructureColumns> listHandBookStructureColumns = handBookStructure.getHandBookStructureColumns();
                for (HandBookStructureColumns hbsc : listHandBookStructureColumns){
                    boolean chek = false;
                    Field[] fieldps = hbq018.getClass().getDeclaredFields();
                    for (Field field : fieldps){
                        if(field.getName().contains(hbsc.getName().toLowerCase(Locale.ROOT))){
                            chek = true;
                            break;
                        }
                    }
                    if (!chek){
                        System.out.println(hbsc.getName());
                        return false;
                    }

                }
            }
            case "Q016" -> {

            }
        }


        return true;
    }

}
