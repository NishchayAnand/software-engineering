package com.bookmyshow.bookmovie.model;

import com.bookmyshow.bookmovie.dto.Location;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="theatre_id")
    private Long theatreId;

    private String name;

    @Embedded
    private Location location;

}
