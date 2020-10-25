package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TableMetaDataDTO {
    private String tableName;
    private List<ColumnMetaDataDTO> columnMetaDataList;

    public TableMetaDataDTO(String tableName) {
        this.tableName = tableName;
    }
}
