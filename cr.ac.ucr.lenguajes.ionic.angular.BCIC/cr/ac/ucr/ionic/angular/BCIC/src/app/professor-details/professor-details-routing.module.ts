import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProfessorDetailsPage } from './professor-details.page';

const routes: Routes = [
  {
    path: '',
    component: ProfessorDetailsPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProfessorDetailsPageRoutingModule {}
