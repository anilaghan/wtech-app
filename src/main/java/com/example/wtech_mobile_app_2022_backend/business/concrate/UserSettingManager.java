package com.example.wtech_mobile_app_2022_backend.business.concrate;

import com.example.wtech_mobile_app_2022_backend.business.abstracts.UserSettingService;
import com.example.wtech_mobile_app_2022_backend.entities.concrate.UserSetting;
import com.example.wtech_mobile_app_2022_backend.repository.UserSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSettingManager implements UserSettingService {
    @Autowired
    UserSettingRepository userSettingRepository;

    @Override
    public void add(UserSetting userSetting) {
        userSettingRepository.save(userSetting);

    }

    @Override
    public void update(UserSetting userSetting) {
        userSettingRepository.save(userSetting);
    }
}
