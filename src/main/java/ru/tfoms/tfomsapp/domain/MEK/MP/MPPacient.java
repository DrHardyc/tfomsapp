package ru.tfoms.tfomsapp.domain.MEK.MP;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.tfoms.tfomsapp.domain.MEK.Pacient;

@Data
@EqualsAndHashCode(callSuper = true)
public class MPPacient extends Pacient {
    private String enp;
    private String inv;
    private String mse;
    private String vnovd;
}
