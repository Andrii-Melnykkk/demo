package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ColumnMetaDataDTO {
    private String columnName;
    private String type;
    private List<String> constraints;

    public ColumnMetaDataDTO(String columnName, String type) {
        this.columnName = columnName;
        this.type = type;
    }
}
