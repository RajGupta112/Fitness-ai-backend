package com.fitness.UserService.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoginResponse {

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDateTime lastLogin;
    private String message;
}
