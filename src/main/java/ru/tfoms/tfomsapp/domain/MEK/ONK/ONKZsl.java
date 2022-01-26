package ru.tfoms.tfomsapp.domain.MEK.ONK;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.tfoms.tfomsapp.domain.MEK.Sank;
import ru.tfoms.tfomsapp.domain.MEK.Zsl;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ONKZsl extends Zsl {
    private String idcase;
    private String uslok;
    private String vidpom;
    private String forpom;
    private String nprmo;
    private String mprdate;
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
}
