package ru.tfoms.tfomsapp.domain.file.onk;

import lombok.Data;

import java.util.List;

@Data
public class ONKOnkusl {
    private String usltip;
    private String hirtip;
    private String lektipl;
    private String lektipv;
    private List<ONKLekpr> lekprs;
    private String pptr;
    private String luchtip;
}
