package com.example.wtech_mobile_app_2022_backend.repository;

import com.example.wtech_mobile_app_2022_backend.entities.concrate.UserSetting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserSettingRepository extends MongoRepository<UserSetting, String> {
}
