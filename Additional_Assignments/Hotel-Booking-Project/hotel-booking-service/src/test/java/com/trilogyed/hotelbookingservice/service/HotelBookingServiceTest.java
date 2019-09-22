package com.trilogyed.hotelbookingservice.service;

import com.trilogyed.hotelbookingservice.model.HotelBooking;
import com.trilogyed.hotelbookingservice.model.Rewards;
import com.trilogyed.hotelbookingservice.model.Room;
import com.trilogyed.hotelbookingservice.util.feign.RewardsClient;
import com.trilogyed.hotelbookingservice.util.feign.RoomClient;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class HotelBookingServiceTest {
    RoomClient roomClient;
    RewardsClient rewardsClient;
    HotelBookingService hotelBookingService;

    @Before
    public void setUp() throws Exception {
        setUpRewardsClientMock();
        setUpRoomClientMock();
        hotelBookingService = new HotelBookingService(rewardsClient, roomClient);
    }

    @Test
    public void getRatesIfMember() {
        HotelBooking hotelBooking = new HotelBooking();
    }


    private void setUpRoomClientMock() {
        roomClient = mock(RoomClient.class);

        Room room = new Room();
        room.setNumber(2023);
        room.setRoomType("King Double");
        room.setBaseRate(200.00f);

        Room room1 = new Room();
        room.setNumber(6021);
        room1.setRoomType("Penthouse");
        room.setBaseRate(400.00f);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        rooms.add(room1);

        doReturn(room).when(roomClient).getRoom(2023);
        doReturn(room).when(roomClient).getRoom(6021);
        doReturn(rooms).when(roomClient).getAllRooms();

    }

    private void setUpRewardsClientMock() {
        rewardsClient = mock(RewardsClient.class);

        Rewards rewards = new Rewards();
        rewards.setId(221);
        rewards.setPoints(2100);
        rewards.setCanDouble(true);
        rewards.setRoomType("King Double");
        rewards.setDiscount(0.06f);

        Rewards rewards1 = new Rewards();
        rewards1.setId(222);
        rewards1.setPoints(3200);
        rewards1.setCanDouble(true);
        rewards1.setRoomType("Penthouse");
        rewards1.setDiscount(0.10f);


        List<Rewards> rewardsList = new ArrayList<>();
        rewardsList.add(rewards);
        rewardsList.add(rewards1);

        doReturn(rewards).when(rewardsClient).getRewards("King Double");
        doReturn(rewards1).when(rewardsClient).getRewards("Penthouse");
        doReturn(rewardsList).when(rewardsClient).getAllRewards();
    }
}