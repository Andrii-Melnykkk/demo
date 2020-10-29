import {TestBed} from '@angular/core/testing';

import {ExtractDatabaseMetaDataService} from './extract-database-meta-data.service';

describe('ExtractDatabaseMetaDataService', () => {
  let service: ExtractDatabaseMetaDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExtractDatabaseMetaDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
