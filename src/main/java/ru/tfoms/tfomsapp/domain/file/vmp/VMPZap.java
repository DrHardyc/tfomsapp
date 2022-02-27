package ru.tfoms.tfomsapp.domain.file.vmp;

import lombok.Data;

@Data
public class VMPZap {
    private String nzap;
    private String prnov;
    private VMPPacient pacient;
    private VMPZsl zsl;
}
