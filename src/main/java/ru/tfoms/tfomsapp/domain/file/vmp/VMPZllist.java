package ru.tfoms.tfomsapp.domain.file.vmp;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.file.Schet;
import ru.tfoms.tfomsapp.domain.file.Zglv;

import java.util.List;

@Data
public class VMPZllist {
    private Zglv zglv;
    private Schet schet;
    private List<VMPZap> zaps;
}
