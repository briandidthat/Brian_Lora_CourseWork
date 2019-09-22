package com.trilogyed.hotelbookingservice.service;

import com.trilogyed.hotelbookingservice.util.feign.RewardsClient;
import com.trilogyed.hotelbookingservice.util.feign.RoomClient;
import org.junit.Before;
import org.junit.Test;

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
    public void getRates() {
    }

    private void setUpRoomClientMock() {
        roomClient = mock(RoomClient.class);
    }

    private void setUpRewardsClientMock() {
        rewardsClient = mock(RewardsClient.class);
    }
}