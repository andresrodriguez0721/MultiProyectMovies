package co.com.poli.servicebookings.repositories;

import co.com.poli.servicebookings.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    Booking findById(String id);
    Booking findByUSERID(Long id);
}
