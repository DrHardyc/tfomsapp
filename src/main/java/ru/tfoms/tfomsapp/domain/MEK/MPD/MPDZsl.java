package ru.tfoms.tfomsapp.domain.MEK.MPD;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.tfoms.tfomsapp.domain.MEK.Sank;
import ru.tfoms.tfomsapp.domain.MEK.Zsl;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class MPDZsl extends Zsl {
    private String idcase;
    private String vidpom;
    private String lpu;
    private String vbr;
    private String datez1;
    private String datez2;
    private String potk;
    private String rsltd;
    private List<String> ossluch;
    private MPDSl sl;
    private String idsp;
    private String sumv;
    private String oplata;
    private String sump;
    private List<Sank> sank;
    private String sankit;
}
