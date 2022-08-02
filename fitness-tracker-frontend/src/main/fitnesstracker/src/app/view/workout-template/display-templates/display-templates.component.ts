import {Component, Input, OnInit} from '@angular/core';
import {WorkoutTemplateDto} from "../../../../../../../../target/generated-sources/openapi/model/workoutTemplateDto";
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-display-templates',
  templateUrl: './display-templates.component.html',
  styleUrls: ['./display-templates.component.css']
})
export class DisplayTemplatesComponent {

  @Input() template: WorkoutTemplateDto;

  items: MenuItem[] = [
    {label: 'Wijzig', icon: 'pi pi-pencil', command: () => {this.wijzigTemplate()}},
    {label: 'Verwijder', icon: 'pi pi-file-excel', command: () => {this.verwijderTemplate()}}
  ];

  constructor() { }

  wijzigTemplate(){
    console.log('wijzig training');
  }

  verwijderTemplate(){
    console.log('verwijder training');
  }

}
