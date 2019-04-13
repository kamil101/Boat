package com.Capgemini.molveno.BoetRental.API;


import com.Capgemini.molveno.BoetRental.Controller.ElectricalBoatService;
import com.Capgemini.molveno.BoetRental.Controller.ReservationService;
import com.Capgemini.molveno.BoetRental.Model.ElectricalBoat;
import com.Capgemini.molveno.BoetRental.Model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/reservation")
public class ReservationEndPoint {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all-reservation")
    public Iterable<Reservation> getAllReservation(){ return reservationService.getAllReservation(); }

    @PostMapping("/add-single-reservation")
    public Reservation saveReservation(@RequestBody @Valid @NotNull Reservation newReservation){
        return reservationService.saveReservation(newReservation);
    }

    @GetMapping("/get-single-reservation")
    public Reservation getSingleReservation(@RequestParam Long id){
        return reservationService.getSingleReservation(id);
    }
    @DeleteMapping("/delete-single-reservation")
    public void deleteReservation(@RequestParam Long id){
        reservationService.deleteReservation(id);
    }

    @PostMapping("/edit-reservation")
    public Reservation editReservation(@RequestBody @Valid @NotNull Reservation editReservation){
        return reservationService.saveReservation(editReservation);}


}
