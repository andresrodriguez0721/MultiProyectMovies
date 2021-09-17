package co.com.poli.servicebookings.entities;

import co.com.poli.servicebookings.models.Movie;
import co.com.poli.servicebookings.models.ShowTime;
import co.com.poli.servicebookings.models.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.NotEmpty;
import java.util.Objects;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;


    @NotNull(message = "El id del usuario no puede ser vacio")
    @Column(name="USERID")
    private Long USERID;

    @Transient
    private User user;


    @NotNull(message = "El id de showtime  no puede ser vacio")
    @Column(name="SHOWTIMEID")
    private Long SHOWTIMEID;

    @Transient
    private ShowTime showTime;


    @ElementCollection(targetClass=Long.class)
    @Column(name = "MOVIESID")
    private List<Long> MOVIESID;

    @Transient
    private Movie movie;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
