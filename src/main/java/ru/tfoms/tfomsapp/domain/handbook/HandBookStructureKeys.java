package ru.tfoms.tfomsapp.domain.handbook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HandBookStructureKeys {
    private String field;
    private String type;

    @JsonProperty("reference")
    private HandBookStructureKeysReference handBookStructureKeysReference;

    @JsonProperty("listStructure")
    private HandBookStructureKeysListStructure handBookStructureKeysListStructure;

}
