package com.Capgemini.molveno.BoetRental.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RowingBoat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private int boatNumber;
    private double minPrice;
    private double actPrice;
    private int numberOfseats;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBoatNumber() {
        return boatNumber;
    }

    public void setBoatNumber(int boatNumber) {
        this.boatNumber = boatNumber;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getActPrice() {
        return actPrice;
    }

    public void setActPrice(double actPrice) {
        this.actPrice = actPrice;
    }

    public int getNumberOfseats() {
        return numberOfseats;
    }

    public void setNumberOfseats(int numberOfseats) {
        this.numberOfseats = numberOfseats;
    }
}
