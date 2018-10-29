import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
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
import { 
    FormMainComponent
  , FormCreateContactComponent } from './';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    BrowserModule , 
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
  declarations: [
    FormMainComponent,
    FormCreateContactComponent
  ]
})
export class FormsModule { }
