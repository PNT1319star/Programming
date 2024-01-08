package core;

import java.util.Objects;
import utility.*;

public class Engineer extends Person implements IEngineer {
    private Profession profession;

    public Engineer(String name, double weight, Coordinate coord, Planet planet, Rocket rocket) {
        super(name, weight, coord, planet, rocket);
        this.profession = Profession.ENGINEER;
    }

    public Engineer(String name, double weight, Planet planet, Rocket rocket) {
        super(name, weight, planet, rocket);
        this.profession = Profession.ENGINEER;
    }

    @Override
    public void enableZeroGravityDevice(ZeroGravityDevice zeroGravityDevice, Rocket rocket) {
        this.status = SttOfGravity.WEIGHTLESS;
        try {
            zeroGravityDevice.turnOn(this, rocket);
            System.out.println(zeroGravityDevice.getState().getDescription() + " by " + this.name);
        } catch (ZeroGravityException e) {
            if (zeroGravityDevice.getState() == SttOfDevice.ON) {
                System.out.println("Cannot turn OFF the device. It is currently ON.");
                System.out.println(e.getMessage());
            } else {
                System.out.println("Cannot turn ON the device. It is currently OFF.");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public void disableZeroGravityDevice(ZeroGravityDevice zeroGravityDevice, Rocket rocket) {
        this.status = SttOfGravity.WEIGHTED;
        try {
            zeroGravityDevice.turnOff(this, rocket);
            System.out.println(zeroGravityDevice.getState().getDescription() + " by " + this.name);
        } catch (ZeroGravityException e) {
            if (zeroGravityDevice.getState() == SttOfDevice.ON) {
                System.out.println("Cannot turn OFF the device. It is currently ON.");
                System.out.println(e.getMessage());
            } else {
                System.out.println("Cannot turn ON the device. It is currently OFF.");
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void checkZeroGravityDevice(ZeroGravityDevice zeroGravityDevice) {
        System.out.printf("%s is checking %s.\n", this.getName(), zeroGravityDevice.getName());
        if (zeroGravityDevice.getState() == SttOfDevice.ON) {
            System.out.println("The device is already ON.");
        } else {
            System.out.println("The device is already OFF");
        }
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject))
            return false;
        Engineer other = (Engineer) otherObject;
        return profession == other.profession;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 17 * Objects.hashCode(profession);
    }

    @Override
    public String toString() {
        return super.toString() + "[profession=" + profession + "]";
    }

}
