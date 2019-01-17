import { Component, OnInit } from '@angular/core';
import { 
    FormBuilder
  , FormGroup
  , FormControl
  , Validators } from '@angular/forms';
import { MatDialog, MatTableDataSource } from '@angular/material';
import { DTOReference } from "../../../core/model";
import { WidgetConfirmComponent } from "../../widgets";

const ELEMENT_DATA: DTOReference[] = [];
  
@Component({
  selector: 'app-form-create-contact',
  templateUrl: './form-create-contact.component.html',
  styleUrls: ['./form-create-contact.component.css']
})
export class FormCreateContactComponent implements OnInit {
  
  public displayedColumns: string[] = [ 'type', 'category', 'value', 'preference' ];
  
  public dataSource = new MatTableDataSource<DTOReference>(ELEMENT_DATA);

  public basic: FormGroup;
  public reference: FormGroup;
  public finish: FormGroup;
  
  public referenceType: any;
  
  public referenceCategory: any;
  
  public referenceValue: any = null;

  constructor(private _builder: FormBuilder, public dialog: MatDialog) { }

  ngOnInit() {
      this.initForm();
  }

  public initForm(): void {
      this.basic = this._builder.group({
         firstCtrl: ['', Validators.required]
      });
      this.reference = this._builder.group({
         secondCtrl: ['', Validators.required]
      });
      this.finish = this._builder.group({
         tirthCtrl: ['', Validators.required]
      });
  }
  
  public openDialog(): void {
      const dialogRef                     = this.dialog.open( WidgetConfirmComponent ); 
      dialogRef.componentInstance.title   = 'Confirmación de creación';
      dialogRef.componentInstance.content = 'Esta a punto de crear el contacto, ¿Está seguro de hacerlo?';
      dialogRef.afterClosed().subscribe(result => {
        console.log(`Dialog result: ${result}`);
      });
  }
  
  public addReference(): void {
      console.log('Se hace normal =>' + this.referenceType);
  }
}
