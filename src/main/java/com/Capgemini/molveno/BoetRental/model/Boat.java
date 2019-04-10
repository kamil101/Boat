package com.Capgemini.molveno.BoetRental.model;

public class Boat {

    private int boatNumber;
    private float minPrijs;
    private float actPrijs;
    private int numberOfseats;

    public int getBoatNumber() {
        return boatNumber;
    }

    public void setBoatNumber(int boatNumber) {
        this.boatNumber = boatNumber;
    }

    public float getMinPrijs() {
        return minPrijs;
    }

    public void setMinPrijs(float minPrijs) {
        this.minPrijs = minPrijs;
    }

    public float getActPrijs() {
        return actPrijs;
    }

    public void setActPrijs(float actPrijs) {
        this.actPrijs = actPrijs;
    }

    public int getNumberOfseats() {
        return numberOfseats;
    }

    public void setNumberOfseats(int numberOfseats) {
        this.numberOfseats = numberOfseats;
    }
}
