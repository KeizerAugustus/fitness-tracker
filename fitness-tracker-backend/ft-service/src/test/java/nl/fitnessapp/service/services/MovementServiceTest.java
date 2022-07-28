package nl.fitnessapp.service.services;

import nl.fitnessapp.model.Movement;
import nl.fitnessapp.model.MovementDto;
import nl.fitnessapp.repositories.MovementRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovementServiceTest {

    @Mock
    MovementRepository movementRepository;

    @InjectMocks
    MovementService cut;

    @Test
    void testGetAllMovements() {
        //Given
        Movement movement1 = new Movement("Squat");
        Movement movement2 = new Movement("Bench Press");

        MovementDto movementDto = new MovementDto().name("Squat");
        MovementDto movementDto2 = new MovementDto().name("Bench Press");


        when(movementRepository.findAll()).thenReturn(List.of(movement1, movement2));

        //When
        List<MovementDto> resultList = cut.getAllMovements();

        //Then
        assertThat(resultList, hasItems(movementDto, movementDto2));
    }


}
