package ru.tfoms.tfomsapp.domain.MEK.MPD;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSUsl;
import ru.tfoms.tfomsapp.domain.MEK.Mrusln;

@Data
public class MPDUsl {
    private String idserv;
    private String lpu;
    private String lpu1;
    private String datein;
    private String dateout;
    private String potk;
    private String codeusl;
    private String tarif;
    private String sumvusl;
    private Mrusln mrusln;
    private String comentu;
    private DSUsl dsUsl;
}
