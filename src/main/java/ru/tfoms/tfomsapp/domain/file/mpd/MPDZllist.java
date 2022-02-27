package ru.tfoms.tfomsapp.domain.file.mpd;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.file.Schet;
import ru.tfoms.tfomsapp.domain.file.Zglv;

import java.util.List;

@Data
public class MPDZllist {
    private Zglv zglv;
    private Schet schet;
    private List<MPDZap> zap;
}
