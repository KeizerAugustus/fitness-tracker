import { Component, OnInit } from '@angular/core';
import {WorkoutService} from "../../service/workout/workout.service";
import {NewWorkoutDto} from "../../../../../../../target/generated-sources/openapi/model/newWorkoutDto";
import {ConfirmationService, MessageService} from "primeng/api";
import {SetInfoDto} from "../../../../../../../target/generated-sources/openapi/model/setInfoDto";

@Component({
  selector: 'app-workout',
  templateUrl: './workout.component.html',
  styleUrls: ['./workout.component.css'],
  providers: [ConfirmationService]
})
export class WorkoutComponent implements OnInit {

  newWorkout: NewWorkoutDto;

  constructor(private workoutService: WorkoutService,
              private messageService: MessageService,
              private confirmationService: ConfirmationService) {
  }

  ngOnInit(): void {
    this.workoutService.getSavedWorkout().subscribe(workout => this.newWorkout = workout);
  }

  saveWorkout() {
    this.workoutService.saveWorkoutLocally(this.newWorkout).subscribe(() => this.messageService.add({
      severity: 'success',
      summary: 'Succes',
      detail: 'Workout opgeslagen',
      life: 3000
    }));
  }

  addRep(set: SetInfoDto) {
    set.reps.push({});
  }

  removeRep(set: SetInfoDto, i: number) {
    set.reps.splice(i, 1);
  }

  finishWorkout() {
    this.confirmationService.confirm({
      message: 'Wil je de training opslaan?',
      header: 'Bevestig',
      icon: 'pi pi-exclamation-triangle',
      accept: () =>{
        this.workoutService.finishWorkout(this.newWorkout).subscribe(() => {
          this.messageService.add({
            severity: 'success',
            summary: 'Succes',
            detail: 'Training succesvol opgeslagen!',
            life: 3000
          });
          this.newWorkout = {};
          this.confirmationService.close();
        })
      }
    })
  }
}
