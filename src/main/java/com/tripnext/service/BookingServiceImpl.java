package com.tripnext.service;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripnext.entity.Booking;
import com.tripnext.entity.Hotel;
import com.tripnext.entity.User;
import com.tripnext.repository.BookingRepository;
import com.tripnext.repository.HotelRepository;
import com.tripnext.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    private EmailService emailService;

    @Override
    public Booking bookHotel(Booking booking) {

        // FETCH FULL USER

        User user =
        userRepo.findById(
                booking.getUser().getId()
        ).orElse(null);

        booking.setUser(user);

        // FETCH FULL HOTEL

        Hotel hotel =
        hotelRepo.findById(
                booking.getHotel().getId()
        ).orElse(null);

        booking.setHotel(hotel);

        // SAVE BOOKING

        Booking savedBooking =
                bookingRepo.save(booking);

        // BILL CALCULATION

        long nights =
        ChronoUnit.DAYS.between(

                booking.getCheckInDate(),

                booking.getCheckOutDate()
        );

        double pricePerNight =
        hotel.getPrice();

        double total =
        pricePerNight * nights;

        double gst =
        total * 0.18;

        double finalAmount =
        total + gst;

        // SEND EMAIL

        emailService.sendEmail(

                user.getEmail(),

                "TripNext Booking Confirmation",

                "Hello " +

                user.getName() +

                ",\n\nYour hotel booking is confirmed!\n\n" +

                "Hotel: " +

                hotel.getHotelName() +

                "\nLocation: " +

                hotel.getLocation() +

                "\nCheck-In: " +

                booking.getCheckInDate() +

                "\nCheck-Out: " +

                booking.getCheckOutDate() +

                "\nGuests: " +

                booking.getNumberOfGuests() +

                "\n\nPrice Per Night: ₹" +

                pricePerNight +

                "\nTotal Nights: " +

                nights +

                "\nGST (18%): ₹" +

                gst +

                "\nFinal Amount: ₹" +

                finalAmount +

                "\n\nThank you for choosing TripNext AI ✈"
        );

        return savedBooking;
    }

    @Override
    public List<Booking> getUserBookings(Long userId){

        User user =
        userRepo.findById(userId).orElse(null);

        return bookingRepo.findByUser(user);
    }

    @Override
    public void cancelBooking(Long id){

        bookingRepo.deleteById(id);
    }

    @Override
    public List<Booking> getAllBookings(){

        return bookingRepo.findAll();
    }
}