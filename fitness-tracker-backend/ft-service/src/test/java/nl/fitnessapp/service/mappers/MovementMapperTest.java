package nl.fitnessapp.service.mappers;

import nl.fitnessapp.model.Movement;
import nl.fitnessapp.model.MovementDto;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class MovementMapperTest {

    @Test
    void testDomainToDto() {
        //Given
        String movementText = "Squat";
        Movement movement = new Movement(movementText);

        //When
        MovementDto movementDto = MovementMapper.INSTANCE.movementToMovementDto(movement);

        //Then
        assertThat(movementDto.getName(), is(equalTo(movementText)));
    }

    @Test
    void testDtoToDomain() {
        //Given
        String movementText = "Squat";
        MovementDto movementDto = new MovementDto().name(movementText);

        //When
        Movement movement = MovementMapper.INSTANCE.movementDtoToMovement(movementDto);

        //Then
        assertThat(movement.getName(), is(equalTo(movementText)));
    }


}
