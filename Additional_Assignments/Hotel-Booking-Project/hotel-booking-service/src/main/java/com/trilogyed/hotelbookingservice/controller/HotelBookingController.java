package com.trilogyed.hotelbookingservice.controller;

import com.trilogyed.hotelbookingservice.service.HotelBookingService;
import com.trilogyed.hotelbookingservice.viewmodel.HotelBookingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@RestController
@RequestMapping("/hotelRewards")
public class HotelBookingController {
    @Autowired
    HotelBookingService hotelBookingService;

    @GetMapping(value = {"/{roomId}?rewardsMember={rewardsMember}&doubleBonusDay={doubleBonusDay}", "/{roomId}"})
    public HotelBookingViewModel getRates(@PathVariable(name = "roomId") int roomId,
                                          @RequestParam(defaultValue = "false", required = false) boolean rewardsMember,
                                          @RequestParam(defaultValue = "false", required = false) boolean doubleBonusDay) {

        return hotelBookingService.getRate(roomId, rewardsMember, doubleBonusDay);
    }
}
