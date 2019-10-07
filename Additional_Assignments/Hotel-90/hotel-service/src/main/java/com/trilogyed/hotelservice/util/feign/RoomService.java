package com.trilogyed.hotelservice.util.feign;

import com.trilogyed.hotelservice.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "room-service")
public interface RoomService {
    @GetMapping(value = "/rooms")
    List<Room> getAllRooms();

    @PostMapping(value = "/rooms")
    Room createRoom();

    @GetMapping(value = "/rooms/{id}")
    Room getRoomByRoomId(@PathVariable int id);

    @PutMapping(value = "/rooms/{id}")
    void updateRoom(@PathVariable int id, @RequestBody Room room);

    @DeleteMapping(value = "/rooms/{id}")
    void deleteRoom(@PathVariable int id);
}
