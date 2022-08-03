package nl.fitnessapp.service.services;

import nl.fitnessapp.enums.MovementType;
import nl.fitnessapp.model.SetTemplate;
import nl.fitnessapp.model.WorkoutTemplate;
import nl.fitnessapp.model.WorkoutTemplateDto;
import nl.fitnessapp.repositories.SetTemplateRepository;
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
    private SetTemplateRepository setTemplateRepository;

    @Autowired
    public WorkoutTemplateService(WorkoutTemplateRepository workoutTemplateRepository, SetTemplateRepository setTemplateRepository) {
        this.workoutTemplateRepository = workoutTemplateRepository;
        this.setTemplateRepository = setTemplateRepository;
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

    public void deleteWorkoutTemplate(Long setTemplateId) {
        workoutTemplateRepository.deleteById(setTemplateId);
    }

    @Transactional
    public WorkoutTemplate changeWorkoutTemplate(WorkoutTemplateDto workoutTemplateDto) {
        WorkoutTemplate workoutTemplateOld = workoutTemplateRepository.getReferenceById((long) workoutTemplateDto.getId());
        WorkoutTemplate workoutTemplateNew = WorkoutTemplateMapper.INSTANCE.workoutTemplateDtoToWorkoutTemplate(workoutTemplateDto);

        List<SetTemplate> notChangedList = workoutTemplateNew.getSetTemplates().stream()
                .filter(setTemplate -> workoutTemplateOld.getSetTemplates().contains(setTemplate)).toList();
        List<SetTemplate> removedList = workoutTemplateOld.getSetTemplates().stream()
                .filter(setTemplate ->
                        !workoutTemplateNew.getSetTemplates().stream().map(SetTemplate::getId).toList().contains(setTemplate.getId()))
                .toList();

        workoutTemplateOld.getSetTemplates().removeAll(removedList);
        workoutTemplateNew.getSetTemplates().removeAll(notChangedList);
        workoutTemplateNew.getSetTemplates().forEach(setTemplate -> {
            if (setTemplate.getId() == null) {
                setTemplateRepository.save(setTemplate);
                workoutTemplateOld.getSetTemplates().add(setTemplate);
            } else {
                SetTemplate setTemplateOld = setTemplateRepository.getReferenceById(setTemplate.getId());
                setTemplateOld.copyAttributes(setTemplate);
            }
        });

        workoutTemplateOld.setTemplateName(workoutTemplateNew.getTemplateName());

        return workoutTemplateOld;
    }
}
