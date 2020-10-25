package com.example.demo.repository;

import com.example.demo.dto.ColumnMetaDataDTO;
import com.example.demo.dto.TableMetaDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DatabaseMetadataExtractorRepo {

    private static final String TABLE_SQL = "SELECT table_schema, table_name, table_type " +
            "FROM information_schema.tables WHERE table_schema = 'public'";
    private static final String COLUMN_SQL = "SELECT column_name,data_type " +
            "FROM information_schema.columns WHERE table_name = ?";

    private final JdbcTemplate jdbcTemplate;

    /**
     * Method, used 2 get list of tables with public schema and meta data to these tables
     * from database
     *
     * @return list of tables with meta data
     */
    public List<TableMetaDataDTO> extractTableMetaData() {

        List<TableMetaDataDTO> tableMetaDataDTOS;

        tableMetaDataDTOS = jdbcTemplate.query(
                TABLE_SQL,
                (rs, rowNum) ->
                        new TableMetaDataDTO(
                                rs.getString("table_name")
                        )
        );
        for (TableMetaDataDTO tableMetaDataDTO : tableMetaDataDTOS) {
            tableMetaDataDTO.setColumnMetaDataList(
                    extractColumnMetaData(tableMetaDataDTO.getTableName()));
            for (int j = 0; j < tableMetaDataDTO.getColumnMetaDataList().size(); j++) {
                tableMetaDataDTO.getColumnMetaDataList().get(j).setConstraints(
                        extractConstraintsData(tableMetaDataDTO.getTableName(),
                                tableMetaDataDTO.getColumnMetaDataList().get(j).getColumnName())
                );
            }
        }
        return tableMetaDataDTOS;
    }

    /**
     * Method, used 2 get list of columns and meta data to these columns from given table
     *
     * @param tableName - name of table, which meta data need to be find out
     * @return list of columns with meta data
     */
    private List<ColumnMetaDataDTO> extractColumnMetaData(String tableName) {

        return jdbcTemplate.query(
                COLUMN_SQL, new Object[]{tableName}, (rs, rowNum) ->
                        new ColumnMetaDataDTO(
                                rs.getString("column_name"),
                                rs.getString("data_type")
                        )
        );
    }

    /**
     * Method, used 2 get list of constraints
     *
     * @param tableName  - name of table
     * @param columnName - name of a column
     * @return list of columns' constraints
     */
    private List<String> extractConstraintsData(String tableName, String columnName) {
        final String CONSTRAINTS_SQL = "SELECT\n" +
                "    tc.CONSTRAINT_NAME\n" +
                "  , ccu.COLUMN_NAME\n" +
                "FROM\n" +
                "    INFORMATION_SCHEMA.TABLE_CONSTRAINTS AS tc\n" +
                "    INNER JOIN INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE AS ccu" +
                " ON ccu.CONSTRAINT_NAME = tc.CONSTRAINT_NAME\n" +
                "WHERE\n" +
                "    tc.TABLE_NAME = '" + tableName + "'" +
                "\tAND COLUMN_NAME = '" + columnName + "'";
        return jdbcTemplate.query(
                CONSTRAINTS_SQL, (rs, rowNum) ->
                        rs.getString("constraint_name"));
    }
}



