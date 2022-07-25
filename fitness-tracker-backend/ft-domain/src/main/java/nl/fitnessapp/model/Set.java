package nl.fitnessapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Set {

    @Id
    @GeneratedValue
    private Long id;

    private Integer order;

    @ManyToOne
    private SetTemplate setTemplate;

    @ManyToOne
    private WorkoutTemplate workoutTemplate;
}
