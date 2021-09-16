package co.com.poli.servicebookings.controller;

import co.com.poli.servicebookings.entities.Booking;
import co.com.poli.servicebookings.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingsController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> save(@RequestBody Booking booking){
        bookingService.save(booking);
        return ResponseEntity.ok(booking);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Booking> delete(@PathVariable("id") Long id){
        Booking booking = bookingService.findById(id);
        if(booking == null){
            return ResponseEntity.notFound().build();
        }
        bookingService.delete(booking);
        return ResponseEntity.ok(booking);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> findAll(){
        List<Booking> bookings = bookingService.findAll();
        if (bookings.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> findById(@PathVariable("id") Long id){
        Booking booking = bookingService.findById(id);
        if (booking == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }
}
