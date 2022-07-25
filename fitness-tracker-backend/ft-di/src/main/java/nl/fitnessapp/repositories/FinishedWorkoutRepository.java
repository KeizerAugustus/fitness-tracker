package nl.fitnessapp.repositories;

import nl.fitnessapp.model.FinishedWorkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinishedWorkoutRepository extends JpaRepository<FinishedWorkout, Long> {
}
