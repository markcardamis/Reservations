package com.majoapps.reservations.landon.business.service;

import com.majoapps.reservations.landon.data.entity.Guest;
import com.majoapps.reservations.landon.data.respository.GuestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getGuest(Long id){
        List<Guest> guests = new ArrayList<>();
        if (id == null){
            Iterable<Guest> results = this.guestRepository.findAll();
            results.forEach(guest -> {guests.add(guest);});
        } else {
            Optional<Guest> guestResponse = this.guestRepository.findById(id);
            if (guestResponse.isPresent()) {
                Guest guest = guestResponse.get();
                guests.add(guest);
            }
        }
        return guests;
    }

}
