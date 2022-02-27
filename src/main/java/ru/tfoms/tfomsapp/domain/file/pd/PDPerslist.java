package ru.tfoms.tfomsapp.domain.file.pd;

import lombok.Data;

import java.util.List;

@Data
public class PDPerslist {
    private PDZglv zglv;
    private List<PDPers> pers;
}
