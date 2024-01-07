package utility;

import java.util.Objects;

import core.*;

public class Landforms implements Destination {
    protected String name;
    protected Coordinate coord;

    public Landforms(String name, Coordinate coord) {
        this.name = name;
        this.coord = coord;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        Landforms place = (Landforms) object;
        return Objects.equals(name, place.name) && Objects.equals(coord, place.coord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coord);
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", coord=" + coord +
                '}';
    }
}
