package co.com.poli.servicebookings.client;

import co.com.poli.servicelibraries.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-showtimes", fallback = ShowtimeClientFallBack.class)
public interface ShowtimeClient {

    @GetMapping("/showtime/{id}")
    Response findById(@PathVariable("id") Long id);

}
