package com.example.wtech_mobile_app_2022_backend.business.concrate;

import com.example.wtech_mobile_app_2022_backend.business.abstracts.ImageService;
import com.example.wtech_mobile_app_2022_backend.business.abstracts.UserService;
import com.example.wtech_mobile_app_2022_backend.business.abstracts.UserSettingService;
import com.example.wtech_mobile_app_2022_backend.config.authenticationConfig.JwtService;
import com.example.wtech_mobile_app_2022_backend.dtos.user.request.*;
import com.example.wtech_mobile_app_2022_backend.dtos.user.response.UserAuthenticationResponse;
import com.example.wtech_mobile_app_2022_backend.dtos.user.response.UserResponse;
import com.example.wtech_mobile_app_2022_backend.dtos.user.request.UserAuthenticationRequest;
import com.example.wtech_mobile_app_2022_backend.entities.concrate.*;
import com.example.wtech_mobile_app_2022_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final UserSettingService userSettingService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final ImageService imageService;

    @Override
    public UserAuthenticationResponse add(UserCreateRequest userCreateRequest) {
        User user = new User();
        UserSetting userSetting = new UserSetting();
        user.setName(userCreateRequest.getName());
        user.setEmail(userCreateRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        user.setPhoneNumber(userCreateRequest.getPhoneNumber());
        user.setIdentityNumber(userCreateRequest.getIdentityNumber());
        user.setAcceptedAgreement(true);
        user.setCreatedDate(LocalDateTime.now());
        user.setRole(userCreateRequest.getRole());
        if(userCreateRequest.getRole() == Role.STUDENT){
            Student student = (Student) user;
        }if(userCreateRequest.getRole() == Role.MENTOR){
            Mentor mentor = (Mentor) user;
        }
        user.setUserSetting(userSetting);
        userSetting.setPauseNotification(true);
        userSetting.setSendFewerNotification(true);
        userSetting.setNightMode(true);
        userSetting.setLanguage(true);
        userSettingService.add(userSetting);
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return UserAuthenticationResponse.builder().token(jwtToken).build();
    }

    @Override
    public UserAuthenticationResponse authenticate(UserAuthenticationRequest userAuthenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userAuthenticationRequest.getEmail(), userAuthenticationRequest.getPassword()
                )
        );
        var user = userRepository.findByEmail(userAuthenticationRequest.getEmail());
        var jwtToken = jwtService.generateToken(user);
        return UserAuthenticationResponse.builder().token(jwtToken).build();
    }


    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updatePassword(String id, UserUpdatePasswordRequest userUpdatePasswordRequest) {
        User user = userRepository.findByEmail(id);

        if (passwordEncoder.matches(userUpdatePasswordRequest.getCurrentPassword(),user.getPassword())) {
            throw new IllegalArgumentException("Incorrect current password");
        }
        if (!userUpdatePasswordRequest.getNewPassword().equals(userUpdatePasswordRequest.getNewPasswordRepeat())) {
            throw new IllegalArgumentException("New password and repeat password do not match");
        }
        user.setPassword(userUpdatePasswordRequest.getNewPassword());

        return userRepository.save(user);
    }

    @Override
    public User update(String id, UserUpdateRequest userUpdateRequest) throws IOException {

        Image image = imageService.addImage(userUpdateRequest.getProfileImage());
        User user = userRepository.findById(id).orElseThrow();
        user.setProfileImage(image);
        user.setName(userUpdateRequest.getName());
        user.setPhoneNumber(userUpdateRequest.getPhoneNumber());
        user.setEmail(userUpdateRequest.getEmail());
        user.setUpdateDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public void updateSetting(UserSettingsRequest userSettingsRequest) {
        User user = userRepository.findByEmail(userSettingsRequest.getEmail());
        UserSetting userSetting = user.getUserSetting();
        userSetting.setPauseNotification(userSettingsRequest.getPauseNotification());
        userSetting.setSendFewerNotification(userSettingsRequest.getSendFewerNotification());
        userSetting.setNightMode(userSettingsRequest.getNightMode());
        userSetting.setLanguage(userSettingsRequest.getLanguage());
        userSettingService.update(userSetting);
    }

    @Override
    public UserResponse getUserById(String id) {
        User user = userRepository.findById(id).orElseThrow();
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setProfileImage(user.getProfileImage());
        return userResponse;
    }
}
