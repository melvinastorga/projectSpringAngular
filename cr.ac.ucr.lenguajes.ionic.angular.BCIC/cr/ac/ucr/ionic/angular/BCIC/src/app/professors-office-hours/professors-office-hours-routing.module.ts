import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

import { ProfessorsOfficeHoursPage } from "./professors-office-hours.page";

const routes: Routes = [
  {
    path: "",
    component: ProfessorsOfficeHoursPage,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProfessorsOfficeHoursPageRoutingModule {}
