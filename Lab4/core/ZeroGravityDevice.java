package core;

import utility.SttOfDevice;
import java.util.Objects;

public class ZeroGravityDevice {
    private String name;
    private SttOfDevice state;
    private DeviceParameters parameters;

    public ZeroGravityDevice(String name, int weightCapacity, int batteryLevel) {
        this.name = name;
        state = SttOfDevice.OFF;
        parameters = new DeviceParameters(weightCapacity, batteryLevel);
    }

    public void turnOn(Person person) throws ZeroGravityException {
        if (person == null) {
            throw new ZeroGravityException("Cannot turn on the device for a null person.");
        }
        if (person.getWeight() <= 0 || person.getWeight() > parameters.getWeightCapacity()) {
            parameters.setSafetyLock(false);
            throw new ZeroGravityException(
                    "Person weight is not within the acceptable range. Device safety lock can not be activated.");
        }

        state = SttOfDevice.ON;
        state.getDescription();
        person.setSpeed(0);
    }

    public void turnOff(Person person) throws ZeroGravityException {
        if (person == null) {
            throw new ZeroGravityException("Cannot turn off the device for a null person.");
        }
        if (person.getWeight() <= 0 || person.getWeight() > parameters.getWeightCapacity()) {
            parameters.setSafetyLock(false);
            throw new ZeroGravityException(
                    "Person weight is not within the acceptable range. Device safety lock can not be activated.");
        }

        state = SttOfDevice.OFF;
        state.getDescription();
        person.setSpeed(person.planet.getSpeed());
    }

    public String getName() {
        return name;
    }

    public SttOfDevice getState() {
        return state;
    }

    @Override
    public String toString() {
        return "ZeroGravityDevice{" +
                "name='" + name + '\'' +
                ", state=" + state +
                '}';
    }

    @Override
    public int hashCode() {
        return 20 * Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ZeroGravityDevice zeroGravityDevice = (ZeroGravityDevice) obj;
        return Objects.equals(name, zeroGravityDevice.name);
    }

    public DeviceParameters getParameters() {
        return parameters;
    }

    public class DeviceParameters {
        private int weightCapacity;
        private boolean hasSafetyLock;
        private int batteryLevel;
        private boolean isFunctional;

        public DeviceParameters(int weightCapacity, int batteryLevel) {
            this.weightCapacity = weightCapacity;
            hasSafetyLock = true;
            this.batteryLevel = batteryLevel;
            isFunctional = true;
        }

        public int getWeightCapacity() {
            return weightCapacity;
        }

        public void setWeightCapacity(int weightCapacity) {
            this.weightCapacity = weightCapacity;
        }

        public boolean hasSafetyLock() {
            return hasSafetyLock;
        }

        public void setSafetyLock(boolean hasSafetyLock) {
            this.hasSafetyLock = hasSafetyLock;
        }

        public int getBatteryLevel() {
            return batteryLevel;
        }

        public void setBatteryLevel(int batteryLevel) {
            this.batteryLevel = batteryLevel;
        }

        public boolean isFunctional() {
            return isFunctional;
        }

        public void setFunctional(boolean isFunctional) {
            this.isFunctional = isFunctional;
        }

        @Override
        public String toString() {
            return "DeviceParameters{" +
                    "weightCapacity=" + weightCapacity +
                    ", hasSafetyLock=" + hasSafetyLock +
                    ", batteryLevel=" + batteryLevel +
                    ", isFunctional=" + isFunctional +
                    '}';
        }
    }
}
