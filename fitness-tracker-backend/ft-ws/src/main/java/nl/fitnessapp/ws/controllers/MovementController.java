package nl.fitnessapp.ws.controllers;

import nl.fitnessapp.api.MovementsApi;
import nl.fitnessapp.model.MovementDto;
import nl.fitnessapp.service.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovementController implements MovementsApi {

    private final MovementService movementService;

    @Autowired
    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    @Override
    public ResponseEntity<List<MovementDto>> returnAllMovements() {
        return ResponseEntity.ok(movementService.getAllMovements());
    }

    @Override
    public ResponseEntity<List<String>> returnAllMuscleGroups() {
        return ResponseEntity.ok(movementService.getAllMusclegroups());
    }

    @Override
    public ResponseEntity<Void> addAMovement(MovementDto movementDto) {
        movementService.addMovement(movementDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> changeAMovement(MovementDto movementDto) {
        movementService.changeMovement(movementDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deletingAMovement(@PathVariable("movementId") Integer movementId) {
        movementService.deleteMovement(movementId);
        return ResponseEntity.ok().build();
    }
}
