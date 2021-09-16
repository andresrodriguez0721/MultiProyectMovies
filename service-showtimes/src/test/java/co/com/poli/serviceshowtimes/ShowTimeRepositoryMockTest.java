package co.com.poli.serviceshowtimes;
import co.com.poli.serviceshowtimes.entities.ShowTime;
import co.com.poli.serviceshowtimes.repositories.ShowtimeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@DataJpaTest
public class ShowTimeRepositoryMockTest {
    @Autowired
    private ShowtimeRepository showTimeRepository;

    @Test
    public void when_findByMovie_return_listMovies(){

        System.out.println("--prueba de test---");
        List<Long> listmovies = new ArrayList<> ();

        listmovies.add(1L);
        listmovies.add(2L);

        ShowTime showTime = ShowTime.builder()
                .date(new Date())
                .moviesId(listmovies) //no se como enviar el movie jajaj
                .build();

        showTimeRepository.save(showTime);

        List<ShowTime> showTimes = showTimeRepository.findAll();
        System.out.println("-- prueba showTimes---"+ showTimes.size());

        Assertions.assertThat(showTimes.size()).isEqualTo(1);
    }
}
