import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {WorkoutTemplateDto} from "../../../../../../../../target/generated-sources/openapi/model/workoutTemplateDto";
import {ConfirmationService, MenuItem, MessageService} from "primeng/api";
import {WorkoutTemplateService} from "../../../service/workout-templates/workout-template.service";

@Component({
  selector: 'app-display-templates',
  templateUrl: './display-templates.component.html',
  styleUrls: ['./display-templates.component.css']
})
export class DisplayTemplatesComponent {

  @Input() template: WorkoutTemplateDto;
  @Output("wijzigTemplate") wijzigEvent = new EventEmitter<WorkoutTemplateDto>();

  items: MenuItem[] = [
    {label: 'Wijzig', icon: 'pi pi-pencil', command: () => {this.wijzigTemplate()}},
    {label: 'Verwijder', icon: 'pi pi-file-excel', command: () => {this.verwijderTemplate()}}
  ];

  constructor(private confirmationService: ConfirmationService, private templateService: WorkoutTemplateService, private messageService: MessageService) { }

  wijzigTemplate(){
    this.wijzigEvent.emit(this.template);
  }

  verwijderTemplate(){
    this.confirmationService.confirm({
      message: 'Weet je zeker dat je ' + this.template.templateName + ' wilt verwijderen?',
      header: 'Bevestig',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.templateService.deletetemplate(this.template).subscribe({
          complete: () => {
            this.messageService.add({
              severity: 'success',
              summary: 'Succes',
              detail: 'Template verwijderd!',
              life: 3000
            });
            this.confirmationService.close();
          },
          error: err => {
            this.messageService.add({
              severity: 'error',
              summary: 'Fail',
              detail: 'Template verwijderen niet gelukt..',
              life: 3000
            });
          }
        })

      }
    });
  }

}
