package com.trilogyed.roomservice.controller;

import com.trilogyed.roomservice.dao.RoomRepository;
import com.trilogyed.roomservice.dto.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*Task:
 *
 */
@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        roomRepository.save(room);
        return room;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable int id) {
        Optional<Room> room = roomRepository.findById(id);
        if (!room.isPresent()) {
            return null;
        }
        return room.get();
    }

    @PutMapping("/{id}")
    public void updateRoom(@PathVariable int id, @RequestBody Room room) {
        if (room.getId() == 0) {
            room.setId(id);
        }

        if (room.getId() != id) {
            throw new IllegalArgumentException("invalid path id.");
        }
        roomRepository.save(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable int id) {
        roomRepository.deleteById(id);
    }
}
