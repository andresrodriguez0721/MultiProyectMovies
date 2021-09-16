package co.com.poli.serviceshowtimes.entities;

import co.com.poli.serviceshowtimes.models.Movie;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "showtimes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //@NotNull(message = "Por favor ingrese una fecha con el formato YYYY-MM-DD")
    @Column(name = "date")
    private Date date;

    @ElementCollection
    @Column(name = "movies_id")
    private List<Long> moviesId;

    @Transient
    private Movie movie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowTime showtime = (ShowTime) o;
        return Objects.equals(id, showtime.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}