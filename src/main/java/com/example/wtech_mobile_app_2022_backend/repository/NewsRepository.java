package com.example.wtech_mobile_app_2022_backend.repository;

import com.example.wtech_mobile_app_2022_backend.entities.concrate.News;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<News,String> {
}
