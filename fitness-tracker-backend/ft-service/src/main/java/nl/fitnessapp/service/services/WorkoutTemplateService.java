package nl.fitnessapp.service.services;

import nl.fitnessapp.enums.MovementType;
import nl.fitnessapp.model.WorkoutTemplate;
import nl.fitnessapp.model.WorkoutTemplateDto;
import nl.fitnessapp.repositories.WorkoutTemplateRepository;
import nl.fitnessapp.service.mappers.WorkoutTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutTemplateService {

    private WorkoutTemplateRepository workoutTemplateRepository;

    @Autowired
    public WorkoutTemplateService(WorkoutTemplateRepository workoutTemplateRepository) {
        this.workoutTemplateRepository = workoutTemplateRepository;
    }

    public List<WorkoutTemplateDto> getAll() {
        return workoutTemplateRepository.findAll().stream()
                .map(WorkoutTemplateMapper.INSTANCE::workoutTemplateToWorkoutTemplateDto)
                .collect(Collectors.toList());
    }

    public List<String> getMovementTypes() {
        return Arrays.stream(MovementType.values()).map(MovementType::toString).collect(Collectors.toList());
    }

    public void addWorkoutTemplate(WorkoutTemplateDto workoutTemplateDto) {
        workoutTemplateRepository.save(WorkoutTemplateMapper.INSTANCE.workoutTemplateDtoToWorkoutTemplate(workoutTemplateDto));
    }

    public void deleteWorkoutTemplate(Long setTemplateId){
        workoutTemplateRepository.deleteById(setTemplateId);
    }

    @Transactional
    public void changeWorkoutTemplate(WorkoutTemplateDto workoutTemplateDto) {
        WorkoutTemplate workoutTemplateOld = workoutTemplateRepository.getReferenceById((long) workoutTemplateDto.getId());
        WorkoutTemplate workoutTemplateNew = WorkoutTemplateMapper.INSTANCE.workoutTemplateDtoToWorkoutTemplate(workoutTemplateDto);

        workoutTemplateOld.setSetTemplates(workoutTemplateNew.getSetTemplates());
        workoutTemplateOld.setTemplateName(workoutTemplateNew.getTemplateName());
    }
}
