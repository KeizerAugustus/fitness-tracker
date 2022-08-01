package nl.fitnessapp.enums;

public enum MovementType {

    TENTENMAX ("tentenmax"),
    EIGHTTOTWELVE("eighttotwelve"),
    OTHER("other");

    MovementType(String type){
        this.type = type;
    }

    private final String type;

    public String toString() {
        return type;
    }
}
