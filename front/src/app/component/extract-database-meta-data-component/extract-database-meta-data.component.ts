import {Component, OnInit} from '@angular/core';
import {ExtractDatabaseMetaDataService} from '../../service/extract-database-meta-data.service';
import {TableMetaData} from '../../model/TableMetaData';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-extract-database-meta-data',
  templateUrl: './extract-database-meta-data.component.html',
  styleUrls: ['./extract-database-meta-data.component.css']
})
export class ExtractDatabaseMetaDataComponent implements OnInit {


  public tablesMetaData: TableMetaData[];
  displayedColumns = ['tableName', 'columnMetaData'];
  displayedColumns2 = ['columnName', 'type', 'constraints'];
  dataSource;


  constructor(private extractDatabaseMetaDataService: ExtractDatabaseMetaDataService) {
  }


  ngOnInit(): void {
    this.extractDatabaseMetaDataService.extractDatabaseMetaData().subscribe(data => {
      this.tablesMetaData = data;
      this.dataSource = new MatTableDataSource<any>(data);
      console.log(this.dataSource);
    });
  }

  getdata(data): any {
    return new MatTableDataSource<any>(data);
  }

}

