package com.trilogyed.hotelbookingservice.util.feign;

import com.trilogyed.hotelbookingservice.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="room-service")
public interface RoomClient {
    @RequestMapping(value = "/room/{number}", method = RequestMethod.GET)
    public Room getRoom(@PathVariable int number);

    @RequestMapping(value = "/room", method = RequestMethod.GET)
    public List<Room> getAllRooms();
}
