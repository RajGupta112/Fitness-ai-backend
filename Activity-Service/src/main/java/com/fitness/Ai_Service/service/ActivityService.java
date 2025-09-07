package com.fitness.Ai_Service.service;

import com.fitness.Ai_Service.repository.ActivityRepository;
import com.fitness.Ai_Service.dto.ActivityRequest;
import com.fitness.Ai_Service.dto.ActivityResponse;
import com.fitness.Ai_Service.modals.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserValidationService userValidationService;
    private final KafkaTemplate<String,Activity> kafkaTepmplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    public ActivityResponse trackActivity(ActivityRequest request) {
    boolean isValidUser=    userValidationService.validateUser(request.getUserId());

    if(!isValidUser) {
        throw new RuntimeException("Invalid User:"+request.getUserId());
    }
        Activity activity=Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();

        Activity saveActivity=activityRepository.save(activity);
        try{
          kafkaTepmplate.send(topicName,saveActivity.getUserId(),saveActivity);
        }catch (Exception e){

        }
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

