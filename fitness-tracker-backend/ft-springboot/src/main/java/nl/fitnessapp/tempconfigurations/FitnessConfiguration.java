package nl.fitnessapp.tempconfigurations;

import nl.fitnessapp.enums.MuscleGroup;
import nl.fitnessapp.model.Movement;
import nl.fitnessapp.enums.MovementType;
import nl.fitnessapp.model.SetTemplate;
import nl.fitnessapp.model.WorkoutTemplate;
import nl.fitnessapp.repositories.MovementRepository;
import nl.fitnessapp.repositories.SetTemplateRepository;
import nl.fitnessapp.repositories.WorkoutTemplateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FitnessConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(MovementRepository movementRepository, WorkoutTemplateRepository workoutTemplateRepository){
        return args -> {
            Movement movement = new Movement("Bench Press", MuscleGroup.CHEST);
            movementRepository.save(movement);

            Movement movement1 = new Movement("Squat", MuscleGroup.LEGS);
            movementRepository.save(movement1);

            Movement movement3 = new Movement("Bicep Curl", MuscleGroup.BICEP);
            movementRepository.save(movement3);

            SetTemplate setTemplateBench = new SetTemplate(MovementType.TENTENMAX, movement);
            setTemplateBench.setAmountOfTimes(3);
            setTemplateBench.setOrderOfSet(2);

            SetTemplate setTemplateSquat = new SetTemplate(MovementType.EIGHTTOTWELVE, movement1);
            setTemplateSquat.setAmountOfTimes(3);
            setTemplateSquat.setOrderOfSet(1);

            SetTemplate setTemplateBicepCurl = new SetTemplate(MovementType.OTHER, movement3);
            setTemplateBicepCurl.setAmountOfTimes(4);
            setTemplateBicepCurl.setOrderOfSet(3);

            SetTemplate setTemplateBpCurl = new SetTemplate(MovementType.OTHER, movement3);
            setTemplateBicepCurl.setAmountOfTimes(10);
            setTemplateBicepCurl.setOrderOfSet(3);

            WorkoutTemplate workoutTemplate = new WorkoutTemplate();
            workoutTemplate.setTemplateName("Van alles wat");
            workoutTemplate.setSetTemplates(List.of(setTemplateBench, setTemplateSquat, setTemplateBicepCurl));
            workoutTemplateRepository.save(workoutTemplate);

            WorkoutTemplate workoutTemplate2 = new WorkoutTemplate();
            workoutTemplate2.setTemplateName("Nummer 2");
            workoutTemplate2.setSetTemplates(List.of(setTemplateBpCurl));
            workoutTemplateRepository.save(workoutTemplate2);

        };
    }
}
