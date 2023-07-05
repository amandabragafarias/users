package com.usersproject.users.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.usersproject.users.entities.User;

public interface UserRepository extends JpaRepository <User, Long> {
    
}
