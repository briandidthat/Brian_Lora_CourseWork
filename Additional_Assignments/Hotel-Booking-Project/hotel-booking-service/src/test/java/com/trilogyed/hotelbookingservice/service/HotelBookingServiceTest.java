package com.trilogyed.hotelbookingservice.service;

import com.trilogyed.hotelbookingservice.model.Rewards;
import com.trilogyed.hotelbookingservice.model.Room;
import com.trilogyed.hotelbookingservice.util.feign.RewardsClient;
import com.trilogyed.hotelbookingservice.util.feign.RoomClient;
import com.trilogyed.hotelbookingservice.viewmodel.HotelBookingViewModel;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * HotelServiceLayerTest
 * Purpose: Verify that the correct values are returned after performing the API calls, and internal calculations.
 * Private Methods:
 * setUpRewardsClientMock() - will set up mock values for rewards testing.
 * setUpRoomClientMock() - will set up mock values for room testing.
 * Public Methods:
 * getRate() - will test with various different combinations of values passed via url.
 * getRateIfEmpty() - will verify that the correct values are returned if the user passes no values via url.
 * getAllRooms() - will expect a list of all rooms available.
 * getAllRewards() - will expect a list of all rewards available.
 * */

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
    public void getRate() {
        // TEST IF USER IS A MEMBER, AND IT IS DOUBLE BONUS DAY
        HotelBookingViewModel hvm = new HotelBookingViewModel();
        hvm.setRoomId(2023);
        hvm.setRewardsMember(true);
        hvm.setDoubleBonusDay(true);
        hvm.setBaseRate(200.00f);
        hvm.setMemberDiscount(0.06f);
        hvm.setBaseRewardPoints(2100);
        hvm.setCanDouble(true);
        hvm.setFinalCost(188);
        hvm.setTotalRewardsPoints(4200);

        HotelBookingViewModel fromService = hotelBookingService.getRate(2023,true, true);
        assertEquals(fromService, hvm);

        // TEST IF USER IS A MEMBER, BUT IT IS NOT DOUBLE BONUS DAY
        HotelBookingViewModel hvm1 = new HotelBookingViewModel();
        hvm1.setRoomId(2023);
        hvm1.setRewardsMember(true);
        hvm1.setDoubleBonusDay(false);
        hvm1.setBaseRate(200.00f);
        hvm1.setMemberDiscount(0.06f);
        hvm1.setBaseRewardPoints(2100);
        hvm1.setCanDouble(true);
        hvm1.setFinalCost(188);
        hvm1.setTotalRewardsPoints(2100);

        HotelBookingViewModel fromService1 = hotelBookingService.getRate(2023, true, false);
        assertEquals(fromService1, hvm1);

        // TEST IF USER IS NOT MEMBER, AND IT IS NOT DOUBLE BONUS DAY
        HotelBookingViewModel hvm2 = new HotelBookingViewModel();
        hvm2.setRoomId(6021);
        hvm2.setRewardsMember(false);
        hvm2.setDoubleBonusDay(false);
        hvm2.setBaseRate(400.00f);
        hvm2.setMemberDiscount(0.10f);
        hvm2.setBaseRewardPoints(3200);
        hvm2.setCanDouble(true);
        hvm2.setFinalCost(400.00f);
        hvm2.setTotalRewardsPoints(0);

        HotelBookingViewModel fromService2 = hotelBookingService.getRate(6021, false, false);
        assertEquals(fromService2, hvm2);
    }

    @Test
    public void getAllRewards() {
        List<Rewards> rewardsList = rewardsClient.getAllRewards();
        assertEquals(2, rewardsList.size());
    }

    @Test
    public void getAllRooms() {
        List<Room> roomList = roomClient.getAllRooms();
        assertEquals(2, roomList.size());
    }

    private void setUpRoomClientMock() {
        roomClient = mock(RoomClient.class);

        Room room = new Room();
        room.setNumber(2023);
        room.setRoomType("King Double");
        room.setBaseRate(200.00f);

        Room room1 = new Room();
        room1.setNumber(6021);
        room1.setRoomType("Penthouse");
        room1.setBaseRate(400.00f);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        rooms.add(room1);

        doReturn(room).when(roomClient).getRoom(2023);
        doReturn(room1).when(roomClient).getRoom(6021);
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