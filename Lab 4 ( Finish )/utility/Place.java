package utility;

import java.util.Objects;
import core.*;

public abstract class Place {
    protected String name;
    protected Coordinate coord;

    public Place(String name, Coordinate coord) {
        this.name = name;
        this.coord = coord;
    }

    public abstract void positionMarker();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Place place = (Place) obj;
        return name.equals(place.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "model='" + name + '\'' +
                ", abs=" + coord.getAbs() +
                ", ord=" + coord.getOrd() +
                '}';
    }
}