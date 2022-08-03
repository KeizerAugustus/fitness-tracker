package nl.fitnessapp.service.services;

import nl.fitnessapp.enums.MuscleGroup;
import nl.fitnessapp.model.Movement;
import nl.fitnessapp.model.MovementDto;
import nl.fitnessapp.repositories.MovementRepository;
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
class MovementServiceTest {

    @Mock
    MovementRepository movementRepository;

    @InjectMocks
    MovementService cut;

    @Test
    void testGetAllMovements() {
        //Given
        Movement movement1 = new Movement("Squat", MuscleGroup.LEGS);
        Movement movement2 = new Movement("Bench Press", MuscleGroup.CHEST);

        MovementDto movementDto = new MovementDto().name("Squat").muscleGroup("Legs");
        MovementDto movementDto2 = new MovementDto().name("Bench Press").muscleGroup("Chest");


        when(movementRepository.findAll()).thenReturn(List.of(movement1, movement2));

        //When
        List<MovementDto> resultList = cut.getAllMovements();

        //Then
        assertThat(resultList, hasItems(movementDto, movementDto2));
    }

    @Test
    void testGetAllMuscleGroups() {
        //When
        List<String> resultList = cut.getAllMusclegroups();

        //Then
        assertThat(resultList.size(), is(equalTo(MuscleGroup.values().length)));
        assertThat(resultList.containsAll(Arrays.stream(MuscleGroup.values()).map(MuscleGroup::toString).toList()), is(equalTo(true)));
    }

    @Test
    void testAddMovementNotExists() {
        //Given
        MovementDto movementToAdd = new MovementDto().name("Bench Press").muscleGroup("Chest");
        Movement movementFound = new Movement("Squat", MuscleGroup.LEGS);

        when(movementRepository.findAll()).thenReturn(List.of(movementFound));

        //When
        cut.addMovement(movementToAdd);

        //Then
        verify(movementRepository, times(1)).save(any());
    }

    @Test
    void testAddMovementExists() {
        //Given
        MovementDto movementToAdd = new MovementDto().name("Bench Press").muscleGroup("Chest");
        Movement movementFound = new Movement("Bench Press", MuscleGroup.CHEST);

        when(movementRepository.findAll()).thenReturn(List.of(movementFound));

        //When
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> cut.addMovement(movementToAdd));

        //Then
        assertThat(exception.getMessage(), is(equalTo("Movement already exists..")));
        verify(movementRepository, times(0)).save(any());
    }

    @Test
    void testDelete(){
        //When
        cut.deleteMovement(1);

        //Then
        verify(movementRepository, times(1)).deleteById(1L);
    }

    @Test
    void testChangeMovementExists(){
        //Given
        Movement movementToChange = new Movement("Chest prss", MuscleGroup.CHEST);
        movementToChange.setId(1l);

        MovementDto movementWithChanges = new MovementDto().id(1).name("Chest Press").muscleGroup("Chest");
        when(movementRepository.findById(1l)).thenReturn(Optional.of(movementToChange));

        //When
        Movement result = cut.changeMovement(movementWithChanges);

        //Then
        assertThat(result.getName(), is(equalTo(movementWithChanges.getName())));
        assertThat(result.getMuscleGroup(), is(equalTo(MuscleGroup.CHEST)));

    }

    @Test
    void testChangeMovementNotExists(){
        //Given
        MovementDto movementWithChanges = new MovementDto().id(1).name("Chest Press").muscleGroup("Chest");
        when(movementRepository.findById(1l)).thenReturn(Optional.empty());

        //When
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> cut.changeMovement(movementWithChanges));

        //Then
        assertThat(exception.getMessage(), is(equalTo("Movement should be found..")));

    }


}
