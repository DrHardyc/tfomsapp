package ru.tfoms.tfomsapp.domain.file.onk;

import lombok.Data;

import java.util.List;

@Data
public class ONKOnksl {
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
    private List<ONKBdiag> bdiags;
    private List<ONKBprot> bprots;
    private List<ONKOnkusl> onkusls;
}
