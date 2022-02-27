package ru.tfoms.tfomsapp.domain.file.ds;

import lombok.Data;

import java.util.List;

@Data
public class DSZap {
    private String nzap;
    private String filename1;
    private List<DSZsl> zsl;
}
