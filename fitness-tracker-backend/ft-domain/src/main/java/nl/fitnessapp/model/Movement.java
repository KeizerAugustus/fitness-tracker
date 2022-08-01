package nl.fitnessapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.fitnessapp.enums.MuscleGroup;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Movement {

    public Movement(String name, MuscleGroup muscleGroup){
        this.name = name;
        this.muscleGroup = muscleGroup;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MuscleGroup muscleGroup;

    @OneToMany(mappedBy = "movement")
    private List<Set> allRepetitions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movement movement)) return false;
        return Objects.equals(getName(), movement.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
