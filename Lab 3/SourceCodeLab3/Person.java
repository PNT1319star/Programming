public class Person implements IPersonRun {
    private String name;
    private Profession profession;
    private Coordinate coord;
    private Planet planet;
    private double speed;
    private double rocket;
    private Status status;
    public Person (String name, Profession profession, Coordinate coord, Planet planet){
        this.name = name;
        this.profession = profession;
        this.coord = coord;
        this.planet = planet;
        this.speed = planet.getSpeed();
        this.status = Status.WEIGHTED; 
    }
    public Person (String name, Profession profession, Planet planet){
        this.name = name;
        this.profession = profession;
        this.planet = planet;
        this.speed = planet.getSpeed();
        this.status = Status.WEIGHTED;
    }
    @Override
    public void run(Coordinate coord) {
        System.out.printf("%s is still running.\n",name);
        this.coord = coord;

    }
    @Override
    public void stop() {
    System.out.printf("%s stops",name);
    }
}
