import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { StorageServiceModule  } from 'ngx-webstorage-service';

import { AuthorizationFilter, SecurityService } from './security';
import { HttpInterceptRequestService } from './http';

/**
 * Modulo donde se puede realizar instanciación global de clases
 */
@NgModule({
  imports: [
    CommonModule 
  ],
  providers: [
    AuthorizationFilter,
    SecurityService,
    StorageServiceModule ,
    { provide: HTTP_INTERCEPTORS, useClass: HttpInterceptRequestService, multi: true }
  ],
  declarations: []
})
export class CoreModule {
}
