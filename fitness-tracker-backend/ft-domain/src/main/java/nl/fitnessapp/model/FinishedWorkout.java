package nl.fitnessapp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class FinishedWorkout {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate workoutDate;

    private String title;

    @OneToMany(mappedBy = "relevantWorkout")
    private List<Set> finishedReps;
}
