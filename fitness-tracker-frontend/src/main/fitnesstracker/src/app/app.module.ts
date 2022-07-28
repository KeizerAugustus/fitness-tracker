import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {TabMenuModule} from "primeng/tabmenu";
import { NavbarComponent } from './view/common/navbar/navbar.component';
import { DisplayMovementComponent } from './view/movement/display-movement/display-movement.component';
import { HomeComponent } from './view/common/home/home.component';
import {TableModule} from "primeng/table";
import {CardModule} from "primeng/card";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    DisplayMovementComponent,
    HomeComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        BrowserModule,
        BrowserAnimationsModule,
        TabMenuModule,
        TableModule,
        CardModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
