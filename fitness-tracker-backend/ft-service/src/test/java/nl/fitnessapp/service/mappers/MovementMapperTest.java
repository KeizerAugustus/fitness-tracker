package nl.fitnessapp.service.mappers;

import nl.fitnessapp.enums.MuscleGroup;
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
        Movement movement = new Movement(movementText, MuscleGroup.LEGS);
        movement.setId(1L);

        //When
        MovementDto movementDto = MovementMapper.INSTANCE.movementToMovementDto(movement);

        //Then
        assertThat(movementDto.getName(), is(equalTo(movementText)));
        assertThat(movementDto.getMuscleGroup(), is(equalTo(MuscleGroup.LEGS.toString())));
        assertThat(movementDto.getId(), is(equalTo(1)));
    }

    @Test
    void testDtoToDomain() {
        //Given
        String movementText = "Squat";
        MovementDto movementDto = new MovementDto().name(movementText).muscleGroup("Legs");
        MovementDto movementDto1 = new MovementDto().name("Deadlift").muscleGroup("Lower back");

        //When
        Movement movement = MovementMapper.INSTANCE.movementDtoToMovement(movementDto);
        Movement movement1 = MovementMapper.INSTANCE.movementDtoToMovement(movementDto1);

        //Then
        assertThat(movement.getName(), is(equalTo(movementText)));
        assertThat(movement.getMuscleGroup(), is(equalTo(MuscleGroup.LEGS)));

        assertThat(movement1.getName(), is(equalTo("Deadlift")));
        assertThat(movement1.getMuscleGroup(), is(equalTo(MuscleGroup.LOWERBACK)));
    }


}
