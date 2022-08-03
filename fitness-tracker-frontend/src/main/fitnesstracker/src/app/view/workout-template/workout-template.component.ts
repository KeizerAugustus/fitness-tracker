import {Component, OnInit, ViewChild} from '@angular/core';
import {WorkoutTemplateDto} from "../../../../../../../target/generated-sources/openapi/model/workoutTemplateDto";
import {WorkoutTemplateService} from "../../service/workout-templates/workout-template.service";
import {CreateTemplateComponent} from "./create-template/create-template.component";

@Component({
  selector: 'app-workout-template',
  templateUrl: './workout-template.component.html',
  styleUrls: ['./workout-template.component.css']
})
export class WorkoutTemplateComponent implements OnInit {

  templates: WorkoutTemplateDto[] = [];
  @ViewChild(CreateTemplateComponent) createComp: CreateTemplateComponent;

  constructor(private templateService: WorkoutTemplateService) { }

  ngOnInit(): void {
    this.templateService.getAllTemplates().subscribe(templates => this.templates = templates);
  }

  newTemplateAdded(){
    this.ngOnInit();
  }

  wijzigTemplate(template: WorkoutTemplateDto){
    this.createComp.templateNew = template;
    this.createComp.newMovementChecked = true;
  }

}
