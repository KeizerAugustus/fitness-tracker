import { Component, OnInit } from '@angular/core';
import {WorkoutTemplateDto} from "../../../../../../../target/generated-sources/openapi/model/workoutTemplateDto";
import {WorkoutTemplateService} from "../../service/workout-templates/workout-template.service";

@Component({
  selector: 'app-workout-template',
  templateUrl: './workout-template.component.html',
  styleUrls: ['./workout-template.component.css']
})
export class WorkoutTemplateComponent implements OnInit {

  templates: WorkoutTemplateDto[] = [];

  constructor(private templateService: WorkoutTemplateService) { }

  ngOnInit(): void {
    this.templateService.getAllTemplates().subscribe(templates => this.templates = templates);
  }

}
