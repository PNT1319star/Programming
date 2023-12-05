public class Universe {
    public static void main(String[] args) {
        Coordinate coordRocket = new Coordinate(20, 30);
        Coordinate coordTuan = new Coordinate(50, 60);
        Rocket itmo1Rocket = new Rocket("ITMO1", coordRocket);
        Planet Earth = new Planet("Earth", 9.8, SttOfFalling.CRIPPLED);
        double x = itmo1Rocket.getAbs(); 
        System.out.println(x);
        System.out.println(itmo1Rocket);
        //System.out.println(Earth.statusOfFalling.getDescription());
        Person Tuan = new Person("Tuan", Profession.ENGINEER, coordTuan, Earth);
        Coordinate newcoordTuan = new Coordinate(70, 90);
        Tuan.run(newcoordTuan);
        Tuan.stop();
    }
}
