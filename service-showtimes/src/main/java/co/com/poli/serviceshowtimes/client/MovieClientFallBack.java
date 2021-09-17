package co.com.poli.serviceshowtimes.client;

import co.com.poli.servicelibraries.Response;
import co.com.poli.servicelibraries.ResponseBuilder;
import co.com.poli.serviceshowtimes.models.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieClientFallBack implements MovieClient{

    private final ResponseBuilder builder = new ResponseBuilder();

    @Override
    public Response findById(Long id) {
        Movie movie = new Movie();
        return builder.success(movie);
    }
}

