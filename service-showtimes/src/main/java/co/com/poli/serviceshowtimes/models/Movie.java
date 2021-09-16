package co.com.poli.serviceshowtimes.models;

import lombok.Data;

@Data
public class Movie {
    private Long id;
    private String title;
    private String director;
    private int rating;
}
