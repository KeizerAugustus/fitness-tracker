import { Injectable } from '@angular/core';
import {RestService} from "../rest.service";
import {Endpoints} from "../../endpoints";
import {WorkoutTemplateDto} from "../../../../../../../target/generated-sources/openapi/model/workoutTemplateDto";
import {Observable} from "rxjs";
import {NewWorkoutDto} from "../../../../../../../target/generated-sources/openapi/model/newWorkoutDto";

@Injectable({
  providedIn: 'root'
})
export class WorkoutTemplateService {

  constructor(private rest: RestService) { }

  getAllTemplates(): Observable<WorkoutTemplateDto[]>{
    this.rest.setEndpoint(Endpoints.workouttemplates);
    return this.rest.doGet<WorkoutTemplateDto[]>();
  }

  getAllStrategies(): Observable<string[]>{
    this.rest.setEndpoint(Endpoints.workouttypes);
    return this.rest.doGet<string[]>();
  }

  addTemplate(template: WorkoutTemplateDto){
    this.rest.setEndpoint(Endpoints.workouttemplates);
    return this.rest.doPost(template);
  }

  changeTemplate(template: WorkoutTemplateDto){
    this.rest.setEndpoint(Endpoints.workouttemplates);
    return this.rest.doPut(template);
  }

  deletetemplate(template: WorkoutTemplateDto){
    this.rest.setEndpoint(Endpoints.workouttemplates, String(template.id));
    return this.rest.doDelete();
  }

  generateNewWorkout(templateId: string): Observable<NewWorkoutDto>{
    this.rest.setEndpoint(Endpoints.convertTemplate, templateId);
    return this.rest.doGet();
  }
}
