package nl.fitnessapp.service.services;

import nl.fitnessapp.model.NewWorkoutDto;
import nl.fitnessapp.model.WorkoutTemplateDto;
import nl.fitnessapp.repositories.WorkoutTemplateRepository;
import nl.fitnessapp.service.mappers.TemplateToWorkoutMapper;
import nl.fitnessapp.service.mappers.WorkoutTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    private WorkoutTemplateRepository workoutTemplateRepository;

    @Autowired
    public WorkoutService(WorkoutTemplateRepository workoutTemplateRepository) {
        this.workoutTemplateRepository = workoutTemplateRepository;
    }

    public NewWorkoutDto generateNewWorkout(int workoutTemplateId) {

        WorkoutTemplateDto workoutTemplateDto = WorkoutTemplateMapper.INSTANCE
                .workoutTemplateToWorkoutTemplateDto(workoutTemplateRepository.getReferenceById((long) workoutTemplateId));

        return TemplateToWorkoutMapper.map(workoutTemplateDto);
    }
}
