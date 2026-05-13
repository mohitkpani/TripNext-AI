package com.tripnext.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate checkInDate;
	
	private LocalDate checkOutDate;
	
	private int numberOfGuests;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Hotel hotel;

	public Booking() {
		
	}

	public Booking(Long id, LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests, User user, Hotel hotel) {
		super();
		this.id = id;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfGuests = numberOfGuests;
		this.user = user;
		this.hotel = hotel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	
}
