import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {MovementDto} from "../../../../../../../../target/generated-sources/openapi/model/movementDto";
import {MovementService} from "../../../service/movements/movement.service";
import {WorkoutTemplateDto} from "../../../../../../../../target/generated-sources/openapi/model/workoutTemplateDto";
import {WorkoutTemplateService} from "../../../service/workout-templates/workout-template.service";
import {MessageService} from "primeng/api";

@Component({
  selector: 'app-create-template',
  templateUrl: './create-template.component.html',
  styleUrls: ['./create-template.component.css'],
  providers: [MessageService]
})
export class CreateTemplateComponent implements OnInit {

  allMovements: MovementDto[] = [];
  allStrategies: string[] = [];
  @Output("newTemplate") newTempEvent = new EventEmitter();

  newMovementChecked: boolean = false;
  templateNew: WorkoutTemplateDto = {};

  cols = [
    {field: 'amountOfTimes', header: 'Hoeveel sets'},
    {field: 'movement', header: 'Oefening'},
    {field: 'movementType', header: 'Strategie'},
  ]

  constructor(private movementService: MovementService, private templateService: WorkoutTemplateService, private messageService: MessageService) {
  }

  ngOnInit(): void {
    this.movementService.getAllMovements().subscribe(movements => this.allMovements = movements);
    this.templateService.getAllStrategies().subscribe(strategies => this.allStrategies = strategies);
  }

  newTemplate() {
    this.templateNew = {setTemplates: [{amountOfTimes: null}]};
    this.newMovementChecked = true;
  }

  onCancelDialog() {
    this.newMovementChecked = false;
  }

  saveTemplate() {
    for (let i = 0; i < this.templateNew.setTemplates.length; i++) {
      this.templateNew.setTemplates[i].orderOfSet = i + 1;
    }
    this.templateService.addTemplate(this.templateNew).subscribe({
        next: () => {
          this.newTempEvent.emit();
          this.newMovementChecked = false;
          this.messageService.add({
            severity: 'success',
            summary: 'Succes',
            detail: 'Template toegevoegd!!',
            life: 3000
          });
        }
      }
    )
  }

  addSet() {
    this.templateNew.setTemplates.push({});
  }

  removeSet() {
    this.templateNew.setTemplates.pop();
  }

}
