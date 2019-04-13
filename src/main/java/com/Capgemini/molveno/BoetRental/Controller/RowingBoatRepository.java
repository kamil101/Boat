package com.Capgemini.molveno.BoetRental.Controller;

import com.Capgemini.molveno.BoetRental.Model.RowingBoat;

import org.springframework.data.repository.CrudRepository;

public interface RowingBoatRepository extends CrudRepository<RowingBoat,Long>{
    Iterable<RowingBoat> findAll();
    RowingBoat findById(long id);
}
