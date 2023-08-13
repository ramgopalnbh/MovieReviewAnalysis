package com.mra.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MRA_Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    private String movieName;
    private String movieType;
    private String releasedInLanguages;
    private String releaseDate;
}
