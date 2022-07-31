package nl.fitnessapp.enums;

public enum MuscleGroup {

    CHEST("Chest"),
    SHOULDER("Shoulder"),
    LEGS("Legs"),
    BICEP("Bicep"),
    TRICEP("Tricep"),
    UPPERBACK("Upper back"),
    LOWERBACK("Lower back");

    MuscleGroup(String string) {
        this.string = string;
    }
    private final String string;

    @Override
    public String toString() {
        return string;
    }
}

