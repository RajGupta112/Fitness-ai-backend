package com.fitness.Ai_Service.dto;

import com.fitness.Ai_Service.modals.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityResponse {
    private String id;
    private String userId;
    private ActivityType type;
    private LocalDateTime startTime;
    private Integer duration;
    private Integer caloriesBurned;
    private Map<String,Object> additionalMetrics;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
