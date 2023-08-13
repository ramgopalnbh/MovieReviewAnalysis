package com.mra.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Transient;
//import org.springframework.data.mongodb.core.mapping.Document;

@Data
//@Document("MRA_Rating")
@Entity
@Table(name = "MRA_Rating")
public class Rating {
//    @Transient
//    public static final String SEQUENCE_NAME ="rating_sequence";

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;
    //@Transient
    //private Long seq;
    private Long userId;
    private Long movieId;
    private int rating;
    private String feedback;
}
