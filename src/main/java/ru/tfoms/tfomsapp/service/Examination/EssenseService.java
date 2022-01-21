package ru.tfoms.tfomsapp.service.Examination;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Pacient;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPZap;

import java.util.List;

@Service
public class EssenseService {

    private final int [] RSLT200 = {407, 408, 409, 410, 411, 412, 413, 414, 417};
    private final int [] RSLT220 = {202, 203, 204, 205, 206, 207, 208};
    private final int [] RSLT211 = {102, 103, 104, 105, 106, 109, 108,107, 110};
    private final int [] RSLT331 = {105, 106};
    private final int [] RSLT341 = {205, 206};
    private final int [] RSLT361 = {405, 406};
    private final int [] VIDPOM290 = {2, 21, 22, 23};
    private final int [] VIDPOM300 = {1, 2, 11, 12, 13, 4, 14};
    private final int [] VIDPOM310 = {12, 13, 14, 31, 32, 33};
    private final int [] VIDPOM320 = {3, 21, 31, 32, 33};

    public void ExamEssense(List<Pacient> pacients) {
//        for (Pacient pacient : pacients){
//            //Q016
//            //ZL_LIST/ZAP/Z_SL/VIDPOM
//            List<MPZap> MPZaps = pacient.getMPZap();
//            for (MPZap MPZap : MPZaps){
//                switch (MPZap.getSluch().getUslok()){
//                    case "4" -> {
//                        if(!searchInArray(VIDPOM290, MPZap.getSluch().getVidpom())){
//                            System.out.println("Ошибка в " + VIDPOM290.getClass().getSimpleName());
//                        }
//                    }
//                    case "3" -> {
//                        if (!searchInArray(VIDPOM300, MPZap.getSluch().getVidpom())){
//                            System.out.println("Ошибка в " + VIDPOM300.getClass().getSimpleName());
//                        }
//                    }
//                    case "2" -> {
//                        if (!searchInArray(VIDPOM310, MPZap.getSluch().getVidpom())){
//                            System.out.println("Ошибка в " + VIDPOM310.getClass().getSimpleName());
//                        }
//                    }
//                    case "1" -> {
//                        if (!searchInArray(VIDPOM320, MPZap.getSluch().getVidpom())){
//                            System.out.println("Ошибка в " + VIDPOM320.getClass().getSimpleName());
//                        }
//                    }
//                }
//                //ZL_LIST/ZAP/Z_SL/SUMV
//                if(MPZap.getSluch().getPotk().equals("1")){
//                    if(!MPZap.getSluch().getSumv().equals("0")){
//                        System.out.println("Неверное значение суммы, выставленной к оплате | SUMV");
//                    }
//                }
//                //ZL_LIST/ZAP/Z_SL/SUMP
//                if(!MPZap.getSluch().getSump().isEmpty()){
//                    if(!MPZap.getSluch().getSump().equals(MPZap.getSluch().getSumv())){
//                        System.out.println("Сумма, принятая к оплате по законченному случаю, не соответствует сумме, выставленной к оплате по законченному случаю, с учетом санкций | SUMP");
//                    }
//                }
//                switch (MPZap.getSluch().getSump()){
//                    case "3" -> {
//                        if(!(MPZap.getSluch().getSump().equals(MPZap.getSluch().getSumv())&&Double.parseDouble(MPZap.getSluch().getSump()) > 0)){
//                            System.out.println("Взаимное несоответствие типа оплаты, суммы, выставленной к оплате, суммы санкций и суммы, принятой к оплате | SUMP");
//                        }
//                    }
//                    case "2" -> {
//                        if(Double.parseDouble(MPZap.getSluch().getSump()) != 0){
//                            System.out.println("Взаимное несоответствие типа оплаты, суммы, выставленной к оплате, суммы санкций и суммы, принятой к оплате | SUMP");
//                        }
//                    }
////                    case "1" -> {
////                        if(Double.parseDouble(zap.getSluch().getSump()) != 0){
////                            System.out.println("Взаимное несоответствие типа оплаты, суммы, выставленной к оплате, суммы санкций и суммы, принятой к оплате | SUMP");
////                        }
////                    }
//                }
//
//            }
//
//        }
    }


    private boolean searchInArray(int[] array, String strSearch){
        for(int i = 0; i < array.length; i++){
            if(array[i] == Integer.parseInt(strSearch)){
                return true;
            }
        }
        return false;
    }
}
