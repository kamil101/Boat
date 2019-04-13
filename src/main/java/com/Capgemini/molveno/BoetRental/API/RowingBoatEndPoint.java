package com.Capgemini.molveno.BoetRental.API;


import com.Capgemini.molveno.BoetRental.Controller.RowingBoatService;
import com.Capgemini.molveno.BoetRental.Model.RowingBoat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/rowingboat")

public class RowingBoatEndPoint {

    @Autowired
    private RowingBoatService rowingBoatService;

    @GetMapping("/all-rowingboat")
    public Iterable<RowingBoat> getAllRowingBoat(){ return rowingBoatService.getAllRowingBoat(); }

    @PostMapping("/add-single-rowingboat")
    public RowingBoat saveRowingBoat(@RequestBody @Valid @NotNull RowingBoat newRowingBoat){
        return rowingBoatService.saveRowingBoat(newRowingBoat);
    }

    @GetMapping("/get-single-rowingboat")
    public RowingBoat getSingleRowingBoat(@RequestParam Long id){
        return rowingBoatService.getSingleRowingBoat(id);
    }
    @DeleteMapping("/delete-single-rowingboat")
    public void deleteRowingBoat(@RequestParam Long id){
        rowingBoatService.deleteRowingBoat(id);
    }

    @PostMapping("/edit-rowingboat")
    public RowingBoat editRowingBoat(@RequestBody @Valid @NotNull RowingBoat editRowingBoat){
        return rowingBoatService.saveRowingBoat(editRowingBoat);}



}