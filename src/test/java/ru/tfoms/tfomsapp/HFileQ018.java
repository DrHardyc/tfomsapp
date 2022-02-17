package ru.tfoms.tfomsapp;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.tfoms.tfomsapp.domain.Exam.ExamParam;
import ru.tfoms.tfomsapp.domain.MEK.MP.*;
import ru.tfoms.tfomsapp.domain.MEK.Mrusln;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPers;
import ru.tfoms.tfomsapp.domain.MEK.PD.PDPerslist;
import ru.tfoms.tfomsapp.domain.MEK.Sank;
import ru.tfoms.tfomsapp.service.Examination.MEK.ExamMP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class HFileQ018 {

    @Test
    void H_0500_02600() throws IOException {
        ExamMP examMP = new ExamMP();
        PDPerslist perslist = new PDPerslist();
        PDPers pers = new PDPers();
        List<PDPers> perss = new ArrayList<>();
        MPZap zap = new MPZap();
        List<MPZap> zaps = new ArrayList<>();
        MPPacient pacient = new MPPacient();
        MPZsl zsl = new MPZsl();
        MPUsl usl = new MPUsl();
        List<MPUsl> usls = new ArrayList<>();
        MPSl sl = new MPSl();
        List<MPSl> sls = new ArrayList<>();
        Mrusln mrusln = new Mrusln();
        List<Mrusln> mruslns = new ArrayList<>();
        MPLekpr lekpr = new MPLekpr();
        List<MPLekpr> lekprs = new ArrayList<>();
        MPMeddev meddev = new MPMeddev();
        List<MPMeddev> meddevs = new ArrayList<>();
        Sank sank = new Sank();
        List<Sank> sanks = new ArrayList<>();
//=======================================================
        pacient.setVpolis("6");
        sl.setSumm("0");
//=======================================================
        zap.setPacient(pacient);
        sanks.add(sank);
        zsl.setSank(sanks);
        meddevs.add(meddev);
        usl.setMeddev(meddevs);
        lekprs.add(lekpr);
        sl.setLekpr(lekprs);
        mruslns.add(mrusln);
        usl.setMruslns(mruslns);
        usls.add(usl);
        sl.setUsl(usls);
        sls.add(sl);
        zsl.setSl(sls);
        zap.setZsl(zsl);
        zaps.add(zap);
        pers.setMpZap(zaps);
        perss.add(pers);
        perslist.setPers(perss);
        examMP.exam(perslist, ExamParam.H_0500_02600);
    }

    @Test
    void H_0500_03000() throws IOException {
        ExamMP examMP = new ExamMP();
        PDPerslist perslist = new PDPerslist();
        PDPers pers = new PDPers();
        List<PDPers> perss = new ArrayList<>();
        MPZap zap = new MPZap();
        List<MPZap> zaps = new ArrayList<>();
        MPPacient pacient = new MPPacient();
        MPZsl zsl = new MPZsl();
        MPUsl usl = new MPUsl();
        List<MPUsl> usls = new ArrayList<>();
        MPSl sl = new MPSl();
        List<MPSl> sls = new ArrayList<>();
        Mrusln mrusln = new Mrusln();
        List<Mrusln> mruslns = new ArrayList<>();
        MPLekpr lekpr = new MPLekpr();
        List<MPLekpr> lekprs = new ArrayList<>();
        MPMeddev meddev = new MPMeddev();
        List<MPMeddev> meddevs = new ArrayList<>();
        Sank sank = new Sank();
        List<Sank> sanks = new ArrayList<>();
//=======================================================
        pacient.setSmo("69013");

        sl.setSumm("0");
//=======================================================
        zap.setPacient(pacient);
        sanks.add(sank);
        zsl.setSank(sanks);
        meddevs.add(meddev);
        usl.setMeddev(meddevs);
        lekprs.add(lekpr);
        sl.setLekpr(lekprs);
        mruslns.add(mrusln);
        usl.setMruslns(mruslns);
        usls.add(usl);
        sl.setUsl(usls);
        sls.add(sl);
        zsl.setSl(sls);
        zap.setZsl(zsl);
        zaps.add(zap);
        pers.setMpZap(zaps);
        perss.add(pers);
        perslist.setPers(perss);
        examMP.exam(perslist, ExamParam.H_0500_03000);
    }

    @Test
    void H_0500_03101() throws IOException {
        ExamMP examMP = new ExamMP();
        PDPerslist perslist = new PDPerslist();
        PDPers pers = new PDPers();
        List<PDPers> perss = new ArrayList<>();
        MPZap zap = new MPZap();
        List<MPZap> zaps = new ArrayList<>();
        MPPacient pacient = new MPPacient();
        MPZsl zsl = new MPZsl();
        MPUsl usl = new MPUsl();
        List<MPUsl> usls = new ArrayList<>();
        MPSl sl = new MPSl();
        List<MPSl> sls = new ArrayList<>();
        Mrusln mrusln = new Mrusln();
        List<Mrusln> mruslns = new ArrayList<>();
        MPLekpr lekpr = new MPLekpr();
        List<MPLekpr> lekprs = new ArrayList<>();
        MPMeddev meddev = new MPMeddev();
        List<MPMeddev> meddevs = new ArrayList<>();
        Sank sank = new Sank();
        List<Sank> sanks = new ArrayList<>();
//=======================================================
        pacient.setVpolis("3");

        sl.setSumm("0");
//=======================================================
        zap.setPacient(pacient);
        sanks.add(sank);
        zsl.setSank(sanks);
        meddevs.add(meddev);
        usl.setMeddev(meddevs);
        lekprs.add(lekpr);
        sl.setLekpr(lekprs);
        mruslns.add(mrusln);
        usl.setMruslns(mruslns);
        usls.add(usl);
        sl.setUsl(usls);
        sls.add(sl);
        zsl.setSl(sls);
        zap.setZsl(zsl);
        zaps.add(zap);
        pers.setMpZap(zaps);
        perss.add(pers);
        perslist.setPers(perss);
        examMP.exam(perslist, ExamParam.H_0500_03101);
    }

    @Test
    void OtherTest() {
        @Data
        class TestLekpr {
            private String test1;
            private String test2;
        }
        @Data
        class Test1 {
            private String testSrring1;
            private List<TestLekpr> testLekpr;
        }
        TestLekpr testLekpr = new TestLekpr();
        Test1 test1 = new Test1();
        List<TestLekpr> testLekprs = new ArrayList<>();
        test1.setTestLekpr(testLekprs);

        testLekpr.setTest1("");
        if (testLekpr.getTest1().isEmpty()){
            System.out.println("IsEmpty");
        }
        if (testLekpr.getTest1() == null){
            System.out.println("Null");
        }
    }
}
