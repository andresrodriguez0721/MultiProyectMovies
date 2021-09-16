package co.com.poli.servicebookings;

import co.com.poli.servicebookings.entities.Booking;
import co.com.poli.servicebookings.repositories.BookingRepository;
import co.com.poli.servicebookings.services.BookingService;
import co.com.poli.servicebookings.services.BookingServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BookingServiceMockTest {

    @Mock
    BookingRepository bookingRepository;
    BookingService bookingService;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.initMocks(this);
        bookingService = new BookingServiceImpl(bookingRepository);

        List<Long> listmovies = new ArrayList<>();
        listmovies.add(1L);
        listmovies.add(2L);

        Booking booking = Booking.builder()
                .id(9L)
                .USERID(1L)
                .SHOWTIMEID(2L)
                .MOVIESID(listmovies)
                .build();


        Mockito.when(bookingRepository.findById(3L))
                .thenReturn(Optional.of(booking));
    }

    @Test
    public void when_findById_return_movie(){
        Booking booking = bookingService.findById(3L);
        Assertions.assertThat(booking.getUSERID()).isEqualTo(1L);
    }

}
