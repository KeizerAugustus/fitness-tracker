package nl.fitnessapp.service.services;

import nl.fitnessapp.model.NewWorkoutDto;
import nl.fitnessapp.model.WorkoutTemplateDto;
import nl.fitnessapp.repositories.FinishedWorkoutRepository;
import nl.fitnessapp.repositories.WorkoutTemplateRepository;
import nl.fitnessapp.service.mappers.ActiveWorkoutToFinishedWorkoutMapper;
import nl.fitnessapp.service.mappers.TemplateToWorkoutMapper;
import nl.fitnessapp.service.mappers.WorkoutTemplateMapper;
import nl.fitnessapp.service.util.WorkoutTempSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class WorkoutService {

    private WorkoutTemplateRepository workoutTemplateRepository;
    private FinishedWorkoutRepository finishedWorkoutRepository;

    @Autowired
    public WorkoutService(WorkoutTemplateRepository workoutTemplateRepository, FinishedWorkoutRepository finishedWorkoutRepository) {
        this.workoutTemplateRepository = workoutTemplateRepository;
        this.finishedWorkoutRepository = finishedWorkoutRepository;
    }

    public NewWorkoutDto generateNewWorkout(int workoutTemplateId) {

        WorkoutTemplateDto workoutTemplateDto = WorkoutTemplateMapper.INSTANCE
                .workoutTemplateToWorkoutTemplateDto(workoutTemplateRepository.getReferenceById((long) workoutTemplateId));

        return TemplateToWorkoutMapper.map(workoutTemplateDto);
    }

    public void saveActiveWorkout(NewWorkoutDto newWorkoutDto) {
        addTimestamp(newWorkoutDto);
        WorkoutTempSaver.getInstance().saveWorkout(newWorkoutDto);
    }

    public NewWorkoutDto getActiveWorkout() {
        return WorkoutTempSaver.getInstance().getSavedWorkout();
    }

    public void saveFinishedWorkout() {
        finishedWorkoutRepository.save(ActiveWorkoutToFinishedWorkoutMapper.map(WorkoutTempSaver.getInstance().getSavedWorkout()));
        WorkoutTempSaver.getInstance().resetInstance();
    }

    private void addTimestamp(NewWorkoutDto newWorkoutDto) {
        newWorkoutDto.getSetInfoList().forEach(setInfoDto -> {
            setInfoDto.getReps().forEach(repInfo -> {
                if (repInfo.getReps() != null && repInfo.getWeight() != null && repInfo.getTimestamp() == null) {
                    repInfo.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
                }
            });
        });

    }
}
