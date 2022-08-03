package nl.fitnessapp.service.mappers;

import nl.fitnessapp.enums.MovementType;
import nl.fitnessapp.model.WorkoutTemplate;
import nl.fitnessapp.model.WorkoutTemplateDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = MovementMapper.class)
public interface WorkoutTemplateMapper {

    WorkoutTemplateMapper INSTANCE = Mappers.getMapper(WorkoutTemplateMapper.class);

    WorkoutTemplateDto workoutTemplateToWorkoutTemplateDto(WorkoutTemplate workoutTemplate);
    WorkoutTemplate workoutTemplateDtoToWorkoutTemplate(WorkoutTemplateDto workoutTemplate);

    default String map(Enum<MovementType> e) {
        return e.toString();
    }

    default MovementType map(String e) {
        return Enum.valueOf(MovementType.class, e.replace(" ", "").toUpperCase());
    }
}
