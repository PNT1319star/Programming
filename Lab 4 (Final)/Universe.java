import core.*;
import utility.*;

public class Universe {
    public static void main(String[] args) {
        Planet moon = new Planet("Moon", 3679.2, 1.625);
        Planet earth = new Planet("Earth", 1.67, 9.8);
        Coordinate coordRocket = new Coordinate(0.0, 0.0);
        Coordinate coordZnayka = new Coordinate(10.0, 0.0);
        Rocket itmo = new Rocket("RocketITMO", coordRocket, 20000, 20000);
        Engineer klepka = new Engineer("Klepka", 70, moon, itmo);
        Engineer zvezdochkin = new Engineer("Zvezdochkin", 65, earth, itmo);
        Engineer znayka = new Engineer("Znayka", 66, coordZnayka, moon, itmo);
        Person doraemon = new Person("Doraemon", 200, moon, itmo);
        ZeroGravityDevice itmoDevice = new ZeroGravityDevice("itmoDevice", coordZnayka, 100, 100);
        Landforms mountain = new Landforms("Hi", new Coordinate(50.0, 0.0));

        System.out.println("Our story starts!");
        itmo.descend();
        itmo.launch();
        doraemon.playingAJoke(znayka);
        znayka.shout();
        znayka.moving(mountain);
        znayka.checkZeroGravityDevice(itmoDevice);
        znayka.enableZeroGravityDevice(itmoDevice, itmo);
        znayka.jump();
        klepka.jump();
        zvezdochkin.jump();
        klepka.chase(znayka);
        zvezdochkin.chase(znayka);
        znayka.runOrStop(itmo);
        itmoDevice.setCoord(znayka.getCoord());
        znayka.enableZeroGravityDevice(itmoDevice, itmo);
        System.out.println(SttOfGravity.WEIGHTLESS.getDescription());
        klepka.soarUp();
        zvezdochkin.soarUp();
        znayka.see();
        znayka.disableZeroGravityDevice(itmoDevice, itmo);
        System.out.println(SttOfGravity.WEIGHTED.getDescription());
        klepka.flyDown();
        zvezdochkin.flyDown();
        klepka.stretchOut();
        zvezdochkin.stretchOut();
        System.out.printf("Percent of damage of %s when he is on %s is %f \n", klepka.getName(),
                klepka.getPlanet().getName(), klepka.getPlanet().damage(klepka));
        System.out.println(klepka.getPlanet().getSttOfFalling().getDescription());
        System.out.printf("Percent of damage of %s when he is on %s is %f \n", zvezdochkin.getName(),zvezdochkin.getPlanet().getName(),zvezdochkin.getPlanet().damage(zvezdochkin));
        System.out.println(zvezdochkin.getPlanet().getSttOfFalling().getDescription());
            klepka.setPlanet(earth);
        System.out.printf("Percent of damage of %s when he is on %s is %f \n", klepka.getName(), klepka.getPlanet().getName(), klepka.getPlanet().damage(klepka));
        System.out.println(klepka.getPlanet().getSttOfFalling().getDescription());
        System.out.println("Our story ends!");
        doraemon.jump();
        doraemon.waiting();
    }
}
