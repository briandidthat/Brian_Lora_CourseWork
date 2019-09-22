package com.trilogyed.hotelbookingservice.viewmodel;

import java.util.Objects;


public class HotelBookingViewModel {
    private int roomId;
    private boolean rewardsMember;
    private boolean doubleBonusDay;
    private float baseRate;
    private float memberDiscount;
    private int baseRewardPoints;
    private boolean canDouble;
    private float finalCost;
    private int totalRewardsPoints;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public boolean isRewardsMember() {
        return rewardsMember;
    }

    public void setRewardsMember(boolean rewardsMember) {
        this.rewardsMember = rewardsMember;
    }

    public boolean isDoubleBonusDay() {
        return doubleBonusDay;
    }

    public void setDoubleBonusDay(boolean doubleBonusDay) {
        this.doubleBonusDay = doubleBonusDay;
    }

    public float getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(float baseRate) {
        this.baseRate = baseRate;
    }

    public float getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(float memberDiscount) {
        this.memberDiscount = memberDiscount;
    }

    public int getBaseRewardPoints() {
        return baseRewardPoints;
    }

    public void setBaseRewardPoints(int baseRewardPoints) {
        this.baseRewardPoints = baseRewardPoints;
    }

    public boolean getCanDouble() {
        return canDouble;
    }

    public void setCanDouble(Boolean canDouble) {
        this.canDouble = canDouble;
    }

    public float getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(float finalCost) {
        this.finalCost = finalCost;
    }

    public int getTotalRewardsPoints() {
        return totalRewardsPoints;
    }

    public void setTotalRewardsPoints(int totalRewardsPoints) {
        this.totalRewardsPoints = totalRewardsPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelBookingViewModel that = (HotelBookingViewModel) o;
        return roomId == that.roomId &&
                rewardsMember == that.rewardsMember &&
                doubleBonusDay == that.doubleBonusDay &&
                Float.compare(that.baseRate, baseRate) == 0 &&
                Float.compare(that.memberDiscount, memberDiscount) == 0 &&
                baseRewardPoints == that.baseRewardPoints &&
                Float.compare(that.finalCost, finalCost) == 0 &&
                totalRewardsPoints == that.totalRewardsPoints &&
                canDouble == that.canDouble;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, rewardsMember, doubleBonusDay, baseRate, memberDiscount,
                baseRewardPoints, canDouble, finalCost, totalRewardsPoints);
    }
}
