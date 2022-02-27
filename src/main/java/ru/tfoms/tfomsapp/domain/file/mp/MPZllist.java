package ru.tfoms.tfomsapp.domain.file.mp;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.file.Schet;
import ru.tfoms.tfomsapp.domain.file.Zglv;

import java.util.List;

@Data
public class MPZllist {
    private Zglv zglv;
    private Schet schet;
    private List<MPZap> zap;
}
