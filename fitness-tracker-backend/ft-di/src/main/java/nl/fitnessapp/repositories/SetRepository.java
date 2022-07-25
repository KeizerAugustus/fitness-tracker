package nl.fitnessapp.repositories;

import nl.fitnessapp.model.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetRepository extends JpaRepository<Set, Long> {
}
