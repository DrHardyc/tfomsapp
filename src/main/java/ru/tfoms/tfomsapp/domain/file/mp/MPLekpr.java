package ru.tfoms.tfomsapp.domain.file.mp;

import lombok.Data;

@Data
public class MPLekpr {
    private String dateinj;
    private String codesh;
    private String regnum;
    private String codmark;
    private MPLekdose lekdose;
}
