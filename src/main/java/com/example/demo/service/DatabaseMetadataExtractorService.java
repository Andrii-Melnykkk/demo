package com.example.demo.service;


import com.example.demo.dto.TableMetaDataDTO;
import com.example.demo.repository.DatabaseMetadataExtractorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class DatabaseMetadataExtractorService {

private final DatabaseMetadataExtractorRepo databaseMetadataExtractorRepo;

    public List<TableMetaDataDTO> extractTableMetaDataService() {
        return databaseMetadataExtractorRepo.extractTableMetaData();
    }
}
