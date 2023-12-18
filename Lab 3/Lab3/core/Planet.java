package core;
import java.util.Objects;

import utility.*; 
public class Planet {
    private String name;
    private double speed;
    private double gravity;
    private SttOfFalling statusOfFalling;

    public Planet(String name, double speed, double gravity) {
        this.name = name;
        this.speed = speed;
        this.gravity = gravity;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getGravity() {
        return gravity;
    }

    public SttOfFalling getSttOfFalling() {
        return statusOfFalling;
    }
 

    public double damage(Person person) {
        double percentOfDamage = 0.1 * Math.pow(person.getWeight(), 0.75) * Math.pow(gravity, 1.5);

        if (percentOfDamage < 10.0) {
            this.statusOfFalling = SttOfFalling.SAFE_WITH_SLIGHT_FRIGHT;
        } else {
            this.statusOfFalling = SttOfFalling.CRIPPLED;
        }

        return percentOfDamage;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Planet planet = (Planet) otherObject;
        return Double.compare(planet.speed, speed) == 0 &&
                Double.compare(planet.gravity, gravity) == 0 &&
                Objects.equals(name, planet.name) &&
                statusOfFalling == planet.statusOfFalling;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, speed, gravity, statusOfFalling);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", gravity=" + gravity +
                ", statusOfFalling=" + statusOfFalling +
                '}';
    }
}
