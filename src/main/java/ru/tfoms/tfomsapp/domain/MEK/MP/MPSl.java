package ru.tfoms.tfomsapp.domain.MEK.MP;

import lombok.Data;

import java.util.List;

@Data
public class MPSl {
    private String slid;
    private String lpu1;
    private String podr;
    private String profil;
    private String profilk;
    private String det;
    private String pcel;
    private String nhistory;
    private String pper;
    private String date1;
    private String date2;
    private String kd;
    private String wai;
    private String dso;
    private String ds1;
    private List<String> ds2;
    private List<String> ds3;
    private String czab;
    private String dn;
    private List<String> code_mes1;
    private String code_mes2;
    private MPKsgkpg ksgkpg;
    private String reab;
    private String prvs;
    private String versspec;
    private String iddokt;
    private String edcol;
    private String tarif;
    private String summ;
    private List<MPLekpr> lekpr;
    private List<MPUsl> usl;
    private String comentsl;
}
