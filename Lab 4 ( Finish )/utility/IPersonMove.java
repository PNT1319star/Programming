package utility;

import core.*;

public interface IPersonMove {
    void move(String name, Coordinate coord);

    void chase(Person person);

    void stop();

    void runOrStop(Rocket rocket);

}
