package com.Capgemini.molveno.BoetRental.Controller;


import com.Capgemini.molveno.BoetRental.Model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@Transactional

public class TripService {

    @Autowired
    private TripRepository tripRepository;

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

    public void editTrip(Trip trip) {

        Trip g = tripRepository.findById(trip.getId());

        if (trip.getId() == 0) {
            g.setId(trip.getId());
        }
        if (trip.getStartDate() == null) {
            g.setStartDate(trip.getStartDate());
        }
        if (trip.getEndDate() == null) {
            g.setEndDate(trip.getEndDate());
        }
        if (!trip.getTripStatus().equals("")) {
            g.setTripStatus(trip.getTripStatus());
        }

        tripRepository.save(g);

    }
}
