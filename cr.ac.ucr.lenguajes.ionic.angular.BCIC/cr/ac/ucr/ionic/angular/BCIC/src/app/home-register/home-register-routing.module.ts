import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeRegisterPage } from './home-register.page';

const routes: Routes = [
  {
    path: '',
    component: HomeRegisterPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class HomeRegisterPageRoutingModule {}
