import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {TableMetaData} from '../model/TableMetaData';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ExtractDatabaseMetaDataService {

  private readonly metaDataUrl: string;

  constructor(private http: HttpClient) {
    this.metaDataUrl = 'http://localhost:8080/database-meta-data';
  }

  public extractDatabaseMetaData = (): Observable<TableMetaData[]> => {
    return this.http.get<TableMetaData[]>(this.metaDataUrl);
  };
}
