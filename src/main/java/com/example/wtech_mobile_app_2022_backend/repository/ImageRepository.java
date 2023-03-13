package com.example.wtech_mobile_app_2022_backend.repository;

import com.example.wtech_mobile_app_2022_backend.entities.concrate.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image,String> {
}
