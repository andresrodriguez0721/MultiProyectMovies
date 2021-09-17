package co.com.poli.servicebookings.services;

import co.com.poli.servicebookings.entities.Booking;
import co.com.poli.servicebookings.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking findByUserId(Long id) {
        /**
         Booking booking = bookingRepository.findByUserid(id);
         ModelMapper modelMapper = new ModelMapper();

         User user = modelMapper.map(userClient.findById(booking.getUSERID()).getData(), User.class);
         booking.setUser(user);

         ShowTime showtime =
         modelMapper.map(showtimeClient.findById(booking.getSHOWTIMEID()).getData(), ShowTime.class);
         booking.setShowTime(showtime);

         List<Long> movieList = booking.getMOVIESID().stream()
         .map(movieItem -> {
         Movie movie = modelMapper.map(movieClient.findById(movieItem).getData(), Movie.class);
         booking.setMovie(movie);
         return movieItem;
         }).collect(Collectors.toList());


         return bookingRepository.findByUserid(id);
         **/
        return new Booking();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBooking(Booking newBooking, Booking oldBooking) {
        oldBooking.setUSERID(newBooking.getUSERID());
        oldBooking.setSHOWTIMEID(newBooking.getSHOWTIMEID());
        oldBooking.setMOVIESID(newBooking.getMOVIESID());
        bookingRepository.save(oldBooking);
    }
}
