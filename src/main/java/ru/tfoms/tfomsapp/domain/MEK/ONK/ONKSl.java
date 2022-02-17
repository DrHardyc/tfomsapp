package ru.tfoms.tfomsapp.domain.MEK.ONK;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.MEK.Cons;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSSl;
import ru.tfoms.tfomsapp.domain.MEK.Ksgkpg;
import ru.tfoms.tfomsapp.domain.MEK.Napr;

import java.util.List;

@Data
public class ONKSl {
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
    private String ds0;
    private String ds1;
    private List<String> ds2;
    private List<String> ds3;
    private String czab;
    private String dsonk;
    private String dn;
    private List<String> codemes1;
    private String codemes2;
    private List<Napr> napr;
    private List<Cons> cons;
    private ONKOnksl onksl;
    private Ksgkpg ksgkpg;
    private String reab;
    private String prvs;
    private String versspec;
    private String iddokt;
    private String edcol;
    private String tarif;
    private String summ;
    private List<ONKUsl> usl;
    private String comentsl;
    private DSSl dsSl;
}
