package com.Capgemini.molveno.BoetRental.Controller;

import com.Capgemini.molveno.BoetRental.Model.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface ReservationRepository extends CrudRepository<Reservation,Long> {
    Iterable<Reservation> findAll();
    Reservation findById(long id);
}
