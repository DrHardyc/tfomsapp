package ru.tfoms.tfomsapp.domain.MEK.ONK;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.MEK.MP.MPZap;
import ru.tfoms.tfomsapp.domain.MEK.Schet;
import ru.tfoms.tfomsapp.domain.MEK.Zglv;

import java.util.List;

@Data
public class ONKZllist {
    private Zglv zglv;
    private Schet schet;
    private List<ONKZap> zaps;
}
