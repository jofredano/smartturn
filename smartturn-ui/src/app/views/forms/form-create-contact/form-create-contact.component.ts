import { Component, OnInit } from '@angular/core';
import { 
    FormBuilder
  , FormGroup
  , Validators } from '@angular/forms';

@Component({
  selector: 'app-form-create-contact',
  templateUrl: './form-create-contact.component.html',
  styleUrls: ['./form-create-contact.component.css']
})
export class FormCreateContactComponent implements OnInit {
    
  public basic: FormGroup;
  public reference: FormGroup;

  constructor(private _builder: FormBuilder) { }

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
  }
}
