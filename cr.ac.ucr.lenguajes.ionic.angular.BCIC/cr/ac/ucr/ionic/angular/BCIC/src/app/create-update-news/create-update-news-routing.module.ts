import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CreateUpdateNewsPage } from './create-update-news.page';

const routes: Routes = [
  {
    path: '',
    component: CreateUpdateNewsPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CreateUpdateNewsPageRoutingModule {}
