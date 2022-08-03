package nl.fitnessapp.service.services;

import nl.fitnessapp.enums.MovementType;
import nl.fitnessapp.enums.MuscleGroup;
import nl.fitnessapp.model.*;
import nl.fitnessapp.repositories.SetTemplateRepository;
import nl.fitnessapp.repositories.WorkoutTemplateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WorkoutTemplateServiceTest {

    @Mock
    private WorkoutTemplateRepository workoutTemplateRepository;

    @Mock
    private SetTemplateRepository setTemplateRepository;

    @InjectMocks
    private WorkoutTemplateService cut;

    private WorkoutTemplate workoutTemplate;
    private WorkoutTemplateDto workoutTemplateDto;

    @BeforeEach
    void buildObjects(){
        workoutTemplate = new WorkoutTemplate();
        workoutTemplate.setTemplateName("Chest");
        workoutTemplate.setId(1l);
        Movement movement = new Movement("Bench Press", MuscleGroup.CHEST);
        Movement movement1 = new Movement("Squat", MuscleGroup.LEGS);
        Movement movement3 = new Movement("Bicep Curl", MuscleGroup.BICEP);

        SetTemplate setTemplateBench = new SetTemplate(MovementType.TENTENMAX, movement);
        setTemplateBench.setAmountOfTimes(3);
        setTemplateBench.setOrderOfSet(2);
        setTemplateBench.setId(1l);

        SetTemplate setTemplateSquat = new SetTemplate(MovementType.EIGHTTOTWELVE, movement1);
        setTemplateSquat.setAmountOfTimes(3);
        setTemplateSquat.setOrderOfSet(1);
        setTemplateSquat.setId(2l);

        SetTemplate setTemplateBicepCurl = new SetTemplate(MovementType.OTHER, movement3);
        setTemplateBicepCurl.setAmountOfTimes(4);
        setTemplateBicepCurl.setOrderOfSet(3);
        setTemplateBicepCurl.setId(3l);
        workoutTemplate.getSetTemplates().add(setTemplateBench);
        workoutTemplate.getSetTemplates().add(setTemplateSquat);
        workoutTemplate.getSetTemplates().add(setTemplateBicepCurl);

        MovementDto movementDto1 = new MovementDto().name("Bench Press").muscleGroup("Chest");
        MovementDto movementDto2 = new MovementDto().name("Squat").muscleGroup("Legs");
        MovementDto movementDto3 = new MovementDto().name("Bicep Curl").muscleGroup("Bicep");

        SetTemplateDto setTemplateDto1 = new SetTemplateDto().movementType("tentenmax").movement(movementDto1).amountOfTimes(3).orderOfSet(2).id(1);
        SetTemplateDto setTemplateDto2 = new SetTemplateDto().movementType("eighttotwelve").movement(movementDto2).amountOfTimes(3).orderOfSet(1).id(2);
        SetTemplateDto setTemplateDto3 = new SetTemplateDto().movementType("other").movement(movementDto3).amountOfTimes(4).orderOfSet(3).id(3);
        workoutTemplateDto = new WorkoutTemplateDto().templateName("Chest").addSetTemplatesItem(setTemplateDto1).addSetTemplatesItem(setTemplateDto2).addSetTemplatesItem(setTemplateDto3).id(1);
    }

    @Test
    void testGetAll(){
        //Given
        when(workoutTemplateRepository.findAll()).thenReturn(List.of(workoutTemplate));

        //When
        List<WorkoutTemplateDto> resultList = cut.getAll();

        //Then
        assertThat(resultList.size(), is(equalTo(1)));
        assertThat(resultList, hasItems(workoutTemplateDto));
    }

    @Test
    void testGetAllMovementTypes() {
        //When
        List<String> resultList = cut.getMovementTypes();

        //Then
        assertThat(resultList.size(), is(equalTo(MovementType.values().length)));
        assertThat(resultList.containsAll(Arrays.stream(MovementType.values()).map(MovementType::toString).toList()), is(equalTo(true)));
    }

    @Test
    void testAddWorkoutTemplate(){
        //When
        cut.addWorkoutTemplate(workoutTemplateDto);

        //Then
        verify(workoutTemplateRepository, times(1)).save(any());
    }

    @Test
    void testDeleteWorkoutTemplate(){
        //When
        cut.deleteWorkoutTemplate((long)workoutTemplateDto.getId());

        //Then
        verify(workoutTemplateRepository, times(1)).deleteById((long) workoutTemplateDto.getId());
    }

    @Test
    void testChangeWorkoutTemplate() {
        //Given
        workoutTemplateDto.getSetTemplates().add(new SetTemplateDto().movementType("other").orderOfSet(2).amountOfTimes(3).movement(new MovementDto().name("Anders").muscleGroup("Chest").id(4)));
        workoutTemplateDto.getSetTemplates().get(0).setOrderOfSet(4);
        workoutTemplateDto.getSetTemplates().remove(1);

        Movement movementNew = new Movement();
        movementNew.setName("Anders");
        movementNew.setMuscleGroup(MuscleGroup.CHEST);
        movementNew.setId(4l);

        SetTemplate setTemplateNew = new SetTemplate();
        setTemplateNew.setMovement(movementNew);
        setTemplateNew.setMovementType(MovementType.OTHER);
        setTemplateNew.setOrderOfSet(2);
        setTemplateNew.setAmountOfTimes(3);



        when(workoutTemplateRepository.getReferenceById((long)workoutTemplateDto.getId())).thenReturn(workoutTemplate);
        when(setTemplateRepository.getReferenceById(1L)).thenReturn(workoutTemplate.getSetTemplates().get(0));
        //When

        WorkoutTemplate result = cut.changeWorkoutTemplate(workoutTemplateDto);
        //Then
        workoutTemplate.getSetTemplates().add(setTemplateNew);
        workoutTemplate.getSetTemplates().get(0).setOrderOfSet(4);
        workoutTemplate.getSetTemplates().remove(1);

        assertThat(result.equals(workoutTemplate), is(equalTo(true)));
        verify(setTemplateRepository, times(1)).save(any());
        verify(setTemplateRepository, times(1)).getReferenceById(1L);
    }
}
