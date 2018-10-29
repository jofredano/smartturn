import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from "../../shared/shared.module";
import { 
    FormMainComponent
  , FormCreateContactComponent } from './';

@NgModule({
  imports: [
    CommonModule,
    SharedModule
  ],
  declarations: [
    FormMainComponent,
    FormCreateContactComponent
  ]
})
export class FormsModule { }
