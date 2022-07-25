package nl.fitnessapp.tempconfigurations;

import nl.fitnessapp.model.Movement;
import nl.fitnessapp.enums.MovementType;
import nl.fitnessapp.model.SetTemplate;
import nl.fitnessapp.repositories.MovementRepository;
import nl.fitnessapp.repositories.SetTemplateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FitnessConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(MovementRepository movementRepository, SetTemplateRepository setTemplateRepository){
        return args -> {
            Movement movement = new Movement("BenchPress");
            movementRepository.save(movement);

            SetTemplate setTemplate = new SetTemplate(MovementType.TENTENMAX, movement);
            setTemplateRepository.save(setTemplate);
        };
    }
}
