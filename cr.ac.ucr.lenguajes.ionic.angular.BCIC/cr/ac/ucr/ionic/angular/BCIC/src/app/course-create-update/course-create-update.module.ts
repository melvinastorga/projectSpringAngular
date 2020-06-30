import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { CourseCreateUpdatePageRoutingModule } from './course-create-update-routing.module';

import { CourseCreateUpdatePage } from './course-create-update.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CourseCreateUpdatePageRoutingModule
  ],
  declarations: [CourseCreateUpdatePage]
})
export class CourseCreateUpdatePageModule {}
