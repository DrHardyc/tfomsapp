package ru.tfoms.tfomsapp.domain.MEK;

import lombok.Data;

import java.util.List;

@Data
public class Pacient {
    private String idpack;
    private String fam;
    private String im;
    private String ot;
    private String w;
    private String dr;
    private String famp;
    private String imp;
    private String otp;
    private String wp;
    private String drp;
    private String mr;
    private String doctype;
    private String docser;
    private String docnum;
    private String docdate;
    private String docorg;
    private String snils;
    private String okatog;
    private String okatop;
    private String adres;
    private String worker;
    private String lpup;
    private String tel;
    private List<ru.tfoms.tfomsapp.domain.MEK.MP.MPZap> MPZap;
}
