package ru.tfoms.tfomsapp.service.Examination.MEK;

import org.springframework.stereotype.Service;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPers;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPerslist;
import ru.tfoms.tfomsapp.domain.MEK.VMP.VMPZap;

@Service
public class ExamVMP {


    public void exam(PDPerslist pdPerslist){
        for (PDPers pers : pdPerslist.getPers()){
            for (VMPZap zap : pers.getVmpZap()){

            }
        }
    }

}
