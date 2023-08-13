package com.mra.services;

import com.mra.entities.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    //create User
    User saveUser(User user);

    //get all users
    List<User> getAllUsers();

    //get single user bu userId
    Optional<User> getUser(Long userId);
}
