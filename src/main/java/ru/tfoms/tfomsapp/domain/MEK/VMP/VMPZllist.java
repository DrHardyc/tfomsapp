package ru.tfoms.tfomsapp.domain.MEK.VMP;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.MEK.Schet;
import ru.tfoms.tfomsapp.domain.MEK.Zglv;

import java.util.List;

@Data
public class VMPZllist {
    private Zglv zglv;
    private Schet schet;
    private List<VMPZap> zaps;
}
