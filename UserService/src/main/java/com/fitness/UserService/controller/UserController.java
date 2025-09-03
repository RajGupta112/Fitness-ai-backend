package com.fitness.UserService.controller;


import com.fitness.UserService.dto.LoginRequest;
import com.fitness.UserService.dto.LoginResponse;
import com.fitness.UserService.dto.UserResponse;
import com.fitness.UserService.modals.User;
import com.fitness.UserService.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/{Id}")
    public ResponseEntity<UserResponse> getUserProfile(@PathVariable String Id){
        return ResponseEntity.ok(userService.getUserProfile(Id));
    }


    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody com.fitness.UserService.dto.RegisterRequest request){
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(userService.login(request));
    }

    @GetMapping("/{Id}/validate")
    public ResponseEntity<Boolean> validateUser(@PathVariable String Id){
        return ResponseEntity.ok(userService.existByUserId(Id));
    }
}
