package com.example.demo.controller;


import com.example.demo.dto.TableMetaDataDTO;
import com.example.demo.service.DatabaseMetadataExtractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/table-meta-data")
public class DatabaseMetadataExtractorController {

    private final DatabaseMetadataExtractorService databaseMetadataExtractorService;

    @GetMapping
    public ResponseEntity<List<TableMetaDataDTO>> getTableMetaData() {
        return ResponseEntity.status(HttpStatus.OK).body(databaseMetadataExtractorService.extractTableMetaDataService());
    }
}
