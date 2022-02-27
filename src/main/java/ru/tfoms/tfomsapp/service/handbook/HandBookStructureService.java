package ru.tfoms.tfomsapp.service.handbook;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.tfoms.tfomsapp.domain.handbook.HandBookStructure;
import ru.tfoms.tfomsapp.domain.handbook.HandBookStructureColumns;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;

public class HandBookStructureService {


    private HandBookStructure getHandBookStructureService(BufferedReader in) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(in, HandBookStructure.class);
    }

    public boolean checkingRelevanceStructure(BufferedReader in, Object o) throws Exception {
        HandBookStructure handBookStructure = getHandBookStructureService(in);
        return chekFields(handBookStructure, o);
    }

    private boolean chekFields(HandBookStructure handBookStructure, Object object) {

        List<HandBookStructureColumns> listHandBookStructureColumns = handBookStructure.getHandBookStructureColumns();
        Field[] fieldps = object.getClass().getDeclaredFields();

        boolean chek = false;
        for (HandBookStructureColumns hbsc : listHandBookStructureColumns){
            for (Field field : fieldps){
                if(field.getName().contains(hbsc.getName().toLowerCase(Locale.ROOT))){
                    chek = true;
                    break;
                }
            }
            if (!chek){
                System.out.println("Поле " + hbsc.getName() + " отсутсвует в справочнике " + object.getClass().getName());
                return false;
            }
            chek = false;
        }

        for (Field field : fieldps){
            if(!field.getName().equals("sysrecordid") && !field.getName().equals("syshash")
                                                        && !field.getName().equals("version")){
                for (HandBookStructureColumns hbsc : listHandBookStructureColumns){
                    if(hbsc.getName().toLowerCase(Locale.ROOT).contains(field.getName())){
                        chek = true;
                        break;
                    }
                }
                if (!chek){
                    System.out.println("Поле " + field.getName() +  " справочника " + object.getClass().getName() + " отсутсвует в запрошенной структуре");
                    return false;
                }
                chek = false;
            }
        }
        return chek;
    }
}
