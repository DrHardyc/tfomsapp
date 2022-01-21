package ru.tfoms.tfomsapp.domain.MEK.MP;

import lombok.Data;

@Data
public class MPZap {
    private String nzap;
    private String prnov;
    private MPPacient pacient;
    private MPZsl MPZsl;
}
