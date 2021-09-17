package co.com.poli.servicebookings.controller;

import co.com.poli.servicebookings.entities.Booking;
import co.com.poli.servicebookings.services.BookingService;
import co.com.poli.servicelibraries.FormatMessage;
import co.com.poli.servicelibraries.ResponseBuilder;
import co.com.poli.servicelibraries.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingsController {
    private final BookingService bookingService;
    private final ResponseBuilder builder = new ResponseBuilder();
    private final FormatMessage message = new FormatMessage();

    @PostMapping
    public Response save(@Valid @RequestBody Booking booking, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(message.formatMessage((result)));
        }
        bookingService.save(booking);
        return builder.success(booking);
    }

    @PutMapping("/{id}")
    public Response updateBooking(@PathVariable("id") Long id, @RequestBody Booking newBooking){
        Booking oldBooking = bookingService.findById(id);
        if(oldBooking == null){
            return builder.success(null);
        }
        bookingService.updateBooking(newBooking, oldBooking);
        return builder.success(newBooking);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Booking booking = bookingService.findById(id);
        if(booking == null){
            return builder.success(null);
        }
        return builder.success(booking);
    }

    @GetMapping("/userid/{userid}")
    public Response findByUserId(@PathVariable("userid") Long userid){
        Booking booking = bookingService.findByUserId(userid);
        if(booking == null){
            return builder.success(null);
        }
        return builder.success(booking);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        System.out.println("entro a eliminar brooking");
        Booking booking = bookingService.findById(id);
        System.out.println("entro a eliminar brooking v2" + booking.toString());
        if(booking == null){
            System.out.println("entro a eliminar brooking null");
            return builder.success(null);
        }
        System.out.println("entro a eliminar brooking llamar delete");
        bookingService.delete(booking);
        System.out.println("entro a eliminar brooking llamo deletee" );
        return builder.success(booking);
    }


    @GetMapping()
    public Response findAll(){
        List<Booking> bookings = bookingService.findAll();
        if(bookings.isEmpty()){
            return builder.success(null);
        }
        return builder.success(bookings);
    }
}
