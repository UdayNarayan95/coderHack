package com.uday.coderHack.repositoryservices;

import java.util.*;

import org.springframework.stereotype.Service;

import com.uday.coderHack.dtos.User;
import com.uday.coderHack.exceptions.UserNotFoundException;

@Service
public interface UserRepositoryService {
    User createUser(String username);

    User updateScore(String userId, int score) throws UserNotFoundException;

    User findUser(String userId) throws UserNotFoundException;

    List<User> findAllUsers();

    void deleteUser(String userId) throws UserNotFoundException;
}
