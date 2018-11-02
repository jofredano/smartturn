import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-widget-confirm',
  templateUrl: './widget-confirm.component.html',
  styleUrls: ['./widget-confirm.component.css']
})
export class WidgetConfirmComponent implements OnInit {

  private _title: string;
  
  private _content: string;
    
  constructor() {
      this._title = 'Confirmación';
      this._content = '¿Está seguro que desea realizar la accion?';
  }

  ngOnInit() {
      //Inicializacion del componente
  }

  public get title(): string {
      return this._title;
  }
  public get content(): string {
      return this._content;
  }
  
  public set title(_title: string) {
      this._title = _title;
  }
  public set content(_content: string) {
      this._content = _content;
  }
}
