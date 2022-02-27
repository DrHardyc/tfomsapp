package ru.tfoms.tfomsapp.domain.file;

import lombok.Data;

import java.util.List;

@Data
public class Ksgkpg {
    private String nksg;
    private String verksg;
    private String ksgpg;
    private String nkpg;
    private String koefz;
    private String koefup;
    private String bztsz;
    private String koefd;
    private String koefu;
    private List<String> crit;
    private String slk;
    private String itsl;
    private List<Slkoef> slkoef;
}
