package ru.tfoms.tfomsapp.domain.MEK.MP;

import lombok.Data;

import java.util.List;

@Data
public class MPZllist {
    private MPZglv zglv;
    private MPSchet schet;
    private List<MPZap> zap;
}
