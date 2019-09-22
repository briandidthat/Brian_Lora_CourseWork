package com.trilogyed.hotelbookingservice.controller;

import com.trilogyed.hotelbookingservice.service.HotelBookingService;
import com.trilogyed.hotelbookingservice.viewmodel.HotelBookingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@RestController
public class HotelBookingController {
    @Autowired
    HotelBookingService hotelBookingService;

    @RequestMapping(value = {"/hotelRewards/{roomId}?rewardsMember={rewardsMember}&doubleBonusDay={doubleBonusDay}",
            "/hotelRewards/{roomId}"})
    public HotelBookingViewModel getRates(@PathVariable(name = "roomId") int roomId,
                                          @PathVariable(name = "rewardsMember", required = false) Optional<Boolean> rewardsMember,
                                          @PathVariable(name = "doubleBonusDay", required = false) Optional<Boolean> doubleBonusDay) {
        // if both values are provided, use the overloaded method for it. If not, use the simple one.
        if (rewardsMember.isPresent() && doubleBonusDay.isPresent()) {
            return hotelBookingService.getRate(roomId, rewardsMember.get(), doubleBonusDay.get());
        } else {
            return hotelBookingService.getRate(roomId);
        }
    }
}
