package co.com.poli.serviceshowtimes.controller;


import co.com.poli.servicelibraries.FormatMessage;
import co.com.poli.servicelibraries.Response;
import co.com.poli.servicelibraries.ResponseBuilder;
import co.com.poli.serviceshowtimes.entities.ShowTime;
import co.com.poli.serviceshowtimes.services.ShowTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/showtime")
@RequiredArgsConstructor
public class ShowTimesController {

    private final ShowTimeService showtimeService;
    private final FormatMessage message = new FormatMessage();
    private final ResponseBuilder builder = new ResponseBuilder();

    @PostMapping
    public Response save(@Valid @RequestBody ShowTime showtime, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(message.formatMessage(result));
        }
        showtimeService.save(showtime);
        return builder.success(showtime);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        ShowTime showTime = showtimeService.findById(id);
        if(showTime == null){
            return builder.success(null);
        }
        showtimeService.delete(showTime);
        return builder.success(showTime);
    }

    @PutMapping("/{id}")
    public Response updateShowtime(@PathVariable("id") Long id, @RequestBody ShowTime newShowtime){
        ShowTime oldShowtime = showtimeService.findById(id);
        if(oldShowtime == null){
            return builder.success(null);
        }
        showtimeService.updateShowtime(newShowtime, oldShowtime);
        return builder.success(newShowtime);
    }

    @GetMapping()
    public Response findAll(){
        List<ShowTime> showtimes = showtimeService.findAll();
        if(showtimes.isEmpty()){
            return builder.success(null);
        }
        return builder.success(showtimes);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        ShowTime showtime = showtimeService.findById(id);
        if(showtime == null){
            return builder.success(null);
        }
        return builder.success(showtime);
    }
}

