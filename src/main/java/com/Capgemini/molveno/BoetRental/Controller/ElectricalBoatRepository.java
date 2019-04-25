package com.Capgemini.molveno.BoetRental.Controller;

import com.Capgemini.molveno.BoetRental.Model.ElectricalBoat;
import com.Capgemini.molveno.BoetRental.Model.RowingBoat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElectricalBoatRepository extends CrudRepository<ElectricalBoat,Long> {

    Iterable<ElectricalBoat> findAll();
    ElectricalBoat findById(long id);


}
