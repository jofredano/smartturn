import { RouterModule, Routes } from "@angular/router";

import { TemplateComponent } from "./layout/template/template.component";
import { AuthorizationFilter } from "../core/security";
import { FormMainComponent } from "./forms/form-main/form-main.component";


export const APP_ROUTES: Routes = [
  //Rutas de los formularios de la aplicacion.
  { path: '', 
    component: TemplateComponent,
    children: [
       { path: 'forms' , 
           children: [
              { path: 'main'  , component: FormMainComponent },
              { path: '**'    , redirectTo: 'main' }
           ], 
           canActivateChild: [AuthorizationFilter] }
    ]  
  },
  { path: '**', redirectTo: 'forms' }
];