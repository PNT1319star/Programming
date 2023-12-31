package core;
import java.util.Objects;
import utility.*;

public class Person implements IPersonRun, IPerson, IPersonFly,IPersonChase,IPersonStop {
    final int fixedDistance = 100;
    final int lengthOfStep = 10;
    protected String name;
    protected Coordinate coord;
    protected Planet planet;
    protected double speed;
    protected double weight;
    protected double height;
    protected Rocket rocket;
    protected SttOfGravity status;
    public Person (String name, double weight, Coordinate coord, Planet planet, Rocket rocket){
        this.name = name;
        this.weight = weight;
        this.coord = coord;
        this.planet = planet;
        this.speed = planet.getSpeed();
        this.status = SttOfGravity.WEIGHTED;
        this.rocket = rocket;
    }
    public Person (String name,double weight, Planet planet, Rocket rocket){
        this.name = name;
        this.weight = weight;
        this.planet = planet;
        this.speed = planet.getSpeed();
        this.status = SttOfGravity.WEIGHTED;
        this.rocket = rocket;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Coordinate getCoord(){
        return coord;
    }
    public void setCoord(Coordinate coord){
        this.coord = coord;
    }
    public Planet getPlanet(){
        return planet;
    }
    public void setPlanet(Planet planet){
        this.planet = planet;
    }
    public String getRocket(){
        return rocket.getModel();
    }
    public double getSpeed(){
        return this.speed;
    }
    public void setSpeed(double speed){
        this.speed = speed;
    }
    public void setRocket(Rocket rocket){
        this.rocket = rocket;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }

    @CustomLogging("This method represents the jumping action.")
    @Override
    public void jump() {
        System.out.printf("%s is jumping out of the rocket\n", name);
    }

    @CustomLogging("This method represents the noticing action.")
    @Override
    public void notice() {
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

    @CustomLogging("This method represents the running action.")
    @Override
    public void run(Coordinate coord, int steps) {
        System.out.printf("%s runned %d steps.\n",name, steps);
        this.coord = coord;

    }

    @CustomLogging("This method represents the stopping action.")
    @Override
    public void stop() {
        System.out.printf("%s stop.\n",name);
    }

    @CustomLogging("This method represents the chasing action.")
    @Override
    public void chase(Person person) {
        System.out.printf("%s is chasing after %s\n", this.name, person.getName());
    }

    public void runOrStop(Person person, Rocket rocket) {
        int i = 1;
        while (Coordinate.distance(person.getCoord(), rocket.getCoord()) <= fixedDistance) {
            person.getCoord().setAbs(person.getCoord().getAbs() + lengthOfStep);
            person.getCoord().setOrd(0);
            IPersonRun runner = (coord, steps) -> {
                System.out.printf("%s runned %d steps.\n", person.getName(), steps);
                person.setCoord(coord);
            };
    
            runner.run(person.getCoord(), lengthOfStep * i);
            i += 1;
        }
        person.stop();
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
                Objects.equals(rocket, person.rocket) ;
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
                ", rocket=" + this.rocket.getModel()+
                ", status=" + status +
                '}';
    }

}