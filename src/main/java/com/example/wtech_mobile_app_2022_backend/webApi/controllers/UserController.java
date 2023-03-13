package com.example.wtech_mobile_app_2022_backend.webApi.controllers;

import com.example.wtech_mobile_app_2022_backend.business.abstracts.UserService;
import com.example.wtech_mobile_app_2022_backend.dtos.user.request.UserSettingsRequest;
import com.example.wtech_mobile_app_2022_backend.dtos.user.request.UserUpdatePasswordRequest;
import com.example.wtech_mobile_app_2022_backend.dtos.user.request.UserUpdateRequest;
import com.example.wtech_mobile_app_2022_backend.dtos.user.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        userService.delete(id);
    }

    @PutMapping("/password/{id}")
    public ResponseEntity<UserUpdatePasswordRequest> updatePassword(@PathVariable String id, @RequestBody @Valid UserUpdatePasswordRequest userUpdatePasswordRequest) {
        userService.updatePassword(id, userUpdatePasswordRequest);
        if (Objects.nonNull(userUpdatePasswordRequest)) {
            return new ResponseEntity<>(userUpdatePasswordRequest, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserUpdateRequest> update(@PathVariable String id, @RequestBody @Valid UserUpdateRequest userUpdateRequest) throws IOException {
        userService.update(id, userUpdateRequest);
        if (Objects.nonNull(userUpdateRequest)) {
            return new ResponseEntity<>(userUpdateRequest, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/settings")
    public ResponseEntity<UserSettingsRequest> settings(@RequestBody UserSettingsRequest userSettingsRequest) {
        userService.updateSetting(userSettingsRequest);
        if (Objects.nonNull(userSettingsRequest)) {
            return new ResponseEntity<>(userSettingsRequest, HttpStatus.OK);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getStudentById(@PathVariable String id) {
        UserResponse userResponse = userService.getUserById(id);
        if (Objects.nonNull(userResponse)) {
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
}
