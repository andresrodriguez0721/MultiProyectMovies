package co.com.poli.servicebookings.services;

import co.com.poli.servicebookings.client.MovieClient;
import co.com.poli.servicebookings.client.ShowtimeClient;
import co.com.poli.servicebookings.client.UserClient;
import co.com.poli.servicebookings.entities.Booking;
import co.com.poli.servicebookings.models.Movie;
import co.com.poli.servicebookings.models.ShowTime;
import co.com.poli.servicebookings.models.User;
import co.com.poli.servicebookings.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    //private final MovieClient movieClient;
    //private final ShowtimeClient showtimeClient;
    private final UserClient userClient;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Booking booking) {

        /**
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

        bookingRepository.save(booking);
        **/

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBooking(Booking newBooking, Booking oldBooking) {
        oldBooking.setUSERID(newBooking.getUSERID());
        oldBooking.setSHOWTIMEID(newBooking.getSHOWTIMEID());
        oldBooking.setMOVIESID(newBooking.getMOVIESID());
        bookingRepository.save(oldBooking);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }

    @Override
    @Transactional(readOnly = true)
    public Booking findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();

        Booking booking = bookingRepository.findById(id).orElse(null);

        try {
            User user = modelMapper.map(userClient.findById(booking.getUSERID()).getData(), User.class);
            booking.setUser(user);
        }catch (Exception exception){
            exception.getCause();
        }



        /**
        Booking booking = bookingRepository.findById(id).orElse(null);
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

        return bookingRepository.findById(id).orElse(null);
         **/
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
}
