package core;
import utility.*;
public class Engineer extends Person implements IEngineer{
    private Profession profession;
    public Engineer(String name, double weight, Coordinate coord, Planet planet, Rocket rocket) {
        super(name ,weight,coord, planet, rocket);
        this.profession = Profession.ENGINEER;  
    }

    public Engineer(String name,double weight, Planet planet, Rocket rocket) {
        super(name,weight, planet, rocket);
        this.profession = Profession.ENGINEER;
    }

    @Override
    public void enableZeroGravityDevice(ZeroGravityDevice zeroGravityDevice) {
        this.status = Status.WEIGHTLESS;
        zeroGravityDevice.turnOn(this);
        System.out.println(zeroGravityDevice.getState().getDescription() + " by " + this.name );
    }

    @Override
    public void disableZeroGravityDevice(ZeroGravityDevice zeroGravityDevice) {
        this.status = Status.WEIGHTED;
        zeroGravityDevice.turnOff(this);
        System.out.println(zeroGravityDevice.getState().getDescription() + " by " + this.name);
    }
}
