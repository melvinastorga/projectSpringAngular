import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RemoveProfessorCoursesPage } from './remove-professor-courses.page';

const routes: Routes = [
  {
    path: '',
    component: RemoveProfessorCoursesPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RemoveProfessorCoursesPageRoutingModule {}
