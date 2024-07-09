package com.uday.coderHack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.uday.coderHack.dtos.User;
import com.uday.coderHack.exceptions.UserNotFoundException;
import com.uday.coderHack.repositoryservices.UserRepositoryService;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
    private UserRepositoryService userRepositoryService;

    @Override
    public User registerUser(String username) {
        return userRepositoryService.createUser(username);
    }

    @Override
    public User updateScore(String userId, int score) throws UserNotFoundException {
        return userRepositoryService.updateScore(userId, score);
    }

    @Override
    public User findUser(String userId) throws UserNotFoundException {
        return userRepositoryService.findUser(userId);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = userRepositoryService.findAllUsers();
        sortUsersBasedOnScore(users);
        return users;
    }

    @Override
    public void deregisterUser(String userId) throws UserNotFoundException {
        userRepositoryService.deleteUser(userId);
    }

    private void sortUsersBasedOnScore(List<User> users) {
        Collections.sort(users, (user1, user2) -> user2.getScore() - user1.getScore()); // sorting users based on score in descending order
    } 
}
