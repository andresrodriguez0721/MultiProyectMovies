package co.com.poli.servicemovies.controller;

import co.com.poli.servicelibraries.FormatMessage;
import co.com.poli.servicelibraries.Response;
import co.com.poli.servicelibraries.ResponseBuilder;
import co.com.poli.servicemovies.entities.Movie;
import co.com.poli.servicemovies.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MoviesController {
    private final MovieService movieService;
    private final ResponseBuilder builder = new ResponseBuilder();
    private final FormatMessage message = new FormatMessage();

    @PostMapping
    public Response save(@Valid @RequestBody Movie movie, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(message.formatMessage(result));
        }
        movieService.save(movie);
        return builder.success(movie);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Movie movie = movieService.findById(id);
        if(movie == null){
            return builder.success(null);
        }
        movieService.delete(movie);
        return builder.success(movie);
    }

    @GetMapping()
    public Response findAll(){
        List<Movie> movies = movieService.findAll();
        if(movies.isEmpty()){
            return builder.success(null);
        }
        return builder.success(movies);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Movie movie = movieService.findById(id);
        if(movie == null){
            return builder.success(null);
        }
        return builder.success(movie);
    }
}
