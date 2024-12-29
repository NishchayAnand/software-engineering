package com.bookmyshow.bookmovie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
//@EqualsAndHashCode - lombok automatically overrides the equals and hashCode methods to ensure two MovieDTO instances
// with the same content are considered equal.
public class MovieDTO {
    private String title;
    private String genre;
    private LocalDate releaseDate;
    private int duration; // in minutes

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj ==  null || getClass() != obj.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) obj;
        return title.equals(movieDTO.getTitle()) &&
                genre.equals(movieDTO.getGenre()) &&
                releaseDate.equals(movieDTO.getReleaseDate()) &&
                duration == movieDTO.getDuration();
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, releaseDate, duration);
    }
}
