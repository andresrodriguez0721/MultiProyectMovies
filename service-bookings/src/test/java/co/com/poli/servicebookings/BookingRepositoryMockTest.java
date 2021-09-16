package co.com.poli.servicebookings;

import co.com.poli.servicebookings.entities.Booking;
import co.com.poli.servicebookings.repositories.BookingRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class BookingRepositoryMockTest {
    @Autowired
    private BookingRepository bookingRepository;

    @Test
    public void when_findByMovie_return_listMovies(){
        List<Long> listMovies = new ArrayList<>();
        listMovies.add(1L);
        listMovies.add(2L);

        Booking booking = Booking.builder()
                .id(9L)
                .USERID(1L)
                .SHOWTIMEID(2L)
                .MOVIESID(listMovies)
                .build();

        bookingRepository.save(booking);

        List<Booking> bookings = bookingRepository.findAll();
        System.out.println("--bookings---"+ bookings.size());
        Assertions.assertThat(bookings.size()).isEqualTo(1);
    }
}
