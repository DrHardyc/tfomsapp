package ru.tfoms.tfomsapp.domain.MEK.MPD;

import lombok.Data;

@Data
public class MPDZap {
    private String nzap;
    private String prnov;
    private MPDPacient pacient;
    private MPDZsl zsl;
}
