package com.example.wtech_mobile_app_2022_backend.dtos.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthenticationResponse {
    private String token;
}
