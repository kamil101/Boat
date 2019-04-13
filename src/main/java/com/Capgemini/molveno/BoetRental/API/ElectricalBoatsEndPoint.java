package com.Capgemini.molveno.BoetRental.API;

import com.Capgemini.molveno.BoetRental.Controller.ElectricalBoatService;
import com.Capgemini.molveno.BoetRental.Model.ElectricalBoat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/electricalboat")

public class ElectricalBoatsEndPoint {

    @Autowired
    private ElectricalBoatService electricalBoatService;

    @GetMapping("/all-electricalBoat")
    public Iterable<ElectricalBoat> getAllElectricalBoat(){ return electricalBoatService.getAllElectricalBoat(); }

    @PostMapping("/add-single-electricalBoat")
    public ElectricalBoat saveElectricalBoat(@RequestBody @Valid @NotNull ElectricalBoat newElectricalBoat){
        return electricalBoatService.saveElectricalBoat(newElectricalBoat);
    }

    @GetMapping("/get-single-electricalBoat")
    public ElectricalBoat getSingleElectricalBoat(@RequestParam Long id){
        return electricalBoatService.getSingleElectricalBoat(id);
    }
    @DeleteMapping("/delete-single-electricalBoat")
    public void deleteElectricalBoat(@RequestParam Long id){
        electricalBoatService.deleteElectricalBoat(id);
    }

    @PostMapping("/edit-electricalBoat")
    public ElectricalBoat editElectricalBoat(@RequestBody @Valid @NotNull ElectricalBoat editElectricalBoat){
        return electricalBoatService.saveElectricalBoat(editElectricalBoat);}

}
