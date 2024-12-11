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
    @Column(name="screen_id")
    private Long screenId;

    @Column(name="screen_name")
    private String screenName;

    @OneToOne
    @JoinColumn(name="theatre_id")
    private Theatre theatre; // foreign key column

}
