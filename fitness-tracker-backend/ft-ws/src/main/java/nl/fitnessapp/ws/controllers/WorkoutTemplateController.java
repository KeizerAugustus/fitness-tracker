package nl.fitnessapp.ws.controllers;

import nl.fitnessapp.api.WorkouttemplatesApi;
import nl.fitnessapp.model.WorkoutTemplateDto;
import nl.fitnessapp.service.services.WorkoutTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkoutTemplateController implements WorkouttemplatesApi {

    private final WorkoutTemplateService workoutTemplateService;

    @Autowired
    public WorkoutTemplateController(WorkoutTemplateService workoutTemplateService){
        this.workoutTemplateService = workoutTemplateService;
    }
    @Override
    public ResponseEntity<List<WorkoutTemplateDto>> returnAllWorkouttemplates() {
        return ResponseEntity.ok(workoutTemplateService.getAll());
    }

    @Override
    public ResponseEntity<List<String>> returnAllWorkouttypes() {
        return ResponseEntity.ok(workoutTemplateService.getMovementTypes());
    }

    @Override
    public ResponseEntity<Void> addAWorkouttemplate(WorkoutTemplateDto workoutTemplateDto) {
        workoutTemplateService.addWorkoutTemplate(workoutTemplateDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> changeAWorkouttemplate(WorkoutTemplateDto workoutTemplateDto) {
        workoutTemplateService.changeWorkoutTemplate(workoutTemplateDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deletingATemplate(@PathVariable("templateId")Integer templateId) {
        workoutTemplateService.deleteWorkoutTemplate((long) templateId);
        return ResponseEntity.ok().build();
    }
}
