package com.fitness.Ai_Service.dto;

import com.fitness.Ai_Service.modals.ActivityType;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityRequest {

    private String userId;
    private ActivityType type;
    private LocalDateTime startTime;
    private Integer duration;
    private Integer caloriesBurned;
    private Map<String,Object> additionalMetrics;

}
