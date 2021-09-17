package co.com.poli.servicemovies.repositories;

import co.com.poli.servicemovies.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {

}
