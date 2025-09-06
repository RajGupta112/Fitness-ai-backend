package com.fitness.Ai_Service.service;

import com.fitness.Ai_Service.config.UserServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserValidationService {

    private final UserServiceClient userServiceClient;

    public boolean validateUser(String userId) {
        log.info("Calling User Service {}",userId);
        return Boolean.TRUE.equals(userServiceClient.validateUser(userId));
    }
}
