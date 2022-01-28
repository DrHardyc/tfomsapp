package ru.tfoms.tfomsapp.service.Examination;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.Pacient;

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
//            List<Zap> MPZaps = pacient.getMPZap();
//            for (Zap Zap : MPZaps){
//                switch (Zap.getSluch().getUslok()){
//                    case "4" -> {
//                        if(!searchInArray(VIDPOM290, Zap.getSluch().getVidpom())){
//                            System.out.println("Ошибка в " + VIDPOM290.getClass().getSimpleName());
//                        }
//                    }
//                    case "3" -> {
//                        if (!searchInArray(VIDPOM300, Zap.getSluch().getVidpom())){
//                            System.out.println("Ошибка в " + VIDPOM300.getClass().getSimpleName());
//                        }
//                    }
//                    case "2" -> {
//                        if (!searchInArray(VIDPOM310, Zap.getSluch().getVidpom())){
//                            System.out.println("Ошибка в " + VIDPOM310.getClass().getSimpleName());
//                        }
//                    }
//                    case "1" -> {
//                        if (!searchInArray(VIDPOM320, Zap.getSluch().getVidpom())){
//                            System.out.println("Ошибка в " + VIDPOM320.getClass().getSimpleName());
//                        }
//                    }
//                }
//                //ZL_LIST/ZAP/Z_SL/SUMV
//                if(Zap.getSluch().getPotk().equals("1")){
//                    if(!Zap.getSluch().getSumv().equals("0")){
//                        System.out.println("Неверное значение суммы, выставленной к оплате | SUMV");
//                    }
//                }
//                //ZL_LIST/ZAP/Z_SL/SUMP
//                if(!Zap.getSluch().getSump().isEmpty()){
//                    if(!Zap.getSluch().getSump().equals(Zap.getSluch().getSumv())){
//                        System.out.println("Сумма, принятая к оплате по законченному случаю, не соответствует сумме, выставленной к оплате по законченному случаю, с учетом санкций | SUMP");
//                    }
//                }
//                switch (Zap.getSluch().getSump()){
//                    case "3" -> {
//                        if(!(Zap.getSluch().getSump().equals(Zap.getSluch().getSumv())&&Double.parseDouble(Zap.getSluch().getSump()) > 0)){
//                            System.out.println("Взаимное несоответствие типа оплаты, суммы, выставленной к оплате, суммы санкций и суммы, принятой к оплате | SUMP");
//                        }
//                    }
//                    case "2" -> {
//                        if(Double.parseDouble(Zap.getSluch().getSump()) != 0){
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
