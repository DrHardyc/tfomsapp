package ru.tfoms.tfomsapp.domain.MEK.ONK;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.tfoms.tfomsapp.domain.MEK.Pacient;

@Data
@EqualsAndHashCode(callSuper = true)
public class ONKPacient extends Pacient {
    private String idpac;
    private String vpolis;
    private String spolis;
    private String npolis;
    private String stokato;
    private String smo;
    private String smoogrn;
    private String smook;
    private String smonam;
    private String inv;
    private String mse;
    private String novor;
    private String vnovd;
}
