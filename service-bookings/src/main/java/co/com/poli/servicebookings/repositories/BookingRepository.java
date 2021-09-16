package co.com.poli.servicebookings.repositories;

import co.com.poli.servicebookings.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    Booking findById(String id);
}
