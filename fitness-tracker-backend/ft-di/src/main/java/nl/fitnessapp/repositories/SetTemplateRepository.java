package nl.fitnessapp.repositories;

import nl.fitnessapp.model.SetTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetTemplateRepository extends JpaRepository<SetTemplate, Long> {
}
