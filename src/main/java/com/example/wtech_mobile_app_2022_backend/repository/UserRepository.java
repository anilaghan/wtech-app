package com.example.wtech_mobile_app_2022_backend.repository;

import com.example.wtech_mobile_app_2022_backend.entities.concrate.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByEmail(String email);
}
