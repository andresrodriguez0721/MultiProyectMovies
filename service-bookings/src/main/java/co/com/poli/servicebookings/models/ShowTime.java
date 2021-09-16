package co.com.poli.servicebookings.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

public class ShowTime {
    private Long id;
    private Date date;
    private List<Long> moviesId;
}
