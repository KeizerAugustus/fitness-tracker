package nl.fitnessapp.service.mappers;

import nl.fitnessapp.enums.MuscleGroup;
import nl.fitnessapp.model.Movement;
import nl.fitnessapp.model.MovementDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static java.lang.Enum.valueOf;

@Mapper
public interface MovementMapper {

    MovementMapper INSTANCE = Mappers.getMapper(MovementMapper.class);

    MovementDto movementToMovementDto(Movement movement);
    Movement movementDtoToMovement(MovementDto movement);

    default String map(Enum<MuscleGroup> e) {
        return e.toString();
    }

    default MuscleGroup map(String e){
        return Enum.valueOf(MuscleGroup.class, e.toUpperCase());
    }
}
