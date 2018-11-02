import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from "../../shared/shared.module";
import {
    MatPaginatorModule
  , MatSortModule
  , MatTableModule
  , MatIconModule
  , MatInputModule
  , MatFormFieldModule
  , MatExpansionModule
  , MatDatepickerModule
  , MatNativeDateModule
  , MatCheckboxModule
  , MatListModule
  , MatButtonModule
  , MatSelectModule
  , MatCardModule
  , MatStepperModule
  , MatDialogModule
} from '@angular/material';
import { WidgetConfirmComponent } from './widget-confirm/widget-confirm.component';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    BrowserModule , 
    FormsModule, 
    ReactiveFormsModule ,
    MatPaginatorModule, 
    MatSortModule , 
    MatTableModule ,
    MatIconModule,
    MatInputModule, 
    MatFormFieldModule ,
    MatExpansionModule ,
    MatDatepickerModule ,
    MatNativeDateModule ,
    MatCheckboxModule ,
    MatListModule ,
    MatButtonModule , 
    MatSelectModule ,
    MatCardModule , 
    MatStepperModule , 
    MatDialogModule 
  ],
  entryComponents: [
    WidgetConfirmComponent
  ],
  declarations: [
    WidgetConfirmComponent
  ]
})
export class WidgetsModule { }
