package co.com.poli.servicebookings.services;

import co.com.poli.servicebookings.entities.Booking;

import java.util.List;

public interface BookingService {
    void save(Booking booking);
    void delete(Booking booking);
    Booking findByUSERID(Long id);
    List<Booking> findAll();
    Booking findById(Long id);
    void updateBooking(Booking newBooking, Booking oldBooking);
}
