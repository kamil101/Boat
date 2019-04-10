package com.Capgemini.molveno.BoetRental.model;

public class Trip {
    private int nmrOfPersons;
    private Boat boat;

    public int getNmrOfPersons() {
        return nmrOfPersons;
    }

    public void setNmrOfPersons(int nmrOfPersons) {
        this.nmrOfPersons = nmrOfPersons;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }
}
