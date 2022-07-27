package nl.fitnessapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class WorkoutTemplate {

    @Id
    @GeneratedValue
    private Long id;

    private String templateName;

    @OneToMany(mappedBy = "workoutTemplate")
    private List<Set> set;

    @OneToMany(mappedBy = "workoutTemplate")
    private List<FinishedWorkout> finishedWorkouts;
}
