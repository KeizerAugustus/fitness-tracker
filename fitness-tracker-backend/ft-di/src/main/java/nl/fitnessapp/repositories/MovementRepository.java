package nl.fitnessapp.repositories;

import nl.fitnessapp.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, String> {

}
