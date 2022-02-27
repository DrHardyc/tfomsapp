package ru.tfoms.tfomsapp.domain.file.onk;

import lombok.Data;

@Data
public class ONKZap {
    private String nzap;
    private String prnov;
    private ONKPacient pacient;
    private ONKZsl zsl;
}
