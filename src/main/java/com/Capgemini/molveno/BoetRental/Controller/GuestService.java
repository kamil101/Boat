package com.Capgemini.molveno.BoetRental.Controller;


import com.Capgemini.molveno.BoetRental.Model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@Transactional
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public Iterable<Guest> getAllGuest() { return guestRepository.findAll(); }

    private Optional<Guest> getOneGuest(Long id){
        return guestRepository.findById(id);
    }

    public Guest saveGuest(Guest newGuest){
        return guestRepository.save(newGuest);
    }

    public void deleteGuest(@RequestParam Long id){
        guestRepository.deleteById(id);
    }

    public Guest getSingleGuest(Long id){
        Optional<Guest> guest = getOneGuest(id);
        if(guest.isPresent()){
            return guest.get();
        }
        return new Guest();
    }

    public void editGuest(@RequestBody Guest guest) {

        Guest g = guestRepository.findById(guest.getId());

        if (guest.getId() == 0) {
            g.setId(guest.getId());
        }
        if (!guest.getFirstName().equals("")) {
            g.setFirstName(guest.getFirstName());
        }
        if (!guest.getLastName().equals("")) {
            g.setLastName(guest.getLastName());
        }
        if (guest.getPhoneNumber() == 0) {
            g.setPhoneNumber(guest.getPhoneNumber());
        }

        guestRepository.save(g);

    }
}
