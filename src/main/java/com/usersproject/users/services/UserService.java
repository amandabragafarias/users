package com.usersproject.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.usersproject.users.entities.User;
import com.usersproject.users.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

     @GetMapping(value = "/{id}")
    public User findUserById(@PathVariable Long id){
        User result = repository.findById(id).get();
        return result;
    }

}
