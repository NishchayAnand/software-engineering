package com.bookmyshow.bookmovie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name="shows")
@Getter
@Setter
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="movie_id", referencedColumnName = "id") // foreign key column
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="screen_id", referencedColumnName = "id") // foreign key column
    private Screen screen;

    @Column(name="show_time")
    private LocalTime showTime;

}
