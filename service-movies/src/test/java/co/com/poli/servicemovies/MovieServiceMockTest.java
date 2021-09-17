package co.com.poli.servicemovies;

import co.com.poli.servicemovies.entities.Movie;
import co.com.poli.servicemovies.repositories.MovieRepository;
import co.com.poli.servicemovies.services.MovieService;
import co.com.poli.servicemovies.services.MovieServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MovieServiceMockTest {
    @Mock
    private MovieRepository movieRepository;
    private MovieService movieService;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.initMocks(this);
        movieService = new MovieServiceImpl(movieRepository);

        Movie movie = Movie.builder()
                .id(3L)
                .tittle("PruebaTestService")
                .director("DirectorTestService")
                .rating(3)
                .build();


        Mockito.when(movieRepository.findById(3L))
                .thenReturn(Optional.of(movie));
    }

    @Test
    public void when_findById_return_movie(){
        Movie movie = movieService.findById(3L);
        Assertions.assertThat(movie.getTittle()).isEqualTo("PruebaTestService");
    }

}
