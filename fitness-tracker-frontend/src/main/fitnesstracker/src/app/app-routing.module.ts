import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DisplayMovementComponent} from "./view/movement/display-movement/display-movement.component";
import {HomeComponent} from "./view/common/home/home.component";
import {WorkoutTemplateComponent} from "./view/workout-template/workout-template.component";

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: "full"},
  {path: 'home', component: HomeComponent},
  {path: 'movements', component: DisplayMovementComponent},
  {path: 'workout-templates', component: WorkoutTemplateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
