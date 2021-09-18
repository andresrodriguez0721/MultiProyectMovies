package co.com.poli.users.clients;

import co.com.poli.servicelibraries.Response;
import co.com.poli.servicelibraries.ResponseBuilder;
import co.com.poli.users.models.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingClientFallBack implements BookingClient{

    private final ResponseBuilder builder = new ResponseBuilder();

    @Override
    public Response findByUSERID(Long userid) {
        Booking booking = new Booking();
        return builder.success(booking);
    }
}

