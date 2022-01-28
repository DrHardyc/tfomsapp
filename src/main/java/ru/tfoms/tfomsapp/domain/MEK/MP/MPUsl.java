package ru.tfoms.tfomsapp.domain.MEK.MP;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.tfoms.tfomsapp.domain.MEK.Mrusln;

import java.util.List;

@Data
public class MPUsl{
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
    private List<MPMeddev> meddev;
    private List<Mrusln> mruslns;
    private String npl;
    private String comentu;
}
