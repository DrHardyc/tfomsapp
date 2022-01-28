package ru.tfoms.tfomsapp.domain.MEK.VMP;

import lombok.Data;

import java.util.List;

@Data
public class VMPOnksl {
    private String ds1t;
    private String stad;
    private String onkt;
    private String onkn;
    private String onkm;
    private String mtstz;
    private String sod;
    private String kfr;
    private String wei;
    private String hei;
    private String bsa;
    private List<VMPBdiag> bdiags;
    private List<VMPBprot> bprots;
    private List<VMPOnkusl> onkusls;
}
