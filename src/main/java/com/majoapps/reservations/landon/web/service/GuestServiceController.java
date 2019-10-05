package com.majoapps.reservations.landon.web.service;

import com.majoapps.reservations.landon.business.service.GuestService;
import com.majoapps.reservations.landon.data.entity.Guest;
import com.majoapps.reservations.landon.data.respository.GuestRepository;
import com.majoapps.reservations.landon.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class GuestServiceController {

    @Autowired
    private GuestService guestService;

    @Autowired
    private GuestRepository guestRepository;

    @RequestMapping(value="/guest/", method= RequestMethod.GET)
    public Iterable<Guest> getGuests() {
        return this.guestRepository.findAll();
    }

    @RequestMapping(value="/guest/{guestId}", method= RequestMethod.GET)
    public List<Guest> getGuestById(@PathVariable(value="guestId",required=false) Long guestNumber) {
        return this.guestService.getGuest(guestNumber);
    }

    @RequestMapping(value = "/guest", method= RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Guest save(@RequestBody Guest guest) {
        return guestRepository.save(guest);
    }

    @RequestMapping(value = "/guest/{guestId}", method= RequestMethod.PUT)
    public ResponseEntity<Guest> updateGuest(@PathVariable Long guestId, @RequestBody Guest newCustomer){

        return guestRepository.findById(guestId).map(customer -> {
            customer.setFirstName(newCustomer.getFirstName());
            customer.setLastName(newCustomer.getLastName());
            customer.setAddress(newCustomer.getAddress());
            customer.setCountry(newCustomer.getCountry());
            customer.setEmailAddress(newCustomer.getEmailAddress());
            customer.setPhoneNumber(newCustomer.getPhoneNumber());
            guestRepository.save(customer);
            return ResponseEntity.ok(customer);
        }).orElseThrow(() -> new ResourceNotFoundException("Guest [guestId="+guestId+"] can't be found"));

    }

    @RequestMapping(value = "/guest/{guestId}", method= RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable Long guestId){

        return guestRepository.findById(guestId).map(customer -> {
                    guestRepository.delete(customer);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(() -> new ResourceNotFoundException("Guest [guestId="+guestId+"] can't be found"));

    }



}
