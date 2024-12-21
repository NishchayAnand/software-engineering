package com.bookmyshow.bookmovie.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;

    @Column(name="release_date")
    private LocalDate releaseDate;

    private int duration; // in minutes

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> shows;

    public Movie(String title, String genre, LocalDate releaseDate, int duration) {
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public Movie(Long id, String title, String genre, LocalDate releaseDate, int duration) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

}
