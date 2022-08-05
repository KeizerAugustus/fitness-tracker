package nl.fitnessapp.service.mappers;

import nl.fitnessapp.model.FinishedWorkout;
import nl.fitnessapp.model.NewWorkoutDto;

public class ActiveWorkoutToFinishedWorkoutMapper {

    public static FinishedWorkout map(NewWorkoutDto newWorkoutDto){
        return new FinishedWorkout();
    }
}
