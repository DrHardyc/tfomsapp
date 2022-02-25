package ru.tfoms.tfomsapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.tfoms.tfomsapp.domain.Exam.ExamParam;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPers;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPerslist;
import ru.tfoms.tfomsapp.domain.MEK.Schet;
import ru.tfoms.tfomsapp.domain.MEK.VMP.*;
import ru.tfoms.tfomsapp.domain.MEK.Zglv;
import ru.tfoms.tfomsapp.service.Examination.MEK.VMPExam;
import ru.tfoms.tfomsapp.service.Examination.MEK.ResultTestExam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TFileQ018Exam {

    @Test
    void T_0300_00900() throws IOException {
        Zglv zglv = new Zglv();
        Schet schet = new Schet();
        VMPExam VMPExam = new VMPExam();
        PDPerslist perslist = new PDPerslist();
        PDPers pers = new PDPers();
        List<PDPers> perss = new ArrayList<>();
        VMPZap zap = new VMPZap();
        List<VMPZap> zaps = new ArrayList<>();
        VMPPacient pacient = new VMPPacient();
        VMPZsl zsl = new VMPZsl();
        VMPUsl usl = new VMPUsl();
        List<VMPUsl> usls = new ArrayList<>();
        VMPSl sl = new VMPSl();
        List<VMPSl> sls = new ArrayList<>();

//=======================================================
        schet.setCodemo("");

        zglv.setFilename("MPProtocol.xml");
        sl.setSumm("0");
//=======================================================
        zap.setPacient(pacient);
        usls.add(usl);
        sl.setUsl(usls);
        sls.add(sl);
        zsl.setSl(sls);
        zap.setZsl(zsl);
        zaps.add(zap);
        pers.setVmpZap(zaps);
        perss.add(pers);
        perslist.setPers(perss);
        assertEquals(ResultTestExam.Success,
                VMPExam.exam(perslist, zglv, schet, ExamParam.T_0300_00900));
    }
}
