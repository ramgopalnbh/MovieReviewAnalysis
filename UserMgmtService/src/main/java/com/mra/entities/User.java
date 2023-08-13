package com.mra.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "MRA_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "userName", length = 20)
    private String userName;
    private String email;
    @Column(name = "password", length = 20)
    private String password;
    private String role;
    @Transient
    private List<Rating> ratings =new ArrayList<>();
}
