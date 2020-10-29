package com.example.demo.controller;


import com.example.demo.dto.TableMetaDataDTO;
import com.example.demo.service.DatabaseMetadataExtractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
public class DatabaseMetadataExtractorController {

    private final DatabaseMetadataExtractorService databaseMetadataExtractorService;

    @GetMapping("/database-meta-data")
    public ResponseEntity<List<TableMetaDataDTO>> getTableMetaData() {
        return ResponseEntity.status(HttpStatus.OK).body(databaseMetadataExtractorService.extractTableMetaDataService());
    }
}
