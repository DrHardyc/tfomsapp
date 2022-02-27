package ru.tfoms.tfomsapp.domain.file.onk;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.file.Schet;
import ru.tfoms.tfomsapp.domain.file.Zglv;

import java.util.List;

@Data
public class ONKZllist {
    private Zglv zglv;
    private Schet schet;
    private List<ONKZap> zaps;
}
