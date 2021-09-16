package co.com.poli.serviceshowtimes.services;

import co.com.poli.serviceshowtimes.entities.ShowTime;

import java.util.List;

public interface ShowTimeService {
    void save(ShowTime showTime);
    void delete(ShowTime showTime);
    List<ShowTime> findAll();
    ShowTime findById(Long id);
}
