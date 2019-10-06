package com.trilogyed.roomservice.dao;

import com.trilogyed.roomservice.dto.Room;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomRepositoryTest {
    @Autowired
    RoomRepository roomRepository;

    private Room room;
    private Room room1;
    private Room room2;

    @Before
    public void setUp() throws Exception {
        roomRepository.deleteAll();

        room = new Room();
        room.setRoomNumber(2210);
        room.setOccupant("The Alchemist");

        room1 = new Room();
        room1.setRoomNumber(3222);
        room1.setOccupant("Octothorp");

        room2 = new Room();
        room2.setRoomNumber(4212);
        room2.setOccupant("Brian");
    }


    @Test
    public void shouldAddAndGetRoom() {
        room = roomRepository.save(room);

        Room fromRepo = roomRepository.findById(room.getId()).get();
        assertEquals(fromRepo, room);
    }

    @Test
    public void shouldUpdateRoom() {
        roomRepository.save(room);
        room.setRoomNumber(2344);

        roomRepository.save(room);

        Room fromRepo = roomRepository.findById(room.getId()).get();
        assertEquals(fromRepo, room);
    }

    @Test
    public void shouldFindAllRooms() {
        roomRepository.save(room);
        roomRepository.save(room1);
        roomRepository.save(room2);

        List<Room> rooms = roomRepository.findAll();
        assertEquals(3, rooms.size());
    }
}