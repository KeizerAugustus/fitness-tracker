import { Component, OnInit } from '@angular/core';
import {RestService} from "../../../service/rest.service";
import {MovementDto} from "../../../../../../../../target/generated-sources/openapi/model/movementDto";
import {Endpoints} from "../../../endpoints";
import {SortEvent} from "primeng/api";

@Component({
  selector: 'app-display-movement',
  templateUrl: './display-movement.component.html',
  styleUrls: ['./display-movement.component.css']
})
export class DisplayMovementComponent implements OnInit {

  movementList: MovementDto[] = []

  constructor(private rest: RestService) { }

  ngOnInit(): void {
    this.rest.setEndpoint(Endpoints.movements);
    this.rest.doGet<MovementDto[]>().subscribe(movementList => this.movementList = movementList);
  }

}
