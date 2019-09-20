package com.trilogyed.hotelbookingservice.controller;

import com.trilogyed.hotelbookingservice.viewmodel.HotelBookingViewModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HotelBookingController {
    @RequestMapping(path = {"/hotelRewards/{roomId}?rewardsMember={rewardsMember}&doubleBonusDay={doubleBonusDay}", "/hotelRewards"})
    public HotelBookingViewModel getRates(@PathVariable("roomId") int roomId,
                                          @PathVariable(name = "rewardsMember", required = false) boolean rewardsMember,
                                          @PathVariable(name = "doubleBonusDay", required = false) boolean doubleBonusDay) {
        return null;
    }
}
