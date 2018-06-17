import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AppComponent } from './app.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { NavbarComponent } from './navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/modules/material/material.module';

import { NewAccomodationComponent } from './new-accomodation/new-accomodation.component';
import { AccomodationsComponent } from './accomodations/accomodations.component';
import { HttpClientModule } from '@angular/common/http';
import { AccomodationComponent } from './accomodation/accomodation.component';






@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    NewAccomodationComponent,
    AccomodationsComponent,
    AccomodationComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    BrowserAnimationsModule,
    MaterialModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
