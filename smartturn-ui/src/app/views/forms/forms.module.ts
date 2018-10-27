import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from "../../shared/shared.module";
import { FormMainComponent } from './form-main/form-main.component';

@NgModule({
  imports: [
    CommonModule,
    SharedModule
  ],
  declarations: [
    FormMainComponent
  ]
})
export class FormsModule { }
