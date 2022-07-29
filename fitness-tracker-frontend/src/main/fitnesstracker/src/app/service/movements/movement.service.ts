import {Injectable} from '@angular/core';
import {Endpoints} from "../../endpoints";
import {MovementDto} from "../../../../../../../target/generated-sources/openapi/model/movementDto";
import {RestService} from "../rest.service";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MovementService {

  constructor(private rest: RestService) {
  }

  getAllMovements(): Observable<MovementDto[]> {
    this.rest.setEndpoint(Endpoints.movements);
    return this.rest.doGet<MovementDto[]>();
  }

  getAllMusclegroups(): Observable<string[]> {
    this.rest.setEndpoint(Endpoints.musclegroups);
    return this.rest.doGet<string[]>();
  }

  addMovement(movement: MovementDto) {
    this.rest.setEndpoint(Endpoints.movements);
    return this.rest.doPost(movement);
  }

  changeMovement(movement: MovementDto) {
    this.rest.setEndpoint(Endpoints.movements);
    return this.rest.doPut(movement);
  }

  deleteMovement(movement: MovementDto) {
    this.rest.setEndpoint(Endpoints.movements, String(movement.id));
    return this.rest.doDelete();
  }
}
