import { Injectable } from '@angular/core';
import {NewWorkoutDto} from "../../../../../../../target/generated-sources/openapi/model/newWorkoutDto";
import {RestService} from "../rest.service";
import {Endpoints} from "../../endpoints";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class WorkoutService {

  constructor(private rest: RestService) { }

  saveWorkoutLocally(workout: NewWorkoutDto): Observable<any>{
    this.rest.setEndpoint(Endpoints.saveLocally);
    return this.rest.doPost(workout);
  }

  getSavedWorkout(): Observable<NewWorkoutDto>{
    this.rest.setEndpoint(Endpoints.retrieveLocalWorkout);
    return this.rest.doGet<NewWorkoutDto>();
  }

  finishWorkout(workout: NewWorkoutDto): Observable<any>{
    this.rest.setEndpoint(Endpoints.persistWorkout);
    return this.rest.doPost(workout);
  }


}
