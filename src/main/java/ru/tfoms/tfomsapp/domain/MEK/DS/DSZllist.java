package ru.tfoms.tfomsapp.domain.MEK.DS;

import lombok.Data;

import java.util.List;

@Data
public class DSZllist {
    private DSZglv zglv;
    private List<DSZap> zaps;
}
