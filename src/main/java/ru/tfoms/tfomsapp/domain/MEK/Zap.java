package ru.tfoms.tfomsapp.domain.MEK;

import lombok.Data;

@Data
public class Zap {
    private String nzap;
    private String prnov;
    private Pacient pacient;
    private ru.tfoms.tfomsapp.domain.MEK.MP.MPZsl MPZsl;
}
