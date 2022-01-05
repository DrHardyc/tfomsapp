package ru.tfoms.tfomsapp.domain.MEK;

import lombok.Data;

@Data
public class Zap {
    private int nzap;
    private int prnov;
    private ZapPcient zapPcient;
    private Sluch sluch;
}
