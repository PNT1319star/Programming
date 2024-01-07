package utility;

import java.util.Objects;
import core.*;

abstract public class Transport {
    protected String model;
    protected Coordinate coord;

    abstract public void move(Coordinate coord);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Transport transport = (Transport) obj;
        return model.equals(transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "model='" + model + '\'' +
                ", abs=" + coord.getAbs() +
                ", ord=" + coord.getOrd() +
                '}';
    }
}