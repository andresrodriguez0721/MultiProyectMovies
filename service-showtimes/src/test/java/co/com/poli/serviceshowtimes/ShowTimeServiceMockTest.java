package co.com.poli.serviceshowtimes;

import co.com.poli.serviceshowtimes.entities.ShowTime;
import co.com.poli.serviceshowtimes.repositories.ShowtimeRepository;
import co.com.poli.serviceshowtimes.services.ShowTimeService;
import co.com.poli.serviceshowtimes.services.ShowTimeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ShowTimeServiceMockTest {

    @Mock
    private ShowtimeRepository showTimeRepository;
    private ShowTimeService showTimeService;

    @BeforeEach
    public void begin(){
       /**

        MockitoAnnotations.initMocks(this);
        showTimeService = new ShowTimeServiceImpl(showTimeRepository);

        List<Long> listmovies = new ArrayList<>();
        listmovies.add(1L);
        listmovies.add(2L);

        ShowTime showTime = ShowTime.builder()
                .id(4L)
                .date(new Date())
                .moviesId(listmovies) //no se como enviar el movie jajaj
                .build();
        System.out.println("--prueba de test5---");

        Mockito.when(showTimeRepository.findById(4L))
                .thenReturn(Optional.of(showTime));

        **/
    }

    @Test
    public void when_findById_return_showTimes(){
        ShowTime showTime = showTimeService.findById(4L);
        Assertions.assertThat(showTime.getId()).isEqualTo(4L);
    }
}
