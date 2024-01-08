package core;

import utility.IZeroGravityDeviceLog;
import utility.SttOfDevice;
import java.util.Objects;

public class ZeroGravityDevice {
    private String name;
    private SttOfDevice state;
    private Coordinate coord;
    private DeviceParameters parameters;

    public ZeroGravityDevice(String name, Coordinate coord, int weightCapacity, int batteryLevel) {
        this.name = name;
        this.state = SttOfDevice.OFF;
        this.coord = coord;
        parameters = new DeviceParameters(weightCapacity, batteryLevel);
    }

    public void turnOn(Person person, Rocket rocket) throws ZeroGravityException {
        if (person == null) {
            throw new ZeroGravityException("Cannot turn on for a null person.");
        } else if (person.getWeight() <= 0 || person.getWeight() > parameters.getWeightCapacity()) {
            parameters.setSafetyLock(false);
            throw new ZeroGravityException(
                    "Person weight is not within the acceptable range. Device safety lock can not be activated.");
            // Устройство работает только на расстоянии 100 от ракеты.
        } else if (Coordinate.distance(rocket.getCoord(), this.coord) != 100.0) {
            throw new ZeroGravityException("Cannot turn on when the device is out of the circle.");
        }
        state = SttOfDevice.ON;
        state.getDescription();
        person.setSpeed(0);
        // Anonymous class : Каждый раз, когда устройство невесомости включается или
        // выключается, я хочу записать это действие в журнал
        IZeroGravityDeviceLog deviceLog = new IZeroGravityDeviceLog() {
            @Override
            public void log(String message) {
                System.out.println("The message is logging in the memory of the device");
                System.out.println("Turned on " + name + ": " + message);
            }
        };
        deviceLog.log("Device's turned on by " + person.getName());
    }

    public void turnOff(Person person, Rocket rocket) throws ZeroGravityException {
        if (person == null) {
            throw new ZeroGravityException("Cannot turn off for a null person.");
        } else if (person.getWeight() <= 0 || person.getWeight() > parameters.getWeightCapacity()) {
            parameters.setSafetyLock(false);
            throw new ZeroGravityException(
                    "Person weight is not within the acceptable range. Device safety lock can not be activated.");
        } else if (Coordinate.distance(rocket.getCoord(), this.coord) != 100.0) {
            throw new ZeroGravityException("Cannot turn off when the device is out of the circle.");
        }

        state = SttOfDevice.OFF;
        state.getDescription();
        person.setSpeed(person.planet.getSpeed());
        // Anonymous class : Каждый раз, когда устройство невесомости включается или
        // выключается, я хочу записать это действие в журнал
        IZeroGravityDeviceLog deviceLog = new IZeroGravityDeviceLog() {
            @Override
            public void log(String message) {
                System.out.println("The message is logging in the memory of the device");
                System.out.println("Turned off " + name + ": " + message);
            }
        };
        deviceLog.log("Device's turned off by " + person.getName());
    }

    public String getName() {
        return name;
    }

    public SttOfDevice getState() {
        return state;
    }

    public DeviceParameters getParameters() {
        return parameters;
    }

    public Coordinate getCoord() {
        return this.coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public static class DeviceParameters {
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
}
