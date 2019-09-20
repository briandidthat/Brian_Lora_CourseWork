package com.trilogyed.hotelbookingservice.service;

import com.trilogyed.hotelbookingservice.model.HotelBooking;
import com.trilogyed.hotelbookingservice.model.Rewards;
import com.trilogyed.hotelbookingservice.model.Room;
import com.trilogyed.hotelbookingservice.util.feign.RewardsClient;
import com.trilogyed.hotelbookingservice.util.feign.RoomClient;
import com.trilogyed.hotelbookingservice.viewmodel.HotelBookingViewModel;
import org.springframework.beans.factory.annotation.Autowired;


public class HotelBookingService {
    private RewardsClient rewardsClient;
    private RoomClient roomClient;

    @Autowired
    public HotelBookingService(RewardsClient rewardsClient, RoomClient roomClient) {
        this.rewardsClient = rewardsClient;
        this.roomClient = roomClient;
    }

    private HotelBookingViewModel buildHotelBookViewModel(HotelBooking hotelBooking, Room room, Rewards rewards) {
        HotelBookingViewModel hbvm = new HotelBookingViewModel();
        hbvm.setRoomId(room.getNumber());
        hbvm.setRewardsMember(hotelBooking.isRewardsMember());

        return hbvm;
    }
}
