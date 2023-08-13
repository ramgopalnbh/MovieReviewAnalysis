package com.mra.controllers;

import com.mra.entities.User;
import com.mra.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User usr =userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(usr);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingMovieCBreaker",fallbackMethod = "ratingMovieFallbackMethod")
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable Long userId){
        Optional<User> usr =userService.getUser(userId);
        return ResponseEntity.ok(usr);
    }

    //Creating fallback method for circuitBreaker
    public ResponseEntity<User> ratingMovieFallbackMethod(Long userId, Exception ex){
        log.info("This fallback method is executing due to service down: "+ex.getMessage());
        User user =User.builder()
                .userName("Dummy")
                .email("dummy@dummy.com")
                .role("Agent")
                .password("Abcjd23432")
                .userId(1L)
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users =userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
