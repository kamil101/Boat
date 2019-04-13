package com.Capgemini.molveno.BoetRental.API;


import com.Capgemini.molveno.BoetRental.Controller.GuestService;
import com.Capgemini.molveno.BoetRental.Model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/guest")

public class GuestEndPoint {
    @Autowired
    private GuestService guestService;

    @GetMapping("/all-guest")
    public Iterable<Guest> getAllGuest(){ return guestService.getAllGuest(); }

    @PostMapping("/add-single-guest")
    public Guest saveGuest(@RequestBody @Valid @NotNull Guest newGuest){

        return guestService.saveGuest(newGuest);
    }

    @GetMapping("/get-single-guest")
    public Guest getSingleGuest(@RequestParam Long id){
        return guestService.getSingleGuest(id);
    }
    @DeleteMapping("/delete-single-guest")
    public void deleteGuest(@RequestParam Long id){
        guestService.deleteGuest(id);
    }

    @PostMapping("/edit-guest")
    public Guest editGuest(@RequestBody @Valid @NotNull Guest editGuest){
        return guestService.saveGuest(editGuest);}


}


