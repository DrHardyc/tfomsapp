package ru.tfoms.tfomsapp.domain.MEK.VMP;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.tfoms.tfomsapp.domain.MEK.Sank;
import ru.tfoms.tfomsapp.domain.MEK.Zsl;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class VMPZsl extends Zsl {
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
    private List<String> vnovm;
    private String rslt;
    private String ishod;
    private List<String> ossluch;
    private List<VMPSl> sl;
    private String idsp;
    private String sumv;
    private String oplata;
    private String sump;
    private List<Sank> sanks;
    private String sankit;
}
