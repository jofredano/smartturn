import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

import { TemplateComponent } from "./template/template.component";
import { SharedModule } from "../../shared/shared.module";

import { TemplateHeaderComponent } from './template-header/template-header.component';
import { TemplateMenuComponent }   from './template-menu/template-menu.component';


/**
 * Modulo que incluye todos los componentes encargados de renderizar el layout en el arbol de la aplicación
 */
@NgModule({
  imports: [
    SharedModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [
    TemplateComponent,
    TemplateHeaderComponent,
    TemplateMenuComponent
  ],
  exports: [
    TemplateComponent,
    TemplateHeaderComponent
  ],
  bootstrap: [
    TemplateComponent,
    TemplateHeaderComponent
  ]
})
export class LayoutModule { }