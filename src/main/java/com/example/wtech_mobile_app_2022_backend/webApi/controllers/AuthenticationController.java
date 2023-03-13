package com.example.wtech_mobile_app_2022_backend.webApi.controllers;

import com.example.wtech_mobile_app_2022_backend.business.abstracts.UserService;
import com.example.wtech_mobile_app_2022_backend.dtos.user.request.UserAuthenticationRequest;
import com.example.wtech_mobile_app_2022_backend.dtos.user.request.UserCreateRequest;
import com.example.wtech_mobile_app_2022_backend.dtos.user.response.UserAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserAuthenticationResponse> register(
            @RequestBody UserCreateRequest userCreateRequest){
        return ResponseEntity.ok(userService.add(userCreateRequest));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserAuthenticationResponse> authenticate(
            @RequestBody UserAuthenticationRequest userAuthenticationRequest){
    return ResponseEntity.ok(userService.authenticate(userAuthenticationRequest));
    }


}
