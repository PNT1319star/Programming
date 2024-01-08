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

    // Calculate the percentage of fall damage on each planet (Рассчитать процент урона от падения на каждой планете.)
    public double damage(Person person) {
        double percentOfDamage = 0.1 * Math.pow(person.getWeight(), 0.75) * Math.pow(gravity, 1.5);

        if (percentOfDamage < 10.0) {
            this.statusOfFalling = SttOfFalling.SAFE_WITH_SLIGHT_FRIGHT;
            System.out.printf("Percent of damage of %s when he is on %s is %f \n", person.getName(),
                    this.name, percentOfDamage);
        } else {
            this.statusOfFalling = SttOfFalling.CRIPPLED;
            System.out.printf("Percent of damage of %s when he is on %s is %f \n", person.getName(),
                    this.name, percentOfDamage);
        }

        return percentOfDamage;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject)
            return true;
        if (otherObject == null || getClass() != otherObject.getClass())
            return false;
        Planet planet = (Planet) otherObject;
        return Double.compare(planet.speed, speed) == 0 &&
                Double.compare(planet.gravity, gravity) == 0 &&
                Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(name)
                + 11 * Double.hashCode(speed)
                + 13 * Double.hashCode(gravity);
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
