import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { ProfessorsPageRoutingModule } from './professors-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../material.module';
import { ProfessorsPage } from './professors.page';
import { CarouselModule,CardsModule, WavesModule,ButtonsModule ,IconsModule,MDBBootstrapModule
  ,ModalModule,ChartsModule,BadgeModule,MDBRootModule,CollapseModule,DropdownModule,NavbarModule
  ,InputsModule,PopoverModule,TooltipModule,CheckboxModule,InputUtilitiesModule,TableModule,StickyHeaderModule,BreadcrumbModule
  
  } from 'angular-bootstrap-md'

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ProfessorsPageRoutingModule,
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
  declarations: [ProfessorsPage]
})
export class ProfessorsPageModule {}
