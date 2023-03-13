package com.example.wtech_mobile_app_2022_backend.business.abstracts;

import com.example.wtech_mobile_app_2022_backend.entities.concrate.UserSetting;

public interface UserSettingService {
    void add(UserSetting userSetting);

    void update(UserSetting userSetting);
}
