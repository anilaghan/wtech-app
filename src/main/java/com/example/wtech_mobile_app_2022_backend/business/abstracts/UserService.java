package com.example.wtech_mobile_app_2022_backend.business.abstracts;

import com.example.wtech_mobile_app_2022_backend.dtos.user.request.*;
import com.example.wtech_mobile_app_2022_backend.dtos.user.response.UserAuthenticationResponse;
import com.example.wtech_mobile_app_2022_backend.dtos.user.response.UserResponse;
import com.example.wtech_mobile_app_2022_backend.dtos.user.request.UserAuthenticationRequest;
import com.example.wtech_mobile_app_2022_backend.entities.concrate.User;

import java.io.IOException;

public interface UserService {

    UserAuthenticationResponse add(UserCreateRequest userCreateRequest);

    UserAuthenticationResponse authenticate(UserAuthenticationRequest userAuthenticationRequest);

    void delete(String id);

    User updatePassword(String id, UserUpdatePasswordRequest userUpdatePasswordRequest);

    User update(String id, UserUpdateRequest userUpdateRequest) throws IOException;

    void updateSetting(UserSettingsRequest userSettingsRequest);

    UserResponse getUserById(String id);
}
