package ru.tfoms.tfomsapp.domain.HandBook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Handbook {

    private String result;
    private String resultText;
    private String resultCode;
    private String total;

    @JsonProperty("list")
    private List<List<HandBookValues>> dirValues;
}