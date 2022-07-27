package nl.fitnessapp.repositories;

import nl.fitnessapp.model.Repetition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepetitionRepository extends JpaRepository<Repetition, Long> {
}
