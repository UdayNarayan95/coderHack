package com.uday.coderHack.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uday.coderHack.dtos.User;
import com.uday.coderHack.exceptions.UserNotFoundException;
import com.uday.coderHack.exchanges.RegisterUserRequest;
import com.uday.coderHack.services.UserService;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.Valid;

@RestController
public class UserController {
    public static final String USER_API_ENDPOINT = "/users";

    @Autowired
    private UserService userService;

    /**
     * Retrieves all users.
     *
     * @return A ResponseEntity containing a list of all User objects with status
     *         OK.
     */
    @GetMapping(USER_API_ENDPOINT)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Retrieves a user by their user ID.
     *
     * @param userId The ID of the user to retrieve.
     * @return A ResponseEntity containing the User object if found, or a
     *         ResponseEntity with status NOT_FOUND if the user does not exist.
     * @throws UserNotFoundException if the user with the specified ID is not found.
     */
    
    @GetMapping(USER_API_ENDPOINT + "/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        try {
            User user = userService.findUser(userId);
            return ResponseEntity.ok().body(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    /**
     * Registers a new user.
     * 
     * @param registerUserRequest the user registration request
     * @return ResponseEntity containing the registered user and an HTTP status code
     */

    @PostMapping(USER_API_ENDPOINT)
    public ResponseEntity<User> registerUser(@Valid @RequestBody RegisterUserRequest registerUserRequest) {
        String username = registerUserRequest.getUsername();

        User user = userService.registerUser(username);

        return ResponseEntity.ok().body(user);
    }
    /**
     * Updates the score of an existing user.
     * 
     * @param userId the ID of the user
     * @param score the new score for the user, must be between 0 and 100
     * @return ResponseEntity containing the updated user and an HTTP status code, or a bad request status if the user is not found
     */

    @PutMapping(USER_API_ENDPOINT + "/{userId}")
    public ResponseEntity<User> updateScore(@PathVariable String userId,
            @Range(min = 0, max = 100) @RequestParam int score) {

        try {
            User user = userService.updateScore(userId, score);
            return ResponseEntity.ok().body(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }

        
    }

      /**
     * Deregisters an existing user.
     *
     * @param userId the ID of the user to be deregistered
     * @return ResponseEntity with an HTTP status code indicating the result of the operation
     */

    @DeleteMapping(USER_API_ENDPOINT + "/{userId}")
    public ResponseEntity<Void> deregisterUser(@PathVariable String userId) {

        try {
            userService.deregisterUser(userId);
            return ResponseEntity.ok().build();
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
