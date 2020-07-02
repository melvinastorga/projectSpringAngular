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

import { StudentDetailsPageRoutingModule } from './student-details-routing.module';

import { StudentDetailsPage } from './student-details.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    StudentDetailsPageRoutingModule,
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
    MaterialModule,
    ReactiveFormsModule,
  ],
  declarations: [StudentDetailsPage]
})
export class StudentDetailsPageModule {}
