package com.majoapps.reservations.landon.business.service;


import com.majoapps.reservations.landon.data.entity.Room;
import com.majoapps.reservations.landon.data.respository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        super();
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms(String roomNumber){
        List<Room> rooms = new ArrayList<>();
        if (roomNumber == null){
            Iterable<Room> results = this.roomRepository.findAll();
            results.forEach(room -> {rooms.add(room);});
        } else {
            Room room = this.roomRepository.findByNumber(roomNumber);
            if (room != null) {
                rooms.add(room);
            }
        }
        return rooms;
    }

}
