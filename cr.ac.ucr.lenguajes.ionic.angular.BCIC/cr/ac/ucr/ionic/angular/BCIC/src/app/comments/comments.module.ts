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

import { CommentsPageRoutingModule } from './comments-routing.module';

import { CommentsPage } from './comments.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CommentsPageRoutingModule,
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
    ReactiveFormsModule,
    MaterialModule
  ],
  declarations: [CommentsPage]
})
export class CommentsPageModule {}
