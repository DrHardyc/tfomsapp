package ru.tfoms.tfomsapp.domain.file.vmp;


import lombok.Data;
import ru.tfoms.tfomsapp.domain.file.Cons;
import ru.tfoms.tfomsapp.domain.file.ds.DSSl;
import ru.tfoms.tfomsapp.domain.file.Napr;

import java.util.List;

@Data
public class VMPSl{
    private String slid;
    private String vidhmp;
    private String metodhmp;
    private String lpu1;
    private String podr;
    private String profil;
    private String profilk;
    private String det;
    private String tald;
    private String talnum;
    private String talp;
    private String nhistory;
    private String date1;
    private String date2;
    private String ds0;
    private String ds1;
    private List<String> ds2;
    private List<String> ds3;
    private String czab;
    private String dsonk;
    private List<String> codemes1;
    private String codemes2;
    private List<Napr> napr;
    private List<Cons> cons;
    private VMPOnksl onksl;
    private String prvs;
    private String versspec;
    private String iddokt;
    private String edcol;
    private String tarif;
    private String summ;
    private List<VMPUsl> usl;
    private String comentsl;
    private DSSl dsSl;
}
