import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-template-header',
  templateUrl: './template-header.component.html',
  styleUrls: ['./template-header.component.css']
})
export class TemplateHeaderComponent implements OnInit {

    /**
     * Indica si el menú esta visible o no
     */
    private _menuActive: boolean = false;
    
    constructor() { }

    ngOnInit() {
        //Implementacion
    }
    
    get showMenu(): boolean {
        return this._menuActive;
    }
    
    set showMenu( menuActive: boolean) {
        this._menuActive = menuActive;
    }
    
    public changeMenuStatus(): void {
      this.showMenu = !this.showMenu;
    }
}
