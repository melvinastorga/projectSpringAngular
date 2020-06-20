import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { HomeLoginPageRoutingModule } from './home-login-routing.module';

import { HomeLoginPage } from './home-login.page';
import { MaterialModule } from '../material.module';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    HomeLoginPageRoutingModule,MaterialModule
  ],
  declarations: [HomeLoginPage]
})
export class HomeLoginPageModule {}
