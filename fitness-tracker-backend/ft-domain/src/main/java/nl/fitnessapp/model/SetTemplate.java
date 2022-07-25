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
public class SetTemplate {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private MovementType movementType;

    @OneToOne
    private Movement movement;

    public SetTemplate(MovementType movementType, Movement movement){
        this.movementType = movementType;
        this.movement = movement;
    }
}
