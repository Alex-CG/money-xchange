import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HomeComponent } from 'src/app/home/home.component';
import { FooterComponent } from 'src/app/home/footer/footer.component';
import { ConversorComponent } from 'src/app/home/conversor/conversor.component';

import { DecimalFormatDirective } from 'src/app/directives/html.directive';

import { HttpClientModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    HomeComponent,
    FooterComponent,
    ConversorComponent,
    DecimalFormatDirective
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  exports: [
  	HomeComponent,
    FooterComponent,
  	ConversorComponent
  ],
  providers: []
})
export class HomeModule { }
