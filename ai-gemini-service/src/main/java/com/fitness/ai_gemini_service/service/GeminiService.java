package com.fitness.ai_gemini_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class GeminiService {

    private final WebClient webClient;

    private String geminiApiUrl;
    private String geminiApiKey;

    public GeminiService(WebClient.Builder webClientBuilder){
        this.webClient=webClientBuilder.build();
    }
}
