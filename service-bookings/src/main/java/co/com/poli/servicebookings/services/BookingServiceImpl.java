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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserClient userClient;
    private final MovieClient movieClient;
    private final ShowtimeClient showtimeClient;


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

        List<Booking> bookings = bookingRepository.findAll();

        bookings.stream().map(booking -> {
            ModelMapper modelMapper = new ModelMapper();
            User user = modelMapper.map(userClient.findById(booking.getUSERID()).getData(), User.class);
            System.out.println("este es el booking consultado v3-->"+ user.getName());
            ShowTime showTime = modelMapper.map(showtimeClient.findById(booking.getSHOWTIMEID()).getData(), ShowTime.class);


            booking.setUser(user);
            System.out.println("user?" + booking.getUser().getName());
            booking.setShowTime(showTime);
            System.out.println("shotime?" + booking.getShowTime().getId());

            booking.setMovies(null);
            return booking;
        }).collect(Collectors.toList());

         return bookings;
    }

    @Override
    @Transactional(readOnly = true)
    public Booking findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Booking booking = bookingRepository.findById(id).orElse(null);

        if(booking != null){
            System.out.println("este es el booking consultado -->"+ booking.getUSERID());

            try {

                System.out.println("este es el booking consultado v2-->"+ booking.getUSERID());

                User user = modelMapper.map(userClient.findById(booking.getUSERID()).getData(), User.class);
                System.out.println("este es el booking consultado v3-->"+ user.getName());
                ShowTime showTime = modelMapper.map(showtimeClient.findById(booking.getSHOWTIMEID()).getData(), ShowTime.class);


                booking.setUser(user);
                System.out.println("user?" + booking.getUser().getName());
                booking.setShowTime(showTime);
                System.out.println("shotime?" + booking.getShowTime().getId());

                booking.setMovies(null);
                System.out.println("movies?");



            }catch (Exception exception){
                exception.getCause();
            }

        }


        return booking;

    }

    @Override
    public Booking findByUserId(Long id) {
        Booking booking = bookingRepository.findByUSERID(id);
        ModelMapper modelMapper = new ModelMapper();

        User user = modelMapper.map(userClient.findById(booking.getUSERID()).getData(), User.class);
        booking.setUser(user);

        ShowTime showtime =
                modelMapper.map(showtimeClient.findById(booking.getSHOWTIMEID()).getData(), ShowTime.class);
        booking.setShowTime(showtime);


        return bookingRepository.findByUSERID(id);
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
