import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';

/**
 * Componente para renderizar el encabezado de la aplicación
 */
@Component({
  selector: 'app-template',
  templateUrl: './template.component.html',
  styleUrls: ['./template.component.css']
})
export class TemplateComponent implements OnInit, OnDestroy {
    
    ngOnInit(): void {
      //Implementacion
    }

    ngOnDestroy(): void {
       //Implementacion
    }
    
}