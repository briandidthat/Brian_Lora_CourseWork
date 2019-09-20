package com.trilogyed.hotelbookingservice.model;

import java.util.Objects;

public class HotelBooking {
    private int id;
    private boolean rewardsMember;
    private float memberDiscount;
    private float finalCost;
    private int totalRewardsPoints;

    public int getId() {
        return id;
    }

    public void setBookingId(int bookingId) {
        this.id = id;
    }

    public boolean isRewardsMember() {
        return rewardsMember;
    }

    public void setRewardsMember(boolean rewardsMember) {
        this.rewardsMember = rewardsMember;
    }

    public float getMemberDiscount() {
        return memberDiscount;
    }

    public void setMemberDiscount(float memberDiscount) {
        this.memberDiscount = memberDiscount;
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
        HotelBooking that = (HotelBooking) o;
        return id == that.id &&
                rewardsMember == that.rewardsMember &&
                Float.compare(that.memberDiscount, memberDiscount) == 0 &&
                Float.compare(that.finalCost, finalCost) == 0 &&
                totalRewardsPoints == that.totalRewardsPoints;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rewardsMember, memberDiscount, finalCost, totalRewardsPoints);
    }

    @Override
    public String toString() {
        return "HotelBooking{" +
                "id=" + id +
                ", rewardsMember=" + rewardsMember +
                ", memberDiscount=" + memberDiscount +
                ", finalCost=" + finalCost +
                ", totalRewardsPoints=" + totalRewardsPoints +
                '}';
    }
}
