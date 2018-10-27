import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";

import { LayoutModule } from "./layout/layout.module";
import { SharedModule } from "../shared/shared.module";
import { TemplateComponent } from "./layout/template/template.component";

export const APP_ROUTES: Routes = [
  { path: '', component: TemplateComponent }
];

@NgModule({
  imports: [
     SharedModule,
     LayoutModule,
     RouterModule.forRoot(APP_ROUTES)
  ],
  declarations: [
  ],
  exports: [
  ],
  bootstrap: [
  ]
})
export class ViewsModule { }