package com.example.wtech_mobile_app_2022_backend.dtos.user.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdatePasswordRequest {

    @NotNull
    @NotBlank
    private String currentPassword;
    @NotNull
    @NotBlank
    private String newPassword;
    @NotNull
    @NotBlank
    private String newPasswordRepeat;
}
