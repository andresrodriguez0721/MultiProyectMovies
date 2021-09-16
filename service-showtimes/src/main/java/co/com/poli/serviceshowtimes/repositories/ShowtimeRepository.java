package co.com.poli.serviceshowtimes.repositories;

import co.com.poli.serviceshowtimes.entities.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepository extends JpaRepository<ShowTime, Long> {
    ShowTime findById(String id);
}

