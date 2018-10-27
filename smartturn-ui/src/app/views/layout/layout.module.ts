import { NgModule } from '@angular/core';
import { TemplateComponent } from "./template/template.component";

import { SharedModule } from "../../shared/shared.module";

/**
 * Modulo que incluye todos los componentes encargados de renderizar el layout en el arbol de la aplicación
 */
@NgModule({
  imports: [
    SharedModule
  ],
  declarations: [
    TemplateComponent
  ],
  exports: [
    TemplateComponent
  ],
  bootstrap: [
    TemplateComponent
  ]
})
export class LayoutModule { }