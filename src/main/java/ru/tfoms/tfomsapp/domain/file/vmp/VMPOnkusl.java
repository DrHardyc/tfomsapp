package ru.tfoms.tfomsapp.domain.file.vmp;

import lombok.Data;

import java.util.List;

@Data
public class VMPOnkusl {
    private String usltip;
    private String hirtip;
    private String lektipl;
    private String lektipv;
    private List<VMPLekpr> lekpr;
    private String pptr;
    private String luchtip;

}
