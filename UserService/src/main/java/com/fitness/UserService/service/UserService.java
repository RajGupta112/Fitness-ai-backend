package com.fitness.UserService.service;

import com.fitness.UserService.dto.LoginRequest;
import com.fitness.UserService.dto.LoginResponse;
import com.fitness.UserService.dto.RegisterRequest;
import com.fitness.UserService.dto.UserResponse;
import com.fitness.UserService.modals.User;
import com.fitness.UserService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail())){
            throw  new RuntimeException("Email already exist");
        }

        User user= new User();
        user.setFirstName(request.getFirstName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setLastName(request.getLastName());

        User savedUser= userRepository.save(user);
        UserResponse userResponse= new UserResponse();
        userResponse.setId(savedUser.getId());
        userResponse.setPassword(savedUser.getPassword());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setFirstName(savedUser.getFirstName());
        userResponse.setLastName(savedUser.getLastName());
        userResponse.setCreatedAt(savedUser.getCreatedAt());
        userResponse.setUpdatedAt(savedUser.getUpdatedAt());
        return userResponse;
    }

    public UserResponse getUserProfile(String id) {
        User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"+id));
        UserResponse userResponse= new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setPassword(user.getPassword());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());
        return userResponse;
    }

    public LoginResponse login(LoginRequest request) {

        User user=userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new RuntimeException("Invalid Email"));

        if(!user.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        LoginResponse loginResponse= new LoginResponse();
        loginResponse.setEmail(user.getEmail());
        loginResponse.setId(user.getId());
        loginResponse.setFirstName(user.getFirstName());
        loginResponse.setLastLogin(java.time.LocalDateTime.now());
        loginResponse.setLastName(user.getLastName());
        loginResponse.setMessage("Login successfully");
     return  loginResponse;
    }

    public boolean existByUserId(String id) {
        log.info("Calling User service for {}" ,id);
        return userRepository.existsById(id);
    }
}

