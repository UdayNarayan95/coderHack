package com.uday.coderHack.repositoryservices;

import java.util.*;


import com.uday.coderHack.dtos.Badge;
import com.uday.coderHack.dtos.User;
import com.uday.coderHack.entities.UserEntity;
import com.uday.coderHack.exceptions.UserNotFoundException;
import com.uday.coderHack.repositories.UserRepository;

import org.modelmapper.ModelMapper;
import jakarta.inject.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryServiceIml implements UserRepositoryService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;
    
    @Override
    public User createUser(String username) {
        ModelMapper modelMapper = modelMapperProvider.get();
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        return modelMapper.map(userRepository.save(userEntity), User.class);
    
    }
    
    @Override
    public User updateScore(String userId, int score) throws UserNotFoundException {
        ModelMapper modelMapper = modelMapperProvider.get();
       

        UserEntity userEntity = userRepository.findByUserId(userId)
                .orElseThrow(UserNotFoundException::new);
            userEntity.setScore(score);
            awardBadges(userEntity, score);
            userRepository.save(userEntity);
            return modelMapper.map(userEntity, User.class);
    }
    
    @Override
    public User findUser(String userId) throws UserNotFoundException {
        ModelMapper modelMapper = modelMapperProvider.get();
        UserEntity userEntity = userRepository.findByUserId(userId)
                .orElseThrow(UserNotFoundException::new);
        return modelMapper.map(userEntity, User.class);
        
    }

    @Override
    public List<User> findAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return convertToUserList(userEntities);
    }

    @Override
    public void deleteUser(String userId) throws UserNotFoundException {
        UserEntity userEntity = userRepository.findByUserId(userId)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(userEntity);
    }
    
    private void awardBadges(UserEntity userEntity, int score) {
        List<Badge> badges = userEntity.getBadges();
        badges.clear();

        if(score >= 60 && score <= 100) {
            badges.add(Badge.CODE_NINJA);
            badges.add(Badge.CODE_CHAMP);
            badges.add(Badge.CODE_MASTER);
        }
        else if(score >= 30 && score < 60) {
            badges.add(Badge.CODE_NINJA);
            badges.add(Badge.CODE_CHAMP);
        }
        else if(score >= 1 && score < 30)
            badges.add(Badge.CODE_NINJA);

    }

    private List<User> convertToUserList(List<UserEntity> userEntities) {
        ModelMapper modelMapper = modelMapperProvider.get();
        List<User> users = new ArrayList<>();
        
        for(UserEntity userEntity : userEntities) {
            users.add(modelMapper.map(userEntity, User.class));
            
        }

        return users;
    }
    
}
