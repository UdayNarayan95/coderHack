package com.uday.coderHack.services;

import com.uday.coderHack.dtos.User;
import java.util.*;

import org.springframework.stereotype.Service;

import com.uday.coderHack.exceptions.UserNotFoundException;

@Service
public interface UserService {

     User registerUser(String username);
     User updateScore(String userId, int score) throws UserNotFoundException;
     User findUser(String userId) throws UserNotFoundException;
     List<User> findAllUsers();
     void deregisterUser(String userId) throws UserNotFoundException;
}
