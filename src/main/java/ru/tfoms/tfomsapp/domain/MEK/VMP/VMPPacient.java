package ru.tfoms.tfomsapp.domain.MEK.VMP;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.tfoms.tfomsapp.domain.MEK.Pacient;


@Data
@EqualsAndHashCode(callSuper = true)
public class VMPPacient extends Pacient {
    private String idpac;
    private String vpolis;
    private String spolos;
    private String npolis;
    private String stokato;
    private String smo;
    private String smoogrn;
    private String smook;
    private String smonam;
    private String mse;
    private String novor;
    private String vnovd;
}
