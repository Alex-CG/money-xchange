import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HomeComponent } from 'src/app/home/home.component';
import { ConversorComponent } from 'src/app/home/conversor/conversor.component';

import { HttpClientModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    HomeComponent,
    ConversorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  exports: [
  	HomeComponent,
  	ConversorComponent
  ],
  providers: []
})
export class HomeModule { }
