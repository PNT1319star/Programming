import core.*;
import utility.*;

public class Universe {
    public static void main(String[] args) throws ZeroGravityException {
        Planet moon = new Planet("Moon", 3679.2, 1.625);
        Planet earth = new Planet("Earth", 1.67, 9.8);
        Planet mars = new Planet("Mars", 5.66, 3.7);
        Coordinate coordRocket = new Coordinate(0, 0);
        Coordinate coordZnayka = new Coordinate(10, 0);
        Rocket itmo = new Rocket("ITMO", coordRocket);
        Engineer klepka = new Engineer("Klepka", 70, moon, itmo);
        Engineer zvezdochkin = new Engineer("Zvezdochkin", 2, earth, itmo);
        Engineer znayka = new Engineer("Znayka", 66, coordZnayka, moon, itmo);
        ZeroGravityDevice itmoDevice = new ZeroGravityDevice("itmoDevice", 100, 100);
        znayka.jump();
        klepka.jump();
        zvezdochkin.jump();
        klepka.chase(znayka);
        zvezdochkin.chase(znayka);
        znayka.runOrStop(znayka, itmo);
        znayka.enableZeroGravityDevice(itmoDevice);
        System.out.println(Status.WEIGHTLESS.getDescription());
        klepka.soarUp();
        zvezdochkin.soarUp();
        znayka.notice();
        znayka.disableZeroGravityDevice(itmoDevice);
        System.out.println(Status.WEIGHTED.getDescription());
        klepka.flyDown();
        zvezdochkin.flyDown();
        klepka.stretchOut();
        zvezdochkin.stretchOut();
        System.out.printf("Percent of damage of %s when he is on %s is %f  \n", klepka.getName(),
                klepka.getPlanet().getName(), klepka.getPlanet().damage(klepka));
        System.out.println(klepka.getPlanet().getSttOfFalling().getDescription());
        System.out.printf("Percent of damage of %s when he is on %s is %f  \n", zvezdochkin.getName(),
                zvezdochkin.getPlanet().getName(), zvezdochkin.getPlanet().damage(zvezdochkin));
        System.out.println(zvezdochkin.getPlanet().getSttOfFalling().getDescription());
        klepka.setPlanet(mars);
        System.out.printf("Percent of damage of %s when he is on %s is %f  \n", klepka.getName(),
                klepka.getPlanet().getName(), klepka.getPlanet().damage(klepka));
        System.out.println(klepka.getPlanet().getSttOfFalling().getDescription());
        klepka.setPlanet(earth);
        System.out.printf("Percent of damage of %s when he is on %s is %f  \n", klepka.getName(),
                klepka.getPlanet().getName(), klepka.getPlanet().damage(klepka));
        System.out.println(klepka.getPlanet().getSttOfFalling().getDescription());
        klepka.setPlanet(moon);
        System.out.printf("Percent of damage of %s when he is on %s is %f  \n", klepka.getName(),
                klepka.getPlanet().getName(), klepka.getPlanet().damage(klepka));
        System.out.println(klepka.getPlanet().getSttOfFalling().getDescription());
        System.out.println(itmoDevice.getParameters().toString());
        itmoDevice.turnOn(klepka);
        Person nullPerson = null;
        itmoDevice.turnOn(nullPerson);
        Coordinate nullCoordinate = null;
        itmo.move(nullCoordinate);
    }
}
