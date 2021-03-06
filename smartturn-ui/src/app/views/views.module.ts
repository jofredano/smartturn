import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";

import { LayoutModule } from "./layout/layout.module";
import { SharedModule } from "../shared/shared.module";

import { FormModule } from './form/form.module';
import { WidgetsModule } from './widgets/widgets.module';

import { APP_ROUTES } from "./routes";


@NgModule({
  imports: [
     SharedModule,
     LayoutModule,
     RouterModule.forRoot(APP_ROUTES),
     FormModule,
     WidgetsModule
  ],
  declarations: [
  ],
  exports: [
  ],
  bootstrap: [
  ]
})
export class ViewsModule { }