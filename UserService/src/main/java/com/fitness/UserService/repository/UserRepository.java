package com.fitness.UserService.repository;

import com.fitness.UserService.modals.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Boolean existsByEmail(String email);
}
