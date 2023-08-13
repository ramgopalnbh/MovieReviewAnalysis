package com.mra.entities;

import lombok.Data;

@Data
public class Rating {
    private Long ratingId;
    private Long userId;
    private Long movieId;
    private int rating;
    private String feedback;
    private Movie movie;
}
