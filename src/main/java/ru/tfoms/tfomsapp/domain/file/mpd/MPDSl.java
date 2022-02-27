package ru.tfoms.tfomsapp.domain.file.mpd;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.file.ds.DSSl;

import java.util.List;

@Data
public class MPDSl {
    private String slid;
    private String lpu1;
    private String nhistory;
    private String date1;
    private String date2;
    private String ds1;
    private String ds1pr;
    private String dsonk;
    private String prdn;
    private List<MPDDs2n> ds2n;
    private List<MPDNaz> naz;
    private String edcol;
    private String tarif;
    private String summ;
    private List<MPDUsl> usl;
    private String comentsl;
    private DSSl dsSl;
}
