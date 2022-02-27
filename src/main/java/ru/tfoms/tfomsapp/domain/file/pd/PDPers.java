package ru.tfoms.tfomsapp.domain.file.pd;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.file.mp.MPZap;
import ru.tfoms.tfomsapp.domain.file.mpd.MPDZap;
import ru.tfoms.tfomsapp.domain.file.onk.ONKZap;
import ru.tfoms.tfomsapp.domain.file.vmp.VMPZap;

import java.util.List;

@Data
public class PDPers {
    private String idpac;
    private String fam;
    private String im;
    private String ot;
    private String w;
    private String dr;
    private List<String> dost;
    private String tel;
    private String famp;
    private String imp;
    private String otp;
    private String wp;
    private String drp;
    private List<String> dostp;
    private String mr;
    private String doctype;
    private String docser;
    private String docnum;
    private String docdate;
    private String docorg;
    private String snils;
    private String okatog;
    private String okatop;
    private String comentp;
    private List<MPZap> mpZap;
    private List<MPDZap> mpdZap;
    private List<VMPZap> vmpZap;
    private List<ONKZap> onkZap;
}
