package ru.tfoms.tfomsapp.domain.MEK.MPD;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.MEK.Schet;
import ru.tfoms.tfomsapp.domain.MEK.Zglv;

import java.util.List;

@Data
public class MPDZllist {
    private Zglv zglv;
    private Schet schet;
    private List<MPDZap> zap;
}
