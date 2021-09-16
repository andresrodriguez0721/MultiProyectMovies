package co.com.poli.servicebookings.models;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
public class User {
    private Long id;
    private String name;
    private String lastName;
}
