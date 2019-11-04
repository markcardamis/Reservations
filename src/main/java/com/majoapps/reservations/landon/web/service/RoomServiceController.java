package com.majoapps.reservations.landon.web.service;

import com.majoapps.reservations.landon.business.service.RoomService;
import com.majoapps.reservations.landon.data.entity.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/api")
@Api(value="/rooms", description = "Data service operations on rooms", tags = ("Rooms"))
public class RoomServiceController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value="/rooms/{roomNumber}", method= RequestMethod.GET)
    public List<Room> getRoomById(@PathVariable(value="roomNumber") String roomNumber) {
        return this.roomService.getRooms(roomNumber);
    }

}
