import { RouterModule, Routes } from "@angular/router";

import { AuthorizationFilter }        from "../core/security";
import { TemplateComponent }          from "./layout/template/template.component";
import { 
    FormMainComponent,
    FormCreateContactComponent }      from "./form";

export const APP_ROUTES: Routes = [
  //Rutas de los formularios de la aplicacion.
  { path: '', 
    component: TemplateComponent,
    children: [
       { path: 'forms' , 
           children: [
              { path: 'main'            , component: FormMainComponent },
              { path: 'create-contact'  , component: FormCreateContactComponent },
              { path: '**'              , redirectTo: 'main' }
           ] }
    ]  
  },
  { path: '**', redirectTo: 'forms' }
];