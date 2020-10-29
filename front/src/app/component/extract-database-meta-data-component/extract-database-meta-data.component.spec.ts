import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ExtractDatabaseMetaDataComponent} from './extract-database-meta-data.component';

describe('ExtractDatabaseMetaDataComponent', () => {
  let component: ExtractDatabaseMetaDataComponent;
  let fixture: ComponentFixture<ExtractDatabaseMetaDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ExtractDatabaseMetaDataComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExtractDatabaseMetaDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
