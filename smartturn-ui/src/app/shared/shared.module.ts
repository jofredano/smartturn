import { NgModule, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { 
   InputTextModule
 , ButtonModule
 , CheckboxModule
 , ScrollPanelModule 
} from 'primeng/primeng';

/**
 *  Modulo donde se puede realizar instanciacion modular de clases
 */
@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  declarations: [
  ],
  exports: [
    CommonModule,
    RouterModule,
    FormsModule,
    InputTextModule,
    ButtonModule,
    CheckboxModule,
    ScrollPanelModule
  ]
})
export class SharedModule {
  static forRoot(): ModuleWithProviders {
    return {
        ngModule: SharedModule
    };
  }
}
