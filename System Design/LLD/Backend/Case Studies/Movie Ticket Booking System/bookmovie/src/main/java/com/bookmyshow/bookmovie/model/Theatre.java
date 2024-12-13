package com.bookmyshow.bookmovie.model;

import com.bookmyshow.bookmovie.dto.Location;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Location location;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Screen> screens;

}
