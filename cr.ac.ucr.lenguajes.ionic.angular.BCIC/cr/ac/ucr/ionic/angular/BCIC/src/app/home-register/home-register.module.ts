import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { HomeRegisterPageRoutingModule } from './home-register-routing.module';

import { HomeRegisterPage } from './home-register.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    HomeRegisterPageRoutingModule
  ],
  declarations: [HomeRegisterPage]
})
export class HomeRegisterPageModule {}
