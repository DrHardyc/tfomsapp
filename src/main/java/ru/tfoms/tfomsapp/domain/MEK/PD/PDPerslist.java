package ru.tfoms.tfomsapp.domain.MEK.PD;

import lombok.Data;

import java.util.List;

@Data
public class PDPerslist {
    private PDZglv zglv;
    private List<Pers> pers;
}
