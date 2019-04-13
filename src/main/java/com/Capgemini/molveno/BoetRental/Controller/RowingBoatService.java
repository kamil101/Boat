package com.Capgemini.molveno.BoetRental.Controller;

import com.Capgemini.molveno.BoetRental.Model.RowingBoat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@Transactional
public class RowingBoatService {


    @Autowired
    private RowingBoatRepository rowingBoatRepository;

    public Iterable<RowingBoat> getAllRowingBoat() { return rowingBoatRepository.findAll(); }

    private Optional<RowingBoat> getOneRowingBoat(Long id){
        return rowingBoatRepository.findById(id);
    }

    public RowingBoat saveRowingBoat(RowingBoat newRowingBoat){
        return rowingBoatRepository.save(newRowingBoat);
    }

    public void deleteRowingBoat(@RequestParam Long id){
        rowingBoatRepository.deleteById(id);
    }

    public RowingBoat getSingleRowingBoat(Long id){
        Optional<RowingBoat> rowingBoat = getOneRowingBoat(id);
        if(rowingBoat.isPresent()){
            return rowingBoat.get();
        }
        return new RowingBoat();
    }
////////////

    public void editRowingBoat(RowingBoat rowingBoat) {

        RowingBoat g = rowingBoatRepository.findById(rowingBoat.getId());

        if (rowingBoat.getBoatNumber() == 0) {
            g.setBoatNumber(rowingBoat.getBoatNumber());
        }
        if (rowingBoat.getNumberOfseats()==0) {
            g.setNumberOfseats(rowingBoat.getNumberOfseats());
        }
        if (rowingBoat.getActPrice() == 0) {
            g.setActPrice(rowingBoat.getActPrice());
        }
        if (rowingBoat.getMinPrice()==0) {
        }

        rowingBoatRepository.save(g);

    }

}
