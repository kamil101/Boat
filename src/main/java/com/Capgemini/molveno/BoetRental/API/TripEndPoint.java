package com.Capgemini.molveno.BoetRental.API;

import com.Capgemini.molveno.BoetRental.Controller.TripService;
import com.Capgemini.molveno.BoetRental.Model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/trip")

public class TripEndPoint {

    @Autowired
    private TripService tripService;

    @GetMapping("/all-trip")
    public Iterable<Trip> getAllTrip(){ return tripService.getAllTrip(); }

    @PostMapping("/add-single-trip")
    public Trip saveElectricalBoat(@RequestBody @Valid @NotNull Trip newTrip){
        return tripService.saveTrip(newTrip);
    }

    @GetMapping("/get-single-trip")
    public Trip getSingleTrip(@RequestParam Long id){
        return tripService.getSingleTrip(id);
    }
    @DeleteMapping("/delete-single-trip")
    public void deleteTrip(@RequestParam Long id){
        tripService.deleteTrip(id);
    }

    @PostMapping("/edit-trip")
    public Trip editTrip(@RequestBody @Valid @NotNull Trip editTrip){
        return tripService.saveTrip(editTrip);}

    @PostMapping("/startTrip/{boatType}")
    public Long editTrip(@PathVariable String boatType) {
return tripService.startTrip(boatType);

    }

    @PostMapping("/endTrip/{boatNmr}")
    public Long editTrip(@PathVariable int boatNmr) {
        return tripService.endTrip(boatNmr);

    }

}
