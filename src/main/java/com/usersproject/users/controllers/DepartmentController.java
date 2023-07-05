package com.usersproject.users.controllers;

import com.usersproject.users.entities.Department;
import com.usersproject.users.entities.User;
import com.usersproject.users.repositories.DepartmentRepository;
import com.usersproject.users.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository repository;

    @GetMapping
    public List<Department> findAll(){
        List<Department> result = repository.findAll();
        return result;

    }

    @GetMapping(value = "/{id}")
    public Department findUserById(@PathVariable Long id){
        Department result = repository.findById(id).get();
        return result;
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department){
        Department newDepartment = repository.save(department);
        return newDepartment;
    }
    @PutMapping(value = "/{id}")
    public Department editDepartment(@RequestBody Department departmentData, @PathVariable Long id){

        Department updatedDepartment = repository.findById(id).get();

            updatedDepartment.setName(departmentData.getName());
            return updatedDepartment;

    }
    @DeleteMapping(value = "/{id}")
    public void deleteDepartment(@PathVariable Long id){
        Department department = repository.findById(id).get();
        repository.delete(department);
    }


}
