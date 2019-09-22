package com.trilogyed.hotelbookingservice.service;

import com.trilogyed.hotelbookingservice.exception.NotFoundException;
import com.trilogyed.hotelbookingservice.model.HotelBooking;
import com.trilogyed.hotelbookingservice.model.Rewards;
import com.trilogyed.hotelbookingservice.model.Room;
import com.trilogyed.hotelbookingservice.util.feign.RewardsClient;
import com.trilogyed.hotelbookingservice.util.feign.RoomClient;
import com.trilogyed.hotelbookingservice.viewmodel.HotelBookingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * SERVICE LAYER
 * Purpose: To perform all necessary operations for hotel booking management.
 * Private methods: buildHotelBookingViewModel(), calculateFinalCost(), checkRewardsPoints(), getRoom(), getRewards().
 * Public methods: getRate(int id), getRate(roomId, rewardsMember, doubleBonusDay).
 */

@SuppressWarnings("SpellCheckingInspection")
@Component
public class HotelBookingService {
    private RewardsClient rewardsClient;
    private RoomClient roomClient;

    @Autowired
    public HotelBookingService(RewardsClient rewardsClient, RoomClient roomClient) {
        this.rewardsClient = rewardsClient;
        this.roomClient = roomClient;
    }

    public HotelBookingViewModel getRate(int roomId, boolean rewardsMember, boolean doubleBonusDay) {
        // GET ROOM BASED ON ID, GET REWARDS BASED ON ROOMTYPE
        Room room = getRoom(roomId);
        Rewards rewards = getRewards(room.getRoomType());

        // CALCULATE VALUES
        float finalCost = calculateFinalCost(rewardsMember, room.getBaseRate(), rewards.getDiscount());
        int totalRewardsPoints = checkRewardsPoints(doubleBonusDay, rewardsMember, rewards);

        // SET VALUES
        HotelBooking hotelBooking = new HotelBooking();
        hotelBooking.setRewardsMember(rewardsMember);
        hotelBooking.setTotalRewardsPoints(totalRewardsPoints);
        hotelBooking.setDoubleBonusDay(doubleBonusDay);
        hotelBooking.setFinalCost(finalCost);

        return buildHotelBookingViewModel(hotelBooking, room, rewards);
    }

// HELPER METHODS
// ===========================================================================================================
    private Room getRoom(int roomId) {
        Room room = roomClient.getRoom(roomId);
        if (room == null) {
            throw new NotFoundException("Sorry, we do not have a room with that number. Please try again.");
        } else {
            return room;
        }
    }

    private Rewards getRewards(String roomType) {
        return rewardsClient.getRewards(roomType);
    }

    // calculate final cost based on membership status, and subsequently the discount rate
    private float calculateFinalCost(boolean isMember, float baseRate, float memberDiscount) {
        if (isMember) {
            return baseRate * (1 - memberDiscount);
        } else {
            return baseRate;
        }
    }

    // return points based on isMember. If member, calculate value based on isDoubleDay && canDouble
    // if not, total rewards points will be the baseRewardsPoints
    private int checkRewardsPoints(boolean isDouble, boolean isMember, Rewards rewards) {
        int totalRewardsPoints = 0;
        if (isMember) {
            if (isDouble && rewards.getCanDouble()) {
                totalRewardsPoints = rewards.getPoints() * 2;
            } else {
                totalRewardsPoints = rewards.getPoints();
            }
        }
        return totalRewardsPoints;
    }

    private HotelBookingViewModel buildHotelBookingViewModel(HotelBooking hotelBooking, Room room, Rewards rewards) {
        HotelBookingViewModel hbvm = new HotelBookingViewModel();
        hbvm.setRoomId(room.getNumber());
        hbvm.setRewardsMember(hotelBooking.isRewardsMember());
        hbvm.setDoubleBonusDay(hotelBooking.isDoubleBonusDay());
        hbvm.setBaseRate(room.getBaseRate());
        hbvm.setMemberDiscount(rewards.getDiscount());
        hbvm.setBaseRewardPoints(rewards.getPoints());
        hbvm.setCanDouble(rewards.getCanDouble());
        hbvm.setFinalCost(hotelBooking.getFinalCost());
        hbvm.setTotalRewardsPoints(hotelBooking.getTotalRewardsPoints());

        return hbvm;
    }
}
