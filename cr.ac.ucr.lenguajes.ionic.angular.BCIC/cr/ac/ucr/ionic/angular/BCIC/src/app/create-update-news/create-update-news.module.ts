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

import { CreateUpdateNewsPageRoutingModule } from './create-update-news-routing.module';

import { CreateUpdateNewsPage } from './create-update-news.page';

@NgModule({
  imports: [
    CommonModule,
    IonicModule,
    CreateUpdateNewsPageRoutingModule,
    FormsModule,
    IonicModule,
    MaterialModule,
    ReactiveFormsModule,
    CarouselModule,
    WavesModule,
    CardsModule,
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
  declarations: [CreateUpdateNewsPage]
})
export class CreateUpdateNewsPageModule {}
