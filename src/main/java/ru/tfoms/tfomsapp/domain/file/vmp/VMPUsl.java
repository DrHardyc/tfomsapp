package ru.tfoms.tfomsapp.domain.file.vmp;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.file.ds.DSUsl;

@Data
public class VMPUsl{
    private String idserv;
    private String lpu;
    private String lpu1;
    private String podr;
    private String profil;
    private String vidvme;
    private String det;
    private String datein;
    private String dateout;
    private String ds;
    private String codeusl;
    private String kolusl;
    private String tarif;
    private String sumvusl;
    private String prvs;
    private String codemd;
    private String comentu;
    private DSUsl dsUsl;
}
