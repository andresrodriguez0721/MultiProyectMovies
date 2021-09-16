package co.com.poli.serviceshowtimes.services;

import co.com.poli.serviceshowtimes.entities.ShowTime;
import co.com.poli.serviceshowtimes.repositories.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowTimeServiceImpl implements ShowTimeService {

    private final ShowtimeRepository showTimeRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ShowTime showTime) {
        showTimeRepository.save(showTime);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(ShowTime showTime) {
        showTimeRepository.delete(showTime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ShowTime> findAll() {
        return showTimeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ShowTime findById(Long id) {
        return showTimeRepository.findById(id).orElse(null);
    }
}
