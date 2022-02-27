package ru.tfoms.tfomsapp.domain.file.onk;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.file.ds.DSZsl;
import ru.tfoms.tfomsapp.domain.file.Sank;

import java.util.List;

@Data
public class ONKZsl {
    private String idcase;
    private String uslok;
    private String vidpom;
    private String forpom;
    private String nprmo;
    private String nprdate;
    private String lpu;
    private String datez1;
    private String datez2;
    private String kdz;
    private String vnovm;
    private String rslt;
    private String ishod;
    private List<String> ossluch;
    private String vbp;
    private List<ONKSl> sls;
    private String idsp;
    private String sumv;
    private String oplata;
    private String sump;
    private List<Sank> sanks;
    private String sankit;
    private DSZsl dsZsl;
}
