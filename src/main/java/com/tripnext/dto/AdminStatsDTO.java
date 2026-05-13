package com.tripnext.dto;

public class AdminStatsDTO {

    private long totalHotels;
    private long totalPlaces;
    private long totalBookings;
    private long totalUsers;
    private double revenue;


    public AdminStatsDTO(long totalHotels,long totalPlaces,long totalBookings,long totalUsers, double revenue) {

        this.totalHotels = totalHotels;
        this.totalPlaces = totalPlaces;
        this.totalBookings = totalBookings;
        this.totalUsers = totalUsers;
        this.revenue = revenue;
    }


    public long getTotalHotels() {
        return totalHotels;
    }

    public long getTotalPlaces() {
        return totalPlaces;
    }

    public long getTotalBookings() {
        return totalBookings;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public double getRevenue() {
        return revenue;
    }
}