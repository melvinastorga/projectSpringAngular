import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomePage } from './home.page';
import { AnimatedCardsModule } from 'ng-uikit-pro-standard';
import { CarouselModule,CardsModule, WavesModule,ButtonsModule ,IconsModule,MDBBootstrapModule
,ModalModule,ChartsModule,BadgeModule,MDBRootModule,CollapseModule,DropdownModule,NavbarModule
,InputsModule,PopoverModule,TooltipModule,CheckboxModule,InputUtilitiesModule,TableModule,StickyHeaderModule,BreadcrumbModule

} from 'angular-bootstrap-md'
import { HomePageRoutingModule } from './home-routing.module';
import { MaterialModule } from '../material.module';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    HomePageRoutingModule,
    MaterialModule,
    ReactiveFormsModule,
    CarouselModule,
    WavesModule,
    CardsModule, AnimatedCardsModule,ButtonsModule,
    IconsModule,
    MDBBootstrapModule,
    ModalModule,ChartsModule,BadgeModule,MDBRootModule,
    CollapseModule,DropdownModule,NavbarModule
    ,InputsModule,PopoverModule,TooltipModule,CheckboxModule,InputUtilitiesModule,TableModule,StickyHeaderModule,BreadcrumbModule
    
  ],
  declarations: [HomePage]
})
export class HomePageModule {}
