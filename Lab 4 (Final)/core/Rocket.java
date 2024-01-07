package core;

import java.util.Objects;
import utility.*;

public class Rocket extends Transport implements Destination {
    private String model;
    private Coordinate coord;
    private RocketParameters rocketParameters;

    public Rocket(String model, Coordinate coord, int fuelCapacity, int payloadCapacity) {
        this.model = model;
        this.coord = coord;
        this.rocketParameters = new RocketParameters(fuelCapacity, payloadCapacity);
    }

    @Override
    public String getName() {
        return model;
    }

    @Override
    public Coordinate getCoord() {
        return coord;
    }

    public RocketParameters getRocketParameters() {
        return rocketParameters;
    }

    public void descend() {
        System.out.printf("Rocket %s descends.\n", this.model);
    }

    public void launch() {
        // Local inner class to represent the LaunchController
        class LaunchController {
            private int launchCountdown = 3;
            final int minFuelCapacity = 20000;

            public void initiateLaunch() {
                // Check if fuel capacity is greater than minimum
                if (rocketParameters.getFuelCapacity() > minFuelCapacity) {
                    System.out.println("Launch sequence initiated. Ignition in:");

                    // Countdown loop
                    while (launchCountdown > 0) {
                        System.out.println(launchCountdown + "...");
                        launchCountdown--;

                        try {
                            // Pause for 1 second (simulating time passing)
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    // Ignition
                    System.out.println("Ignition!");
                } else {
                    System.out.println("The rocket cannot launch. Insufficient fuel capacity.");
                }
            }
        }

        // Create an instance of the local inner class and initiate the launch
        LaunchController launchController = new LaunchController();
        launchController.initiateLaunch();
    }

    public static class RocketParameters {
        private int fuelCapacity;
        private int payloadCapacity;

        public RocketParameters(int fuelCapacity, int payloadCapacity) {
            this.fuelCapacity = fuelCapacity;
            this.payloadCapacity = payloadCapacity;
        }

        public int getFuelCapacity() {
            return fuelCapacity;
        }

        public int getPayloadCapacity() {
            return payloadCapacity;
        }
    }

    @Override
    public void move(Coordinate coord) {
        if (coord == null) {
            throw new RocketException("Coordinate cannot be null.");
        }

        this.coord = coord;
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "model='" + model + '\'' +
                ", abs=" + this.coord.getAbs() +
                ", ord=" + this.coord.getOrd() +
                '}';
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(model);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Rocket rocket = (Rocket) obj;
        return Objects.equals(model, rocket.model);
    }
}
