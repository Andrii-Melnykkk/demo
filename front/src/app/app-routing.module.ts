import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ExtractDatabaseMetaDataComponent} from './component/extract-database-meta-data-component/extract-database-meta-data.component';

const routes: Routes = [
  { path: '', component: ExtractDatabaseMetaDataComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
