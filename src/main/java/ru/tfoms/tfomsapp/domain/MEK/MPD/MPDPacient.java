package ru.tfoms.tfomsapp.domain.MEK.MPD;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.tfoms.tfomsapp.domain.MEK.Pacient;

@Data
@EqualsAndHashCode(callSuper = true)
public class MPDPacient extends Pacient {
    private String idpac;
    private String vpolis;
    private String spolis;
    private String npolis;
    private String enp;
    private String stokato;
    private String smo;
    private String smonam;
    private String novor;
}