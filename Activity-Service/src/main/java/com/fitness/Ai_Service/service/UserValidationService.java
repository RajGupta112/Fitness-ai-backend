package com.fitness.Ai_Service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class UserValidationService {

    private final WebClient userServiceWebClient;

    public  boolean validateUser(String userId){
        return  userServiceWebClient.get()
                .uri("api/users/userId/validate")
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
