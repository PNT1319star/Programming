public class ZeroGravityDevice{
    private double speedOfPerson;
    private double speedOfPlanet;
    private SttDevice state;
    public ZeroGravityDevice(double speedOfPlanet){
        state=SttDevice.OFF;
        this.speedOfPerson=this.speedOfPlanet=speedOfPlanet;
    }
    public void turnOn(){
        state=SttDevice.ON;
        this.speedOfPerson=0;
        System.out.println("Device is turned on");
    }
    public void turnOff(){
        state=SttDevice.OFF;
        this.speedOfPerson=this.speedOfPlanet;
        System.out.println("Device is turned off");
    }
}