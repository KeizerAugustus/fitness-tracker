package nl.fitnessapp.ws.movement;

import nl.fitnessapp.api.MovementsApi;
import nl.fitnessapp.model.MovementDto;
import nl.fitnessapp.service.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovementController implements MovementsApi {

    private final MovementService movementService;

    @Autowired
    public MovementController(MovementService movementService){
        this.movementService = movementService;
    }

    @Override
    public ResponseEntity<List<MovementDto>> returnAllMovements() {
        return ResponseEntity.ok(movementService.getAllMovements());
    }
}
