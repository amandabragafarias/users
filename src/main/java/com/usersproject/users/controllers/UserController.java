package com.usersproject.users.controllers;

import java.util.List;

import com.usersproject.users.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.usersproject.users.entities.User;
import com.usersproject.users.repositories.UserRepository;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll(){
        List<User> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public User findUserById(@PathVariable Long id){
        User result = repository.findById(id).get();
        return result;
    }

     @PostMapping
    public User createUser(@RequestBody User user){
        User result = repository.save(user);
        return result;
    }

    @PutMapping(value = "/{id}")
    public User editUser(@RequestBody User userData, @PathVariable Long id){

        User updatedUser = repository.findById(id).get();
        updatedUser.setName(userData.getName());
        updatedUser.setEmail(userData.getEmail());
        updatedUser.setDepartment(userData.getDepartment());

        return updatedUser;

    }
    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id){
        User user = repository.findById(id).get();
        repository.delete(user);
    }
}
