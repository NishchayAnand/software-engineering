package com.bookmyshow.bookmovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class MovieDTO {
    private String title;
    private String genre;
    private LocalDate releaseDate;
    private int duration; // in minutes
}
