package com.fitness.ai_gemini_service.service;

import com.fitness.ai_gemini_service.modal.Recomendation;
import com.fitness.ai_gemini_service.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    public List<Recomendation> getUserRecommendation(String userId) {
       return   recommendationRepository.findByUserId(userId);
    }

    public Recomendation getActivityRecomendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId).orElseThrow(()-> new RuntimeException("NO Recommendation found this activity"));
    }
}
