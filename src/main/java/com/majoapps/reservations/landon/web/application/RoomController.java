package com.majoapps.reservations.landon.web.application;

import com.majoapps.reservations.landon.business.service.RoomService;
import com.majoapps.reservations.landon.data.entity.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value="/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService){
        super();
        this.roomService = roomService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String getRooms(@RequestParam(value="roomNumber", required=false)String roomNumber, Model model){
        List<Room> getRoomById = this.roomService.getRooms(roomNumber);
        model.addAttribute("rooms", getRoomById);
        return "rooms";
    }

}
