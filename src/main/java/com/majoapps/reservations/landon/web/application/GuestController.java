package com.majoapps.reservations.landon.web.application;

import com.majoapps.reservations.landon.business.service.GuestService;
import com.majoapps.reservations.landon.data.entity.Guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value="/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService){
        super();
        this.guestService = guestService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String getRooms(@RequestParam(value="guestNumber", required=false)Long id, Model model){
        System.out.println(id);
        List<Guest> getGuestById = this.guestService.getGuest(id);
        model.addAttribute("guests", getGuestById);
        return "guests";
    }

}
