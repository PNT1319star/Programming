import core.*;
import utility.*;

public class Universe {
    public static void main(String[] args) {
        Planet moon = new Planet("Moon", 3679.2, 1.625);
        Planet earth = new Planet("Earth", 1.67, 9.8);
        Coordinate coordRocket = new Coordinate(0.0, 0.0);
        Coordinate coordZnayka = new Coordinate(20.0, 0.0);
        Rocket itmo = new Rocket("RocketITMO", coordRocket, 20000, 20000);
        Engineer klepka = new Engineer("Klepka", 70, moon, itmo);
        Engineer zvezdochkin = new Engineer("Zvezdochkin", 65, earth, itmo);
        Engineer znayka = new Engineer("Znayka", 66, coordZnayka, moon, itmo);
        Person doraemon = new Person("Doraemon", 200, moon, itmo);
        ZeroGravityDevice itmoDevice = new ZeroGravityDevice("itmoDevice", coordRocket, 100, 100);

        System.out.println("Our story starts!");
        itmo.descend();
        itmo.launch();
        doraemon.playingAJoke(znayka);
        znayka.shout();
        znayka.move("Hello", new Coordinate(50, 0));
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
        klepka.soarUp();
        zvezdochkin.soarUp();
        znayka.see();
        znayka.disableZeroGravityDevice(itmoDevice, itmo);
        System.out.println(SttOfGravity.WEIGHTED.getDescription());
        klepka.flyDown();
        zvezdochkin.flyDown();
        klepka.stretchOut();
        zvezdochkin.stretchOut();
        znayka.getPlanet().damage(znayka);
        klepka.getPlanet().damage(klepka);
        zvezdochkin.getPlanet().damage(zvezdochkin);
        doraemon.jump();
        doraemon.waiting(znayka);
        znayka.move("Pyramidal Mountain", new Coordinate(60, 0));
        itmoDevice.setCoord(znayka.getCoord());
        znayka.enableZeroGravityDevice(itmoDevice, itmo);
        zvezdochkin.jumpUp(znayka);
        zvezdochkin.hug(znayka);
        System.out.println("Our story ends!");

    }
}
