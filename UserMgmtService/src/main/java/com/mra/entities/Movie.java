package com.mra.entities;

import lombok.Data;

@Data
public class Movie {
    private Long movieId;
    private String movieName;
    private String movieType;
    private String releasedInLanguages;
    private String releaseDate;
}
