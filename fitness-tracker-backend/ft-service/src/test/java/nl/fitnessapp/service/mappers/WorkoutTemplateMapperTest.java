package nl.fitnessapp.service.mappers;

import nl.fitnessapp.enums.MovementType;
import nl.fitnessapp.enums.MuscleGroup;
import nl.fitnessapp.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WorkoutTemplateMapperTest {

    private WorkoutTemplate workoutTemplate;
    private WorkoutTemplateDto workoutTemplateDto;

    @BeforeEach
    void buildObjects(){
        workoutTemplate = new WorkoutTemplate();
        workoutTemplate.setTemplateName("Chest");
        Movement movement = new Movement("Bench Press", MuscleGroup.CHEST);
        Movement movement1 = new Movement("Squat", MuscleGroup.LEGS);
        Movement movement3 = new Movement("Bicep Curl", MuscleGroup.BICEP);

        SetTemplate setTemplateBench = new SetTemplate(MovementType.TENTENMAX, movement);
        setTemplateBench.setAmountOfTimes(3);
        setTemplateBench.setOrderOfSet(2);

        SetTemplate setTemplateSquat = new SetTemplate(MovementType.EIGHTTOTWELVE, movement1);
        setTemplateSquat.setAmountOfTimes(3);
        setTemplateSquat.setOrderOfSet(1);

        SetTemplate setTemplateBicepCurl = new SetTemplate(MovementType.OTHER, movement3);
        setTemplateBicepCurl.setAmountOfTimes(4);
        setTemplateBicepCurl.setOrderOfSet(3);
        workoutTemplate.setSetTemplates(List.of(setTemplateBench, setTemplateSquat, setTemplateBicepCurl));

        MovementDto movementDto1 = new MovementDto().name("Bench Press").muscleGroup("Chest");
        MovementDto movementDto2 = new MovementDto().name("Squat").muscleGroup("Legs");
        MovementDto movementDto3 = new MovementDto().name("Bicep Curl").muscleGroup("Bicep");

        SetTemplateDto setTemplateDto1 = new SetTemplateDto().movementType("tentenmax").movement(movementDto1).amountOfTimes(3).orderOfSet(2);
        SetTemplateDto setTemplateDto2 = new SetTemplateDto().movementType("eighttotwelve").movement(movementDto2).amountOfTimes(3).orderOfSet(1);
        SetTemplateDto setTemplateDto3 = new SetTemplateDto().movementType("other").movement(movementDto3).amountOfTimes(4).orderOfSet(3);
        workoutTemplateDto = new WorkoutTemplateDto().templateName("Chest").setTemplates(List.of(setTemplateDto1, setTemplateDto2, setTemplateDto3));

    }

    @Test
    void domainToDto(){
        //When
        WorkoutTemplateDto result = WorkoutTemplateMapper.INSTANCE.workoutTemplateToWorkoutTemplateDto(workoutTemplate);

        //Then
        assertThat(result, is(equalTo(workoutTemplateDto)));

    }
}
