package com.fitness.ai_gemini_service.modal;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Data
@Builder
public class Recomendation {

    @Id
    private String id;
    private String activityId;
    private String userId;
    private  String recommendation;
    private List<String> improvements;
    private List<String> suggestion;
    private List<String> safety;

    @CreatedDate
    private LocalDateTime createdAt;
}



