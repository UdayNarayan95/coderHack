package com.uday.coderHack.repositories;

import java.util.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.uday.coderHack.entities.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity,String>{

    Optional<UserEntity> findByUserId(String userId);
    
} 
