package ru.tfoms.tfomsapp.domain.MEK.MP;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.MEK.Schet;
import ru.tfoms.tfomsapp.domain.MEK.Zglv;

import java.util.List;

@Data
public class MPZllist {
    private Zglv zglv;
    private Schet schet;
    private List<MPZap> zap;
}
