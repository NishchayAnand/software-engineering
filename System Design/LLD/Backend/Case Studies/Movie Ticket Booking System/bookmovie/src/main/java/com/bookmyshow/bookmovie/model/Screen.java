package com.bookmyshow.bookmovie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne // Unidirectional Relationship
    @JoinColumn(name="theatre_id", referencedColumnName = "id")
    private Theatre theatre; // foreign key column

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<Show> shows;

}
