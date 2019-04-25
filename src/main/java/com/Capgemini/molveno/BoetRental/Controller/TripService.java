package com.Capgemini.molveno.BoetRental.Controller;


import com.Capgemini.molveno.BoetRental.Model.RowingBoat;
import com.Capgemini.molveno.BoetRental.Model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

@Component
@Transactional

public class TripService {

    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private RowingBoatRepository rowingBoatRepository;


    public Iterable<Trip> getAllTrip() { return tripRepository.findAll(); }

    private Optional<Trip> getOneTrip(Long id){
        return tripRepository.findById(id);
    }

    public Trip saveTrip(Trip newTrip){
        return tripRepository.save(newTrip);
    }

    public void deleteTrip(@RequestParam Long id){
        tripRepository.deleteById(id);
    }

    public Trip getSingleTrip(Long id){
        Optional<Trip> trip = getOneTrip(id);
        if(trip.isPresent()){
            return trip.get();
        }
        return new Trip();
    }

    //Start Trip
    public long startTrip(String boatType){
        int  boatId = -1;

        //steps
        //to know the boar number
        if (boatType.equals("RowingBoat")){
            //if Rowingboat
           List<RowingBoat> list =  rowingBoatRepository.findByStatus("free");
            RowingBoat r = list.get(0);
               boatId = ((int) r.getId());

               //change boat status
              r.setStatus("onGoingBoat");

              //creating a trip
              Trip trip = new Trip();
              trip.setBoatNumber(boatId);
              trip.setTripStatus("onGoingTrip");
              trip.setStartTime(LocalDateTime.now());

            tripRepository.save(trip);


        }
        else if(boatType.equals("xxx")){
           /*
            //electric
            //if electric
            List<RowingBoat> list =  rowingBoatRepository.findByStatus("free");
            RowingBoat r = list.get(0);
            boatId = r.getId();

            //change boat status
            r.setStatus("onGoingBoat");

            //creating a trip
            Trip trip = new Trip();
            trip.setBoatNumber(boatId);
            trip.setTripStatus("onGoingTrip");
            trip.setStartTime(LocalDateTime.now());

            //save to DB
            tripRepository.save(trip);
        */
        }

        return boatId;

    }

    public void editTrip(Trip trip) {

        Trip g = tripRepository.findById(trip.getId());

        if (trip.getId() == 0) {
            g.setId(trip.getId());
        }
        if (trip.getStartTime() == null) {
            g.setStartTime(trip.getStartTime());
        }
        if (trip.getEndTime() == null) {
            g.setEndTime(trip.getEndTime());
        }
        if (!trip.getTripStatus().equals("")) {
            g.setTripStatus(trip.getTripStatus());
        }

        tripRepository.save(g);

    }


    //new methos to end a trip
    public Trip endTrip(int boatNmr){

        //to filter the DB by boatNumber and Status
        Trip trip = tripRepository.findByBoatNumberAndTripStatus( (boatNmr),"onGoingTrip");
        RowingBoat boat = rowingBoatRepository.findById(boatNmr);

        //set endTime
        trip.setEndTime(LocalDateTime.now());

        //change the statue of trip
        trip.setTripStatus("Ended");
        //need to make boat free
        boat.setStatus("free");
        rowingBoatRepository.save(boat);
        //>><<



        // to calc duration
        Long min = Duration.between(trip.getStartTime(),trip.getEndTime()).getSeconds()/60;

        //to calc price
        double price = min * boat.getActPrice();
        trip.setTripCost(price);

        //to save changes
        tripRepository.save(trip);


        //System.out.println(Duration.between(trip.getStartTime(),trip.getEndTime()).getSeconds()/60);
        return trip;






    }


}
