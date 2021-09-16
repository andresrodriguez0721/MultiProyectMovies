package co.com.poli.servicebookings.services;

import co.com.poli.servicebookings.entities.Booking;

import java.util.List;

public interface BookingService {
    void save(Booking booking);
    void delete(Booking booking);
    List<Booking> findAll();
    Booking findById(Long id);
}
