package com.fitness.Ai_Service.service;

import com.fitness.Ai_Service.repository.ActivityRepository;
import com.fitness.Ai_Service.dto.ActivityRequest;
import com.fitness.Ai_Service.dto.ActivityResponse;
import com.fitness.Ai_Service.modals.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    public ActivityResponse trackActivity(ActivityRequest request) {
        Activity activity=Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();

        Activity saveActivity=activityRepository.save(activity);
        return mapToResponse(saveActivity);
    }

    private ActivityResponse mapToResponse(Activity saveActivity) {
        ActivityResponse activityResponse= new ActivityResponse();
        activityResponse.setId(saveActivity.getId());
        activityResponse.setType(saveActivity.getType());
        activityResponse.setUserId(saveActivity.getUserId());
        activityResponse.setDuration(saveActivity.getDuration());
        activityResponse.setCaloriesBurned(saveActivity.getCaloriesBurned());
        activityResponse.setStartTime(saveActivity.getStartTime());
        activityResponse.setAdditionalMetrics(saveActivity.getAdditionalMetrics());
        activityResponse.setCreatedAt(saveActivity.getCreatedAt());
        activityResponse.setUpdatedAt(saveActivity.getUpdatedAt());
        return activityResponse;
    }
}

