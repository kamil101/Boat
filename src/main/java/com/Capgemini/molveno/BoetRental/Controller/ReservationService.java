package com.Capgemini.molveno.BoetRental.Controller;

import com.Capgemini.molveno.BoetRental.Model.ElectricalBoat;
import com.Capgemini.molveno.BoetRental.Model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
@Transactional
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Iterable<Reservation> getAllReservation() { return reservationRepository.findAll(); }

    private Optional<Reservation> getOneReservation(Long id){
        return reservationRepository.findById(id);
    }

    public Reservation saveReservation(Reservation newReservation){
        return reservationRepository.save(newReservation);
    }

    public void deleteReservation(@RequestParam Long id){
        reservationRepository.deleteById(id);
    }

    public Reservation getSingleReservation(Long id){
        Optional<Reservation> reservation = getOneReservation(id);
        if(reservation.isPresent()){
            return reservation.get();
        }
        return new Reservation();
    }

    public void editReservation(Reservation reservation) {

        Reservation g = reservationRepository.findById(reservation.getId());

        if (reservation.getId() == 0) {
            g.setId(reservation.getId());
        }
        if (reservation.getNumberOfPerson() == 0) {
            g.setNumberOfPerson(reservation.getNumberOfPerson());
        }
        if (reservation.getPrice() == 0) {
            g.setPrice(reservation.getPrice());
        }

        reservationRepository.save(g);

    }
}
