package ru.tfoms.tfomsapp.domain.MEK.MP;

import lombok.Data;

import java.util.List;

@Data
public class MPUsl {
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
    private String npl;
    private String comentu;
    private List<MPMeddev> meddev;
    private List<MPMrusln> mrusLn;
}
