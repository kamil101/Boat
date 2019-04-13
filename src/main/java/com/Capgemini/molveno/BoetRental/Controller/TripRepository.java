package com.Capgemini.molveno.BoetRental.Controller;

import com.Capgemini.molveno.BoetRental.Model.Trip;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TripRepository extends CrudRepository<Trip,Long> {


    Iterable<Trip> findAll();
    Trip findById(long id);
}
