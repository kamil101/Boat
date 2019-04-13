package com.Capgemini.molveno.BoetRental.Controller;

import com.Capgemini.molveno.BoetRental.Model.ElectricalBoat;
import com.Capgemini.molveno.BoetRental.Model.RowingBoat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Component
@Transactional

public class ElectricalBoatService {

    @Autowired
    private ElectricalBoatRepository electricalBoatRepository;

    public Iterable<ElectricalBoat> getAllElectricalBoat() { return electricalBoatRepository.findAll(); }

    private Optional<ElectricalBoat> getOneElectricalBoat(Long id){
        return electricalBoatRepository.findById(id);
    }

    public ElectricalBoat saveElectricalBoat(ElectricalBoat newElectricalBoat){
        return electricalBoatRepository.save(newElectricalBoat);
    }

    public void deleteElectricalBoat(@RequestParam Long id){
        electricalBoatRepository.deleteById(id);
    }

    public ElectricalBoat getSingleElectricalBoat(Long id){
        Optional<ElectricalBoat> electricalBoat = getOneElectricalBoat(id);
        if(electricalBoat.isPresent()){
            return electricalBoat.get();
        }
        return new ElectricalBoat();
    }

    public void editElectricalBoat(ElectricalBoat electricalBoat) {

        ElectricalBoat g = electricalBoatRepository.findById(electricalBoat.getId());

        if (electricalBoat.getBoatNumber() == 0) {
            g.setBoatNumber(electricalBoat.getBoatNumber());
        }
        if (electricalBoat.getNumberOfseats()==0) {
            g.setNumberOfseats(electricalBoat.getNumberOfseats());
        }
        if (electricalBoat.getActPrice() == 0) {
            g.setActPrice(electricalBoat.getActPrice());
        }
        if (electricalBoat.getMinPrice()==0) {
            g.setMinPrice(electricalBoat.getMinPrice());
        }

        electricalBoatRepository.save(g);

    }



}

