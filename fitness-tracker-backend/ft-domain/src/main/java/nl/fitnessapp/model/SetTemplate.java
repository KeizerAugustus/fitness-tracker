package nl.fitnessapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.fitnessapp.enums.MovementType;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class SetTemplate {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private MovementType movementType;

    @OneToOne
    private Movement movement;

    @OneToMany(mappedBy = "setTemplate")
    private List<Set> occurenceList;

    public SetTemplate(MovementType movementType, Movement movement){
        this.movementType = movementType;
        this.movement = movement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SetTemplate that)) return false;
        return getMovementType() == that.getMovementType() && Objects.equals(getMovement(), that.getMovement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovementType(), getMovement());
    }
}
