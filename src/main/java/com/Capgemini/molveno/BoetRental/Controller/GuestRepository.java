package com.Capgemini.molveno.BoetRental.Controller;

import com.Capgemini.molveno.BoetRental.Model.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuestRepository extends CrudRepository<Guest,Long> {

    Iterable<Guest> findAll();
    Guest findById(long id);
}
