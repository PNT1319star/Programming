package core;

import java.util.Objects;
import utility.*;

public class Person implements IPersonJump, IPersonFly, IPersonChase, IPersonStop, IPersonSee,
        IPersonStretchOut, IPersonJoke, IPersonWait, IPersonMove, IPersonShout {
    final double fixedDistance = 100.0;
    final double lengthOfStep = 10.0;
    protected String name;
    protected Coordinate coord;
    protected Planet planet;
    protected double speed;
    protected double weight;
    protected Rocket rocket;
    protected SttOfGravity status;

    public Person(String name, double weight, Coordinate coord, Planet planet, Rocket rocket) {
        this.name = name;
        this.weight = weight;
        this.coord = coord;
        this.planet = planet;
        this.speed = planet.getSpeed();
        this.status = SttOfGravity.WEIGHTED;
        this.rocket = rocket;
    }

    public Person(String name, double weight, Planet planet, Rocket rocket) {
        this.name = name;
        this.weight = weight;
        this.planet = planet;
        this.speed = planet.getSpeed();
        this.status = SttOfGravity.WEIGHTED;
        this.rocket = rocket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public String getRocket() {
        return rocket.getName();
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @CustomLogging("This method represents the jumping action.")
    @Override
    public void jump() {
        System.out.printf("%s is jumping out of the rocket\n", name);
    }

    @CustomLogging("This method represents the noticing action.")
    @Override
    public void see() {
        System.out.printf("%s is seeing the fantastic jump\n", name);
    }

    @CustomLogging("This method represents the stretching out action.")
    @Override
    public void stretchOut() {
        System.out.printf("%s is stretching out on the surface\n", name);
    }

    @CustomLogging("This method represents the soaring up action.")
    @Override
    public void soarUp() {
        System.out.printf("%s is soaring up\n", name);
    }

    @CustomLogging("This method represents the flying down action.")
    @Override
    public void flyDown() {
        System.out.printf("%s is flying down\n", name);
    }

    @CustomLogging("This method represents the stopping action.")
    @Override
    public void stop() {
        System.out.printf("%s stops.\n", name);
    }

    @CustomLogging("This method represents the chasing action.")
    @Override
    public void chase(Person person) {
        System.out.printf("%s is chasing after %s\n", this.name, person.getName());
    }

    @CustomLogging("This method represents the playing-a-joke action.")
    @Override
    public void playingAJoke(Person person) {
        System.out.printf("%s is playing a joke on %s\n", this.name, person.getName());
    }

    @CustomLogging("This method represents the waiting action.")
    @Override
    public void waiting() {
        System.out.printf("%s is waiting\n", this.name);
    }

    @CustomLogging("This method represents the moving action.")
    @Override
    public <T extends Destination> void moving(T destination) {
        System.out.printf("%s moves to %s.\n", this.name, destination.getName());
        this.setCoord(destination.getCoord());
    }

    @CustomLogging("This method represents the shouting action.")
    @Override
    public void shout() {
        System.out.printf("%s angrily shouts.\n", this.name);
    }

    public void runOrStop(Rocket rocket) {
        double i = 1.0;
        while (Coordinate.distance(this.getCoord(), rocket.getCoord()) < fixedDistance) {
            this.getCoord().setAbs(this.getCoord().getAbs() + lengthOfStep);
            this.getCoord().setOrd(0);
            IPersonRun runner = (coord, steps) -> {
                System.out.printf("%s runned %f steps.\n", this.getName(), steps);
                this.setCoord(coord);
            };

            runner.run(this.getCoord(), lengthOfStep * i);
            i += 1;
        }
        this.stop();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return name.equals(person.name) &&
                planet.equals(person.planet) &&
                Double.compare(person.speed, speed) == 0 &&
                Objects.equals(rocket, person.rocket);
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(name)
                + 11 * Objects.hashCode(planet)
                + 13 * Double.hashCode(speed)
                + 15 * Objects.hashCode(rocket);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", abs=" + this.coord.getAbs() +
                ", ord=" + this.coord.getOrd() +
                ", planet=" + this.planet.getName() +
                ", speed=" + speed +
                ", rocket=" + this.rocket.getName() +
                ", status=" + status +
                '}';
    }
}