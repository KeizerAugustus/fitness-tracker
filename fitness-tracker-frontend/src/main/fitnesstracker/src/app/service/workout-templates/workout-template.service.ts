import { Injectable } from '@angular/core';
import {RestService} from "../rest.service";
import {Endpoints} from "../../endpoints";
import {WorkoutTemplateDto} from "../../../../../../../target/generated-sources/openapi/model/workoutTemplateDto";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class WorkoutTemplateService {

  constructor(private rest: RestService) { }

  getAllTemplates(): Observable<WorkoutTemplateDto[]>{
    this.rest.setEndpoint(Endpoints.workouttemplates);
    return this.rest.doGet<WorkoutTemplateDto[]>();
  }
}
