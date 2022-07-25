package nl.fitnessapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Repitition {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Movement movement;

    @ManyToOne
    private FinishedWorkout relevantWorkout;

    private Integer reps;

    private Double weight;

    private LocalDateTime timestamp;
}
