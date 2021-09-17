package co.com.poli.servicebookings.client;

import co.com.poli.servicebookings.models.ShowTime;
import co.com.poli.servicelibraries.Response;
import co.com.poli.servicelibraries.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShowtimeClientFallBack implements ShowtimeClient{

    private final ResponseBuilder builder = new ResponseBuilder();

    @Override
    public Response findById(Long id) {
        ShowTime showtime = new ShowTime();
        return builder.success(showtime);
    }
}
