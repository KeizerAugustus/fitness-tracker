import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {TabMenuModule} from "primeng/tabmenu";
import {NavbarComponent} from './view/common/navbar/navbar.component';
import {DisplayMovementComponent} from './view/movement/display-movement/display-movement.component';
import {HomeComponent} from './view/common/home/home.component';
import {TableModule} from "primeng/table";
import {CardModule} from "primeng/card";
import {ToolbarModule} from "primeng/toolbar";
import {ButtonModule} from "primeng/button";
import {RippleModule} from "primeng/ripple";
import {DialogModule} from "primeng/dialog";
import {InputTextModule} from "primeng/inputtext";
import {FormsModule} from "@angular/forms";
import {DropdownModule} from "primeng/dropdown";
import {ToastModule} from "primeng/toast";
import {ConfirmDialogModule} from "primeng/confirmdialog";
import { DisplayTemplatesComponent } from './view/workout-template/display-templates/display-templates.component';
import { WorkoutTemplateComponent } from './view/workout-template/workout-template.component';
import {SplitButtonModule} from "primeng/splitbutton";
import { CreateTemplateComponent } from './view/workout-template/create-template/create-template.component';
import {OrderListModule} from "primeng/orderlist";
import {InputNumberModule} from "primeng/inputnumber";
import {ConfirmationService, MessageService} from "primeng/api";
import { WorkoutComponent } from './view/workout/workout.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    DisplayMovementComponent,
    HomeComponent,
    DisplayTemplatesComponent,
    WorkoutTemplateComponent,
    CreateTemplateComponent,
    WorkoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    TabMenuModule,
    TableModule,
    CardModule,
    ToolbarModule,
    ButtonModule,
    RippleModule,
    DialogModule,
    InputTextModule,
    DropdownModule,
    ToastModule,
    ConfirmDialogModule,
    SplitButtonModule,
    OrderListModule,
    InputNumberModule
  ],
  providers: [MessageService, ConfirmationService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
