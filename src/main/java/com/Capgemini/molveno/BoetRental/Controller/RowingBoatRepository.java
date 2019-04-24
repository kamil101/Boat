package com.Capgemini.molveno.BoetRental.Controller;

import com.Capgemini.molveno.BoetRental.Model.RowingBoat;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RowingBoatRepository extends CrudRepository<RowingBoat,Long>{
    Iterable<RowingBoat> findAll();
    RowingBoat findById(long id);
    public int countBoats();
    public List<RowingBoat> findByStatus(String status);



}
