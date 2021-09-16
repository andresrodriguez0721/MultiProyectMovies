package co.com.poli.servicemovies.controller;

import co.com.poli.servicemovies.entities.Movie;
import co.com.poli.servicemovies.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MoviesController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> save(@RequestBody Movie movie){
        movieService.save(movie);
        return ResponseEntity.ok(movie);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Movie> delete(@PathVariable("id") Long id){
        Movie movie = movieService.findById(id);
        if(movie == null){
            return ResponseEntity.notFound().build();
        }
        movieService.delete(movie);
        return ResponseEntity.ok(movie);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> findAll(){
        List<Movie> movies = movieService.findAll();
        if (movies.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable("id") Long id){
        Movie movie = movieService.findById(id);
        if (movie == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }
}
