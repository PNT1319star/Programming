public class ZeroGravityDevice{
    private double speedOfPerson;
    private double speedOfPlanet;
    private SttDevice state;
    public ZeroGravityDevice(double speedOfPlanet){
        state =SttDevice.OFF;
        this.speedOfPerson=this.speedOfPlanet=speedOfPlanet;
    }
    public void turnOn(){
        state = SttDevice.ON;
        state.getDescription();
        this.speedOfPerson = 0;

    }
    public void turnOff(){
        state = SttDevice.OFF;
        state.getDescription();
        this.speedOfPerson = this.speedOfPlanet;
    }
    public double height(double speedOfPerson, double s)
}