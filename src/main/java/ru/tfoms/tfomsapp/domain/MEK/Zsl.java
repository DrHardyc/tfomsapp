package ru.tfoms.tfomsapp.domain.MEK;

import lombok.Data;
import ru.tfoms.tfomsapp.domain.MEK.DS.DSZsl;

@Data
public abstract class Zsl {
    private String idcase;
    private DSZsl dsZsl;
}
