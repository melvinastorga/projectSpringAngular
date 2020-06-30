import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CourseCreateUpdatePage } from './course-create-update.page';

const routes: Routes = [
  {
    path: '',
    component: CourseCreateUpdatePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CourseCreateUpdatePageRoutingModule {}
