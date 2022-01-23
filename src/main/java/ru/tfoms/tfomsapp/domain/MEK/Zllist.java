package ru.tfoms.tfomsapp.domain.MEK;

import lombok.Data;

import java.util.List;

@Data
public class Zllist {
    private Zglv zglv;
    private Schet schet;
    private List<Zap> zap;
}
