package nl.fitnessapp.service.mappers;

import nl.fitnessapp.model.Movement;
import nl.fitnessapp.model.MovementDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovementMapper {

    MovementMapper INSTANCE = Mappers.getMapper(MovementMapper.class);

    MovementDto movementToMovementDto(Movement movement);
    Movement movementDtoToMovement(MovementDto movement);
}
