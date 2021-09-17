package co.com.poli.servicemovies;


import co.com.poli.servicemovies.entities.Movie;
import co.com.poli.servicemovies.repositories.MovieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class MovieRepositoryMockTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void when_findByMovie_return_listMovies(){
        Movie movie = Movie.builder()
                .tittle("PruebaTest")
                .director("DirectorTest")
                .rating(4)
                .build();

        movieRepository.save(movie);

        List<Movie> movies = movieRepository.findAll();
        System.out.println("--movies---"+ movies.size());
        Assertions.assertThat(movies.size()).isEqualTo(2);
    }
}
