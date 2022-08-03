import {Component, OnInit} from '@angular/core';
import {MovementDto} from "../../../../../../../../target/generated-sources/openapi/model/movementDto";
import {MovementService} from "../../../service/movements/movement.service";
import {ConfirmationService, MessageService} from "primeng/api";

@Component({
  selector: 'app-display-movement',
  templateUrl: './display-movement.component.html',
  styleUrls: ['./display-movement.component.css'],
  providers: [MessageService, ConfirmationService]
})
export class DisplayMovementComponent implements OnInit {

  movementList: MovementDto[] = [];
  movementNew: MovementDto = {};
  submitted: boolean;
  muscleGroupList: string[] = []
  movementWijzigPopupZichtbaar: boolean;

  constructor(private movementService: MovementService,
              private messageService: MessageService,
              private confirmationService: ConfirmationService) {
  }

  ngOnInit(): void {
    this.movementService.getAllMovements().subscribe(movementList => this.movementList = movementList)
    this.movementService.getAllMusclegroups().subscribe(muscleGroupList => this.muscleGroupList = muscleGroupList);
  }

  newMovement() {
    this.movementNew = {};
    this.movementWijzigPopupZichtbaar = true;
    this.submitted = false;
  }

  saveMovement() {
    this.submitted = true;

    if (this.movementNew.name.trim() && this.movementNew.muscleGroup) {
      if (!this.movementNew.id) {
        this.movementService.addMovement(this.movementNew).subscribe({
          error: err => this.messageService.add({severity: 'error', detail: "Toevoegen mislukt..", life: 3000}),
          complete: () => {
            this.movementWijzigPopupZichtbaar = false;
            this.messageService.add({
              severity: 'success',
              summary: 'Succes',
              detail: 'Oefening toegevoegd!',
              life: 3000
            });
            this.ngOnInit();
          }
        })
      } else {
        this.movementService.changeMovement(this.movementNew).subscribe({
          error: err => this.messageService.add({severity: 'error', detail: "Wijzigen mislukt..", life: 3000}),
          complete: () => {
            this.movementWijzigPopupZichtbaar = false;
            this.messageService.add({
              severity: 'success',
              summary: 'Succes',
              detail: 'Oefening gewijzigd!',
              life: 3000
            });
            this.ngOnInit();
          }
        })
      }
    }
  }

  onCancelDialog() {
    this.movementWijzigPopupZichtbaar = false;
  }

  editMovement(movement: MovementDto) {
    this.movementNew = movement;
    this.movementWijzigPopupZichtbaar = true;
  }

  deleteMovement(movement: MovementDto) {
    this.confirmationService.confirm({
      message: 'Weet je zeker dat je ' + movement.name + ' wilt verwijderen?',
      header: 'Bevestig',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.movementService.deleteMovement(movement).subscribe({
          complete: () => {
            this.messageService.add({
              severity: 'success',
              summary: 'Succes',
              detail: 'Oefening verwijderd!',
              life: 3000
            });
            this.ngOnInit();
          },
          error: err => {
            this.messageService.add({
              severity: 'error',
              summary: 'Fail',
              detail: 'Oefening wordt gebruikt voor een template, kan niet verwijderd worden!',
              life: 3000
            });
          }
        })

      }
    });
  }

}
