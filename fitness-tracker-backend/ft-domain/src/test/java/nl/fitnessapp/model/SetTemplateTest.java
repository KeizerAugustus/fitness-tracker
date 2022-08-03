package nl.fitnessapp.model;

import nl.fitnessapp.enums.MovementType;
import nl.fitnessapp.enums.MuscleGroup;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class SetTemplateTest {

    @Test
    void copyAttributes() {
        //Given
        SetTemplate setTemplate1 = new SetTemplate();
        setTemplate1.setId(1L);
        setTemplate1.setOrderOfSet(1);
        setTemplate1.setAmountOfTimes(2);
        setTemplate1.setMovementType(MovementType.TENTENMAX);
        setTemplate1.setMovement(new Movement("Bench press", MuscleGroup.CHEST));

        SetTemplate setTemplate2 = new SetTemplate();
        setTemplate2.setId(1L);
        setTemplate2.setOrderOfSet(5);
        setTemplate2.setAmountOfTimes(5);
        setTemplate2.setMovementType(MovementType.OTHER);
        setTemplate2.setMovement(new Movement("Squat", MuscleGroup.LEGS));
        //When
        setTemplate2.copyAttributes(setTemplate1);
        //Then
        assertThat(setTemplate2.equals(setTemplate1), is(equalTo(true)));
    }

    @Test
    void testEquals() {
        //Given
        SetTemplate setTemplate1 = new SetTemplate();
        setTemplate1.setId(1L);
        setTemplate1.setOrderOfSet(1);
        setTemplate1.setAmountOfTimes(2);
        setTemplate1.setMovementType(MovementType.TENTENMAX);
        setTemplate1.setMovement(new Movement("Bench press", MuscleGroup.CHEST));

        SetTemplate setTemplate2 = new SetTemplate();
        setTemplate2.setId(1L);
        setTemplate2.setOrderOfSet(1);
        setTemplate2.setAmountOfTimes(2);
        setTemplate2.setMovementType(MovementType.TENTENMAX);
        setTemplate2.setMovement(new Movement("Bench press", MuscleGroup.CHEST));

        SetTemplate setTemplate3 = new SetTemplate();
        setTemplate3.setId(1L);
        setTemplate3.setOrderOfSet(1);
        setTemplate3.setAmountOfTimes(2);
        setTemplate3.setMovementType(MovementType.TENTENMAX);
        setTemplate3.setMovement(new Movement("Squat", MuscleGroup.LEGS));

        //Then
        assertThat(setTemplate1.equals(setTemplate2), is(equalTo(true)));
        assertThat(setTemplate2.equals(setTemplate3), is(equalTo(false)));
        assertThat(setTemplate1.equals(setTemplate3), is(equalTo(false)));
    }

    @Test
    void testHashCode() {
        //Given
        SetTemplate setTemplate1 = new SetTemplate();
        setTemplate1.setId(1L);
        setTemplate1.setOrderOfSet(1);
        setTemplate1.setAmountOfTimes(2);
        setTemplate1.setMovementType(MovementType.TENTENMAX);
        setTemplate1.setMovement(new Movement("Bench press", MuscleGroup.CHEST));

        SetTemplate setTemplate2 = new SetTemplate();
        setTemplate2.setId(1L);
        setTemplate2.setOrderOfSet(1);
        setTemplate2.setAmountOfTimes(2);
        setTemplate2.setMovementType(MovementType.TENTENMAX);
        setTemplate2.setMovement(new Movement("Bench press", MuscleGroup.CHEST));

        SetTemplate setTemplate3 = new SetTemplate();
        setTemplate3.setId(1L);
        setTemplate3.setOrderOfSet(1);
        setTemplate3.setAmountOfTimes(2);
        setTemplate3.setMovementType(MovementType.TENTENMAX);
        setTemplate3.setMovement(new Movement("Squat", MuscleGroup.LEGS));
        //When
        int hashcode1 = setTemplate1.hashCode();
        int hashcode2 = setTemplate2.hashCode();
        int hashcode3 = setTemplate3.hashCode();
        //Then
        assertThat(hashcode1, is(equalTo(hashcode2)));
        assertThat(hashcode1, is(not(equalTo(hashcode3))));
        assertThat(hashcode2, is(not(equalTo(hashcode3))));
    }
}
