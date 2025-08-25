package com.fitness.Ai_Service;

import com.fitness.Ai_Service.modals.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ActivityRepository extends MongoRepository<Activity,String> {
}
