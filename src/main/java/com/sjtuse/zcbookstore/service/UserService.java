package com.sjtuse.zcbookstore.service;

import com.sjtuse.zcbookstore.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zcoaolas on 3/5/2017.
 */
public interface UserService {
    /**
     * @param username from user input
     * @return User object if user exists, null otherwise
     */
    User getByUsername(String username);

    /**
     * Get all users in the system
     * @return A list of users
     */
    List<User> getAllUsers();
}
