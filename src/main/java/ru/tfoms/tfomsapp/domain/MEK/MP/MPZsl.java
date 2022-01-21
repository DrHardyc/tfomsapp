package ru.tfoms.tfomsapp.domain.MEK.MP;

import lombok.Data;

import java.util.List;

@Data
public class MPZsl {
    private String idcase;
    private String uslok;
    private String vidpom;
    private String forpom;
    private String nprmo;
    private String nprdate;
    private String lpu;
    private String Datez1;
    private String Datez2;
    private String Kdz;
    private List<String> vnovm;
    private String rslt;
    private String ishod;
    private List<String> ossluch;
    private String vbp;
    private List<MPSl> sl;
    private String idsp;
    private String sumv;
    private String oplata;
    private String sump;
    private List<MPSank> sank;
    private String sankit;

}
