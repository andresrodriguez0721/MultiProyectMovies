package co.com.poli.servicebookings.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ShowTime {
    private Long id;
    private Date date;
    private List<Long> moviesId;
}
