package nl.fitnessapp.ws.controllers;

import nl.fitnessapp.api.WorkoutApi;
import nl.fitnessapp.model.NewWorkoutDto;
import nl.fitnessapp.service.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController implements WorkoutApi {

    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @Override
    public ResponseEntity<NewWorkoutDto> returnTheNewWorkout(@PathVariable("templateId")Integer templateId) {
       return ResponseEntity.ok(workoutService.generateNewWorkout(templateId));
    }

    @Override
    public ResponseEntity<Void> finishWorkout() {
        workoutService.saveFinishedWorkout();
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<NewWorkoutDto> getWorkout() {
        return ResponseEntity.ok(workoutService.getActiveWorkout());
    }

    @Override
    public ResponseEntity<NewWorkoutDto> savingWorkout(NewWorkoutDto newWorkoutDto) {
        workoutService.saveActiveWorkout(newWorkoutDto);
        return ResponseEntity.ok(workoutService.saveActiveWorkout(newWorkoutDto));
    }
}
