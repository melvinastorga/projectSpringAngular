import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MaterialModule } from "../material.module";
import {
  CarouselModule,
  CardsModule,
  WavesModule,
  ButtonsModule,
  IconsModule,
  MDBBootstrapModule,
  ModalModule,
  ChartsModule,
  BadgeModule,
  MDBRootModule,
  CollapseModule,
  DropdownModule,
  NavbarModule,
  InputsModule,
  PopoverModule,
  TooltipModule,
  CheckboxModule,
  InputUtilitiesModule,
  TableModule,
  StickyHeaderModule,
  BreadcrumbModule,
} from "angular-bootstrap-md";


import { IonicModule } from '@ionic/angular';

import { RemoveProfessorCoursesPageRoutingModule } from './remove-professor-courses-routing.module';

import { RemoveProfessorCoursesPage } from './remove-professor-courses.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RemoveProfessorCoursesPageRoutingModule,
    CarouselModule,
    CardsModule,
    ReactiveFormsModule,
    WavesModule,
    MaterialModule,
    ButtonsModule,
    IconsModule,
    MDBBootstrapModule,
    ModalModule,
    ChartsModule,
    BadgeModule,
    MDBRootModule,
    CollapseModule,
    DropdownModule,
    NavbarModule,
    InputsModule,
    PopoverModule,
    TooltipModule,
    CheckboxModule,
    InputUtilitiesModule,
    TableModule,
    StickyHeaderModule,
    BreadcrumbModule,
  ],
  declarations: [RemoveProfessorCoursesPage]
})
export class RemoveProfessorCoursesPageModule {}
