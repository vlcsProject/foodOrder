import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HeadRoutingModule } from './head-routing.module';
import { AdminComponent } from './admin/admin.component';


@NgModule({
  declarations: [
    AdminComponent
  ],
  imports: [
    CommonModule,
    HeadRoutingModule
  ]
})
export class HeadModule { }
