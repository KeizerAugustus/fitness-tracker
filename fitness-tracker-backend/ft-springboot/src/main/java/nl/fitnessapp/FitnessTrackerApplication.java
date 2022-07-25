package nl.fitnessapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "nl.fitnessapp")
@EnableJpaRepositories("nl.fitnessapp.repositories")
public class FitnessTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FitnessTrackerApplication.class, args);
    }
}
