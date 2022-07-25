package nl.fitnessapp.model;

public enum MovementType {

    TENTENMAX ("tentenmax"),
    EIGHTTOTWELVE("eighttotwelve");

    MovementType(String type){
        this.type = type;
    }

    private final String type;

    public String getStringValue() {
        return type;
    }
}
