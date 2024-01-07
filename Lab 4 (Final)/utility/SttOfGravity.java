package utility;

public enum SttOfGravity {
    WEIGHTED("Gravity exists"), WEIGHTLESS("Gravity disappears");

    private final String description;

    SttOfGravity(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}