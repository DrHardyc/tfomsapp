package ru.tfoms.tfomsapp.domain.MEK.DS;

import lombok.Data;

import java.util.List;

@Data
public class DSZsl {
    private String idcase;
    private List<DSSl> sl;
    private String nprnom;
    private String extr;
}
