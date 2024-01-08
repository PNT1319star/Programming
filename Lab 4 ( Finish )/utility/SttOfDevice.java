package utility;

public enum SttOfDevice {
    ON("Device is on"),
    OFF("Device is off");

    private final String description;

    SttOfDevice(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}