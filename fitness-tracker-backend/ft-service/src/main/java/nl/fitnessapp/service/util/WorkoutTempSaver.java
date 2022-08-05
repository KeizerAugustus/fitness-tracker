package nl.fitnessapp.service.util;


import nl.fitnessapp.model.NewWorkoutDto;

public class WorkoutTempSaver {

    private WorkoutTempSaver(){}

    private static WorkoutTempSaver instance;

    private NewWorkoutDto workoutToSave;

    public static WorkoutTempSaver getInstance(){
        if (instance == null){
            instance = new WorkoutTempSaver();
        }
        return instance;
    }

    public NewWorkoutDto getSavedWorkout(){
        return workoutToSave;
    }

    public void saveWorkout(NewWorkoutDto newWorkoutDto){
        this.workoutToSave = newWorkoutDto;
    }

    public void resetInstance(){
        instance = null;
    }
}
