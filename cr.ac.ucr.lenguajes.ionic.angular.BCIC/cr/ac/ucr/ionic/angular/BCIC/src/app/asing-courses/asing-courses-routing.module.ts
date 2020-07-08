import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AsingCoursesPage } from './asing-courses.page';

const routes: Routes = [
  {
    path: '',
    component: AsingCoursesPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AsingCoursesPageRoutingModule {}
