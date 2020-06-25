import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { CoursesPageRoutingModule } from './courses-routing.module';
import { CoursesPage } from './courses.page';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../material.module';
import { CarouselModule,CardsModule, WavesModule,ButtonsModule ,IconsModule,MDBBootstrapModule
  ,ModalModule,ChartsModule,BadgeModule,MDBRootModule,CollapseModule,DropdownModule,NavbarModule
  ,InputsModule,PopoverModule,TooltipModule,CheckboxModule,InputUtilitiesModule,TableModule,StickyHeaderModule,BreadcrumbModule
  
  } from 'angular-bootstrap-md'


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CoursesPageRoutingModule,
    CommonModule,
    FormsModule,
    IonicModule,
    MaterialModule,
    ReactiveFormsModule,
    CarouselModule,
    WavesModule,
    CardsModule,ButtonsModule,
    IconsModule,
    MDBBootstrapModule,
    ModalModule,ChartsModule,BadgeModule,MDBRootModule,
    CollapseModule,DropdownModule,NavbarModule
    ,InputsModule,PopoverModule,TooltipModule,CheckboxModule,InputUtilitiesModule,TableModule,StickyHeaderModule,BreadcrumbModule
  ],
  declarations: [CoursesPage]
})
export class CoursesPageModule {}
