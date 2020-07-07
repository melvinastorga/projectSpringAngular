import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProfessorCreateUpdatePage } from './professor-create-update.page';

const routes: Routes = [
  {
    path: '',
    component: ProfessorCreateUpdatePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProfessorCreateUpdatePageRoutingModule {}
