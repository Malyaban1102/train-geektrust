package com.geektrust.backend.model;

public class Bogie {
    private String destination;
    private int distance;

    public Bogie(String destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }

    public String getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }
}
