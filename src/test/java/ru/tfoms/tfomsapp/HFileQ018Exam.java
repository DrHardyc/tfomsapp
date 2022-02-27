package ru.tfoms.tfomsapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.tfoms.tfomsapp.domain.examination.ExamParam;
import ru.tfoms.tfomsapp.domain.file.*;
import ru.tfoms.tfomsapp.domain.file.mp.*;
import ru.tfoms.tfomsapp.domain.file.pd.PDPers;
import ru.tfoms.tfomsapp.domain.file.pd.PDPerslist;
import ru.tfoms.tfomsapp.service.examination.flk.MPExam;
import ru.tfoms.tfomsapp.service.examination.flk.ResultTestExam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HFileQ018Exam {

    @Test
    void H_0500_02600() throws IOException {
        Zglv zglv = new Zglv();
        Schet schet = new Schet();
        MPExam MPExam = new MPExam();
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
        zglv.setFilename("MPProtocol.xml");
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
        assertEquals(ResultTestExam.Success,
                MPExam.exam(perslist, zglv, schet, ExamParam.H_0500_02600));
    }

//    @Test
//    void H_0500_03000() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        pacient.setSmo("69013");
//
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0500_03000));
//    }
//
//    @Test
//    void H_0500_03101() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        pacient.setEnp("1");
//        pacient.setVpolis("3");
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0500_03101));
//    }
//
//    @Test
//    void H_0500_02801() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        pacient.setNpolis("1");
//        pacient.setVpolis("3");
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0500_02801));
//    }
//
//    @Test
//    void H_0600_03900() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        zsl.setUslok("4");
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0600_03900));
//    }
//
//    @Test
//    void H_0600_04000() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        zsl.setVidpom("21");
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0600_04000));
//    }
//
//    @Test
//    void H_0600_04100() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        zsl.setForpom("3");
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0600_04100));
//    }
//
//    @Test
//    void H_0600_04200() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        zsl.setForpom("3");
//        zsl.setNprmo("010001");
//        zsl.setUslok("1");
//
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0600_04200));
//    }
//
//    @Test
//    void H_0600_04400() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        zsl.setLpu("010001");
//
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0600_04400));
//    }
//
//    @Test
//    void H_0600_04900() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        zsl.setRslt("417");
//
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0600_04900));
//    }
//
//    @Test
//    void H_0600_05000() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        zsl.setIshod("403");
//
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0600_05000));
//    }
//
//    @Test
//    void H_0600_05400() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        zsl.setIdsp("28");
//
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0600_05400));
//    }
//
//    @Test
//    void H_0700_06300() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        sl.setProfil("14");
//
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0700_06300));
//    }
//
//    @Test
//    void H_0700_06400() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        sl.setProfilk("14");
//        zsl.setUslok("1");
//
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0700_06400));
//    }
//
//    @Test
//    void H_0700_06600() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        sl.setPcel("3.1");
//        zsl.setUslok("3");
//
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0700_06600));
//    }
//
//    @Test
//    void H_0700_06800() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        sl.setNhistory("dfadgf");
//        zsl.setUslok("3");
//
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0700_06800));
//    }
//
//    @Test
//    void H_0700_07100() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        sl.setKd("dfadgf");
//        zsl.setUslok("1");
//
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0700_07100));
//    }
//
//    @Test
//    void H_0700_07302() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        sl.setDs1("D51.1");
//
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0700_07302));
//    }
//
//    @Test
//    void H_0700_07601() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        sl.setDs1("D51.1");
//        sl.setCzab("1");
//
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0700_07601));
//    }
//
//    @Test
//    void H_0700_08201() throws IOException {
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
////=======================================================
//        sl.setPrvs("16");
//
//        sl.setSumm("0");
////=======================================================
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0700_08201));
//    }
//
//    @Test
//    //H_0800_09000
//    void H_0800_09300() throws IOException {
//        Zglv zglv = new Zglv();
//        Schet schet = new Schet();
//        ExamMP examMP = new ExamMP();
//        PDPerslist perslist = new PDPerslist();
//        PDPers pers = new PDPers();
//        List<PDPers> perss = new ArrayList<>();
//        MPZap zap = new MPZap();
//        List<MPZap> zaps = new ArrayList<>();
//        MPPacient pacient = new MPPacient();
//        MPZsl zsl = new MPZsl();
//        MPUsl usl = new MPUsl();
//        List<MPUsl> usls = new ArrayList<>();
//        MPSl sl = new MPSl();
//        List<MPSl> sls = new ArrayList<>();
//        Mrusln mrusln = new Mrusln();
//        List<Mrusln> mruslns = new ArrayList<>();
//        MPLekpr lekpr = new MPLekpr();
//        List<MPLekpr> lekprs = new ArrayList<>();
//        MPMeddev meddev = new MPMeddev();
//        List<MPMeddev> meddevs = new ArrayList<>();
//        Sank sank = new Sank();
//        List<Sank> sanks = new ArrayList<>();
//        Ksgkpg ksgkpg = new Ksgkpg();
////=======================================================
//        ksgkpg.setNkpg("10");
//        ksgkpg.setNksg("");
//        sl.setSumm("0");
////=======================================================
//        sl.setKsgkpg(ksgkpg);
//        zap.setPacient(pacient);
//        sanks.add(sank);
//        zsl.setSank(sanks);
//        meddevs.add(meddev);
//        usl.setMeddev(meddevs);
//        lekprs.add(lekpr);
//        sl.setLekpr(lekprs);
//        mruslns.add(mrusln);
//        usl.setMruslns(mruslns);
//        usls.add(usl);
//        sl.setUsl(usls);
//        sls.add(sl);
//        zsl.setSl(sls);
//        zap.setZsl(zsl);
//        zaps.add(zap);
//        pers.setMpZap(zaps);
//        perss.add(pers);
//        perslist.setPers(perss);
//        assertEquals(ResultTestExam.Success, examMP.exam(perslist, ExamParam.H_0800_09300));
//    }
//
//    @Test
//    void OtherTest() {
//        @Data
//        class TestLekpr {
//            private String test1;
//            private String test2;
//        }
//        @Data
//        class Test1 {
//            private String testSrring1;
//            private List<TestLekpr> testLekpr;
//        }
//        TestLekpr testLekpr = new TestLekpr();
//        Test1 test1 = new Test1();
//        List<TestLekpr> testLekprs = new ArrayList<>();
//        test1.setTestLekpr(testLekprs);
//
//        testLekpr.setTest1("");
//        if (testLekpr.getTest1().isEmpty()){
//            System.out.println("IsEmpty");
//        }
//        if (testLekpr.getTest1() == null){
//            System.out.println("Null");
//        }
//    }
}
