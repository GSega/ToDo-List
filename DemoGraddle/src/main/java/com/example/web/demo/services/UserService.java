package com.example.web.demo.services;

import com.example.web.demo.entity.UserEntity;
import com.example.web.demo.exception.UserAlreadyExistException;
import com.example.web.demo.exception.UserNotFoundException;
import com.example.web.demo.model.User;
import com.example.web.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registraton (UserEntity user ) throws UserAlreadyExistException {
        if(userRepo.findByUserName(user.getUserName()) != null){
            throw new UserAlreadyExistException("User with name \"" + user.getUserName() + "\" already exists");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null){
            throw new UserNotFoundException("user with id \"" + id + "\" not found");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
