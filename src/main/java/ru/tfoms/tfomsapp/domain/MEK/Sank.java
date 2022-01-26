package ru.tfoms.tfomsapp.domain.MEK;

import lombok.Data;

import java.util.List;

@Data
public class Sank {
    private String scode;
    private String ssum;
    private String stip;
    private List<String> slid;
    private String sosn;
    private String dateact;
    private String numact;
    private List<String> codeexp;
    private String scom;
    private String sist;
}
