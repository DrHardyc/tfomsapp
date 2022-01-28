package ru.tfoms.tfomsapp.domain.HandBook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HandBookStructure {
    private String parent;
    private String displayValue;
    private String sorting;
    private String isHierarchical;

    @JsonProperty("Columns")
    private List<HandBookStructureColumns> handBookStructureColumns;

    @JsonProperty("Keys")
    private List<HandBookStructureKeys> handBookStructureKeys;
}
