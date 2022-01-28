package ru.tfoms.tfomsapp.domain.HandBook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class HandBookStructureColumns {
    @JsonProperty
    private String Name;
    @JsonProperty
    private String Alias;
    @JsonProperty
    private String Description;
    @JsonProperty
    private String DataType;
    @JsonProperty
    private String ContentType;
    @JsonProperty
    private String Number;
    @JsonProperty
    private String EmptyAllowed;
    @JsonProperty
    private String Visible;
    @JsonProperty
    private String MinLength;
    @JsonProperty
    private String MaxLength;
    @JsonProperty
    private String MaxIntPartLength;
    @JsonProperty
    private String MaxFracPartLength;
}
